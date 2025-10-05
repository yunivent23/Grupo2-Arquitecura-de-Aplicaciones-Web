package upc.edu.pe.apileadyourway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.apileadyourway.entities.Chats;
import upc.edu.pe.apileadyourway.serviceimplements.ChatsServiceImplement;

public interface IChatsRepository extends JpaRepository<Chats, Integer> {
}
