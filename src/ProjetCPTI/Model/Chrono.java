package ProjetCPTI.Model;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Chrono{
    private long depart; //l'heure de lancement du chronomètre 
    private long fin; //l'heure de fin du chronomètre 
    private boolean execution; //true si le chrono tourne toujours, false si le chrono ne tourne plus 
    
    /**
     * Constructeur de notre objet chronomètre 
     */
    public Chrono(){
        this.depart = 0;
        this.fin = 0;
        this.execution = false;
    }
    
    /**
     * Méthode qui permet de dmarrer le chronomètre 
     */
    public void Start(){
        this.depart = System.currentTimeMillis();
        this.execution = true;
    }
    
    /**
     * Méthode qui permet d'arréter le chronomètre 
     */
    public void Stop(){
        this.fin = System.currentTimeMillis();
        this.execution = false;
    }
    
    /**
     * Méthode qui permet de déterminer le temps écoulé entre le lancement et l'arrêt du chronomètre 
     * @return le temps écoulé entre le lancement et l'arrêt du chronomètre 
     */
    public long TempsEcoule(){
        long ecoule = 0;
        if (this.execution){
            ecoule = (System.currentTimeMillis() - this.depart) / 1000;
        }
        else{
            ecoule = (this.fin - this.depart) / 1000;
        }
        return ecoule;
    }
 
}
