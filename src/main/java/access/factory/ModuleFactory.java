package com.csys.template.access.factory;

import com.csys.template.access.domain.Module;
import com.csys.template.access.dto.ModuleDTO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ModuleFactory {
  public static ModuleDTO moduleToModuleDTO(Module module) {
    ModuleDTO moduleDTO=new ModuleDTO();
    moduleDTO.setNumModule(module.getNumModule());
    moduleDTO.setDesModule(module.getDesModule());
    moduleDTO.setCodeModule(module.getCodeModule());
    moduleDTO.setRevision(module.getRevision());
    moduleDTO.setGrp(module.getGrp());
    moduleDTO.setChemin(module.getChemin());
    moduleDTO.setAfficher(module.getAfficher());
    moduleDTO.setImage(module.getImage());
    moduleDTO.setNomImage(module.getNomImage());
    moduleDTO.setProcessusName(module.getProcessusName());
    moduleDTO.setVersionDatabase(module.getVersionDatabase());
    moduleDTO.setDescModule(module.getDescModule());
    moduleDTO.setDesModuleBrut(module.getDesModuleBrut());
    moduleDTO.setCentres(module.getCentres());
    moduleDTO.setVersionModule(module.getVersionModule());
    moduleDTO.setDesignationSec(module.getDesignationSec());
    return moduleDTO;
  }

  public static Module moduleDTOToModule(ModuleDTO moduleDTO) {
    Module module=new Module();
    module.setNumModule(moduleDTO.getNumModule());
    module.setDesModule(moduleDTO.getDesModule());
    module.setCodeModule(moduleDTO.getCodeModule());
    module.setRevision(moduleDTO.getRevision());
    module.setGrp(moduleDTO.getGrp());
    module.setChemin(moduleDTO.getChemin());
    module.setAfficher(moduleDTO.getAfficher());
    module.setImage(moduleDTO.getImage());
    module.setNomImage(moduleDTO.getNomImage());
    module.setProcessusName(moduleDTO.getProcessusName());
    module.setVersionDatabase(moduleDTO.getVersionDatabase());
    module.setDescModule(moduleDTO.getDescModule());
    module.setDesModuleBrut(moduleDTO.getDesModuleBrut());
    module.setCentres(moduleDTO.getCentres());
    module.setVersionModule(moduleDTO.getVersionModule());
    module.setDesignationSec(moduleDTO.getDesignationSec());
    return module;
  }

  public static Collection<ModuleDTO> moduleToModuleDTOs(Collection<Module> modules) {
    List<ModuleDTO> modulesDTO=new ArrayList<>();
    modules.forEach(x -> {
      modulesDTO.add(moduleToModuleDTO(x));
    } );
    return modulesDTO;
  }
}

