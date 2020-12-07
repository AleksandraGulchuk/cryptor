package com.hillel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MenuAction[] actions = new MenuAction[]{
                new CesarCryptMenuAction(new StringCryptor(new CesarSymbolCryptor()), reader),
                new CesarUncryptMenuAction(new StringCryptor(new CesarSymbolCryptor()), reader),
                new XorCryptMenuAction(new StringCryptor(new XorSymbolCryptor()), reader),
                new XorUncryptMenuAction(new StringCryptor(new XorSymbolCryptor()), reader),
                new ExitMenuAction()
        };

        Menu menu = new Menu(reader, actions);
        menu.run();

    }
}
