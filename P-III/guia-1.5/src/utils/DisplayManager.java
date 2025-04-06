package utils;

import models.Product;

import java.util.List;
import java.util.Map;

public class DisplayManager{

    public static void printMsg(String msg){
        System.out.println(msg);
    }

    public static void printError(String e){
        System.out.println(e);
    }

    public static void printProduct(Product p){
        System.out.println(p);
    }

    public static void printList(List<?> list){
        list.forEach(System.out::println);
    }

    public static void printMap(Map<?, ?> map){
        map.forEach((key, value) -> System.out.println(key + " | " + value));
    }
}
