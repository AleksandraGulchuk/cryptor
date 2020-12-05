package com.hillel;

import java.io.BufferedReader;
import java.io.IOException;

public class Menu {
    private BufferedReader reader;
    private MenuAction[] actions;

    public Menu(BufferedReader reader, MenuAction[] actions) {
        this.reader = reader;
        this.actions = actions;
    }

    public void run() throws IOException {
        boolean isCloseAfter = false;
        while (!isCloseAfter) {
            printActions();
            int numberOfAction = getChoice() - 1;
            actions[numberOfAction].doAction();
            isCloseAfter = actions[numberOfAction].closeAfter();
        }
    }

    private void printActions() {
        for (int i = 0; i < actions.length; i++) {
            System.out.println((i + 1) + " - " + actions[i].getName());
        }
    }

    private int getChoice() throws IOException {
        int choice = 0;
        while (choice <= 0 || choice > actions.length) {
            System.out.println("Сделайте свой выбор (от 1 до " + actions.length + " ):");
            try {
                choice = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException exception) {
                System.out.println("Вы ввели некорректное значение!");
            }
        }
        return choice;
    }

}
