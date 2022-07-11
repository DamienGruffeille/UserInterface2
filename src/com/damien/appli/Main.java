package com.damien.appli;

import com.damien.windows.FenetrePrincipale;

import javax.swing.UIManager;

/**
 * The type Main.
 */
public class Main {
    /**
     * Instantiates a new Main.
     */
    public Main() {
        FenetrePrincipale frame = new FenetrePrincipale ();
        frame.setVisible (true);
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
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
