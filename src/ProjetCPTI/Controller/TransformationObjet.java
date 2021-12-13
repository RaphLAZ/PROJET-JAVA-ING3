package ProjetCPTI.Controller;

import ProjetCPTI.Model.Element;
import ProjetCPTI.Model.Ennemi;
import ProjetCPTI.Model.GlaceDur;
import ProjetCPTI.Model.GlaceFine;
import ProjetCPTI.Model.Joueur;
import ProjetCPTI.Model.Map;
import ProjetCPTI.Model.Objet;
import ProjetCPTI.Model.Struct;
import ProjetCPTI.Model.Tunnel;
import ProjetCPTI.Model.Water;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class TransformationObjet{
    
    /**
     * Méthode qui transforme l'objet après que le joueur soit passé dessus
     * @param struct : en paramètre notre structure de données du jeu qui contient notre plateau de jeu et les données sur chaque objet qui bougent  
     * @param element  : en parametre l'élèment dont on souhaite transformer l'objet en dessous après son passage 
     */
    public static void ApresPassage(Struct struct, Element element){
        Map map = struct.getMap();
        Joueur J1;
        int ordonnee = element.getOrdonnee();
        int abscisse = element.getAbscisse();
        Objet objet = null;
        
        if (element.getSymbole() == "\u001B[35m" + 'J' + "\u001B[0m"){
            Joueur joueur = (Joueur) element;
            
            if (joueur.getPotion() > 0){
                switch (joueur.getUnderSymbole()){
                    case "\u001B[34m" + 'G' + "\u001B[0m":
                        objet = new GlaceDur();
                        map.setScore(20);
                        break;
                    case "\u001B[36m" + 'g' + "\u001B[0m":
                        objet = new GlaceFine();
                        map.setScore(40);
                        break;
                    case "\u001B[33m" + 'Q' + "\u001B[0m":
                        objet = new GlaceFine();
                        break;
                }
                map.setCaseObject(ordonnee, abscisse, objet);
                struct.setMap(map);
                return;
            }
        }
        
        if (element.getSymbole() == "\u001B[35m" + 'E' + "\u001B[0m"){
            Ennemi ennemi = (Ennemi) element;
            
            switch (ennemi.getUnderSymbole()){
                    case "\u001B[34m" + 'G' + "\u001B[0m":
                        objet = new GlaceDur();
                        break;
                    case "\u001B[36m" + 'g' + "\u001B[0m":
                        objet = new GlaceFine();
                        break;
                    case "\u001B[33m" + 'Q' + "\u001B[0m":
                        objet = new GlaceFine();
                        break;
                    case "\u001B[34m" + 'W' + "\u001B[0m":
                        objet = new Water();
                        break;
                }
                map.setCaseObject(ordonnee, abscisse, objet);
                struct.setMap(map);
                return;
        }

        switch (element.getUnderSymbole()){
            case "\u001B[34m" + 'G' + "\u001B[0m":
                objet = new GlaceFine();
                map.setScore(20);
                break;
            case "\u001B[36m" + 'g' + "\u001B[0m":
                objet = new Water();
                map.CaseSolvedAction();
                map.setScore(40);
                break;
            case "\u001B[33m" + 'Q' + "\u001B[0m":
                objet = new Water();
                break;
            case "\u001B[30m" + 'T' + "\u001B[0m":
                objet = new Tunnel();
                break;
            default:
                objet = map.ReturnCaseObject(ordonnee, abscisse);
                break;
        }
            
        
        map.setCaseObject(ordonnee, abscisse, objet);
        struct.setMap(map);
    }
  
}
