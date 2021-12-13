package ProjetCPTI.Model;
/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Empty extends Objet{
    
    /**
     * Constructeur de notre objet qui dérive de la classe Objet qui correspond aux objets qui composent notre plateau de jeu 
     */
    public Empty(){
        super.setSymbole("\u001B[0m" + ' ' + "\u001B[0m");
        super.setLabel("src\\ProjetCPTI\\Images\\Empty.jpg");
    }
}
