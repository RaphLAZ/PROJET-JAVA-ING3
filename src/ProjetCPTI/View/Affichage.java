package ProjetCPTI.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import ProjetCPTI.Controller.Game;
import ProjetCPTI.Model.Brique;
import ProjetCPTI.Model.Ennemi;
import ProjetCPTI.Model.Joueur;
import ProjetCPTI.Model.Map;
import ProjetCPTI.Model.Struct;
import ProjetCPTI.Model.Tondeuse;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Affichage{
    
    /**
     * Méthode qui affiche notre menu de jeu 
     */
    public static void AfficheMenu(){
        
            System.out.println();
            System.out.println("Bienvue au jeu FINN - ECE !");
            System.out.println();
            System.out.println("Veuillez entrer la lettre h pour accéder aux règles du jeu");
            System.out.println("Veuillez entrer la lettre s pour afficher les Scores de la partie sauvegardée");
            System.out.println("Veuillez entrer la lettre n pour commencer une nouvelle partie");
            System.out.println("Veuillez entrer la lettre r pour reprendre une partie déjà sauvegardée");
            System.out.println();
            System.out.print("Veuillez entrer votre choix: ");
            
            Scanner sc = new Scanner(System.in);
            char input = sc.next().charAt(0);
            input = Character.toLowerCase(input);
            System.out.println();
        
            switch(input){
                case 'h':
                    try{
                        AnnonceRegles();
                        System.out.println();
                        System.out.print("Appuyer sur la lettre q pour revenir en arrière au menu d'accueil: ");
                        while (input != 'q'){
                            input = sc.next().charAt(0);
                            input = Character.toLowerCase(input);
                            if (input == 'q') AfficheMenu();
                        } 
                        break;
                    }catch (IOException exception){}
                case 's':
                    AfficherScores();
                    System.out.println();
                    System.out.print("Appuyer sur la lettre q pour revenir en arrière au menu d'accueil: ");
                    while (input != 'q'){
                        input = sc.next().charAt(0);
                        input = Character.toLowerCase(input);
                        if (input == 'q') AfficheMenu();
                    }
                    break;
                case 'n':
                    File file = new File("src\\ProjetCPTI\\Model\\Files\\ScoreSave.txt");
                    file.delete();
                    try{
                        Game.GameStart(1);
                    } catch (IOException exception){}
                    break;
                case 'r':
                    int level = RecupererSavePartie();
                    try{
                        Game.GameStart(level);
                    } catch (IOException exception){}
                    break;
                case 'p':
                    System.exit(0);
                default:
                    AfficheMenu();
                    break;
            }   
    }
    
    /**
     * Méthode qui permet de récuper le niveau de la partie sauvegardée 
     * @return le niveau de la partie sauvegardée, ou bien 1 si aucune partie n'a été sauvegardée  
     */
    public static int RecupererSavePartie(){
        try{
            File file = new File("src\\ProjetCPTI\\Model\\Files\\ScoreSave.txt");
            FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null){
                sb.setLength(0);
                sb.append(line);
            }

            char Level = sb.charAt(0);
            int level = Character.getNumericValue(Level);
            if (level < 5){
                br.close();
                fr.close();
                return level + 1;
            }
            else{
                System.out.println("Le dernier niveau sauvegardé est de niveau 5, donc le jeu va commencer au niveu 1");
                br.close();
                fr.close();
                file.delete();
                return 1;
            }         
        } catch (IOException exception){
            System.err.println("Il n'existe aucune partie enregistrée");
        }
        return 1;
    }
    
    /**
     * Méthode qui annonce les règles du jeu 
     * @throws IOException : renvoie IOException dans le cas où les fichiers nécessaires à l'initialisation du jeu n'ont pas pu être lus
     */
    public static void AnnonceRegles() throws IOException{
        String text = "";
        try{
            File file = new File("src\\ProjetCPTI\\Model\\Files\\GameRules.txt");
            FileReader fr = new FileReader(file); BufferedReader in = new BufferedReader(fr);
            String Buffer;
            while ((Buffer = in.readLine()) != null){
                text = text + "\n" + Buffer;
            }
            System.out.println(text);
            in.close();
            fr.close();
        }
        catch(FileNotFoundException e){
            System.err.println("Le répertoire spécifié est introuvable dans la méthode AnnonceRegles de la classe Affichage.java");
        }
        catch(IOException e){
            System.err.println("Une erreur est survenue dans la lecture du fichier spécifié, veuillez vérifier que le fichier est en mode lecture");
        }
    }
    
    /**
     * Méthode qui affiche les scores de la partie sauvegardée 
     */
    public static void AfficherScores(){
        try (BufferedReader in = new BufferedReader(new FileReader("src\\ProjetCPTI\\Model\\Files\\ScoreSave.txt"))){
            String Buffer;
            while ((Buffer = in.readLine()) != null){
                System.out.println(Buffer);
            }
        }
        catch(Exception e){
            System.out.println("Aucune partie n'a été sauvegardée, il n'y a donc pas de scores à afficher");
        }
    }
      
    /**
     * Méthode qui affiche notre jeu 
     * @param struct : en paramètre notre structure de données du jeu qui contient notre plateau de jeu et les données sur chaque objet qui bougent 
     */
    public static void AfficheMap(Struct struct){

        Map map = struct.getMap();
        Joueur J1 = struct.getJoueur();
        Ennemi E1 = struct.getEnnemi();
        Brique B1 = struct.getBrique();
        Tondeuse L1 = struct.getTondeuse();
        String Symbole;
        
        for (int i = 0;i < map.getNbrLignes();i++){

            for (int j = 0;j < map.getNbrColonnes();j++){
                Symbole = map.ReturnCaseObjectSymbole(i, j);
                
                try{
                    if (E1.getAbscisse() == j && E1.getOrdonnee() == i){
                        Symbole = E1.getSymbole();
                    }
                }catch(Exception e){}
                
                try{
                    if (B1.getAbscisse() == j && B1.getOrdonnee() == i){
                        Symbole = B1.getSymbole();
                    }
                }catch (Exception e){}
                
                try{
                    if (L1.getAbscisse() == j && L1.getOrdonnee() == i){
                        Symbole = L1.getSymbole();
                    }
                }catch (Exception e){}
                
                if (J1.getAbscisse() == j && J1.getOrdonnee() == i){
                        Symbole = J1.getSymbole();
                }

                System.out.print(" " + Symbole + " |");
            }
            System.out.println();
        }
        
        System.out.println();
        if (J1.getPotion() > 0){
            System.out.println("Points de légèreté: " + J1.getPotion());
        }
        System.out.println("level " + map.getLevel());
        System.out.println(map.getCaseSolved() + "/" + map.getCaseToSolve());
        System.out.println("Score: " + map.getScore());
        System.out.println("Temps Ecoulé: " + struct.getChrono() + " secondes");
        
        System.out.println();
    }
        
}
