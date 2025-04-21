package model.utils;

import java.util.List;

public class DisplayManager{

    public static void printMsg(String msg){
        System.out.println(msg);
    }

    public static void printError(String e){
        System.out.println(e);
    }

    public static void printList(List<?> list){
        list.forEach(System.out::println);
    }

}
