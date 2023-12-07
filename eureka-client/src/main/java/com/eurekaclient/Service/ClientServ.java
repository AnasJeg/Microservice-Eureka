package com.eurekaclient.Service;

import com.eurekaclient.Entities.Client;
import com.eurekaclient.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServ {

    @Autowired
    private ClientRepository clientRepository;


    public List<Client> retournerListeClients() {
        return clientRepository.findAll();
    }

    public Client retournerClientById(Long id) throws Exception {
        return clientRepository.findById(id).orElseThrow(() -> new Exception("Client Not Found"));
    }

    public Client enregistrerClient(Client client) {
        return clientRepository.save(client);
    }

    public ResponseEntity<Client> modifierClient(Long id, Client client) throws Exception {
        Client c1 = clientRepository.findById(id).orElseThrow(() -> new Exception("Client Not Found"));
        c1.setAge(client.getAge());
        c1.setNom(client.getNom());
        clientRepository.save(c1);
        return ResponseEntity.ok().body(c1);
    }

    public void supprimerClient(Long id) {
        clientRepository.deleteById(id);
    }
}
