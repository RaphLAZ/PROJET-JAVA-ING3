package ProjetCPTI.Model;
/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public  abstract class Element extends Objet{
    private int abscisse; //abscisse de notre élèment 
    private int ordonnee; //ordonnee de notre élèment 
    private Objet objet; //objet se situant sous notre élèment 
    
    /**
     * Méthode qui permet d'écrire le symbol correspondant à notre objet, car la classe Elemennt dérive de la classe Objet 
     * @param Symbole : correspond au symbole dont on souhaite définir à notre objet 
     */
    @Override
    public void setSymbole(String Symbole){
        super.setSymbole(Symbole);
    }
    
    /**
     * Méthode qui permet de définir l'abscisse de notre élèment 
     * @param abscisse : abscisse que l'on souhaite attribuer à notre élèment 
     */
    public void setAbscisse(int abscisse){
        this.abscisse = abscisse;
    }
    
    /**
     * Méthode qui permet de définir l'ordonnee de notre élèment 
     * @param ordonnee : ordonnee de notre élèment 
     */
    public void setOrdonnee(int ordonnee){
        this.ordonnee = ordonnee;
    }
    
    /**
     * Méthode qui retourne l'abscisse de notre élèment 
     * @return : l'abscisse de notre élèment 
     */
    public int getAbscisse(){
        return this.abscisse;
    }
    
    /**
     * Méthode qui retourne l'ordonnee de notre élèment 
     * @return : l'ordonnee de notre élèment 
     */
    public int getOrdonnee(){
        return this.ordonnee;
    }
    
    /**
     * Méthode qui permet de définir l'objet qui se situe sous notre élèment sur le plateau de jeu  
     * @param objet : objet dont on souhaite définir sous notre élèment 
     */
    public void setUnderObject(Objet objet){
        this.objet = objet;
    }
    
    /**
     * Méthode qui permet de retourner l'objet de notre plateau de jeu qui se situe sous notre élèment 
     * @return : l'objet qui se situe sous notre élèment 
     */
    public Objet getUnderObject(){
        return this.objet;
    }
    
    /**
     * Méthode qui retourne le symbole de l'objet qui se situe sous notre élèment sur le plateau de jeu 
     * @return : symbole de l'objet qui se situe sous notre élèment sur le plateau de jeu 
     */
    public String getUnderSymbole(){
        return this.objet.getSymbole();
    }
    
}
