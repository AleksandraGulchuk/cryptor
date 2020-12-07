package com.hillel;

import java.io.BufferedReader;
import java.io.IOException;

public class CesarUncryptMenuAction implements MenuAction {

    private final StringCryptor stringCryptor;
    private final BufferedReader reader;

    public CesarUncryptMenuAction(StringCryptor stringCryptor, BufferedReader reader) {
        this.stringCryptor = stringCryptor;
        this.reader = reader;
    }

    @Override
    public void doAction() throws IOException {
        System.out.println("Введите текст:");
        stringCryptor.setText(reader.readLine());
        CesarSymbolCryptor cesarSymbolCryptor = (CesarSymbolCryptor) stringCryptor.getSymbolCryptor();
        boolean isKeyTaken = false;
        while (!isKeyTaken) {
            System.out.println("Введите ключ:");
            try {
                int key = Integer.parseInt(reader.readLine());
                isKeyTaken = true;
                cesarSymbolCryptor.setKey(key);
                System.out.println("Ваш текст расшифрован: ");
                System.out.println("Расшифрованный текст: " + stringCryptor.uncrypt() +
                        "\nЗашифрованный текст: " + stringCryptor.getText() +
                        "\nключ: " + cesarSymbolCryptor.getKey());

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
