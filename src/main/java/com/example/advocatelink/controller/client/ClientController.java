package com.example.advocatelink.controller.client;
import com.example.advocatelink.models.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/client")
public class ClientController {
    static List<Client> clients = new ArrayList<>();
    private long id;

    @GetMapping
    public String usersForm(final Model model) {
        model.addAttribute("client", new Client());
        return "html/form";
    }
    @PostMapping
    public String result(Client client) {
        client.gerarId(id);
        id++;
        clients.add(client);
        return "html/result";
    }
}
