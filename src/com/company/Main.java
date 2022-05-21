package com.company;

import java.util.Random;
import java.util.Scanner;


class Lab1 {
    private final Random random = new Random();
    final Scanner scanner = new Scanner(System.in);
    int computer_number;
    int user_number;

    static int count = 0;

    int get_number_from_keyboard() {
        count++;
        System.out.print("Введите число: ");
        return scanner.nextInt();
    }

    int get_random_value(int min, int max) {
        return random.nextInt(max-min+1) + min;
    }

    public void start_game() {
        computer_number = this.get_random_value(0, 100);

        do {
            user_number = this.get_number_from_keyboard();
            if (user_number > computer_number) {
                System.out.println("Меньше!");
            }
            if (user_number < computer_number) {
                System.out.println("Больше");
            }
        } while (computer_number != user_number);

        System.out.println("Вы угадали!\nВсего за " + count + " попыток.");
    }
}

class Lab2 extends Lab1 {
    int min = 0;
    int max = 100;

    void print_help_text() {
        System.out.println("Для ввода ответов используете следующие символы:\n'0'-если ваше число меньше\n'1'-если " +
                           "ваше число больше\n'2'-если я угадал ваше число");
    }

    void calculate_new_number_gap(int answer) {
        count++;
        if (answer == 0) {
            max = computer_number;
        }
        if (answer == 1) {
            min = computer_number;
        }
    }

    public void start_game() {
        print_help_text();
        do {
            computer_number = get_random_value(min, max);
            System.out.println("Вы загадали число " + computer_number + "?");
            user_number = scanner.nextInt();
            if (user_number != 2) {
                calculate_new_number_gap(user_number);
            }
        } while (user_number != 2);
        System.out.println("Я угадал ваше число!\nВсего за " + count + " попыток.");
    }
}

class Main{

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать!");
        System.out.println("Если вы хотите отгадывать число введите: '1'\n" +
                           "Если вы хотите загадывать число введите: '2'");
        int type_game = scanner.nextInt();
        if (type_game==1) {
            Lab1 game = new Lab1();
            game.start_game();

        }
        if (type_game==2) {
            Lab2 game = new Lab2();
            game.start_game();
        }
    }
}
