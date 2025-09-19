package upc.edu.pe.apileadyourway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import upc.edu.pe.apileadyourway.entities.Resenia;

@Repository
public interface IReseniaRepository extends JpaRepository<Resenia, Integer> {


}
