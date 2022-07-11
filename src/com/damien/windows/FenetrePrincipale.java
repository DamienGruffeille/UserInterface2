package com.damien.windows;

import javax.swing.*;
import java.awt.*;

public class FenetrePrincipale extends JFrame {

    private String [] choix = {"Arthur Rimbaud", "Lafontaine"};
    private String [] choixType = {"Poeme", "Autre"};
    private JComboBox<String> cboChoix = new JComboBox<>();
    private JButton btnOpen = new JButton("Ouvrir");
    private JButton btnClose = new JButton("Fermer");
    private JButton btnHelp = new JButton("Help");
    private JTextArea txtZone = new JTextArea();
    private JTextField txtNom = new JTextField();
    private JComboBox<String> cboType = new JComboBox<>();
    private JButton btnOuvrir = new JButton("Ouvrir");
    private JButton btnAnnuler = new JButton("Annuler");

    public FenetrePrincipale() {
        this.setSize(600,400);
        this.setTitle("Editeur de texte");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Définition de l'état initial de la fenêtre
        initControls();
    }

    private void initControls () {
        // Définition de l'état initial des contrôles
        JPanel zoneClient = (JPanel) this.getContentPane();
        zoneClient.setLayout(new BorderLayout());

        // Création du panneau Nord et ses composants
            // Partie gauche du panneau Nord avec Label et cbo
        JPanel panNordGauche = new JPanel();
        panNordGauche.setLayout(new BoxLayout(panNordGauche, BoxLayout.X_AXIS));
        panNordGauche.add(new JLabel("Explorer"));
        for(int i = 0; i < choix.length; i++) cboChoix.addItem(choix[i]);
        panNordGauche.add(cboChoix);
            // Partie droite du panneau Nord avec les 3 boutons
        JPanel panNordDroite = new JPanel(new FlowLayout());
        panNordDroite.add(btnOpen);
        panNordDroite.add(btnClose);
        panNordDroite.add(btnHelp);

        JPanel panNordComplet = new JPanel();
        panNordComplet.setLayout(new GridLayout(1,2,20,20));
        panNordComplet.add(panNordGauche);
        panNordComplet.add(panNordDroite);

        // Création du panneau Central
        JScrollPane panTxt = new JScrollPane(txtZone);
        // renvoi à la ligne si le mot ne tient pas
        txtZone.setLineWrap(true);
        // avec un coupure entre 2 mots
        txtZone.setWrapStyleWord(true);

        // Création du panneau South
        JPanel panSouthGauche = new JPanel();
        panSouthGauche.setLayout(new BoxLayout(panSouthGauche, BoxLayout.Y_AXIS));
        panSouthGauche.add(new JLabel("Nom :"));
        panSouthGauche.add(new JLabel("Type :"));

        JPanel panSouthCentre = new JPanel();
        panSouthCentre.setLayout(new BoxLayout(panSouthCentre, BoxLayout.Y_AXIS));
        panSouthCentre.add(txtNom);
        for (int i = 0; i < choixType.length; i++) cboType.addItem(choixType[i]);
        panSouthCentre.add(cboType);

        JPanel panSouthDroite = new JPanel();
        panSouthDroite.setLayout(new BoxLayout(panSouthDroite, BoxLayout.Y_AXIS));
        panSouthDroite.add(btnOuvrir);
        panSouthDroite.add(btnAnnuler);

        JPanel panSouthComplet = new JPanel();
        panSouthComplet.setLayout(new BoxLayout(panSouthComplet, BoxLayout.X_AXIS));
        panSouthComplet.add(panSouthGauche);
        panSouthComplet.add(panSouthCentre);
        panSouthComplet.add(panSouthDroite);

        // Positionnement des contrôles
        zoneClient.add(panNordComplet, BorderLayout.NORTH);
        zoneClient.add(panTxt,BorderLayout.CENTER);
        zoneClient.add(panSouthComplet, BorderLayout.SOUTH);
    }
}
