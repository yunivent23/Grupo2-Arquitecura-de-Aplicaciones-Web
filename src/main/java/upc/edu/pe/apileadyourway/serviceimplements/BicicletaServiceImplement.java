package upc.edu.pe.apileadyourway.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.apileadyourway.entities.Bicicleta;
import upc.edu.pe.apileadyourway.repositories.IBicicletaRepository;
import upc.edu.pe.apileadyourway.serviceinterfaces.IBicicletaService;

import java.util.List;

@Service
public class BicicletaServiceImplement implements IBicicletaService {
    @Autowired
    private IBicicletaRepository repository;

    @Override
    public List<Bicicleta> listarTodo() {
        return repository.findAll();
    }

    @Override
    public Bicicleta buscarPorId(int id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public void publicarBicicleta(Bicicleta bicicleta) {
        repository.save(bicicleta);
    }

    @Override
    public void editarBicicleta(Bicicleta bicicleta) {
        repository.save(bicicleta);
    }

    @Override
    public void eliminarBicicleta(int id) {
        repository.deleteById(id);
    }
/*
    @Override
    public List<Bicicleta> buscarPorTipo(String tipo) {
        return repository.buscarPorTipo(tipo);
    }

    @Override
    public List<Bicicleta> buscarPorMarca(String marca) {
        return repository.buscarPorMarca(marca);
    }

    @Override
    public List<Bicicleta> buscarPorColor(String color) {
        return repository.buscarPorColor(color);
    }

    @Override
    public List<Bicicleta> buscarPorEstado(String estado) {
        return repository.buscarPorEstado(estado);
    }

    @Override
    public List<Bicicleta> buscarPorRangoDePrecio(double precioMin, double precioMax) {
        return repository.buscarPorRangoDePrecio(precioMin, precioMax);
    }

    @Override
    public List<Bicicleta> buscarPorDisponibilidad(boolean disponible) {
        return repository.buscarPorDisponibilidad(disponible);
    }
*/
    @Override
    public List<Bicicleta> buscarMultiplesFiltros(
            String tipo,
            String marca,
            String color,
            Double precioMin,
            Double precioMax,
            Boolean disponible,
            String estado) {
        return repository.buscarMultiplesFiltros(
                tipo, marca, color, precioMin, precioMax, disponible, estado
        );
    }
}
