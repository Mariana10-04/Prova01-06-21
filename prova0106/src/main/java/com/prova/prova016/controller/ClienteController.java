package com.jpa.basic.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.jpa.basic.dto.ClientDTO;
import com.jpa.basic.entity.Client;
import com.jpa.basic.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;
    
    @GetMapping("/")
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/clientsdto")
    public List<ClientDTO> getClientsDto(){
        List<Client> result = clientService.getClients();
        return result.stream().map(client -> new ClientDTO(client)).collect(Collectors.toList());
    }
    
    @PostMapping("/")
    public Client newClient(@RequestBody Client client){
        clientService.saveClient(client);
        return client;
    }
    
    @PutMapping("/{id}")
    public Client updatedClient(@PathVariable Long id, @RequestBody Client client){
        return clientService.updateClient(id, client);
    }
    
    @DeleteMapping("/{id}")
    public String deleteCLient(@PathVariable Long id){
        return clientService.deleteClient(id);
    }
    
    
    
}

