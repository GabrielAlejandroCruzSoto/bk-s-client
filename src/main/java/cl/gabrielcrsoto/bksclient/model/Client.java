package cl.gabrielcrsoto.bksclient.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "tbl_client")
public class Client {
    @Id
    @GeneratedValue(generator="gen-tbl-client")
    @GenericGenerator(name="gen-tbl-client", strategy = "uuid")
    private String id;

    @Column(unique = true)
    private String rut;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private Date dateBirth;

    @Column
    private String email;

    @Column
    private String sex;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> lstAddress;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> lstPhone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
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
