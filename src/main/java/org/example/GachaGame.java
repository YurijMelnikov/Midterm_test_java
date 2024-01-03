package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GachaGame {
    private ArrayList<Toy> toys;

    public GachaGame(ArrayList<Toy> toys) {
        this.toys = toys;
    }

    public void raffle() throws IOException {
        File file = new File("Gacha");
        if (file.exists()) file.createNewFile();
        FileWriter writer = new FileWriter(file, true);
        Random rnd = new Random();
        for (Toy item : this.toys) {
            if (rnd.nextInt(100) <= item.getDropChance()) {
                item.setToyCount(item.getToyCount() - 1);
                System.out.printf("Выиграна игрушка %s%n", item.getToyName());
                writer.write(String.format("Попытка %d - Выиграна игрушка %s%n", Main.counter, item.getToyName()));
                writer.flush();
                if (item.getToyCount() == 0) {
                    toys.remove(item);
                }
                if (this.toys.isEmpty()) {
                    System.out.println("Игрушки закончились");
                    writer.write("Игрушки закончились");
                    writer.flush();
                    writer.close();
                    break;
                }
                break;
            }
        }
        writer.close();
    }
}
