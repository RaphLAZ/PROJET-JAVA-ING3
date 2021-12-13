package ProjetCPTI.View;

import ProjetCPTI.Controller.Game;
import ProjetCPTI.Model.Struct;
import javax.swing.JFrame;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class MyFrame extends JFrame{
    
    /**
     * Attributs des différents affichages que notre frame peut avoir 
     */
    private PlateauJeu plateau;
    private final Menu menu;
    private final Regles regles;
    private final Scores scores;
    
    /**
     * Constructeur de notre objet MyFrame 
     */
    public MyFrame(){
        Game.framePrincipal = this;
        this.setSize(900, 900);
        this.setTitle("Club Penguin Thin Ice");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        regles = new Regles(this);
        menu = new Menu(this);
        scores = new Scores(this);
        
        setContentPane(menu);
    }
    
 
    /**
     * Méthode qui permet de démarer une partie 
     * @param level : niveau à partir duquel on souhaite démarrer 
     */
    public void demmarerPartie(int level){
        try{
            Struct struct = Game.GameInit(level);
            plateau = new PlateauJeu(struct, this);
            setContentPane(plateau);
            this.revalidate();
            this.repaint();
        } catch (Exception exception){
            
        }
    }
    
    /**
     * Méthode qui permet d'afficher le menu 
     */
    public void mainMenu(){
        setContentPane(menu);
        this.revalidate();
        this.repaint();
    }
    
    /**
     * Méthode qui permet d'initialiser notre plateau de jeu 
     * @param plateau : prends en paramètre notre panel PlateauJeu 
     */
    public void setPlateau(PlateauJeu plateau){
        this.removeAll();
        this.plateau = plateau;
        plateau.setSize(500,375);
        setContentPane(plateau);
    }
    
    /**
     * Méthode qui permet d'afficher le panel d'affichage des règles du jeu 
     */
    public void Regles(){
        setContentPane(regles);
        this.revalidate();
        this.repaint();
    }
    
    /**
     * Méthode qui permet d'afficher le panel d'affichage des scores du jeu
     */
    public void Scores(){
        setContentPane(scores);
        this.revalidate();
        this.repaint();
    }
  
}
