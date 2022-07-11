package com.damien.appli;

import com.damien.windows.FenetrePrincipale;

import javax.swing.UIManager;

public class Main {
    public Main() {
        FenetrePrincipale frame = new FenetrePrincipale ();
        frame.setVisible (true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Main();
        }
        catch (Exception e) {
            new Main ();
        }

    }
}
