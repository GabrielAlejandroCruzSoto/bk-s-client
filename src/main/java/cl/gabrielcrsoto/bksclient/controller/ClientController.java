package cl.gabrielcrsoto.bksclient.controller;

import cl.gabrielcrsoto.bksclient.model.Client;
import cl.gabrielcrsoto.bksclient.model.dto.ClientDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @PostMapping("client/save")
    public ClientDTO save(ClientDTO client){}

    @PutMapping("client/update")
    public ClientDTO update(Client client){}

    @GetMapping("client/all")
    public List<ClientDTO> findAll(){}
    @GetMapping("client/search")
    public List<ClientDTO> findByRut(String rut){}
    @GetMapping("client/search")
    public List<ClientDTO> findByNameAndLastName(String name, String lastName){}
    @DeleteMapping("client/delete")
    public void deleteById(String id){}
}
