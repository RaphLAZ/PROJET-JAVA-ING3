package ProjetCPTI.Model;
/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Porte extends Objet{
    
    /**
     * Constructeur de notre objet qui dérive de la classe Objet qui correspond aux objets qui composent notre plateau de jeu 
     */
    public Porte(){
        super.setSymbole("\u001B[31m" + 'P' + "\u001B[0m");
        super.setLabel("src\\ProjetCPTI\\Images\\finish.png");
    }
}
