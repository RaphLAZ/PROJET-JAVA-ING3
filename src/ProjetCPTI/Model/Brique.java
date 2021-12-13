package ProjetCPTI.Model;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Brique extends Element{
    
    /**
     * Constructeur de notre objet qui dérive de la classe Element qui correspon aux objets qui ont la proprité depouvoir bouger sur notre matrice de jeu 
     * @param abscisse : abscisse de l'objet 
     * @param ordonnee : ordonne de l'objet
     */
    public Brique(int abscisse, int ordonnee){
        super.setSymbole("\u001B[32m" + 'B' + "\u001B[0m");
        super.setAbscisse(abscisse);
        super.setOrdonnee(ordonnee);
        super.setLabel("src\\ProjetCPTI\\Images\\MovingBlock.png");
    }
 
}
