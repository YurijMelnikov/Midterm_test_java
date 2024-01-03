package org.example;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //Переменная counter - отвечает за подсчёт попыток в игре
    public static int counter = 1;

    public static void main(String[] args) throws IOException {
        //Список из игрушек - объектов <Toy>, игрушки добавляются через конструктор и записываются в список
        ArrayList<Toy> toys = new ArrayList<>();
        Toy toy1 = new Toy(1, "Медвед", 10, 10);
        toys.add(toy1);
        Toy toy2 = new Toy(2, "Заиц", 10, 15);
        toys.add(toy2);
        Toy toy3 = new Toy(3, "Енот-бандит", 10, 5);
        toys.add(toy3);
        Toy toy4 = new Toy(4, "Кунг-фу панда", 1, 1);
        toys.add(toy4);
        //Розыгрыш вынес в отдельный класс, который принимает список из игрушек
        GachaGame gacha = new GachaGame(toys);
        //Цикл, в котором будем играть, количество циклов = количество попыток в розыгрыше
        for (int i = 0; i < 100; i++) {
            gacha.raffle();
            Main.counter += 1;
        }
        //Выводим в консоль результаты игры записанные в файл
        FileReader reader = new FileReader("Gacha");
        Scanner scan = new Scanner(reader);
        System.out.println("Результаты игры");
        while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
        scan.close();
        reader.close();
    }
}