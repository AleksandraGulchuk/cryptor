package com.hillel;

public class StringCryptor {
    private SymbolCryptor symbolCryptor;
    private String text;

    public StringCryptor(SymbolCryptor symbolCryptor) {
        this.symbolCryptor = symbolCryptor;
    }

    public void setText(String text) {
        this.text = text;
    }

    public SymbolCryptor getSymbolCryptor() {
        return symbolCryptor;
    }

    public String crypt() {
        char[] wordArray = text.toCharArray();
        char[] changedWordArray = new char[wordArray.length];
        for (int i = 0; i < wordArray.length; i++) {
            changedWordArray[i] = symbolCryptor.crypt(wordArray[i]);
        }
        return new String(changedWordArray);
    }

    public String uncrypt() {
        char[] wordArray = text.toCharArray();
        char[] changedWordArray = new char[wordArray.length];
        for (int i = 0; i < wordArray.length; i++) {
            changedWordArray[i] = symbolCryptor.uncrypt(wordArray[i]);
        }
        return new String(changedWordArray);
    }


}
