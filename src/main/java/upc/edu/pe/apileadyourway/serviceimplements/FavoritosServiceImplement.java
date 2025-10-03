package upc.edu.pe.apileadyourway.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.apileadyourway.dtos.FavortitosDTO;
import upc.edu.pe.apileadyourway.entities.Favoritos;
import upc.edu.pe.apileadyourway.repositories.IFavoritosRepository;
import upc.edu.pe.apileadyourway.serviceinterfaces.IFavoritosService;
import upc.edu.pe.apileadyourway.serviceinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoritosServiceImplement implements IFavoritosService {
    @Autowired
    private IFavoritosRepository repository;

    @Autowired
    IUsuarioService usuarioService;

    /*@Override
    public void insertarLista(FavortitosDTO listasFavortitasDTO){
        Favoritos lista = new Favoritos();
        lista.setFechaGuardado(listasFavortitasDTO.getFechaGuardado());

        Usuario usuario = usuarioService.findId(listasFavortitasDTO.getIdUsuario());
        Bicicleta bicicleta = bicicletaService.buscarPorId(listasFavortitasDTO.getIdBicicleta());

        lista.setUsuario(usuario);
        lista.setBicicleta(bicicleta);

        listaFavoritosRepository.save(lista);
    }

    @Override
    public void editarLista(FavortitosDTO listasFavortitasDTO, int idReporte){
        Favoritos lista = this.listaID(idReporte);

        lista.setFechaGuardado(listasFavortitasDTO.getFechaGuardado());

        Usuario usuario = usuarioService.findId(listasFavortitasDTO.getIdUsuario());
        Bicicleta bicicleta = bicicletaService.buscarPorId(listasFavortitasDTO.getIdBicicleta());

        lista.setUsuario(usuario);
        lista.setBicicleta(bicicleta);

        listaFavoritosRepository.save(lista);
    }
    @Override
    public List<FavortitosDTO> listarListaCliente(int idCliente){
        List<Favoritos> favoritos = listaFavoritosRepository.findByIdUsuario(idCliente);
        List<FavortitosDTO> listasFavortitasDTOS = new ArrayList<>();

        for (Favoritos lista : favoritos) {
            FavortitosDTO listasFavortitasDTO =  new FavortitosDTO();
            listasFavortitasDTO.setFechaGuardado(lista.getFechaGuardado());
            listasFavortitasDTOS.add(listasFavortitasDTO);
        }
        return listasFavortitasDTOS;
    }


     */


    @Override
    public void insertarLista(Favoritos fav) {
        repository.save(fav);
    }

    @Override
    public void editarLista(Favoritos fav) {
        repository.save(fav);
    }

    @Override
    public List<FavortitosDTO> listarListaCliente(int idCliente) {
        return repository.findByIdUsuario(idCliente);
    }

    @Override
    public Favoritos listaID(int id){
        return repository.findById(id).orElse(null);
    }
}
