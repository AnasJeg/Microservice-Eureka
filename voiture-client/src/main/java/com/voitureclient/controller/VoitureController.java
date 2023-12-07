package com.voitureclient.controller;


import com.voitureclient.entities.Voiture;
import com.voitureclient.proxy.MicroserviceClientProxy;
import com.voitureclient.repository.VoitureRepository;
import com.voitureclient.service.VoitureService;
import com.voitureclient.beans.Clientbeans;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VoitureController {

    @Autowired
    VoitureRepository voitureRepository;
    @Autowired
    MicroserviceClientProxy microserviceUserProxy;
    @Autowired
    VoitureService voitureService;

    @GetMapping("/clients")
    public List<Clientbeans> find(){
        return microserviceUserProxy.find();
    }

    @GetMapping("/clients/{id}")
    Clientbeans chercherUnClient(@PathVariable Long id){
        return   microserviceUserProxy.chercherUnClient(id);
    }

    @GetMapping("/car/{id}")
    Voiture getVoitureById(@PathVariable Long id){


        return
                voitureRepository.getVoitureById(id);
    }
    @GetMapping("/carr/{id}")
    Voiture getVoitureeById(@PathVariable Long id){
        Voiture voiture=getVoitureById(id);
        Clientbeans client=getInfoClient(voiture.getId());
        voiture.setClient(client);
        return
                voiture;
    }


    @GetMapping("clientInfo/{id}")
    Clientbeans getInfoClient(@PathVariable Long id) {
        Voiture voiture= voitureRepository.getVoitureById(id);
        Clientbeans clientInfo = microserviceUserProxy.chercherUnClient(voiture.getId_client());
        return clientInfo;
    }


}