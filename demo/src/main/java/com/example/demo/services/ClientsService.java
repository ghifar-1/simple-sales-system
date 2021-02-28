package com.example.demo.services;
import com.example.demo.models.Client;

import java.util.List;

public interface ClientsService {

    List<Client> getAllClients();

    Client createClients (Client client);

    Client updateClients (Client client);
}
