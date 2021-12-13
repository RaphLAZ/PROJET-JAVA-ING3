package ProjetCPTI.View;

import ProjetCPTI.Controller.FileData;
import ProjetCPTI.Controller.Game;
import ProjetCPTI.Controller.Mouvement;
import ProjetCPTI.Model.Brique;
import ProjetCPTI.Model.Chrono;
import ProjetCPTI.Model.Ennemi;
import ProjetCPTI.Model.Joueur;
import ProjetCPTI.Model.Map;
import ProjetCPTI.Model.Objet;
import ProjetCPTI.Model.Struct;
import ProjetCPTI.Model.Tondeuse;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Raphael LAZZARI-ARMOUR
 */
public final class PlateauJeu extends JPanel{
    /**
     * Attributs de notre plateau de jeu 
     */
    private Struct struct;
    private final Chrono chrono;
    
    private JButton up;
    private JButton down;
    private JButton right;
    private JButton left;
    
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
   
    private final Icon J = new Joueur(0, 0).getLabel().getIcon();
    private final Icon B = new Brique(0, 0).getLabel().getIcon();
    private final Icon L = new Tondeuse(0, 0).getLabel().getIcon();
    private final Icon E = new Ennemi(0, 0).getLabel().getIcon();
    private JPanel panel;
    private JLabel matrice[][];
    
    /**
     * Constructeur de notre objet PlateauJeu 
     * @param struct : prends en paramètre notre sutrcutre de données 
     * @param conteneur : prends en paramètre la frame 
     */
    public PlateauJeu(Struct struct, MyFrame conteneur){
        
        this.struct = struct;
        this.chrono = new Chrono();

        initComponents();
    }
    
