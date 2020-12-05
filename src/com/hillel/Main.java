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


//        int key = 2135000000;
//        String wordToCrypt = "萸萹萺";
//
//        char[] wordToCryptArray = wordToCrypt.toCharArray();
//
//        for(int i = 0; i < wordToCryptArray.length; i++){
//            wordToCryptArray[i] = (char) (wordToCrypt.charAt(i)+key);
//        }
//
//        String wordToUncrypt = new String(wordToCryptArray);
//
//        System.out.println(wordToUncrypt);
//
//                int key = 5;
//        String wordToCrypt = "45";
//
//        char[] wordToCryptArray = wordToCrypt.toCharArray();
//
//        for(int i = 0; i < wordToCryptArray.length; i++){
//            wordToCryptArray[i] = (char) (wordToCrypt.charAt(i)^key);
//        }
//
//        String wordToUncrypt = new String(wordToCryptArray);
//
//        System.out.println(wordToUncrypt);

    }
}
