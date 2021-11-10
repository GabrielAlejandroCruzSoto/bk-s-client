package cl.gabrielcrsoto.bksclient.model.dto;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

public class ClientDTO {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("yyyy-MM-dd");

    private String id;
    private String rut;
    private String name;
    private String lastName;
    private String dateBirthday;
    private String sex;
    private List<AddressDTO> lstAddress;
    private List<PhoneDTO> lstPhone;

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

    public String getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(String dateBirthday) {
        this.dateBirthday = dateBirthday;
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


    public Date getDateBirthdayToDate() throws ParseException {
        Date parse = new Date(dateFormat.parse(this.dateBirthday).getTime()); ;
        return parse;
    }

    public void setDateBirthdayInDate(Date dateBirthday) {
        this.dateBirthday = this.dateFormat.format(new java.util.Date(dateBirthday.getTime()));
    }
}
