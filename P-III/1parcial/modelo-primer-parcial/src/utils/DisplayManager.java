package utils;

import models.UsuarioEntity;

import java.util.List;

public class DisplayManager<T>{

    public static void printMsg(String msg){
        System.out.println(msg);
    }

    public static void printError(String e){
        System.out.println(e);
    }

    public static void printList(List<?> list){
        list.forEach(System.out::println);
    }

    public static void printUsuario(UsuarioEntity usuario){
        System.out.println(usuario);
    }

}
