package com.hillel;

import java.io.BufferedReader;
import java.io.IOException;

public class XorUncryptMenuAction implements MenuAction {

    StringCryptor stringCryptor;
    BufferedReader reader;

    public XorUncryptMenuAction(StringCryptor stringCryptor, BufferedReader reader) {
        this.stringCryptor = stringCryptor;
        this.reader = reader;
    }

    @Override
    public void doAction() throws IOException {
        System.out.println("Введите текст:");
        stringCryptor.setText(reader.readLine());
        XorSymbolCryptor xorSymbolCryptor = (XorSymbolCryptor) stringCryptor.getSymbolCryptor();
        boolean isKeyTaken = false;
        while (!isKeyTaken) {
            System.out.println("Введите ключ:");
            try {
                int key = Integer.parseInt(reader.readLine());
                isKeyTaken = true;
                xorSymbolCryptor.setKey(key);
                System.out.println("Ваш текст расшифрован: ");
                System.out.println("Расшифрованный текст: " + stringCryptor.uncrypt() +
                        "\nЗашифрованный текст: " + stringCryptor.getText() +
                        "\nключ: " + xorSymbolCryptor.getKey());
            } catch (NumberFormatException exception) {
                System.out.println("Вы ввели некорректное значение!");
            }
        }
    }

    @Override
    public String getName() {
        return "расшифровать шифр xor";
    }

    @Override
    public boolean closeAfter() {
        return false;
    }

}
