package upc.edu.pe.apileadyourway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.apileadyourway.entities.Mensajes;

import java.util.List;

@Repository
public interface IMensajesRepository extends JpaRepository<Mensajes, Integer> {
    List<Mensajes> findByChatsIdChat(int idChat);
}
