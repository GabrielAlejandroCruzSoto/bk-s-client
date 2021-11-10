package cl.gabrielcrsoto.bksclient.service;


import cl.gabrielcrsoto.bksclient.model.Client;

import java.util.List;

public interface IClientService {

    public Client save(Client client);
    public Client update(Client client);
    public List<Client> findAll();
    public List<Client> findByRut(String rut);
    public List<Client> findByNameAndLastName(String name, String lastName);
    public void deleteById(String id);
}