    /**
     * Méthode qui permet de rafraîchir notre affichage après le mouvement du joueur 
     */
    public void refresh(){
        Objet objet;
        Map map = this.struct.getMap();
        Joueur J1 = this.struct.getJoueur();
        Ennemi E1 = this.struct.getEnnemi();
        Brique B1 = this.struct.getBrique();
        Tondeuse L1 = this.struct.getTondeuse();
        
        /**
         * Affichage de la matrice du plateau de jeu. On modifie juste l'image du label de chaque case de la matrice 
         */
        for (int i = 0;i < map.getNbrLignes();i++){
            
            for (int j = 0;j < map.getNbrColonnes();j++){

                objet = map.ReturnCaseObject(i, j);
                this.matrice[i][j].setIcon(objet.getLabel().getIcon());
                
                /**
                 * Remplacement de l'image de la case sur la matrice dans le cas où un élèment se trouve dessus. 
                 */
                if (J1.getAbscisse() == j && J1.getOrdonnee() == i){
                    this.matrice[i][j].setIcon(this.J);
                }
                /**
                 * Les blocs try...catch permettent que le plateau de jeu puisse fonctionner dans le cas où 
                 * on se trouve dans un tableau qui ne contient pas ces objets 
                 */
                try{
                    if (B1.getAbscisse() == j && B1.getOrdonnee() == i){
                        this.matrice[i][j].setIcon(this.B);
                    }
                }catch (Exception e){}
                
                try{
                    if (L1.getAbscisse() == j && L1.getOrdonnee() == i){
                        this.matrice[i][j].setIcon(this.L);
                    }
                }catch (Exception e){}
                
                 try{
                    if (E1.getAbscisse() == j && E1.getOrdonnee() == i){
                        this.matrice[i][j].setIcon(this.E);
                    }
                }catch (Exception exception){}

                this.matrice[i][j].repaint();
            }
            this.repaint();
        }
        /**
         * On sauvegarde le temps écoulé afin de pouvoir l'afficher dans le label correspondant 
         */
        this.struct.setChrono(this.chrono.TempsEcoule());
        
        /**
         * Affichage du label pour le score 
         */
        this.label1.setText("Score: " + String.valueOf(map.getScore()));
        this.label1.setBounds(0, 800, 200, 50);
        this.label1.setFont(new Font("MV Boli",Font.PLAIN,30));
        this.label1.setForeground(Color.WHITE);
        this.panel.add(this.label1);
        
        /**
         * Affichage du label du niveau 
         */
        this.label2.setText("Level: " + String.valueOf(map.getLevel()));
        this.label2.setBounds(750, 800, 150, 50);
        this.label2.setFont(new Font("MV Boli",Font.PLAIN,30));
        this.label2.setForeground(Color.WHITE);
        this.panel.add(this.label2);

        /**
         * Affichage du label du nombre de cases restantes à passer dessus 
         */
        this.label3.setText(map.getCaseSolved() + "/" + map.getCaseToSolve());
        this.label3.setBounds(250, 800, 200, 50);
        this.label3.setFont(new Font("MV Boli",Font.PLAIN,30));
        this.label3.setForeground(Color.WHITE);
        this.panel.add(this.label3);

        /**
         * Affichage du label du chronomètre 
         */
        this.label4.setText("Time : " + + this.struct.getChrono() + " s");
        this.label4.setBounds(450, 800, 200, 50);
        this.label4.setFont(new Font("MV Boli",Font.PLAIN,30));
        this.label4.setForeground(Color.WHITE);
        this.panel.add(this.label4);
        
        /**
         * Affichage du label contenant le nombre de cases sur lequel ECEman peut passes dessus sans briser la glace. 
         * Le label ne s'affiche que si la potion a été activée.
         */
        if (J1.getPotion() > 0){
            this.label5.setText("P: " + J1.getPotion());
            this.label5.setBounds(350, 750, 100, 50);
            this.label5.setFont(new Font("MV Boli",Font.PLAIN,30));
            this.label5.setForeground(Color.WHITE);
            this.panel.add(this.label5);
        }
        else{
            this.panel.remove(this.label5);
        }
        /**
         * On vérifie si on est dans un cas d'un niveau réussi. Pour cela il faut que 
         * ECEman soit sur la porte et que toutes les glaces soit transformées en eau 
         */
        if(J1.getUnderSymbole() == "\u001B[31m" + 'P' + "\u001B[0m" /*&& map.getCaseSolved() == map.getCaseToSolve()*/){
            
            this.chrono.Stop();
            this.struct.setChrono(this.chrono.TempsEcoule());
            map.setScore((int) this.chrono.TempsEcoule());
            Game.CalculScoreTime(struct);
            
            /**
             * Eneregistrement du score dans un fichier 
             */
            try{
                FileData.SaveScores(struct);
            }
            catch (IOException e){}
            
            /**
             * Affichage d'une optionpane pour demander au joueur si il veut aller au niveau suivant ou quitter le jeu 
             */
            String[] textes = {"Niveau Suivant", "Quitter"};
            JOptionPane jop = new JOptionPane();
            int rang = jop.showOptionDialog(null, 
              "Tu as Gagné !!!",
              "Bravo !!!    Score : " + struct.getMap().getScore(),              
              JOptionPane.YES_NO_CANCEL_OPTION,
              JOptionPane.QUESTION_MESSAGE,
              null,
              textes,
              textes[0]);
            
            switch (rang) {
                case JOptionPane.YES_OPTION:
                    /**
                     * Dans le cas où le joueur se trouve au niveau 5 
                     */
                    try {
                        if (map.getLevel() < 5){
                            this.struct = Game.GameInit(map.getLevel()+1);
                            initComponents();
                        }
                        else{
                            String[] texts = {"Recommencer", "Quitter"};
                            JOptionPane jop1 = new JOptionPane();
                            int rang1 = jop1.showOptionDialog(null, 
                              "Vous avez fini le jeu",
                              "Bravo !!!",              
                              JOptionPane.YES_NO_CANCEL_OPTION,
                              JOptionPane.QUESTION_MESSAGE,
                              null,
                              texts,
                              texts[0]);
                            
                            switch (rang1){
                                case JOptionPane.YES_OPTION:
                                    File file = new File("src\\ProjetCPTI\\Model\\Files\\ScoreSave.txt");
                                    file.delete();
                                    Game.framePrincipal.demmarerPartie(1);
                                    break;
                                case JOptionPane.NO_OPTION:
                                    Game.framePrincipal.mainMenu();
                                    break;
                                case JOptionPane.CLOSED_OPTION:
                                    Game.framePrincipal.mainMenu();
                                    break;
                                default:
                                    break;
                            }
                        }
                    } catch (IOException ex){}
                        
                    
                    break;
                case JOptionPane.NO_OPTION:
                    Game.framePrincipal.mainMenu();
                    break;
                case JOptionPane.CLOSED_OPTION:
                    Game.framePrincipal.mainMenu();
                    break;
                default:
                    break;
            }
        }
        
        /**
         * On vérifie si on est dans un cas de GameOver. Si on touche un ennemi, 
         * tombe dans l'eau ou arrive sur la porte sans avoir transformé toutes les cases en eau 
         */
        if (Game.GameOverCheck(this.struct) == false){

            String[] textes = {"Recommencer", "Quitter"};
            JOptionPane jop = new JOptionPane();
            int rang = jop.showOptionDialog(null, "Tu as Perdu !!!", "Ohhh !!!",
                       JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
                       null, textes, textes[0]);
            
            switch (rang) {
                case JOptionPane.YES_OPTION:
                    map = this.struct.getMap();
                    Game.framePrincipal.demmarerPartie(map.getLevel());
                    break;
                case JOptionPane.NO_OPTION:
                    Game.framePrincipal.mainMenu();
                    break;
                case JOptionPane.CLOSED_OPTION:
                    Game.framePrincipal.mainMenu();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Méthode qui initialise notre affichage du jeu 
     */
    public void initComponents(){
        this.removeAll();
        this.matrice = new JLabel [15][19];
        this.panel = new JPanel();
        this.panel.setBounds(0, 0, 900, 900);
        this.panel.setBackground(new Color(70, 191, 255)); 
        Map map = this.struct.getMap();
        Joueur J1 = this.struct.getJoueur();
        Brique B1 = this.struct.getBrique();
        Tondeuse L1 = this.struct.getTondeuse(); 
        Ennemi E1 = this.struct.getEnnemi();
        Objet objet;   
        
        this.setLayout(null);
        this.panel.setLayout(null);
        this.panel.setOpaque(true);
    
        /**
         * On démarre le chronomètre du niveau 
         */
        this.chrono.Start();
        
        /**
         * Initialisation de la matrice d'affiche du plateau de jeu 
         */
        for (int i = 0;i < map.getNbrLignes();i++){

            for (int j = 0;j < map.getNbrColonnes();j++){
                
                objet = map.ReturnCaseObject(i, j);
                
                if (J1.getAbscisse() == j && J1.getOrdonnee() == i){
                        objet = J1.getObject();
                }
                try{
                    if (B1.getAbscisse() == j && B1.getOrdonnee() == i){
                        objet = B1.getObject();
                    }
                }catch (Exception e){}
                
                try{
                    if (L1.getAbscisse() == j && L1.getOrdonnee() == i){
                        objet = L1.getObject();
                    }
                }catch (Exception exception){}
                
                try{
                    if (E1.getAbscisse() == j && E1.getOrdonnee() == i){
                        objet = E1.getObject();
                    }
                }catch (Exception exception){}
                
                this.matrice[i][j] = objet.getLabel();
                this.matrice[i][j].setBounds(60 + j * 40, 10 + i * 40, 40, 40);
            }
        }
        
        /**
         * On ajoute notre matrice au panel 
         */
        for (int a = 0;a < map.getNbrLignes();a++){

            for (int b = 0;b < map.getNbrColonnes();b++){
                
                this.panel.add(this.matrice[a][b]);
            }
        }

        /**
         * Affichage du label du score 
         */
        this.label1 = new JLabel();
        this.label1.setText("Score: " + String.valueOf(map.getScore()));
        this.label1.setBounds(0, 800, 200, 50);
        this.label1.setFont(new Font("MV Boli",Font.PLAIN,30));
        this.label1.setForeground(Color.WHITE);
        this.panel.add(this.label1);
        
        /**
         * Affichage du label du niveau 
         */
        this.label2 = new JLabel();
        this.label2.setText("Level: " + String.valueOf(map.getLevel()));
        this.label2.setBounds(750, 800, 150, 50);
        this.label2.setFont(new Font("MV Boli",Font.PLAIN,30));
        this.label2.setForeground(Color.WHITE);
        this.panel.add(this.label2);
        
        /**
         * Affichage du label du nombres de cases retsantes à transformer 
         */
        this.label3 = new JLabel();
        this.label3.setText(map.getCaseSolved() + "/" + map.getCaseToSolve());
        this.label3.setBounds(250, 800, 200, 50);
        this.label3.setFont(new Font("MV Boli",Font.PLAIN,30));
        this.label3.setForeground(Color.WHITE);
        this.panel.add(this.label3);
        
        /**
         * Affichage du label du chrono
         */
        this.label4 = new JLabel();
        this.label4.setText("Time : " + + this.struct.getChrono() + " s");
        this.label4.setBounds(450, 800, 200, 50);
        this.label4.setFont(new Font("MV Boli",Font.PLAIN,30));
        this.label4.setForeground(Color.WHITE);
        this.panel.add(this.label4);
        
        /**
         * Affichage du label de potion si le joueur démarre sur une case qui contient la potion 
         */
        this.label5 = new JLabel();
        this.label5.setText("P: " + J1.getPotion());
        this.label5.setBounds(350, 750, 100, 50);
        this.label5.setFont(new Font("MV Boli",Font.PLAIN,30));
        this.label5.setForeground(Color.WHITE);
        if (J1.getPotion() > 0) this.panel.add(this.label5);
        
        /**
         * Affichage des boutons qui permettent au joueur de faire déplacer ECEman 
         */
        this.up = new JButton();
        this.up.setText("UP");
        this.up.setBounds(400, 650, 100, 50);
        this.up.setFont(new Font("MV Boli",Font.PLAIN,20));
        this.panel.add(this.up);
        
        this.down = new JButton();
        this.down.setText("DOWN");
        this.down.setBounds(400, 700, 100, 50);
        this.down.setFont(new Font("MV Boli",Font.PLAIN,20));
        this.panel.add(this.down);
        
        this.left = new JButton();
        this.left.setText("LEFT");
        this.left.setBounds(300, 650,100, 100);
        this.left.setFont(new Font("MV Boli",Font.PLAIN,20));
        this.panel.add(this.left);
        
        
        this.right = new JButton();
        this.right.setText("RIGHT");
        this.right.setBounds(500, 650, 100, 100);
        this.right.setFont(new Font("MV Boli",Font.PLAIN,20));
        this.panel.add(this.right);
        
        /**
         * Ajout des ActionListener au bouton de déplacement 
         */
        this.up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mouvement.DirectionDeplacement(struct, 1);
                refresh();
            }
        });
        this.down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mouvement.DirectionDeplacement(struct, 2);
                refresh();
            }
        });
        this.right.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mouvement.DirectionDeplacement(struct, 3);
                refresh();
            }
        });
        this.left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mouvement.DirectionDeplacement(struct, 4);
                refresh();
            }
        });
        
        /**
         * Ajout du panel à la MyFrame 
         */
        this.add(this.panel);
        this.panel.revalidate();
        this.panel.repaint();
    }
    
}
