package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

// Starter for Search Inventory (Workbook 3a, Section 3-2 Using an ArrayList, Exercise 1).
// main is done: it asks getInventory() for the list and prints every product.
// Your job is getInventory(): fill the list with at least 5 products.
public class SearchInventory {
    public static void main(String[] args) {
        ArrayList<Product> inventory = getInventory();

        for (Product product : inventory) {
            System.out.println(product);
        }

    }

   public static ArrayList<Product> getInventory() {
        ArrayList<Product> inventory = new ArrayList<>();
/*
        inventory.add(new Product(0 , "cheese", 2.99));
        inventory.add(new Product(1,"milk", 2.33));
        inventory.add(new Product(2,"bread", 2.55));
        inventory.add(new Product(3, "eggs", 2.67));
        inventory.add(new Product(4,"butter", 2.56));*/

       String inv = "inventory.txt";
       try (BufferedReader reader = new BufferedReader(new FileReader(inv))) {

           String invLine;


           while ((invLine = reader.readLine()) != null) {
               String[] parts = invLine.split("\\|");

               int id = Integer.parseInt(parts[0]);
               String name = parts[1];
               double price = Double.parseDouble(parts[2]);

               inventory.add(new Product(id, name, price));

           }

       }
       catch (Exception e) {
           System.out.println("file has error");
       }

       return inventory;








    }

}

