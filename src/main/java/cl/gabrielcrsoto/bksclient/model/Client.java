package cl.gabrielcrsoto.bksclient.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "tbl_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column
    private String rut;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private Date dateBirthday;

    @Column
    private String sex;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> lstAddress;

    @OneToMany
    private List<Phone> lstPhone;

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

    public Date getDateBirthday() {
        return dateBirthday;
    }

    public void setDateBirthday(Date dateBirthday) {
        this.dateBirthday = dateBirthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Address> getLstAddress() {
        return lstAddress;
    }

    public void setLstAddress(List<Address> lstAddress) {
        this.lstAddress = lstAddress;
    }

    public List<Phone> getLstPhone() {
        return lstPhone;
    }

    public void setLstPhone(List<Phone> lstPhone) {
        this.lstPhone = lstPhone;
    }
}
