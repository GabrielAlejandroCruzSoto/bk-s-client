package cl.gabrielcrsoto.bksclient.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tbl_phone")
public class Phone {
    @Id
    @GeneratedValue(generator="gen-tbl-phone")
    @GenericGenerator(name="gen-tbl-phone", strategy = "uuid")
    private String id;

    @Column
    private String description;

    @Column
    private String codCountry;

    @Column
    private String numberPhone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCodCountry() {
        return codCountry;
    }

    public void setCodCountry(String codCountry) {
        this.codCountry = codCountry;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
