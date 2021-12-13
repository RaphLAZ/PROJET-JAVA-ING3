package ProjetCPTI.Model;
/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Tunnel extends Objet{
    private boolean entrance; //true si le tunnel st une entrée, false si le tunnel est une sortie 
    private int OTunnelOrdonnee; // Ordonnee de l'autre bouche du tunnel 
    private int OTunnelAbscisse; //Abscisse de l'autre bouche du tunnel 
    
    /**
     * Constructeur de notre objet qui dérive de la classe Objet qui correspond aux objets qui composent notre plateau de jeu 
     */
    public Tunnel(){
        super.setSymbole("\u001B[30m" + 'T' + "\u001B[0m");
        super.setLabel("src\\ProjetCPTI\\Images\\Tunnel.jpg");
    }
    
    /**
     * Méthode qui permet de définir les coordonnées de l'autre bouche du tunnel 
     * @param abscisse : abscisse de l'autre bouche du tunnel 
     * @param ordonnee : ordonnee de l'autre bouche du tunnel 
     */
    public void setOTunnelCoordonnees(int abscisse, int ordonnee){
        this.OTunnelAbscisse = abscisse;
        this.OTunnelOrdonnee = ordonnee;
    }
            
    /**
     * Mthode qui renvoie l'abscisse de l'autre bouche du tunnel 
     * @return : l'abscisse de l'autre bouche du tunnel 
     */
    public int getOTunnelAbscisse(){
        return this.OTunnelAbscisse;
    }
    
    /**
     * Méthode qui renvoie l'ordonnee de l'autre bouche du tunnel 
     * @return : l'ordonnee de l'autre bouche du tunnel 
     */
    public int getOTunnelOrdonnee(){
        return this.OTunnelOrdonnee;
    }
    
    /**
     * Méthode qui permet de définir si le tunnel est une entrée ou une sortie 
     * @param entrance : true si le tunnel st une entrée, false si le tunnel est une sortie 
     */
    public void setEntrance(boolean entrance){
        this.entrance = entrance;
    }
    
    /**
     * Méthode qui renvoie true si le tunnel st une entrée, false si le tunnel est une sortie
     * @return : true si le tunnel st une entrée, false si le tunnel est une sortie
     */
    public boolean getEntrance(){
        return this.entrance;
    }
 
}
