package ProjetCPTI.View;

import ProjetCPTI.Controller.Game;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Menu extends JPanel{
    /**
     * Attributs nécessaires à l'affichage de notre menu 
     */
    private final JButton button1; 
    private final JButton button2;
    private final JButton button3;
    private final JButton button4;
    private final JLabel label;
    
    /**
     * Constructeur de notre panle Menu 
     * @param frame : représente la frame sur laquelle on souhaite faire l'affichage 
     */
    public Menu(MyFrame frame){
        
        /**
         * Initialisation de notre Affichage du menu 
         */
        this.label = new JLabel();
        this.setBackground(new Color(70, 191, 255));  
        this.label.setText(" Bienvenue au jeu FINN - ECE!");
        ImageIcon icon = new ImageIcon("src\\ProjetCPTI\\Images\\Menu.png");
        this.label.setIcon(icon);
        this.label.setVerticalTextPosition(JLabel.TOP);
        this.label.setHorizontalTextPosition(JLabel.CENTER);
        this.label.setFont(new Font("MV Boli",Font.PLAIN,40));
        this.label.setForeground(Color.BLACK);
        this.label.setHorizontalAlignment(JLabel.CENTER);
        this.label.setBounds(50, 200, 800, 400);
        this.add(this.label);
        
        this.button1 = new JButton();
        this.button1.setText("Règles");
        this.button1.setBounds(100, 700, 100, 50);
        this.add(this.button1);

        
        this.button2 = new JButton();
        this.button2.setText("Scores");
        this.button2.setBounds(700, 700, 100, 50);
        this.add(this.button2);

        
        this.button3 = new JButton();
        this.button3.setText("Saved");
        this.button3.setBounds(300, 700, 100, 50);
        this.add(this.button3);

        
        this.button4 = new JButton();
        this.button4.setText("New");
        this.button4.setBounds(500, 700, 100, 50);
        this.add(this.button4);

        this.setLayout(null);
        this.revalidate();
        this.repaint();
    
        /**
         * Ajout des listeners 
         */
        this.button1.addActionListener((ActionEvent e) -> {
            Game.framePrincipal.Regles();
        });
        
        this.button2.addActionListener((ActionEvent e) -> {
            Game.framePrincipal.Scores();
        });
        
        this.button3.addActionListener((ActionEvent e) -> {
            int start = Affichage.RecupererSavePartie();
            Game.framePrincipal.demmarerPartie(start);
        });
        
        this.button4.addActionListener((ActionEvent e) -> {
            File file = new File("src\\ProjetCPTI\\Model\\Files\\ScoreSave.txt");
            file.delete();
            Game.framePrincipal.demmarerPartie(5);
        });
        
        
    }
    
}
