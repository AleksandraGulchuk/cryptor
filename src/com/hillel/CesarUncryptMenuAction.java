package com.hillel;

import java.io.BufferedReader;
import java.io.IOException;

public class CesarUncryptMenuAction implements MenuAction {
    StringCryptor stringCryptor;
    BufferedReader reader;

    public CesarUncryptMenuAction(StringCryptor stringCryptor, BufferedReader reader) {
        this.stringCryptor = stringCryptor;
        this.reader = reader;
    }

    @Override
    public void doAction() throws IOException {
        System.out.println("Введите текст:");
        stringCryptor.setText(reader.readLine());
        CesarSymbolCryptor cesarSymbolCryptor = (CesarSymbolCryptor) stringCryptor.getSymbolCryptor();
        boolean isRepeat = true;
        while (isRepeat) {
            System.out.println("Введите ключ:");
            try {
                int key = Integer.parseInt(reader.readLine());
                isRepeat = false;
                cesarSymbolCryptor.setKey(key);
                System.out.println("Ваш текст расшифрован: " + stringCryptor.uncrypt());
            } catch (NumberFormatException exception) {
                System.out.println("Вы ввели некорректное значение!");
            }
        }
    }

    @Override
    public String getName() {
        return "расшифровать шифр цезаря";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
