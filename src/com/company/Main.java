package com.company;

import com.example.game.Enemy;
import com.example.game.ISaveable;
import com.example.game.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("""
                Choose
                1 to enter a string
                0 to quit""");

        while(!quit) {
            System.out.println("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0 -> quit = true;
                case 1 -> {
                    System.out.println("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                }
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {
      for(int i = 0; i < objectToSave.write().size(); i++) {
          System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
      }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();
        objectToLoad.read(values);
    }


    public static void main(String[] args) {
        Player cloud = new Player("Cloud", 25, 25);
        System.out.println(cloud.toString());
        saveObject(cloud);

        cloud.setHitPoints(8);
        System.out.println(cloud);
        cloud.setWeapon("Stormbringer");
        saveObject(cloud);
        //loadObject(cloud);
        System.out.println(cloud);

    ISaveable werewolf = new Enemy("Werewolf", 35, 40);
        System.out.println(werewolf);
        saveObject(werewolf);

    }
}
