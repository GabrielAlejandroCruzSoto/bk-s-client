package cl.gabrielcrsoto.bksclient.repository;

import cl.gabrielcrsoto.bksclient.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClientRepository extends JpaRepository<Client,String> {

    @Query("SELECT c FROM tbl_client c WHERE c.rut = ?1")
    public List<Client> findByRut(String rut);

    @Query("SELECT c FROM tbl_client c WHERE c.name = ?1 AND lastName= ?2")
    public List<Client> findByNameAndLastName(String name, String lastName);
}
