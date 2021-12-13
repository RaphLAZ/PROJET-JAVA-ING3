package ProjetCPTI.View;

import ProjetCPTI.Controller.Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Scores extends JPanel{
    private final JButton button1;
    
    /**
     * Constructeur de notre panel d'affichage des scores de notre partie 
     * @param frame : prends en paramètre notre frame 
     */
    public Scores(MyFrame frame){

        this.removeAll();
        this.setBackground(new Color(70, 191, 255)); 
        this.setLayout(null);

        JTextPane regles = new JTextPane();
        regles.setBounds(100, 700, 100, 50);
        regles.setFont(new Font("MV Boli",Font.PLAIN,20));
        String text = "";
        try (BufferedReader in = new BufferedReader(new FileReader("src\\ProjetCPTI\\Model\\Files\\ScoreSave.txt"))){
            String Buffer;
            while ((Buffer = in.readLine()) != null){
                text = text + "\n" + Buffer;
            }
        }
        catch(Exception e){
            text = "Aucune partie n'a été sauvegardée, il n'y a donc pas de scores à afficher, ou alors le ficher de sauvegarde est introuvable";
        }
        regles.setText(text);
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
