package Problema1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static Map<Integer,Carte> citire()
    {
        try {
        File file=new File("src/main/resources/carti.json");
        ObjectMapper mapper=new ObjectMapper();
        Map<Integer,Carte> carti = mapper.readValue(file, new TypeReference<Map<Integer,Carte>>(){});
        return carti;
        }  catch (IOException e) {
        e.printStackTrace();
        }
        return null;
    }

    public static void scriere(Map<Integer,Carte> carti)
    {
        try{
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/carti.json");
            mapper.writeValue(file,carti);
        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Map<Integer,Carte> carti = new HashMap<Integer,Carte>();
        carti = citire();

        /*for(var c:carti.entrySet())
        {
            System.out.println(c.getKey() + ": "+c.getValue());
        }*/
        carti.entrySet().forEach(System.out::println);
        Scanner read = new Scanner(System.in);
        /*System.out.println("Introduceti numele cartii pe care doriti sa o stergeti din lista: ");
        String nume = read.nextLine();
        int key = 0;
        for(Map.Entry<Integer,Carte> c:carti.entrySet())
        {
            if(nume.compareTo(c.getValue().titlul())==0) {
                key = c.getKey();
            }
        }

        carti.remove(key);

        for(Map.Entry<Integer,Carte> c:carti.entrySet())
        {
            System.out.println(c.getKey() + ": "+c.getValue());
        }*/

        /*System.out.println("Introduceti titlul cartii pe care doriti sa o adaugati: ");
        String nume = read.nextLine();
        System.out.println("Introduceti autorul: ");
        String autor = read.nextLine();
        System.out.println("Intorduceti anul: ");
        int an = read.nextInt();
        Carte car = new Carte(nume,autor,an);
        carti.putIfAbsent(carti.size()+1,car);
        scriere(carti);
        carti.entrySet().forEach(System.out::println);*/

        System.out.println("\nAfisarea cartilor autorului Yuval Noah Harari");
        Set<Carte> carti_autor = carti.values()
                .stream()
                .filter(c-> c.autorul().compareTo("Yuval Noah Harari")==0)
                .collect(Collectors.toSet());
        carti_autor
                .stream()
                .forEach(System.out::println);

        System.out.println("\nAfisarea ordonata a cartilor autorului Yuval Noah Harari");
        /*Collections.sort(carti_autor, (Carte a, Carte b)->
        {
            if(a.titlul().compareToIgnoreCase(b.titlul()) < 0)
                return -1;
            else
            {
                if(a.titlul().compareToIgnoreCase(b.titlul()) > 0)
                    return 1;
                else return 0;
            }
        });*/







    }
}
