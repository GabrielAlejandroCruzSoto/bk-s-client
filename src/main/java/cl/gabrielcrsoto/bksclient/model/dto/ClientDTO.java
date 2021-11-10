package cl.gabrielcrsoto.bksclient.model.dto;

import java.sql.Date;
import java.util.List;

public class ClientDTO {
    private String id;
    private String rut;
    private String name;
    private String lastName;
    private Date dateBirthday;
    private String sex;
    private List<AddressDTO> lstAddress;
    private List<PhoneDTO> lstPhone;
}
