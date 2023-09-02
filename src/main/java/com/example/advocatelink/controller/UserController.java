package com.example.advocatelink.controller;
import com.example.advocatelink.models.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/client")
public class UserController {
    static List<Client> clients = new ArrayList<>();

    @GetMapping
    public String usersForm(final Model model) {
        model.addAttribute("client", new Client());
                return "html/form";
    }
    @PostMapping
    public String result(Client client) {
        clients.add(client);
        return "html/result";
    }
}
