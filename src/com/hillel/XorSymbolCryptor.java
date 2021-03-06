package com.hillel;

public class XorSymbolCryptor implements SymbolCryptor {

    private int key;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    @Override
    public char crypt(char c) {
        return (char) (c ^ key);
    }

    @Override
    public char uncrypt(char c) {
        return (char) (c ^ key);
    }

}
