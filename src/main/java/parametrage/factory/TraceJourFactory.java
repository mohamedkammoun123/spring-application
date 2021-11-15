package com.csys.template.parametrage.factory;

import com.csys.template.parametrage.domain.Journaux;
import com.csys.template.parametrage.domain.TraceJour;
import com.csys.template.parametrage.domain.TraceJourPK;
import com.csys.template.parametrage.dto.TraceJourDTO;
import com.csys.template.util.Helper;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.context.SecurityContextHolder;

public class TraceJourFactory {
    
    public static TraceJourDTO tracejourToTraceJourDTO(TraceJour tracejour) {
        TraceJourDTO tracejourDTO = new TraceJourDTO();
        tracejourDTO.setCodJou(tracejour.getTraceJourPK().getCodJou());
        tracejourDTO.setCodeSoc(tracejour.getTraceJourPK().getCodeSoc());
        tracejourDTO.setDateM(LocalDateTime.now());
        tracejourDTO.setLibJou(tracejour.getLibJou());
        tracejourDTO.setUserName(tracejour.getUserName());
        tracejourDTO.setType(tracejour.getType());
        return tracejourDTO;
    }
    
    public static TraceJour tracejourDTOToTraceJour(Journaux journaux,String type) {
        TraceJour tracejour = new TraceJour();
        TraceJourPK tracejourPK = new TraceJourPK();
        tracejourPK.setCodeSoc(journaux.getJournauxPK().getCodeSoc());
        tracejourPK.setCodJou(journaux.getJournauxPK().getCodJou());
        tracejourPK.setDateM(LocalDateTime.now());
        tracejour.setTraceJourPK(tracejourPK);
        tracejour.setLibJou(journaux.getLibJr());
//        tracejour.setUserName(journaux.getUserName());
        tracejour.setType(type);
        return tracejour;
    }
    
    public static Collection<TraceJourDTO> tracejourToTraceJourDTOs(Collection<TraceJour> tracejours) {
        List<TraceJourDTO> tracejoursDTO = new ArrayList<>();
        tracejours.forEach(x -> {
            tracejoursDTO.add(tracejourToTraceJourDTO(x));
        });
        return tracejoursDTO;
    }
    
    public static TraceJourDTO createTracejourToTraceJourDTO(Journaux journaux, String type) {
        TraceJourDTO tracejourDTO = new TraceJourDTO();
        tracejourDTO.setCodJou(journaux.getJournauxPK().getCodJou());
        tracejourDTO.setCodeSoc(journaux.getJournauxPK().getCodeSoc());
//        tracejourDTO.setDateM(LocalDateTime.now());
        tracejourDTO.setLibJou(journaux.getLibJr());
//        tracejourDTO.setUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        tracejourDTO.setType(type);
        return tracejourDTO;
    }
}
