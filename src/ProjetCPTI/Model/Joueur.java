package ProjetCPTI.Model;
/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Joueur extends Element{
    private int potion; //contient le nombre de cases sur lequel notre joueur peut se déplacer sans briser la glace sous lui 
    private boolean surGlaceDur;
    /**
     * Constructeur de notre objet qui dérive de la classe Element qui correspon aux objets qui ont la proprité depouvoir bouger sur notre matrice de jeu 
     * @param abscisse : abscisse de l'objet 
     * @param ordonnee : ordonne de l'objet
     */
    public Joueur(int abscisse, int ordonnee){
        super.setSymbole("\u001B[35m" + 'J' + "\u001B[0m");
        super.setAbscisse(abscisse);
        super.setOrdonnee(ordonnee);
        super.setLabel("src\\ProjetCPTI\\Images\\icon.png");
        this.surGlaceDur = false;
    }
    
    /**
     * Méthode qui permet de définir le nombre de cases sur lequel notre joueur peut se déplacer sans briser la glace sous lui
     * @param potion : nombre de cases sur lequel notre joueur peut se déplacer sans briser la glace sous lui
     */
    public void setPotion(int potion){
        this.potion = potion;
    }
    
    /**
     * Méthode qui renvoie le nombre de cases sur lequel notre joueur peut se déplacer sans briser la glace sous lui
     * @return : le nombre de cases sur lequel notre joueur peut se déplacer sans briser la glace sous lui
     */
    public int getPotion(){
        return this.potion;
    }
    
    /**
     * Méthode qui permet de déclarer si le joueur est sur la glacedur ou non
     * @param check true si sur glace dur, flase dans la cas contraire 
     */
    public void setSurGlaceDur(boolean check){
        this.surGlaceDur = check;
    }
    
    /**
     * Méthode qui indique si le joueur est sur la glacedur 
     * @return true si le joueur est sur la glacedur, flase dans le cas contraire  
     */
    public boolean estSurGlaceDur(){
        return surGlaceDur;
    }
    
}
