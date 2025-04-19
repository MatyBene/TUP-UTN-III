package services;

import models.PrestamoEntity;
import models.UsuarioEntity;
import repositories.PrestamoRepository;
import repositories.UsuarioRepository;

import java.util.List;
import java.util.Optional;

public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PrestamoRepository prestamoRepository;

    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
        this.prestamoRepository = new PrestamoRepository();
    }

    public void crear(UsuarioEntity usuario) {
        usuarioRepository.guardar(usuario);
    }

    public void eliminar(Integer id){
        usuarioRepository.eliminar(id);
    }

    public List<UsuarioEntity> UsuariosConPrestamosActivos(){
        List<UsuarioEntity> usuarios = usuarioRepository.listar();
        List<PrestamoEntity> prestamos = prestamoRepository.listar();

        List<Integer> idsUsuarios = prestamos.stream()
                .filter(p -> p.getFechaDevolucion() == null)
                .map(PrestamoEntity::getUsuarioId)
                .distinct()
                .toList();

        return usuarios.stream()
                .filter(u -> idsUsuarios.contains(u.getId()))
                .toList();
    }

    public boolean puedeSolicitar(Integer id){
        List<PrestamoEntity> prestamos = prestamoRepository.listar();

        int cantidadPrestamos = (int) prestamos.stream()
                .filter(p -> p.getFechaDevolucion() == null)
                .filter(p -> p.getUsuarioId().equals(id))
                .count();

        return cantidadPrestamos < 5;
    }

    public List<UsuarioEntity> usuarios(){
        return usuarioRepository.listar();
    }
}
