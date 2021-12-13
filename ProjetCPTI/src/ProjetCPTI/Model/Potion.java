package ProjetCPTI.Model;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Potion extends Objet{
    private int potion = 0; //Correspond au nombre de cases que cette potion permet de se déplacer sans rien briser 
    
    /**
     * Constructeur de notre objet 
     */
    public Potion(){
        super.setSymbole("\u001B[33m" + 'Q' + "\u001B[0m");
        super.setLabel("src\\ProjetCPTI\\Images\\Potion.jpg");
    }
    
    /**
     * Méthode qui permet de définir le nombre de cases que cette potion permet de se déplacer sans rien briser 
     * @param potion : nombre de cases que cette potion permet de se déplacer sans rien briser 
     */
    public void setPotion(int potion){
        this.potion = potion;
    }
    
    /**
     * Méthode qui retourne le nombre de cases que cette potion permet de se déplacer sans rien briser 
     * @return : le nombre de cases que cette potion permet de se déplacer sans rien briser
     */
    public int getPotion(){
        return this.potion;
    }
    
}
