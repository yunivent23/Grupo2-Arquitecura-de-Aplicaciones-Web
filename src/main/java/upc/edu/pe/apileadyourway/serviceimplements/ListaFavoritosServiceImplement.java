package upc.edu.pe.apileadyourway.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.apileadyourway.dtos.ListasFavortitasDTO;
import upc.edu.pe.apileadyourway.dtos.ReporteDTO;
import upc.edu.pe.apileadyourway.entities.Bicicleta;
import upc.edu.pe.apileadyourway.entities.ListaFavoritos;
import upc.edu.pe.apileadyourway.entities.Reporte;
import upc.edu.pe.apileadyourway.entities.Usuario;
import upc.edu.pe.apileadyourway.repositories.IListaFavoritosRepository;
import upc.edu.pe.apileadyourway.repositories.IReporteRepository;
import upc.edu.pe.apileadyourway.serviceinterfaces.IBicicletaService;
import upc.edu.pe.apileadyourway.serviceinterfaces.IListaFavoritosService;
import upc.edu.pe.apileadyourway.serviceinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListaFavoritosServiceImplement implements IListaFavoritosService {
    @Autowired
    IListaFavoritosRepository listaFavoritosRepository;

    @Autowired
    IUsuarioService usuarioService;

    @Autowired
    IBicicletaService bicicletaService;

    @Override
    public void insertarLista(ListasFavortitasDTO listasFavortitasDTO){
        ListaFavoritos lista = new ListaFavoritos();
        lista.setFechaGuardado(listasFavortitasDTO.getFechaGuardado());

        Usuario usuario = usuarioService.findId(listasFavortitasDTO.getIdUsuario());
        Bicicleta bicicleta = bicicletaService.buscarPorId(listasFavortitasDTO.getIdBicicleta());

        lista.setUsuario(usuario);
        lista.setBicicleta(bicicleta);

        listaFavoritosRepository.save(lista);
    }

    @Override
    public void editarLista(ListasFavortitasDTO listasFavortitasDTO, int idReporte){
        ListaFavoritos lista = this.listaID(idReporte);

        lista.setFechaGuardado(listasFavortitasDTO.getFechaGuardado());

        Usuario usuario = usuarioService.findId(listasFavortitasDTO.getIdUsuario());
        Bicicleta bicicleta = bicicletaService.buscarPorId(listasFavortitasDTO.getIdBicicleta());

        lista.setUsuario(usuario);
        lista.setBicicleta(bicicleta);

        listaFavoritosRepository.save(lista);
    }
    @Override
    public List<ListasFavortitasDTO> listarListaCliente(int idCliente){
        List<ListaFavoritos> listaFavoritos = listaFavoritosRepository.findByIdUsuario(idCliente);
        List<ListasFavortitasDTO> listasFavortitasDTOS = new ArrayList<>();

        for (ListaFavoritos lista : listaFavoritos) {
            ListasFavortitasDTO listasFavortitasDTO =  new ListasFavortitasDTO();
            listasFavortitasDTO.setFechaGuardado(lista.getFechaGuardado());
            listasFavortitasDTOS.add(listasFavortitasDTO);
        }
        return listasFavortitasDTOS;
    }

    @Override
    public ListaFavoritos listaID(int id){
        return listaFavoritosRepository.findById(id).get();
    }
}
