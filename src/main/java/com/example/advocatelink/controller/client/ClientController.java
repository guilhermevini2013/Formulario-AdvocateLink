package com.example.advocatelink.controller.client;
import com.example.advocatelink.models.Client;
import com.example.advocatelink.models.Contato;
import com.example.advocatelink.models.Endereco;
import com.example.advocatelink.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public String usersForm(final Model model) {
        model.addAttribute("client", new Client());
        return "html/form";
    }
    @PostMapping
    public String result(Client client) {
        clientService.inclui(client);
        return "html/result";
    }
    @PostMapping("/api/add")
    public ResponseEntity<String> adduser(@RequestBody Client clientRequest) {
        try {
            // Crie um novo cliente com base nos dados recebidos
            clientService.inclui(clientRequest);
            return new ResponseEntity<>("Usuário adicionado com sucesso", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao adicionar o usuário: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api")
    public ResponseEntity< List<Client> >  getlist(){
        return ResponseEntity.ok(clientService.listar());
    }
    @DeleteMapping("/api/{id}")
    public ResponseEntity<Boolean> deletClient(@PathVariable Long id){

        return new ResponseEntity<>(clientService.deletar(id), HttpStatus.NO_CONTENT);
    }
    @PutMapping(value = "/api/{id}")
    public ResponseEntity<Client> getClientbyname(@PathVariable Long id,@RequestBody Client client){

        return ResponseEntity.ok(clientService.alterar(id,client));
    }
}
