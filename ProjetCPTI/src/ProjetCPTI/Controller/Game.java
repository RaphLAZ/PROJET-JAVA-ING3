package ProjetCPTI.Controller;

import java.io.IOException;
import ProjetCPTI.Model.Chrono;
import ProjetCPTI.Model.Ennemi;
import ProjetCPTI.Model.Joueur;
import ProjetCPTI.Model.Map;
import ProjetCPTI.Model.Struct;
import ProjetCPTI.View.Affichage;
import ProjetCPTI.View.MyFrame;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Game{
    
    public static MyFrame framePrincipal;
    
    /**
     * Méthode qui lance notre jeu à partir du niveau passé en argument
     * @param level : représente le niveau à partir duquel on souhaite commencer le jeu 
     * @throws IOException : renvoie IOException dans le cas où les fichiers nécessaires à l'initialisation du jeu n'ont pas pu être lus 
     */
    public static void GameStart(int level) throws IOException{
        
        for (int i = level;i <= 5;i++){
            
            Struct struct = new Struct();
            
            try{
                struct = Game.GameInit(i);
                if (GamePlay(struct) == 1){
                    GameStart(i);
                }
            
                System.out.println();
                System.out.println("Vous avez réussi le niveau " + level +  "!");
                System.out.println();
            } catch (IOException exception){}  
        }
    }
    
    /**
     * Méthode qui initialse notre plateau de jeu, les données des objets qui bougent et affichage notre plateau de jeu à l'écran 
     * @param level : prends en paramètre le niveau que l'on souhaite initialisé 
     * @return : retourne la structure de donnée qui contient notre plateau de jeu et les données sur chaque objet qui bougent 
     * @throws IOException : renvoie IOException dans le cas où les fichiers nécessaires à l'initialisation du jeu n'ont pas pu être lus
     */
    public static Struct GameInit(int level) throws IOException{

        Struct struct = new Struct();
        try{
            
            Map map = new Map(level);
            struct.setMap(map);
            FileData.SetParameters(struct);
            Affichage.AfficheMap(struct);
        } catch(IOException exception){}
        
        return struct;
    }
    
    /**
     * Méthode qui constitue notre jeu du niveau quel on est
     * @param struct : en paramètre notre structure de données du jeu qui contient notre plateau de jeu et les données sur chaque objet qui bougent  
     * @return : renvoie 1 si on a fait un GameOver, ou 0 si le niveau a été réalisé sans GameOver
     */
    public static int GamePlay(Struct struct){
       
        Chrono chrono = new Chrono();
        chrono.Start();
        
        Joueur J1 = struct.getJoueur();
        Map map = struct.getMap();
        
        while (J1.getUnderSymbole() != "\u001B[31m" + 'P' + "\u001B[0m" && map.getCaseSolved() != map.getCaseToSolve()){
            
            if (GameOverCheck(struct) == false){
               return 1;
            }
            else{
                Mouvement.DeplacementInput(struct);
                struct.setChrono(chrono.TempsEcoule());
                Affichage.AfficheMap(struct);
            }
        }
        
        chrono.Stop();
        struct.setChrono(chrono.TempsEcoule());
        Game.CalculScoreTime(struct);
        
        try{
            FileData.SaveScores(struct);
        }
        catch (IOException e){}
        
        return 0;
    }
    
    public static void CalculScoreTime(Struct struct){
        Map map = struct.getMap();
        int scorec = map.getScore();
        int chr = (int) struct.getChrono();
        
        switch (map.getLevel()) {
            case 1:
                scorec *= 45/chr;
                break;
            case 2:
                scorec *= 100/chr;
                break;
            case 3:
                scorec *= 100/chr;
                break;
            case 4:
                scorec *= 100/chr;
                break;
            case 5:
                scorec *= 100/chr;
                break;
            default:
                break;
        }
        map.setScore(scorec);
        struct.setMap(map);
    }
    
        /**
     * Méthode qui affiche à l'écran le cas où on est dans une situation de GameOver
     * @param struct : en paramètre notre structure de données du jeu qui contient notre plateau de jeu et les données sur chaque objet qui bougent
     * @return false si on est dans une situation de GameOver, true dans le cas contraire 
     */
    public static boolean GameOverCheck(Struct struct){

        Joueur J1 = struct.getJoueur();
        Ennemi E1 = struct.getEnnemi();
        Map map = struct.getMap();
        
        try{
            if ( (J1.getAbscisse() == E1.getAbscisse()) && (J1.getOrdonnee() == E1.getOrdonnee()) ){
                System.out.println("Game Over !");
                System.out.println();
                return false;
            }
        }catch (Exception e){}
        
        if (J1.getUnderSymbole() == ("\u001B[34m" + 'W' + "\u001B[0m")){
            System.out.println("Game Over !");
            System.out.println();
            return false;
        }
        
        return true;
    }
    
}
