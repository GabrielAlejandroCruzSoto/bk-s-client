package cl.gabrielcrsoto.bksclient.repository;

import cl.gabrielcrsoto.bksclient.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IClientRepository extends JpaRepository<Client,String> {

    @Query( value = "SELECT c FROM tbl_client c WHERE c.rut = :param_rut",
            nativeQuery = true)
    public Collection<Client> findByRut(@Param("param_rut") String rut);

    @Query( value = "SELECT c FROM tbl_client c WHERE c.name = :param_name AND lastName = :param_lastName",
            nativeQuery = true)
    public Collection<Client> findByNameAndLastName(@Param("param_name") String name,
                                                    @Param("param_lastName")String lastName);
}
