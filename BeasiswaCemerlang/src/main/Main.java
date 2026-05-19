package main;

import controller.ControllerSistem;
import view.MainView;

public class Main {
    public static void main(String[] args) {
    /**
        123240099_AsiilNR
    */
    java.awt.EventQueue.invokeLater(()->{
        MainView view = new MainView();
        ControllerSistem controller = new ControllerSistem(view);
        view.setVisible(true);
    });
    }
}
