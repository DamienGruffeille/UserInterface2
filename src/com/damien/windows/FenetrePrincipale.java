package com.damien.windows;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

/**
 * The type Fenetre principale.
 */
public class FenetrePrincipale extends JFrame {
    /**
     * Déclaration Tableau String.
     */
    private String[] choix = {"Arthur Rimbaud", "Lafontaine"};
    /**
     * Déclaration Tableau String.
     */
    private String[] choixType = {"Poeme", "Autre"};
    /**
     * Déclaration ComboBox.
     **/
    private JComboBox<String> cboChoix = new JComboBox<>();
    /**
     * Bouton Open.
     */
    private JButton btnOpen = new JButton("Ouvrir");
    /**
     * Bouton Close.
     */
    private JButton btnClose = new JButton("Fermer");
    /**
     * Bouton Help.
     */
    private JButton btnHelp = new JButton("Help");
    /**
     * Déclaration Zone Texte.
     */
    private JTextArea txtZone = new JTextArea();
    /**
     * Déclaration Zone Texte Nom.
     */
    private JTextField txtNom = new JTextField();
    /**
     * Déclaration ComboBox.
     **/
    private JComboBox<String> cboType = new JComboBox<>();
    /**
     * Bouton Ouvrir.
     */
    private JButton btnOuvrir = new JButton("Ouvrir");
    /**
     * Bouton Annuler.
     */
    private JButton btnAnnuler = new JButton("Annuler");

    /**
     * Instantiates a new Fenetre principale.
     */
    public FenetrePrincipale() {
        this.setSize(600, 400);
        this.setTitle("Editeur de texte");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Définition de l'état initial de la fenêtre
        initControls();
    }

    private void initControls() {
        // Définition de l'état initial des contrôles
        JPanel zoneClient = (JPanel) this.getContentPane();
        zoneClient.setLayout(new BorderLayout());
        zoneClient.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Création du panneau Nord et ses composants
            // Partie gauche du panneau Nord avec Label et cbo
        JPanel panNordGauche = new JPanel();
        panNordGauche.setLayout(new BoxLayout(panNordGauche, BoxLayout.X_AXIS));
        panNordGauche.add(new JLabel("Explorer"));
        panNordGauche.add(Box.createRigidArea(new Dimension(5, 0)));
        for (int i = 0; i < choix.length; i++) {
            cboChoix.addItem(choix[i]);
        }
        panNordGauche.add(cboChoix);
            // Partie droite du panneau Nord avec les 3 boutons
        JPanel panNordDroite = new JPanel(new FlowLayout());
        panNordDroite.add(btnOpen);
        panNordDroite.add(btnClose);
        panNordDroite.add(btnHelp);

        JPanel panNordComplet = new JPanel();
        panNordComplet.setLayout(new GridLayout(1, 2, 20, 20));
        panNordComplet.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
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
        panSouthGauche.setLayout(
                new BoxLayout(panSouthGauche, BoxLayout.Y_AXIS));
        panSouthGauche.setBorder(
                BorderFactory.createEmptyBorder(0, 0, 0, 10));
        panSouthGauche.add(new JLabel("Nom :"));
        panSouthGauche.add(
                Box.createRigidArea(new Dimension(0, 5)));
        panSouthGauche.add(new JLabel("Type :"));

        JPanel panSouthCentre = new JPanel();
        panSouthCentre.setLayout(
                new BoxLayout(panSouthCentre, BoxLayout.Y_AXIS));
        panSouthCentre.add(txtNom);
        panSouthCentre.add(
                Box.createRigidArea(new Dimension(0, 5)));
        for (int i = 0; i < choixType.length; i++) {
            cboType.addItem(choixType[i]);
        }
        panSouthCentre.add(cboType);

        JPanel panSouthDroite = new JPanel();
        panSouthDroite.setLayout(
                new BoxLayout(panSouthDroite, BoxLayout.Y_AXIS));
        panSouthDroite.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        panSouthDroite.add(btnOuvrir);
        panSouthDroite.add(Box.createRigidArea(new Dimension(0, 5)));
        panSouthDroite.add(btnAnnuler);

        JPanel panSouthComplet = new JPanel();
        panSouthComplet.setLayout(
                new BoxLayout(panSouthComplet, BoxLayout.X_AXIS));
        panSouthComplet.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        panSouthComplet.add(panSouthGauche);
        panSouthComplet.add(panSouthCentre);
        panSouthComplet.add(panSouthDroite);

        // Positionnement des contrôles
        zoneClient.add(panNordComplet, BorderLayout.NORTH);
        zoneClient.add(panTxt, BorderLayout.CENTER);
        zoneClient.add(panSouthComplet, BorderLayout.SOUTH);
    }
}
