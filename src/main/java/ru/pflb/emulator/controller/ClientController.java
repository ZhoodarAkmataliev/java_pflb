package ru.pflb.emulator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pflb.emulator.model.dto.ClientDto;
import ru.pflb.emulator.service.ClientService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

@RestController
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable long id) {
        ClientDto client = clientService.getUserById(id);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/addClient/{id}")
    public ResponseEntity addClient(
            @RequestBody ClientDto client) throws URISyntaxException {

        return ResponseEntity.created(new URI("http://localhost:8080/client/{id}")).build();
    }




}
