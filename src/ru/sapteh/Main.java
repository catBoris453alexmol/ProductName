package ru.sapteh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "products.txt";
        List<Product> products = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))){
            while (fileReader.ready()){
                Product product = getProduct(fileReader.readLine()) ;
                products.add(product);
            }
        }
        if ("-c".equals(args[0])){
            int id = 0;
            for (Product product: products) {
                if (product.getId() > id){
                    id = product.getId();
                }
            }
            String name = args[args.length - 3];
            if (name.length() > 30){
                name = name.substring(0,30);
            }
            String price = args[args.length - 2];
            if (price.length() > 8){
                price = price.substring(0,8);
            }
            String quantity = args[args.length - 1];
            if (quantity.length() > 4){
                quantity = quantity.substring(0,4);
            }
            Product product = new Product(++id, name,price,quantity);
            products.add(product);
        }
        try (FileWriter fw = new FileWriter(fileName)){
            for (Product product : products) {
                fw.write(product.toString());
                fw.write("\n");
            }
        }
    }
    public static Product getProduct(String stringLine){
        String id = stringLine.substring(0,8).trim();
        String name = stringLine.substring(8,38).trim();
        String price = stringLine.substring(38,46).trim();
        String quantity = stringLine.substring(46,50).trim();
        return new Product(Integer.parseInt(id), name,price,quantity);
    }
}
