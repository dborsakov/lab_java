package com.company;

import java.util.Random;
import java.util.Scanner;


class Lab1 {
    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();
    static int count = 0;

    int get_number_from_keyboard() {
        count++;
        System.out.print("Введите число: ");
        return scanner.nextInt();
    }

    int get_random_value() {
        return random.nextInt(101);
    }

    public static void game() {
        Lab1 game = new Lab1();
        int user_number;
        int random_value = game.get_random_value();

        do {
            user_number = game.get_number_from_keyboard();
            if (user_number > random_value) {
                System.out.println("Меньше!");
            }
            if (user_number < random_value) {
                System.out.println("Больше");
            }
        } while (random_value != user_number);
        System.out.println("Вы угадали!\nВсего за " + count + " попыток.");
    }
}

class Main{
    public static void main(String[] args) {
        System.out.println("Добро пожаловать!");
        Lab1.game();
    }
}
