package ProjetCPTI.Model;

/**
 *
 * @author Raphael LAZZARI-ARMOUR 
 */
public class Struct{
    private Map map; //notre plateau de jeu 
    private Joueur J1; //notre joueur 
    private Ennemi E1; //l'ennemi si il existe 
    private Brique B1; //la brique si elle existe 
    private Tondeuse L1; //la tondeuse si elle existe 
    private long chrono; //notre chrono
    
    /******************************************************************
     * Méthodes concernant le chronométrage                           *
     *****************************************************************/
    
    /**
     * Méthode qui permet de définir le temps que le joueur a mis depis le début du plateau de jeu  
     * @param chrono : le temps mis pour terminer le plateau de jeu 
     */
    public void setChrono(long chrono){
        this.chrono = chrono;
    }
    
    /**
     * Méthode qui renvoie le chrono de notre plateau de jeu 
     * @return le chrono de notre plateau de jeu 
     */
    public long getChrono(){
        return this.chrono;
    }
    
    /******************************************************************
     * Méthodes concernant les briques                                *
     *****************************************************************/
   
    /**
     * Méthode qui permet d'ajouter notre objet passé en argument à notre structure de données 
     * @param B1 : notre objet brique que l'on souhaite ajouter à notre structure de données 
     */
    public void setBrique(Brique B1){
        this.B1 = B1;
    }
    
    /**
     * Méthode qui renvoie l'objet brique de notre sutrcutre de données 
     * @return l'objet brique de notre sutrcutre de données 
     */
    public Brique getBrique(){
        return this.B1;
    }
    
    /******************************************************************
     * Méthodes concernant le Joueur                                  *
     *****************************************************************/
    
    /**
     * Méthode qui permet d'ajouter notre objet passé en argument à notre structure de données 
     * @param J1 : notre objet joueur que l'on souhaite ajouter à notre structure de données 
     */
    public void setJoueur(Joueur J1){
        this.J1 = J1;
    }
    
    /**
     * Méthode qui renvoie l'objet joueur de notre structure de données 
     * @return l'objet joueur de notre structure de données
     */
    public Joueur getJoueur(){
        return this.J1;
    }
    
    /******************************************************************
     * Méthodes concernant les Ennemi                                 *
     *****************************************************************/
    
    /**
     * Méthode qui permet d'ajouter notre objet passé en argument à notre structure de données 
     * @param E1 : notre objet ennemi que l'on souhaite ajouter à notre structure de données 
     */
    public void setEnnemi(Ennemi E1){
        this.E1 = E1;
    }
    
    /**
     * Méthode qui renvoie l'objet ennemi de notre structure de données 
     * @return l'objet ennemi de notre structure de données 
     */
    public Ennemi getEnnemi(){
        return this.E1;
    }
    
    /******************************************************************
     * Méthodes concernant les Tondeuses                                 *
     *****************************************************************/
    
    /**
     * Méthode qui permet d'ajouter notre objet passé en argument à notre structure de données 
     * @param L1 : notre objet tondeuse que l'on souhaite ajouter à notre structure de données 
     */
    public void setTondeuse(Tondeuse L1){
        this.L1 = L1;
    }
    
    /**
     * Méthode qui renvoie l'objet tondeuse de notre structure de données 
     * @return l'objet tondeuse de notre structure de données 
     */
    public Tondeuse getTondeuse(){
        return this.L1;
    }
    
    /******************************************************************
     * Méthodes concernant la Map de niveau                           *
     *****************************************************************/
    
    /**
     * Méthode qui permet d'ajouter notre objet passé en argument à notre structure de données 
     * @param map : notre objet map que l'on souhaite ajouter à notre structure de données
     */
    public void setMap(Map map){
        this.map = map;
    }
    
    /**
     * Méthode qui renvoie l'objet map de notre structure de données 
     * @return l'objet map de notre structure de données 
     */
    public Map getMap(){
        return this.map;
    }
    
}
