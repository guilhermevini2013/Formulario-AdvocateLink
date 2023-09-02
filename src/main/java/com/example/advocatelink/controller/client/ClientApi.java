package com.example.advocatelink.controller.client;

import com.example.advocatelink.controller.client.ClientController;
import com.example.advocatelink.models.Client;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/list")
@RestController
public class ClientApi {

    @GetMapping()
    public List<Client> getlist(){
        return ClientController.clients;
    }
    @DeleteMapping (value = "/del={nome}")
    public void removeClient(@PathVariable String nome){
        for (Client client: ClientController.clients) {
            if (client.getNome().contains(nome)){
                ClientController.clients.remove(client);
                break;
            }
        }
    }
    @GetMapping(value = "/pesq={nome}")
    public Client getClientbyname(@PathVariable String nome){
        for (Client client: ClientController.clients) {
            if (client.getNome().contains(nome)){
                return client;
            }
        }
        return null;
    }


}
