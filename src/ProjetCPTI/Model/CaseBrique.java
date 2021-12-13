package ProjetCPTI.Model;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class CaseBrique extends Objet{
    
    /**
     * Constructeur de notre objet qui dérive de la classe Objet qui correspond aux objets qui composent notre plateau de jeu 
     */
    public CaseBrique(){
        super.setSymbole("\u001B[32m" + 'C' + "\u001B[0m");
        super.setLabel("src\\ProjetCPTI\\Images\\CaseBrique.jpg");
    }
    
}
