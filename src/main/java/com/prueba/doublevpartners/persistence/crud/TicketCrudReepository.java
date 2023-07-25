package com.prueba.doublevpartners.persistence.crud;

import com.prueba.doublevpartners.persistence.entity.TicketBD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TicketCrudReepository extends JpaRepository<TicketBD,Long> {

    List<TicketBD> findByUsuario(String usuario);
}
