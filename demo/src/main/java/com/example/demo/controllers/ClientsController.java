package com.example.demo.controllers;


import com.example.demo.models.Client;
import com.example.demo.services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ClientsController {

	@Autowired
	ClientsService clientsService;

	@GetMapping("/clients")
	public ResponseEntity<List<Client>> getAllClients() {
		try {
			List<Client> clients = new ArrayList<Client>();

			clientsService.getAllClients().forEach(clients::add);

			if (clients.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(clients, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@PostMapping("/clients")
	public ResponseEntity<Client> createClients(@RequestBody Client client) {
		try {
			Client client1 = clientsService
					.createClients(client);
			return new ResponseEntity<>(client1, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/clients")
	public ResponseEntity<Client> updateClients(@RequestBody Client client) {
		try {
			return new ResponseEntity<>(clientsService.updateClients(client),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
