package upc.edu.pe.apileadyourway.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.edu.pe.apileadyourway.entities.Reporte;
import upc.edu.pe.apileadyourway.repositories.IReporteRepository;
import upc.edu.pe.apileadyourway.serviceinterfaces.IReporteService;

import java.util.List;

@Service
public class ReporteServiceImplement implements IReporteService {
    @Autowired
    IReporteRepository reporteRepository;

    @Override
    public void insertarReporte(Reporte reporte) {
        reporteRepository.save(reporte);
    }

    @Override
    public void editarReporte(Reporte reporte) {
        reporteRepository.save(reporte);
    }

    @Override
    public List<Reporte> listarReporteCliente(Long idCliente) {
        return reporteRepository.findByIdUsuario(idCliente);
    }

    @Override
    public Reporte listaID(int id) {
        return reporteRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminarReporte(int id) {
        reporteRepository.deleteById(id);
    }

    /*@Autowired
    IUsuarioService  usuarioService;

    @Autowired
    IBicicletaService  bicicletaService;

    @Override
    public void insertarReporte(ReporteDTO reporteDTO){
        Reporte reporte = new Reporte();
        reporte.setMotivo(reporteDTO.getMotivo());
        reporte.setFechaReporte(reporteDTO.getFechaReporte());
        reporte.setEstado(reporteDTO.getEstado());
        reporte.setTipo(reporteDTO.getTipo());
        reporte.setMensaje(reporteDTO.getMensaje());

        Usuario usuario = usuarioService.(reporteDTO.getUsuario());
        Bicicleta bicicleta = bicicletaService.buscarPorId(reporteDTO.getBicicleta());

        reporte.setUsuario(usuario);
        reporte.setBicicleta(bicicleta);

        reporteRepository.save(reporte);
    }

    @Override
    public void editarReporte(ReporteDTO reporteDTO, int idReporte){
        Reporte reporte = this.listaID(idReporte);

        reporte.setMotivo(reporteDTO.getMotivo());
        reporte.setFechaReporte(reporteDTO.getFechaReporte());
        reporte.setEstado(reporteDTO.getEstado());
        reporte.setTipo(reporteDTO.getTipo());
        reporte.setMensaje(reporteDTO.getMensaje());

        Usuario usuario = usuarioService.findId(reporteDTO.getIdUsuario());
        Bicicleta bicicleta = bicicletaService.buscarPorId(reporteDTO.getIdBicicleta());

        reporte.setUsuario(usuario);
        reporte.setBicicleta(bicicleta);

        reporteRepository.save(reporte);
    }
    @Override
    public List<ReporteDTO> listarReporteCliente(int idCliente){
        List<Reporte> listaReporte = reporteRepository.findByIdUsuario(idCliente);
        List<ReporteDTO> listaReporteDTO = new ArrayList<>();

        for (Reporte reporte : listaReporte) {
            ReporteDTO repoteDTO =  new ReporteDTO();
            repoteDTO.setMotivo(reporte.getMotivo());
            repoteDTO.setFechaReporte(reporte.getFechaReporte());
            repoteDTO.setEstado(reporte.getEstado());
            repoteDTO.setTipo(reporte.getTipo());
            repoteDTO.setMensaje(reporte.getMensaje());
            listaReporteDTO.add(repoteDTO);
        }
        return listaReporteDTO;
    }

    @Override
    public Reporte listaID(int id){
        return reporteRepository.findById(id).get();
    }*/


}
