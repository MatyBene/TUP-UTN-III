import models.UsuarioEntity;
import repositories.UsuarioRepository;
import utils.DisplayManager;
import view.Menu;

import java.util.Optional;

import static utils.DisplayManager.*;

public class Main{
    public static void main(String[] args){

        UsuarioRepository usuarioRepository = new UsuarioRepository();

        printList(usuarioRepository.listar());

        printMsg("\nUsuario 1 sin modificar");
        Optional<UsuarioEntity> usuario = usuarioRepository.buscarXId(1);
        usuario.ifPresent(DisplayManager::printUsuario);

        usuarioRepository.modificar(new UsuarioEntity(1, "Anita Lopez", "al@gmail.com"));

        printMsg("\nUsuario 1 modificado");
        Optional<UsuarioEntity> usuarioModificado = usuarioRepository.buscarXId(1);
        usuarioModificado.ifPresent(DisplayManager::printUsuario);

        usuarioRepository.eliminar(1);

        printMsg("\nUsuario 1 eliminado");
        Optional<UsuarioEntity> usuarioEliminado = usuarioRepository.buscarXId(1);
        usuarioEliminado.ifPresentOrElse(DisplayManager::printUsuario, () -> printMsg("El usuario no se encuentra en la base de datos"));

        printList(usuarioRepository.listar());


//        Menu.menuPrincipal();
    }
}