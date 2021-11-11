package cl.gabrielcrsoto.bksclient.service.impl;

import cl.gabrielcrsoto.bksclient.exception.BksClientException;
import cl.gabrielcrsoto.bksclient.exception.ClientFoundException;
import cl.gabrielcrsoto.bksclient.exception.ClientNotFoundException;
import cl.gabrielcrsoto.bksclient.model.Client;
import cl.gabrielcrsoto.bksclient.repository.IClientRepository;
import cl.gabrielcrsoto.bksclient.service.IClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class ClientServiceImpl implements IClientService {

    private static final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    @Autowired
    private IClientRepository clientRepository;

    @Override
    public Client save(Client client) {

        if(!this.validateRUT(client.getRut())){
            throw new BksClientException("RUT invalidate");
        }
        if(this.existsClientByRUT(client.getRut())){
            throw new ClientFoundException("The client's rut already exists");
        }
        return this.clientRepository.save(client);
    }

    @Override
    public Client update(Client client) {

        if(!this.existsClientByRUT(client.getRut())){
            throw new ClientFoundException("The Client with the rut Does not exist");
        }

        if(this.findByNameAndLastName(client.getName(),client.getLastName()).size() == 0){
            throw new ClientNotFoundException("Client Not Found. The client was not found by the NAME and LAST NAME");
        }
        this.clientRepository.
        return this.clientRepository.save(client);
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
        Collection<Client> collectorsClient = this.clientRepository.findByRut(rut);
        if(collectorsClient== null){
            throw new ClientNotFoundException("Client Not Found. The client was not found by the RUT");
        }
        if (collectorsClient.isEmpty()){
            throw new ClientNotFoundException("Client Not Found. The client was not found by the RUT");
        }
        List<Client> lstClient =collectorsClient.stream().collect(Collectors.toList());

        return lstClient;
    }

    @Override
    public List<Client> findByNameAndLastName(String name, String lastName) {

        Collection<Client> collectorsClient = this.clientRepository.findByNameAndLastName(name,lastName);
        if(collectorsClient== null){
            throw new ClientNotFoundException("Client Not Found. The client was not found by the NAME and LAST NAME");
        }
        if (collectorsClient.isEmpty()){
            throw new ClientNotFoundException("Client Not Found. The client was not found by the NAME and LAST NAME");
        }
        List<Client> lstClient =collectorsClient.stream().collect(Collectors.toList());

        return lstClient;
    }

    @Override
    public void deleteById(String id) {
        this.clientRepository.deleteById(id);

        throw new ClientNotFoundException("Client Not Found.");
    }

    private boolean validateRUT(String rut){
        boolean isValidate = false;
        try {
            rut =  rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

            char dv = rut.charAt(rut.length() - 1);

            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                isValidate = true;
            }

        } catch (java.lang.NumberFormatException e) {
            logger.error("The RUT must not contain letters.It should only have numbers.");
            logger.error(e.getMessage());
            throw new BksClientException("The RUT must not contain letters.It should only have numbers.");
        } catch (Exception e) {
            throw new BksClientException("An error occurred when validating the RUT.");
        }
        return isValidate;
    }
    private boolean existsClientByRUT(String rut){
        boolean isExists = false;
        Collection<Client> collectorsClient = this.clientRepository.findByRut(rut);
        if(collectorsClient== null ||  collectorsClient.isEmpty()){
            isExists = false;
        }else{
            isExists = true;
        }
        return isExists;
    }
}
