package com.hillel;

public class ExitMenuAction implements MenuAction {

    @Override
    public void doAction() {
        System.out.println("Спасибо! Хорошего дня!");
    }

    @Override
    public String getName() {
        return "Выход";
    }

    @Override
    public boolean closeAfter() {
        return true;
    }

}
