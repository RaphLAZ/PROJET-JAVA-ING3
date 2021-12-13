package ProjetCPTI.Controller;

import java.util.Scanner;
import ProjetCPTI.Model.Brique;
import ProjetCPTI.Model.Ennemi;
import ProjetCPTI.Model.Joueur;
import ProjetCPTI.Model.Map;
import ProjetCPTI.Model.Potion;
import ProjetCPTI.Model.Struct;
import ProjetCPTI.Model.Tondeuse;
import ProjetCPTI.Model.Tunnel;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Mouvement{
    

    /*******************************************************
     * Méthodes de déplacement pour les briques            *
     *******************************************************/
    /**
     * Méthode qui vérifie si le déplacement sur la case dont on souhaite aller est possible 
     * @param map : correspond à notre plateau des objets qui ne bougent pas 
     * @param ordonnee : correspond à l'ordonnéee à laquelle on souhaite vérifier l'ojet sur lequel on s'intéresse 
     * @param abscisse : correspond à l'abscisse à laquelle on souhaite vérifier l'ojet sur lequel on s'intéresse
     * @return : true si le déplacement est possible, false dans le cas où le déplacement n'est pas possible 
     */
    public static boolean VoisinDeplacementBrique(Map map, int ordonnee, int abscisse){

        //Dans le cas où le déplacement est possible 
        if (map.ReturnCaseObject(ordonnee, abscisse).getSymbole() == ("\u001B[34m" + 'G' + "\u001B[0m") ||
            map.ReturnCaseObject(ordonnee, abscisse).getSymbole() == ("\u001B[32m" + 'C' + "\u001B[0m") ||
            map.ReturnCaseObject(ordonnee, abscisse).getSymbole() == "\u001B[36m" + 'g' + "\u001B[0m" ){
            
            return true;
        }
        else return false;
    }
    
    /**
     * Méthode déplacement pour la brique que le joueur peut déplacer durant le jeu 
     * @param struct : en paramètre notre structure de données du jeu qui contient notre plateau de jeu et les données sur chaque objet qui bougent 
     * @param direction : la direction dont laquelle on sohaite déplacer notre brique 
     */
    public static void DeplacementBrique(Struct struct, int direction){
        
        Brique B1 = struct.getBrique();
        Map map = struct.getMap();
        
        switch (direction){
            
            //Dans le cas où on veut aller vers le haut
            case 1:
                if (VoisinDeplacementBrique(map, B1.getOrdonnee() - 1, B1.getAbscisse()) == true){
                    B1.setOrdonnee(B1.getOrdonnee() - 1);
                    B1.setUnderObject(map.ReturnCaseObject(B1.getOrdonnee(), B1.getAbscisse()));
                }
                break;
                
            //Dans le cas où on veut aller vers le bas            
            case 2:
                if (VoisinDeplacementBrique(map, B1.getOrdonnee() + 1, B1.getAbscisse()) == true){
                    B1.setOrdonnee(B1.getOrdonnee() + 1);
                    B1.setUnderObject(map.ReturnCaseObject(B1.getOrdonnee(), B1.getAbscisse()));
                }
                break;
                
            //Dans le cas où on veut aller vers la droite    
            case 3:
                if (VoisinDeplacementBrique(map, B1.getOrdonnee(), B1.getAbscisse() + 1) == true){
                    B1.setAbscisse(B1.getAbscisse() + 1);
                    B1.setUnderObject(map.ReturnCaseObject(B1.getOrdonnee(), B1.getAbscisse()));
                }
                break;
                
            //Dans le cas où on veut aller vers la gauche 
            case 4:
                if (VoisinDeplacementBrique(map, B1.getOrdonnee(), B1.getAbscisse() - 1) == true){
                    B1.setAbscisse(B1.getAbscisse() - 1);
                    B1.setUnderObject(map.ReturnCaseObject(B1.getOrdonnee(), B1.getAbscisse()));
                }
                break;
        }
        struct.setBrique(B1);
    }
    
    /*******************************************************
     * Méthodes de déplacement pour le joueur              *
     *******************************************************/
    
    /**
     * Méthode qui vérifie si le déplacement sur la case dont on souhaite aller est possible 
     * @param struct : en paramètre notre structure de données du jeu qui contient notre plateau de jeu et les données sur chaque objet qui bougent 
     * @param ordonnee : correspond à l'ordonnéee à laquelle on souhaite vérifier l'ojet sur lequel on s'intéresse 
     * @param abscisse : correspond à l'abscisse à laquelle on souhaite vérifier l'ojet sur lequel on s'intéresse
     * @return : true si le déplacement est possible, false dans le cas où le déplacement n'est pas possible 
     */
    public static boolean VoisinDeplacementJoueur(Struct struct, int ordonnee, int abscisse){

        Map map = struct.getMap();
        
        //Dans le cas où le déplacement est possible 
        if (map.ReturnCaseObject(ordonnee, abscisse).getSymbole() == "\u001B[34m" + 'G' + "\u001B[0m" ||
            map.ReturnCaseObject(ordonnee, abscisse).getSymbole() == "\u001B[36m" + 'g' + "\u001B[0m" ||
            map.ReturnCaseObject(ordonnee, abscisse).getSymbole() == "\u001B[31m" + 'P' + "\u001B[0m" ||
            map.ReturnCaseObject(ordonnee, abscisse).getSymbole() == "\u001B[34m" + 'W' + "\u001B[0m" ||
            map.ReturnCaseObject(ordonnee, abscisse).getSymbole() == "\u001B[30m" + 'T' + "\u001B[0m" ||
            map.ReturnCaseObject(ordonnee, abscisse).getSymbole() == "\u001B[33m" + 'Q' + "\u001B[0m" ){
            
            return true;
        }
        else return false;
    }
    
    /**
     * Méthode qui permet de savoir si le joeur peut effecture le déplacement en fonction de la direction souhaité 
     * @param struct : en paramètre notre structure de données du jeu qui contient notre plateau de jeu et les données sur chaque objet qui bougent 
     * @param joueur : prends en paramètre l'objet joueur
     * @param direction : direction dans laquelle on souhaite vérifier que le joueur peut se déplacer  
     * @return true si le déplacement est possible, false dans la cas où le déplacement n'est pas possible 
     */
    public static boolean DeplacementPossible(Struct struct, Joueur joueur, int direction){
       
        boolean check = false;
        int ordonnee = 0;
        int abscisse = 0;
   
        switch(direction){
            
            //Vers le haut 
            case 1: 
                ordonnee = joueur.getOrdonnee() - 1;
                abscisse = joueur.getAbscisse();
                check = VoisinDeplacementJoueur(struct,ordonnee,abscisse);
                break;
            //Vers le bas 
            case 2:
                ordonnee = joueur.getOrdonnee() + 1;
                abscisse = joueur.getAbscisse();
                check = VoisinDeplacementJoueur(struct,ordonnee,abscisse);
                break;
            //Vers la droite
            case 3:
                ordonnee = joueur.getOrdonnee();
                abscisse = joueur.getAbscisse() + 1;
                check = VoisinDeplacementJoueur(struct,ordonnee,abscisse);
                break;
            //Vers la gauche 
            case 4:
                ordonnee = joueur.getOrdonnee();
                abscisse = joueur.getAbscisse() - 1;
                check = VoisinDeplacementJoueur(struct,ordonnee,abscisse);
                break;  
        }

        return check;
    }
    
    /**
     * Méthode qui effectue le déplacement du joueur ainsi que le changement sur la map après le passage si cela est possible  
     * @param struct : en paramètre notre structure de données du jeu qui contient notre plateau de jeu et les données sur chaque objet qui bougent 
     * @param direction : direction dans laquelle on souhaite vérifier que le joueur peut se déplacer 
     * @return true si le délacement a pu s'effectuer, false dans le cas où le déplacement n'est pas possible 
     */
    public static boolean DirectionDeplacement(Struct struct, int direction){

        Joueur J1 = struct.getJoueur();
        Map map = struct.getMap();
        Brique B1 = struct.getBrique();
        Tondeuse L1 = struct.getTondeuse();
        
        int ordonnee = J1.getOrdonnee();
        int abscisse = J1.getAbscisse();
        
        boolean check = false;
        //Dans le cas où le déplacement n'est pas possible 
        if (DeplacementPossible(struct, J1, direction) == false) check = false;
        
        //Dans le cas où le déplacement est possible 
        else{
            
            switch (direction){
                //Dans le cas où on veut aller vers le haut 
                case 1:
                    try{
                        if ( (B1.getOrdonnee() == J1.getOrdonnee() - 1) && B1.getAbscisse() == J1.getAbscisse()){
                            check = VoisinDeplacementBrique(map, B1.getOrdonnee() - 1, B1.getAbscisse());
                            if (check == false) return check;
                        }
                    }catch (Exception e){}
            
                    try{
                        if ( (L1.getOrdonnee() - 1 == J1.getOrdonnee() - 1) && L1.getAbscisse() == J1.getAbscisse()){
                            check = VoisinDeplacementBrique(map, L1.getOrdonnee() - 1, L1.getAbscisse());
                            if (check == false) return check;
                        }
                    }catch (Exception e){}
                    
                    TransformationObjet.ApresPassage(struct, J1);
                    J1.setOrdonnee(ordonnee - 1);
                    try{
                        DeplacementEnnemi(struct);
                    } catch (Exception IOException){}
                    J1.setUnderObject(map.ReturnCaseObject(ordonnee - 1, abscisse));
                    if (J1.getUnderSymbole() == "\u001B[33m" + 'Q' + "\u001B[0m"){
                        Potion potion = (Potion) map.ReturnCaseObject(J1.getOrdonnee(), J1.getAbscisse());
                        J1.setPotion(potion.getPotion());
                    }
                    if (J1.getPotion() > 0){
                        J1.setPotion(J1.getPotion() - 1);
                    }
                    check = true;
                    break;
                //Dans le cas où on veut aller vers le bas            
                case 2:
                    try{
                        if ( (B1.getOrdonnee() == J1.getOrdonnee() + 1) && B1.getAbscisse() == J1.getAbscisse()){
                            check = VoisinDeplacementBrique(map, B1.getOrdonnee() + 1, B1.getAbscisse());
                            if (check == false) return check;
                        }
                    }catch (Exception e){}
            
                    try{
                        if ( (L1.getOrdonnee() - 1 == J1.getOrdonnee() + 1) && L1.getAbscisse() == J1.getAbscisse()){
                            check = VoisinDeplacementBrique(map, B1.getOrdonnee() + 1, B1.getAbscisse());
                            if (check == false) return check;
                        }
                    }catch (Exception e){}
                    
                    TransformationObjet.ApresPassage(struct, J1);
                    J1.setOrdonnee(ordonnee + 1);
                    try{
                        DeplacementEnnemi(struct);
                    } catch (Exception IOException){}
                    J1.setUnderObject(map.ReturnCaseObject(ordonnee + 1, abscisse));
                    if (J1.getUnderSymbole() == "\u001B[33m" + 'Q' + "\u001B[0m"){
                        Potion potion = (Potion) map.ReturnCaseObject(J1.getOrdonnee(), J1.getAbscisse());
                        J1.setPotion(potion.getPotion());
                    }
                    if (J1.getPotion() > 0){
                        J1.setPotion(J1.getPotion() - 1);
                    }
                    check = true;
                    break;
                //Dans le cas où on veut aller vers la droite    
                case 3: 
                    try{
                        if ( (B1.getOrdonnee() == J1.getOrdonnee()) && B1.getAbscisse() == J1.getAbscisse() + 1){
                            check = VoisinDeplacementBrique(map, B1.getOrdonnee() - 1, B1.getAbscisse() + 1);
                            if (check == false) return check;
                        }
                    }catch (Exception e){}
            
                    try{
                        if ( (L1.getOrdonnee() - 1 == J1.getOrdonnee() - 1) && L1.getAbscisse() == J1.getAbscisse() + 1){
                            check = VoisinDeplacementBrique(map, B1.getOrdonnee(), B1.getAbscisse() + 1);
                            if (check == false) return check;
                        }
                    }catch (Exception e){}
                    
                    TransformationObjet.ApresPassage(struct, J1);
                    J1.setAbscisse(abscisse + 1);
                    try{
                        DeplacementEnnemi(struct);
                    } catch (Exception IOException){}
                    J1.setUnderObject(map.ReturnCaseObject(ordonnee, abscisse + 1));
                    if (J1.getUnderSymbole() == "\u001B[33m" + 'Q' + "\u001B[0m"){
                        Potion potion = (Potion) map.ReturnCaseObject(J1.getOrdonnee(), J1.getAbscisse());
                        J1.setPotion(potion.getPotion());
                    }
                    if (J1.getPotion() > 0){
                        J1.setPotion(J1.getPotion() - 1);
                    }
                    check = true;
                    break;
                //Dans le cas où on veut aller vers la gauche 
                case 4:
                    try{
                        if ( (B1.getOrdonnee() == J1.getOrdonnee()) && B1.getAbscisse() == J1.getAbscisse() - 1){
                            check = VoisinDeplacementBrique(map, B1.getOrdonnee() - 1, B1.getAbscisse() - 1);
                            if (check == false) return check;
                        }
                    }catch (Exception e){}
            
                    try{
                        if ( (L1.getOrdonnee() - 1 == J1.getOrdonnee() - 1) && L1.getAbscisse() == J1.getAbscisse() - 1){
                            check = VoisinDeplacementBrique(map, B1.getOrdonnee(), B1.getAbscisse() - 1);
                            if (check == false) return check;
                        }
                    }catch (Exception e){}
                    
                    TransformationObjet.ApresPassage(struct, J1);
                    J1.setAbscisse(abscisse - 1);
                    try{
                        DeplacementEnnemi(struct);
                    } catch (Exception IOException){}
                    J1.setUnderObject(map.ReturnCaseObject(ordonnee, abscisse - 1));
                    if (J1.getUnderSymbole() == "\u001B[33m" + 'Q' + "\u001B[0m"){
                        Potion potion = (Potion) map.ReturnCaseObject(J1.getOrdonnee(), J1.getAbscisse());
                        J1.setPotion(potion.getPotion());
                    }
                    if (J1.getPotion() > 0){
                        J1.setPotion(J1.getPotion() - 1);
                    }
                    check = true;
                    break;
            }
             try{
                if ( (B1.getOrdonnee() == J1.getOrdonnee()) && B1.getAbscisse() == J1.getAbscisse()){
                    Mouvement.DeplacementBrique(struct,direction);
                }
            }catch (Exception e){}
            
            try{
                if ( (L1.getOrdonnee() == J1.getOrdonnee()) && L1.getAbscisse() == J1.getAbscisse()){
                    Mouvement.DeplacementTondeuse(struct,direction);
                }
            }catch (Exception e){}
            
            try{
                if (J1.getUnderSymbole() == ("\u001B[30m" + 'T' + "\u001B[0m")){
                    Tunnel T1 = (Tunnel) map.ReturnCaseObject(J1.getOrdonnee(), J1.getAbscisse());
                
                    if (T1.getEntrance() == true){
                        int Ordonnee = ((Tunnel) map.ReturnCaseObject(J1.getOrdonnee(), J1.getAbscisse())).getOTunnelOrdonnee();
                        int Abscisse = ((Tunnel) map.ReturnCaseObject(J1.getOrdonnee(), J1.getAbscisse())).getOTunnelAbscisse();              
                        J1.setAbscisse(Abscisse);
                        J1.setOrdonnee(Ordonnee);
                        J1.setUnderObject(map.ReturnCaseObject(J1.getOrdonnee(), J1.getAbscisse()));
                    }
                }
            }catch (Exception e){}
        }
        
        struct.setJoueur(J1);
        return check;
    }
    
    /**
     * Méthode qui demande à l'utilisateur d'entrer la direction dans laquelle il souhaite aller et effectue les déplacement des ennemis si ils existent 
     * @param struct : en paramètre notre structure de données du jeu qui contient notre plateau de jeu et les données sur chaque objet qui bougent 
     */
    public static void DeplacementInput(Struct struct){
        boolean check = false;
        
        while (check == false){
            System.out.print("Veuillez entrer votre direction s'il vous plaît: ");
            Scanner sc = new Scanner(System.in);
            char input = sc.next().charAt(0);
            input = Character.toLowerCase(input);

            int direction;
            
            switch (input){
                case '2':
                case 's':
                    direction = 2;
                    check = DirectionDeplacement(struct, direction);
                    break;
                case '4':
                case 'q':
                    direction = 4;
                    check = DirectionDeplacement(struct, direction);
                    break;
                case '6':
                case 'd':
                    direction = 3;
                    check = DirectionDeplacement(struct, direction);
                    break;
                case '8':
                case 'z':
                    direction = 1;
                    check = DirectionDeplacement(struct, direction);
                    break;
                case 'p':
                    System.exit(0);
            }
        }  
    }
    
    /*******************************************************
     * Méthodes de déplacement pour les ennemis            *
     *******************************************************/
    
    /**
     * Méthode qui vérifie si le déplacement sur la case dont on souhaite aller est possible 
     * @param struct : en paramètre notre structure de données du jeu qui contient notre plateau de jeu et les données sur chaque objet qui bougent 
     * @param ordonnee : correspond à l'ordonnéee à laquelle on souhaite vérifier l'ojet sur lequel on s'intéresse 
     * @param abscisse : correspond à l'abscisse à laquelle on souhaite vérifier l'ojet sur lequel on s'intéresse
     * @return : true si le déplacement est possible, false dans le cas où le déplacement n'est pas possible 
     */
    public static boolean VoinsinDeplacementEnnemi(Struct struct, int ordonnee, int abscisse){

        Map map = struct.getMap();
        Brique B1 = struct.getBrique();
        Tondeuse L1 = struct.getTondeuse();
        
        //Dans le cas où le déplacement est possible 
        if (map.ReturnCaseObject(ordonnee, abscisse).getSymbole() == "\u001B[34m" + 'G' + "\u001B[0m" ||
            map.ReturnCaseObject(ordonnee, abscisse).getSymbole() == "\u001B[36m" + 'g' + "\u001B[0m" ||
            map.ReturnCaseObject(ordonnee, abscisse).getSymbole() == "\u001B[34m" + 'W' + "\u001B[0m" ){
            /*
            try{
                if (ordonnee == B1.getOrdonnee() && abscisse == B1.getAbscisse()){
                    return false;
                }
                
                else if (ordonnee == L1.getOrdonnee() && abscisse == L1.getAbscisse()){
                    return false;
                }
            } catch (Exception exception){}
            */
            return true;
        }
        else return false;
    }
    
    /**
     * Méthode qui vérifie si le déplacement est possible pour l'ennemi
     * @param struct : en paramètre notre structure de données du jeu qui contient notre plateau de jeu et les données sur chaque objet qui bougent 
     */
    public static void DeplacementPossible(Struct struct){
       
        Ennemi E1 = struct.getEnnemi();
        Map map = struct.getMap();
        
        boolean check;
        
        //déplacement à l'horizontal
        if (E1.getDirection() == true){
            
            //Vers la droite 
            if (E1.getWay() == true){
                int abscisseE = E1.getAbscisse() + 1;
                check = VoinsinDeplacementEnnemi(struct, E1.getOrdonnee(), abscisseE);
                if (check == false){
                    E1.setWay(false);
                }
            }
            
            //Vers la droite 
            else{
                int abscisseE = E1.getAbscisse() - 1;
                check = VoinsinDeplacementEnnemi(struct, E1.getOrdonnee(), abscisseE);
                if (check == false){
                    E1.setWay(true);
                }
            }
        }
        
        //déplacement à la vertical
        else{
            
            //Vers le bas 
            if (E1.getWay() == true){
                int ordonneeE = E1.getOrdonnee() + 1;
                check = VoinsinDeplacementEnnemi(struct, ordonneeE, E1.getAbscisse());
                if (check == false){
                    E1.setWay(false);
                }
            }
            
            //Vers le haut 
            else{
                int ordonneeE = E1.getOrdonnee() - 1;
                check = VoinsinDeplacementEnnemi(struct, ordonneeE, E1.getAbscisse());
                if (check == false){
                    E1.setWay(true);
                }
            }
        }
        struct.setEnnemi(E1);
    }
     
    /**
     * Méthode qui effectue le déplacement de l'ennemi dans le cas où cela est possible 
     * @param struct : en paramètre notre structure de données du jeu qui contient notre plateau de jeu et les données sur chaque objet qui bougent 
     */
    public static void DeplacementEnnemi(Struct struct){
        
        Ennemi E1 = struct.getEnnemi();
        Map map = struct.getMap();
        DeplacementPossible(struct);
        
        //déplacement à l'horizontal
        if (E1.getDirection() == true){
            
            //Vers la droite 
            if (E1.getWay() == true){
                int abscisseE = E1.getAbscisse() + 1;
                E1.setUnderObject(map.ReturnCaseObject(E1.getOrdonnee(), abscisseE));
                E1.setAbscisse(abscisseE);
                TransformationObjet.ApresPassage(struct, E1);
            }
            
            //Vers la droite 
            else{
                int abscisseE = E1.getAbscisse() - 1;
                E1.setUnderObject(map.ReturnCaseObject(E1.getOrdonnee(), abscisseE));
                E1.setAbscisse(abscisseE); 
                TransformationObjet.ApresPassage(struct, E1);
            }
        }
        
        //déplacement à la vertical
        else{
            
            //Vers le bas 
            if (E1.getWay() == true){
                int ordonneeE = E1.getOrdonnee() + 1;
                E1.setUnderObject(map.ReturnCaseObject(ordonneeE, E1.getAbscisse()));
                E1.setOrdonnee(ordonneeE);
                TransformationObjet.ApresPassage(struct, E1);
            }
            
            //Vers le haut 
            else{
                int ordonneeE = E1.getOrdonnee() - 1;
                E1.setUnderObject(map.ReturnCaseObject(ordonneeE, E1.getAbscisse()));
                E1.setOrdonnee(ordonneeE); 
                TransformationObjet.ApresPassage(struct, E1);
            }
        }
        
        struct.setEnnemi(E1);
    } 
    
    /*******************************************************
     * Méthodes de déplacement pour les tondeuses          *
     ******************************************************/
    
    /**
     * Méthode qui effectue le déplacement de la tondeuse dans le cas où cela est possible 
     * @param struct : en paramètre notre structure de données du jeu qui contient notre plateau de jeu et les données sur chaque objet qui bougent 
     * @param direction : direction dans laquelle on souhaite vérifier que le joueur peut se déplacer
     */
    public static void DeplacementTondeuse(Struct struct, int direction){
        
        Tondeuse L1 = struct.getTondeuse();
        Map map = struct.getMap();
        
        switch (direction){
            
            //Dans le cas où on veut aller vers le haut
            case 1:
                while (VoisinDeplacementBrique(map, L1.getOrdonnee() - 1, L1.getAbscisse()) == true){    
                    TransformationObjet.ApresPassage(struct, L1);
                    L1.setOrdonnee(L1.getOrdonnee() - 1);
                    L1.setUnderObject(map.ReturnCaseObject(L1.getOrdonnee(), L1.getAbscisse()));
                }
                break;
                
            //Dans le cas où on veut aller vers le bas            
            case 2:
                while (VoisinDeplacementBrique(map, L1.getOrdonnee() + 1, L1.getAbscisse()) == true){
                    TransformationObjet.ApresPassage(struct, L1);
                    L1.setOrdonnee(L1.getOrdonnee() + 1);
                    L1.setUnderObject(map.ReturnCaseObject(L1.getOrdonnee(), L1.getAbscisse()));
                }
                break;
                
            //Dans le cas où on veut aller vers la droite    
            case 3:
                while (VoisinDeplacementBrique(map, L1.getOrdonnee(), L1.getAbscisse() + 1) == true){
                    TransformationObjet.ApresPassage(struct, L1);
                    L1.setAbscisse(L1.getAbscisse() + 1);
                    L1.setUnderObject(map.ReturnCaseObject(L1.getOrdonnee(), L1.getAbscisse()));
                }
                break;
                
            //Dans le cas où on veut aller vers la gauche 
            case 4:
                while (VoisinDeplacementBrique(map, L1.getOrdonnee(), L1.getAbscisse() - 1) == true){
                    TransformationObjet.ApresPassage(struct, L1);
                    L1.setAbscisse(L1.getAbscisse() - 1);
                    L1.setUnderObject(map.ReturnCaseObject(L1.getOrdonnee(), L1.getAbscisse()));
                } 
                break;
        }
        struct.setTondeuse(L1);
    }
    
}