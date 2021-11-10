package cl.gabrielcrsoto.bksclient.controller;

import cl.gabrielcrsoto.bksclient.exception.BksClientException;
import cl.gabrielcrsoto.bksclient.model.Client;
import cl.gabrielcrsoto.bksclient.model.dto.ClientDTO;
import cl.gabrielcrsoto.bksclient.service.IClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClientController {

    @Autowired
    private IClientService clientService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("client/save")
    public ResponseEntity<ClientDTO> save(@RequestBody ClientDTO inClientDto) {
        ClientDTO outClientDTO  = null;
        try {
            Client inClient = this.convertToClient(inClientDto);
            outClientDTO = this.convertToClientDTO(this.clientService.save(inClient));
        } catch (ParseException parseException) {
            throw new BksClientException("Date could not be converted");
        }
        return new ResponseEntity<ClientDTO>(outClientDTO, HttpStatus.CREATED);
    }

    @PutMapping("client/update")
    public ResponseEntity<ClientDTO> update(@RequestBody ClientDTO inClientDto) {
        ClientDTO outClientDTO =  null;

        try {
            Client inClient = this.convertToClient(inClientDto);
            outClientDTO = this.convertToClientDTO(this.clientService.update(inClient));
        } catch (ParseException parseException) {
            throw new BksClientException("Date could not be converted");
        }
        return new ResponseEntity<ClientDTO>(outClientDTO, HttpStatus.CREATED);
    }

    @GetMapping("client/all")
    public ResponseEntity<List<ClientDTO>> findAll() {
        List<ClientDTO> lstClientDTO = this.clientService.findAll()
                .stream()
                .map(this::convertToClientDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(lstClientDTO, HttpStatus.OK);
    }

    @GetMapping("client/search")
    public ResponseEntity<List<ClientDTO>> searchBy(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "last_name") String lastName,
            @RequestParam(required = false, name = "rut") String rut) {
        List<ClientDTO> lstClientDTO = new ArrayList<>();

        if (rut == null) {
            lstClientDTO = this.clientService.findByRut(rut)
                    .stream()
                    .map(this::convertToClientDTO)
                    .collect(Collectors.toList());
        } else {
            lstClientDTO = this.clientService.findByNameAndLastName(name, lastName)
                    .stream()
                    .map(this::convertToClientDTO)
                    .collect(Collectors.toList());
        }
        return new ResponseEntity<>(lstClientDTO, HttpStatus.OK);
    }

    @DeleteMapping("client/delete")
    public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
        this.clientService.deleteById(id);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    private Client convertToClient(ClientDTO clientDTO) throws ParseException {
        Client client = modelMapper.map(clientDTO, Client.class);
        client.setDateBirthday(clientDTO.getDateBirthdayToDate());
        return client;
    }

    private ClientDTO convertToClientDTO(Client client) {
        ClientDTO clientDTO = modelMapper.map(client, ClientDTO.class);
        clientDTO.setDateBirthdayInDate(client.getDateBirthday());
        return clientDTO;
    }
}
