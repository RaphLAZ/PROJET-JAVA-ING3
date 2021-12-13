package ProjetCPTI.Controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import ProjetCPTI.Model.Brique;
import ProjetCPTI.Model.Ennemi;
import ProjetCPTI.Model.Joueur;
import ProjetCPTI.Model.Map;
import ProjetCPTI.Model.Potion;
import ProjetCPTI.Model.Struct;
import ProjetCPTI.Model.Tondeuse;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import ProjetCPTI.Model.Tunnel;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class FileData{
    
    /**
     * Méthode qui permet d'initialiser nos objets qui bougent sur notre matrice de jeu ou bien pour remplir les données nécessaires sur les tunnels 
     * @param struct : en paramètre notre structure de données du jeu qui contient notre plateau de jeu et les données sur chaque objet qui bougent 
     * @throws IOException : renvoie IOException dans le cas où le fichier est introuvable ou si le fichier n'est pas en mode lecture 
     */
    public static void SetParameters(Struct struct) throws IOException{
        
        //On récupère les informations de notre structure de donnée nécessaire pour notre jeu
        Map map = struct.getMap();
        Joueur J1 = struct.getJoueur();
        Ennemi E1 = struct.getEnnemi();
        Brique B1 = struct.getBrique();
        Tondeuse L1 = struct.getTondeuse();
        
        Tunnel T1 = null;
        Tunnel T2 = null;

        File file = new File("src\\ProjetCPTI\\Model\\Files\\Datalevel" + map.getLevel()  + ".txt");
        try{
            FileReader fr = new FileReader(file); 
            BufferedReader br = new BufferedReader(fr);
            
            StringBuilder sb = new StringBuilder();
            String line;
            int indice = 10;
            int numberA = 0;
            int numberO = 0;
            int OnumberA = 0;
            int OnumberO = 0;
            boolean TunnelCheck = false;
            
            while((line = br.readLine()) != null){
                sb.append(line);
                char FCaractere = sb.charAt(0);
                sb.deleteCharAt(0);

                for (int a = 0;a < 4;a++){
                    
                    int toadd = Character.getNumericValue(sb.charAt(a));
                    
                    if (a > 1){
                        numberA = numberA + (indice * toadd);
                    }
                    else{
                        numberO = numberO + (indice * toadd);
                    }
                    
                    if (indice == 1) indice = 10;
                    else indice = indice / 10;
                }
                
                sb.delete(0, 4);
                
                switch (FCaractere){
                    
                    case 'J':
                        J1 = new Joueur(numberA, numberO);
                        J1.setUnderObject(map.ReturnCaseObject(numberO, numberA));
                        break;
                    case 'E':
                        E1 = new Ennemi(numberA, numberO);
                        E1.setUnderObject(map.ReturnCaseObject(numberO, numberA));
                        boolean direction;
                        direction = Character.getNumericValue(sb.charAt(0)) == 1;
                        E1.setDirection(direction);
                        boolean way;
                        way = Character.getNumericValue(sb.charAt(1)) == 1;
                        E1.setWay(way);
                        sb.delete(0, 2);
                        break;
                    case 'B':
                        B1 = new Brique(numberA, numberO);
                        B1.setUnderObject(map.ReturnCaseObject(numberO, numberA));
                        break;
                    case 'T':
                        if (TunnelCheck == false){
                            T1 = new Tunnel();
                            T2 = new Tunnel();
                            T1.setEntrance(Character.getNumericValue(sb.charAt(0)) == 1);
                            OnumberA = numberA;
                            OnumberO = numberO;
                            TunnelCheck = true;                       
                            sb.delete(0, 1);
                        }
                        else{
                            T2.setEntrance(Character.getNumericValue(sb.charAt(0)) == 1);
                            T1.setOTunnelCoordonnees(numberA, numberO);
                            T2.setOTunnelCoordonnees(OnumberO, OnumberA);
                            map.setCaseObject(OnumberO, OnumberA, T1);
                            map.setCaseObject(numberO, numberA, T2);
                            sb.delete(0, 1);
                        }
                        break;
                    case 'L':
                        L1 = new Tondeuse(numberA, numberO);
                        L1.setUnderObject(map.ReturnCaseObject(numberO, numberA));
                        break;
                    case 'Q':
                        Potion potion = (Potion) map.ReturnCaseObject(numberO, numberA);
                        potion.setPotion(Character.getNumericValue(sb.charAt(0)));
                        map.setCaseObject(numberO, numberA, potion);
                        sb.delete(0, 1);
                }
                
                numberA = 0;
                numberO = 0;
                
            }
            struct.setTondeuse(L1);
            struct.setJoueur(J1);
            struct.setEnnemi(E1);
            struct.setBrique(B1);
            struct.setMap(map);
            br.close();
            fr.close();
        } catch (IOException exception){
            System.err.println("Le fichier est introuvable, soit n'est pas en mode lecture, problème Méthode FileData.SetParameters");
        }
    }
    
    /**
     * Méthode qui permet d'enregistrer les scores d'une partie 
     * @param struct : en paramètre notre structure de données du jeu qui contient notre plateau de jeu et les données sur chaque objet qui bougent 
     * @throws IOException : renvoie IOException si le fichier nommé existe mais est un répertoire plutôt qu’un fichier régulier, 
     *                       n’existe pas mais ne peut pas être créé, ou ne peut pas être ouvert pour toute autre raison
     */
    public static void SaveScores(Struct struct) throws IOException{
       
        try{
            Writer file = new FileWriter("src\\ProjetCPTI\\Model\\Files\\ScoreSave.txt", true);
            Map map = struct.getMap();
            
            file.write(String.valueOf(map.getLevel()) + " <- Niveau atteint ");
            file.write(String.valueOf(map.getScore()) + " <- Score obtenu ");
            file.write(String.valueOf(struct.getChrono()) + " <- Temps nécessaire\n");
            file.close();
        }
        catch (IOException exception){
            System.err.println("Le fichier nommé existe mais est un répertoire plutôt qu’un fichier régulier,"
                    + "ou alors il n’existe pas mais ne peut pas être créé, ou ne peut pas être ouvert pour toute autre raison");
        }
    }
    
}
