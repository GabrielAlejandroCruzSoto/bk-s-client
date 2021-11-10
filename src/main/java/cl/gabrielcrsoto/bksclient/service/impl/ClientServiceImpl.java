package cl.gabrielcrsoto.bksclient.service.impl;

import cl.gabrielcrsoto.bksclient.exception.ClientNotFoundException;
import cl.gabrielcrsoto.bksclient.model.Client;
import cl.gabrielcrsoto.bksclient.repository.IClientRepository;
import cl.gabrielcrsoto.bksclient.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {
    @Autowired
    private IClientRepository clientRepository;

    @Override
    public Client save(Client client) {
        return this.clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {

        if(this.findByNameAndLastName(client.getName(),client.getLastName()).size() == 0){
            throw new ClientNotFoundException("Client Not Found. The client was not found by the NAME and LAST NAME");
        }
        return this.save(client);
    }

    @Override
    public List<Client> findAll() {
        List<Client> lstClient = new ArrayList<>();
        this.clientRepository.findAll().iterator().forEachRemaining(lstClient::add);
        if(lstClient.size()==0){
            throw new ClientNotFoundException("Client Not Found.");
        }
        return lstClient;
    }

    @Override
    public List<Client> findByRut(String rut) {
        List<Client> lstClient =this.findByRut(rut);
        if(lstClient.size() == 0){
            throw new ClientNotFoundException("Client Not Found. The client was not found by the RUT");
        }
        return lstClient;
    }

    @Override
    public List<Client> findByNameAndLastName(String name, String lastName) {
        List<Client> lstClient =this.findByNameAndLastName(name,lastName);
        if(lstClient.size() == 0){
            throw new ClientNotFoundException("Client Not Found. The client was not found by the NAME and LAST NAME");
        }
        return lstClient;
    }

    @Override
    public void deleteById(String id) {
        this.clientRepository.deleteById(id);

        throw new ClientNotFoundException("Client Not Found.");
    }

    private boolean validateRUT(String rut){
        return true;
    }
}
