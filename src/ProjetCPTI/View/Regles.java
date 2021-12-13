package ProjetCPTI.View;

import ProjetCPTI.Controller.Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Regles extends JPanel{
    private final JButton button1;
    
    /**
     * Constructeur de notre panel Règles du jeu 
     * @param frame : prends en paramètre notre frame 
     */
    public Regles(MyFrame frame){
        this.removeAll();
        this.setBackground(new Color(70, 191, 255)); 
        this.setLayout(null);

        JTextPane regles = new JTextPane();
        regles.setBounds(100, 700, 100, 50);
        regles.setFont(new Font("MV Boli",Font.PLAIN,20));
        regles.setText("Le jeu Club Penguin Thin Ice se joue sur cinq niveaux\n\n"
                + "- Le premier comporte seulement de la glace fine, que le pingoin peut "
                + "marcher dessus et se brise au premier passage\n\n"
                + "- Le deuxième comporte également de la glace dure, que le pingoin peut "
                + "marcher dessus et se brise au deuxième passage dessus\n\n"
                + "- Le troisième comporte une brique qui peut être déplacé dans les quatres "
                + "directions et qui doit être placé sur la case bleu foncé afin de pouvoir finir "
                + "finir le niveau en parcourant toutes les cases du tableau, également une tondeuse "
                + "qui brise toute la glace sur son passage jusqu'à s'arréter contre un mur "
                + "La case Q comporte une potion qui donne un certain nombre de cases que le joueur "
                + "peut parcourir sans briser la glace\n\n"
                + "- Le quatrième comporte un tunnel qui permet au joueur d'accéder à une autre partie "
                + "du plateau de jeu\n\n"
                + "- Le cinquième niveau comporte des ennemis qui se déplacent et qu'il faut éviter au risque "
                + "de devoir recommencer le niveau en entier. L'ennemi peut se déplacer sur la glace et sur l'eau.\n\n"
                + "Toutes les cases du plateau de jeu doivent être transformées en eau pour valider le niveau.\n\n"
                + "Le calcul du score se fait de la façon suivante : 20 points pour une glace épaisse brisée, 40 points pour une glace fine brisée. A la fin "
                + "de la partie, des points sont ajouté en fonction du temps mis pour finir le niveau. Donc plus le joueur finit le niveau rapidement plus il marque de points.\n\n"
                + "Dans le cas d'un GameOver, le joueur peut soit revenir au menu soit recommencer le niveau où il se trouve");

        JScrollPane pane = new JScrollPane(regles);
        pane.setBounds(0, 0, 900, 600);
        this.add(pane, BorderLayout.CENTER);

        button1 = new JButton();
        button1.setText("Retour");
        button1.setBounds(100, 800, 100, 30);
        this.add(button1);

        this.revalidate();
        this.repaint();

        button1.addActionListener((ActionEvent e) -> {
            Game.framePrincipal.mainMenu();
        });
    }
    
}
