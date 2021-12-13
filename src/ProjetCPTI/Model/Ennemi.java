package ProjetCPTI.Model;
/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Ennemi extends Element{
    private boolean direction; // horizontal ou vertical 
    private boolean way; // vers la gauche ou vers la droite 
    
    /**
     * Constructeur de notre objet Ennemi 
     * @param abscisse : abscisse de notre objet 
     * @param ordonnee : ordonnee de notre objet 
     */
    public Ennemi(int abscisse, int ordonnee){
        super.setAbscisse(abscisse);
        super.setOrdonnee(ordonnee);
        super.setSymbole("\u001B[35m" + 'E' + "\u001B[0m");
        super.setLabel("src\\ProjetCPTI\\Images\\Ennemi.jpg");
    }
    
    /**
     * Méthode qui définit si l'objet va vers la droite ou vers la gauche 
     * @param way : true si l'élèment va vers la droite, false si vers la gauche 
     */
    public void setWay(boolean way){
        this.way = way;
    }
    
    /**
     * Méthode qui retourne si l'élèment se déplacer vers la gauche ou vers la droite 
     * @return : true si l'élèment va vers la droite, false si vers la gauche 
     */
    public boolean getWay(){
        return this.way;
    }
    
    /**
     * Méthode qui définit si lélèment se dirige horizontalement ou verticalement 
     * @param direction : true si l'élèment se dirige horizontalement, false si verticalement 
     */
    public void setDirection(boolean direction){
        this.direction = direction;
    }
    
    /**
     * Méthode qui retourne si l'élèment se déplace horizontalement ou verticalement 
     * @return : true si l'élèment se dirige horizontalement, false si verticalement 
     */
    public boolean getDirection(){
        return this.direction;
    }
 
}
