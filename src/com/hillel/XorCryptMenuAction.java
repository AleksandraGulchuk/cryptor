package com.hillel;

import java.io.BufferedReader;
import java.io.IOException;

public class XorCryptMenuAction implements MenuAction {
    StringCryptor stringCryptor;
    BufferedReader reader;

    public XorCryptMenuAction(StringCryptor stringCryptor, BufferedReader reader) {
        this.stringCryptor = stringCryptor;
        this.reader = reader;
    }

    @Override
    public void doAction() throws IOException {
        System.out.println("Введите текст:");
        stringCryptor.setText(reader.readLine());
        XorSymbolCryptor xorSymbolCryptor = (XorSymbolCryptor) stringCryptor.getSymbolCryptor();
        boolean isRepeat = true;
        while (isRepeat) {
            System.out.println("Введите ключ:");
            try {
                int key = Integer.parseInt(reader.readLine());
                isRepeat = false;
                xorSymbolCryptor.setKey(key);
                System.out.println("Ваш текст зашифрован: " + stringCryptor.crypt() + " ключ: " + key);
            } catch (NumberFormatException exception) {
                System.out.println("Вы ввели некорректное значение!");
            }
        }

    }

    @Override
    public String getName() {
        return "зашифровать шифром xor";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }
}
