package ProjetCPTI.Model;
/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class GlaceDur extends Objet{
    
    /**
     * Constructeur de notre objet qui dérive de la classe Objet qui correspond aux objets qui composent notre plateau de jeu 
     */
    public GlaceDur(){
        super.setSymbole("\u001B[34m" + 'G' + "\u001B[0m");
        super.setLabel("src\\ProjetCPTI\\Images\\glacedur.png");
    }  
}
