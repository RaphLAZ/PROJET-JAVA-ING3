package ProjetCPTI.Model;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public abstract class Objet{
    private String Symbole; //symbole de notre objet
    private JLabel label;

    /**
     * Méthode qui ermet de définir le symbole de notre objet 
     * @param Symbole : symbole de notre objet 
     */
    public void setSymbole(String Symbole){
        this.Symbole = Symbole;
    }
    
    /**
     * Méthode qui renvoie le symbole de notre objet 
     * @return : renvoie le symbole de notre objet
     */
    public String getSymbole(){
        return this.Symbole;
    }
    
    /**
     * Méthode qui renvoie notre objet avec ses attributs  
     * @return : l'objet avec ses attributs 
     */
    public Objet getObject(){
        return this;
    }
    
    public void setLabel(String access){
        this.label = new JLabel();
        ImageIcon image = new ImageIcon(access);
        label.setIcon(image);   
    }
    
    public JLabel getLabel(){
        return this.label;
    }
    
}
