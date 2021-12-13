package ProjetCPTI.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public class Map{
    private int lignes; //nombre de lignes de notre plateau de jeu 
    private int colonnes; //nombre de colonnes de notre plateau de jeu 
    private Objet [][] matrice; //matrice de notre plateau de jeu 
    private final int level; //niveau de notre plateau de jeu 
    private int CaseToSolve; //nombre de cases de glace à transformer en eau 
    private int CaseSolved; //nombre de cases transformées en eau 
    private int Score; //score atteint lors du parcours de la matrice 
    
    /**
     * Constructeur de notre objet Map, plateau de jeu 
     * @param level : correspond au niveau de la carte de jeu qu'on souhaite initialiser 
     * @throws IOException : renvoie IOException dans le cas où le fichier est introuvable ou si le fichier n'est pas en mode lecture 
     */
    public Map(int level) throws IOException{

        this.level = level;
        this.lignes = 15;
        this.colonnes = 19;
        this.CaseToSolve = 0;
        this.CaseSolved = 0;
        this.Score = 0;
        this.matrice = new Objet [this.lignes][this.colonnes];

        try{
            File file = new File("src\\ProjetCPTI\\Model\\Files\\level" + this.level  + ".txt");
            FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr);
            int i = 0;
            int j = 0;
            int c;

            while((c = br.read()) != -1){
                char ch = (char) c;
                switch (ch){
                    case '#':
                        matrice[j][i] = new Empty();
                        i++;
                        break;
                    case 'G':
                        matrice[j][i] = new GlaceDur();
                        CaseToSolve++;
                        i++;
                        break;
                    case 'g':
                        matrice[j][i] = new GlaceFine();
                        CaseToSolve++;
                        i++;
                        break;
                    case 'M':
                        matrice[j][i] = new Mur();
                        i++;
                        break;
                    case 'P':
                        matrice[j][i] = new Porte();
                        i++;
                        break;
                    case 'W':
                        matrice[j][i] = new Water();
                        i++;
                        CaseSolved++;
                        break;
                    case 'T':
                        matrice[j][i] = new Tunnel();
                        i++;
                        break;
                    case 'C':
                        matrice[j][i] = new CaseBrique();
                        i++;
                        break;
                    case 'Q':
                        matrice[j][i] = new Potion();
                        i++;
                        break;
                }
                
                if (i == this.colonnes){
                    j++;
                    i = 0;
                }
            }
            br.close();
            fr.close();
        } catch (IOException exception){
            System.err.println("Le fichier est introuvable, soit n'est pas en mode lecture dans le constructuer Map");
        }
    }
    
    /**
     * Méthode qui modifie l'objet se trouvant la place abscisse, ordonnee de la matrice de jeu 
     * @param ordonnee : ordonnee de la matrice dont on souhaite modifier l'objet 
     * @param abscisse : abscisse de la matrice dont on souhaite modifier l'objet 
     * @param objet : objet par lequel on souhaite modifier dans la matrice de jeu 
     */
    public void setCaseObject(int ordonnee, int abscisse, Objet objet){
        this.matrice[ordonnee][abscisse] = objet;
    }
    
    /**
     * Méthode qui renvoie l'objet du plateau de jeu correspond aux coordonnées passé en paramètre 
     * @param ordonnee : ordonnee de l'objet dont on souhaite renvoyer 
     * @param abscisse : absicsse de l'objet dont on souhaite renvoyer 
     * @return : l'objet du plateau de jeu correspond aux coordonnées passé en paramètre 
     */
    public Objet ReturnCaseObject(int ordonnee, int abscisse){
        return this.matrice[ordonnee][abscisse];
    }
    
    /**
     * Méthode qui renvoie le symbole de l'objet du plateau de jeu correspond aux coordonnées passé en paramètre 
     * @param ordonnee : ordonnee de l'objet dont on souhaite renvoyer le symbole 
     * @param abscisse : abscisse de l'objet dont on souhaite renvoyer le symbole 
     * @return le symbole de l'objet du plateau de jeu correspond aux coordonnées passé en paramètre
     */
    public String ReturnCaseObjectSymbole(int ordonnee, int abscisse){
        return this.matrice[ordonnee][abscisse].getSymbole();
    }
    
    /**
     * Méthode qui incrémente notre attribut CaseSolved 
     */
    public void CaseSolvedAction(){
        this.CaseSolved++;
    }
    
    /**
     * Méthode qui renvoie le nombre de cases transformés en eau 
     * @return le nombre de cases transformés en eau 
     */
    public int getCaseSolved(){
        return this.CaseSolved;
    }
    
    /**
     * Mthode qui renvoie le nombre de cases qu'il reste à transformer en eau 
     * @return le nombre de cases qu'il reste à transformer en eau 
     */
    public int getCaseToSolve(){
        return this.CaseToSolve;
    }
    
    /**
     * Méthode qui renvoie le niveau de notre plateau de jeu 
     * @return le niveau de notre plateau de jeu 
     */
    public int getLevel(){
        return this.level;
    }
    
    /**
     * Méthode qui renvoie le nmbre de lignes de notre plateau de jeu 
     * @return le nmbre de lignes de notre plateau de jeu 
     */
    public int getNbrLignes(){
        return this.lignes;
    }
    
    /**
     * Méthode qui renvoie le nombre de colonnes de notre plateau de jeu 
     * @return le nombre de colonnes de notre plateau de jeu 
     */
    public int getNbrColonnes(){
        return this.colonnes;
    }
    
    /**
     * Méthode qui permet d'ajouter un score au score déja atteint dans notre plateau de jeu 
     * @param score : score que on souhaite ajouter au score déja atteint dans notre plateau de jeu 
     */
    public void setScore(int score){
        this.Score = this.Score + score;
    }
    
    /**
     * Méthode qui renvoie le score déjà atteint sur notre plateau de jeu 
     * @return le score déjà atteint sur notre plateau de jeu 
     */
    public int getScore(){
        return this.Score;
    }
    
}