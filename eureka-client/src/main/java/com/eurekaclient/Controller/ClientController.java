package com.eurekaclient.Controller;

import com.eurekaclient.Entities.Client;
import com.eurekaclient.Service.ClientServ;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientController {


    @Autowired
    ClientServ clientService;

    @GetMapping("/")
    public List<Client> chercherClient(){
        return clientService.retournerListeClients();
    }

    @GetMapping("/{id}")
    public Client chercherUnClient(@PathVariable Long id) throws Exception {
        return clientService.retournerClientById(id);
    }

    @PostMapping("/")
    public Client enregistrerUnClient(@RequestBody Client client){
        return clientService.enregistrerClient(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> modifierUnClient(@PathVariable Long id, @RequestBody Client client) throws Exception {
        return clientService.modifierClient(id, client);
    }

    @DeleteMapping("/{id}")
    public void deleteUnClient(@PathVariable Long id){
        clientService.supprimerClient(id);
    }

}
