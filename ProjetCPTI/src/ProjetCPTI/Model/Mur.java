package ProjetCPTI.Model;
/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Mur extends Objet{
    
    /**
     * Constructeur de notre objet qui dérive de la classe Objet qui correspond aux objets qui composent notre plateau de jeu 
     */
    public Mur(){
        super.setSymbole("\u001B[40m" + 'M' + "\u001B[0m");
        super.setLabel("src\\ProjetCPTI\\Images\\wall.png");
    }
}
