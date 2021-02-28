package com.example.demo.services;

import com.example.demo.models.Client;

import com.example.demo.repositories.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsServiceImpl implements ClientsService{

    @Autowired
    ClientsRepository clientsRepository;

    @Override
    public List<Client> getAllClients() {
        return clientsRepository.findAll();
    }

    @Override
    public Client createClients(Client client) {
        return clientsRepository.save(client);
    }

    @Override
    public Client updateClients(Client client) {
        Optional<Client> optional = clientsRepository.findById(client.getId());
        if(optional.isPresent())
        {
            Client client1 = optional.get();
            client1.setLastName(client.getLastName());
            client1.setMobile((client.getMobile()));
            client1.setName(client.getName());
            client1.setSales(client.getSales());
            return clientsRepository.save(client1);
        }
        else {
            return null;
        }
    }
}
