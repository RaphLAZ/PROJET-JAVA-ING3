package ProjetCPTI.Model;
/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Water extends Objet{
    
    /**
     * Constructeur de notre objet qui dérive de la classe Objet qui correspond aux objets qui composent notre plateau de jeu 
     */
    public Water(){
        super.setSymbole("\u001B[34m" + 'W' + "\u001B[0m");
        super.setLabel("src\\ProjetCPTI\\Images\\water.png");
    }
}
