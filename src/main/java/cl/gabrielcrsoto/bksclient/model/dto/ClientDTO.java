package cl.gabrielcrsoto.bksclient.model.dto;

import cl.gabrielcrsoto.bksclient.exception.BksClientException;
import cl.gabrielcrsoto.bksclient.service.impl.ClientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ClientDTO {
    private static final Logger logger = LoggerFactory.getLogger(ClientDTO.class);

    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd");

    private String id;
    private String rut;
    private String name;
    private String lastName;
    private String dateBirth;
    private String sex;
    private String email;
    private List<AddressDTO> lstAddress;
    private List<PhoneDTO> lstPhone;

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<AddressDTO> getLstAddress() {
        return lstAddress;
    }

    public void setLstAddress(List<AddressDTO> lstAddress) {
        this.lstAddress = lstAddress;
    }

    public List<PhoneDTO> getLstPhone() {
        return lstPhone;
    }

    public void setLstPhone(List<PhoneDTO> lstPhone) {
        this.lstPhone = lstPhone;
    }


    public Date getDateBirthToDate() throws ParseException {
        Date parse = null;
        try{
            parse = new Date(dateFormat.parse(this.dateBirth).getTime()); ;
        }catch(Exception exception){
            logger.error("Exception ->" + exception.getMessage());
            logger.error("Cause ->" + exception.getCause().getMessage());
            throw new BksClientException("Date birth with invalidate format");
        }
        return parse;
    }

    public void setDateBirthInDate(Date dateBirth) {
        try{
            this.dateBirth = this.dateFormat.format(new java.util.Date(dateBirth.getTime()));
        }catch(Exception exception){
            logger.error("Exception ->" + exception.getMessage());
            logger.error("Cause ->" + exception.getCause().getMessage());
            throw new BksClientException("Date birth with invalidate format");
        }
    }
}
