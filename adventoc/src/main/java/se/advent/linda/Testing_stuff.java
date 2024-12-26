package se.advent.linda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Testing_stuff {

    void make_conections(List<String> input, Map<String, Conection> map, Conection node){
        //System.out.println(node.getName());
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i).contains(node.getName())){
                //System.out.println(input.get(i));
                String test = input.get(i).replace(node.getName(), " ").replace("-", " ").strip();
                //System.out.println(test);
                node.addChild(map.get(test));
            }
        }
        //for (Conection elem : node.getChilds()) {
        //    System.out.println(elem.getName());
        //}
    }

    Map<String, Conection> make_stringMap(List<String> input){
        Map<String, Conection> conection_map = new HashMap<>();
        for (int i = 0; i < input.size(); i++) {
            conection_map.put(input.get(i).substring(0, input.get(i).indexOf("-")), new Conection(input.get(i).substring(0, input.get(i).indexOf("-"))));
            conection_map.put(input.get(i).substring(input.get(i).indexOf("-")+1, input.get(i).length()), new Conection(input.get(i).substring(input.get(i).indexOf("-")+1, input.get(i).length())));
        }
        return conection_map;
    }

    Integer test_LAN(Conection root, Integer node, Integer counter){
        //System.out.println("Counter is: " + counter);
        if (node != root.getConect_amount()){
            for (int i = node; i != root.getConect_amount(); i++) {
                if(root.getChild(node).getChilds().contains(root.getChild(i))){
                    counter ++;
                }
            }
            test_LAN(root, node+1, counter);
        }
        return counter;
    }
    
    public static void main(String[] args) {
        Testing_stuff test = new Testing_stuff();
        List<String> base_input = new ArrayList<>(List.of("aq-cg","yn-aq","yn-cg", "aq-gf", "gf-yn"));
        Map<String, Conection> conection_map = test.make_stringMap(base_input);
        for (String node : conection_map.keySet()){
            test.make_conections(base_input, conection_map, conection_map.get(node));
        }
    System.out.println(base_input);
    }
}