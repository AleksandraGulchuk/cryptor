package com.hillel;

public class StringCryptor {

    private final SymbolCryptor symbolCryptor;
    private String text;

    public StringCryptor(SymbolCryptor symbolCryptor) {
        this.symbolCryptor = symbolCryptor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SymbolCryptor getSymbolCryptor() {
        return symbolCryptor;
    }

    public String crypt() {
        char[] textArray = text.toCharArray();
        char[] changedTextArray = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            changedTextArray[i] = symbolCryptor.crypt(textArray[i]);
        }
        return new String(changedTextArray);
    }

    public String uncrypt() {
        char[] textArray = text.toCharArray();
        char[] changedTextArray = new char[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            changedTextArray[i] = symbolCryptor.uncrypt(textArray[i]);
        }
        return new String(changedTextArray);
    }

}
