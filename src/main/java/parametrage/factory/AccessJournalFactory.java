package com.csys.template.parametrage.factory;

import com.csys.template.access.factory.UserFactory;
import com.csys.template.parametrage.domain.AccessJournal;
import com.csys.template.parametrage.domain.AccessJournalPK;
import com.csys.template.parametrage.dto.AccessJournalDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AccessJournalFactory {

    public static AccessJournalDTO accessjournalToAccessJournalDTO(AccessJournal accessjournal) {
        AccessJournalDTO accessjournalDTO = new AccessJournalDTO();
        accessjournalDTO.setCodJou(accessjournal.getAccessJournalPK().getCodJou());
        accessjournalDTO.setCodeSoc(accessjournal.getAccessJournalPK().getCodeSoc());
        accessjournalDTO.setUserName(accessjournal.getAccessJournalPK().getUserName());
        accessjournalDTO.setUser(UserFactory.userToUserDTO(accessjournal.getUser()));
        return accessjournalDTO;
    }

    public static AccessJournal accessjournalDTOToAccessJournal(AccessJournalDTO accessjournalDTO) {
        AccessJournal accessjournal = new AccessJournal();
        AccessJournalPK accessJournalPK = new AccessJournalPK();
        accessJournalPK.setCodJou(accessjournalDTO.getCodJou());
        accessJournalPK.setCodeSoc(accessjournalDTO.getCodeSoc());
        accessJournalPK.setUserName(accessjournalDTO.getUserName());
        accessjournal.setAccessJournalPK(accessJournalPK);
        return accessjournal;
    }

    public static List<AccessJournalDTO> accessjournalToAccessJournalDTOs(List<AccessJournal> accessjournals) {
        List<AccessJournalDTO> accessjournalsDTO = new ArrayList<>();
        accessjournals.forEach(x -> {
            accessjournalsDTO.add(accessjournalToAccessJournalDTO(x));
        });
        return accessjournalsDTO;
    }
}
