package com.csys.template.parametrage.web.rest;

import com.csys.template.parametrage.dto.JournauxDTO;
import com.csys.template.parametrage.service.JournauxService;
import com.csys.template.util.RestPreconditions;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing Journaux.
 */
@RestController
@RequestMapping("/api")
public class JournauxResource {

    private static final String ENTITY_NAME = "journaux";

    private final JournauxService journauxService;

    private final Logger log = LoggerFactory.getLogger(JournauxService.class);

    public JournauxResource(JournauxService journauxService) {
        this.journauxService = journauxService;
    }

    @GetMapping("/journaux/getJournal")
    public ResponseEntity<JournauxDTO> getJournal(@RequestParam(name = "codJou") String codJou, @RequestParam(name = "codeSoc") String codeSoc) {
        log.debug("Request to get Journaux: codJou : {} codeSoc : {}", codJou, codeSoc);
        JournauxDTO dto = journauxService.findOne(codJou, codeSoc);
        RestPreconditions.checkFound(dto, "Journal inexistant !");
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/journaux")
    public List<JournauxDTO> findByFilters(@RequestParam(name = "societe", required = false) String societe, @RequestParam(name = "manuelle", required = false) List<Boolean> manuelle,
            @RequestParam(name = "controle", required = false, defaultValue = "true") Boolean controle) {
        log.debug("Request to find Journaux By Filters societe :{} manuelle :{} controle :{}", societe, manuelle, controle);
        return journauxService.findByFilters(societe, manuelle, controle, null);

    }


    @PostMapping("/journaux")
    public ResponseEntity<JournauxDTO> saveJournaux(@Valid @RequestBody JournauxDTO journauxDTO, BindingResult bindingResult) throws URISyntaxException, MethodArgumentNotValidException {
        log.debug("REST request to save journaux : {}", journauxDTO);
        if (bindingResult.hasErrors()) {
            throw new MethodArgumentNotValidException(null, bindingResult);
        }
        JournauxDTO result = (JournauxDTO) journauxService.save(journauxDTO);
        return ResponseEntity.created(new URI("/api/journaux/")).body(result);
    }

    @PutMapping("/journaux")
    public ResponseEntity<JournauxDTO> updateJournaux(@Valid @RequestBody JournauxDTO journauxDTO) throws MethodArgumentNotValidException {
        log.debug("Request to update journaux: {}", journauxDTO);
        JournauxDTO result = journauxService.update(journauxDTO);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/journaux")
    public ResponseEntity<Boolean> deleteJournaux(@RequestParam String codJou, @RequestParam String codeSoc) {
        log.debug("Request to delete journaux :  codJou:{}  codeSoc:{} ", codJou, codeSoc);
        Boolean resultat = journauxService.delete(codJou, codeSoc);
        return ResponseEntity.ok().body(resultat);
    }
}
