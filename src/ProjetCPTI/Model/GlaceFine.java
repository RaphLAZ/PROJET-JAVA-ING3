package ProjetCPTI.Model;
/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class GlaceFine extends Objet{

    /**
     * Constructeur de notre objet qui dérive de la classe Objet qui correspond aux objets qui composent notre plateau de jeu 
     */
    public GlaceFine(){
        super.setSymbole("\u001B[36m" + 'g' + "\u001B[0m");
        super.setLabel("src\\ProjetCPTI\\Images\\glacefine.png");
    }
}
