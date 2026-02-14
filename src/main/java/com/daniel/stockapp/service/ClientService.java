package com.daniel.stockapp.service;

import com.daniel.stockapp.model.Client;
import com.daniel.stockapp.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Créer un client
    public Client creerClient(Client client) {
        return clientRepository.save(client);
    }

    // Lister tous les clients
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    // Trouver un client par ID
    public Optional<Client> getClientById(Long id) {
        return clientRepository.findById(id);
    }

    // Supprimer un client
    public void supprimerClient(Long id) {
        clientRepository.deleteById(id);
    }
}
