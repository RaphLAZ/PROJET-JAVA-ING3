package ProjetCPTI.Controller;

import ProjetCPTI.View.Affichage;
import ProjetCPTI.View.MyFrame;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Raphael LAZZARI-ARMOUR 
 */
public class Main{
   
    public static void main (String[] args) throws IOException{
        boolean choice = false;

        while (choice == false){
            
            System.out.println();
            System.out.println("Veuillez entrer : ");
            System.out.println("C -> si vous souhaitez jouer en mode console");
            System.out.println("G -> si vous souhaitez jouer en mode graphique");
            Scanner sc = new Scanner(System.in);
            char input = sc.next().charAt(0);
            input = Character.toLowerCase(input);
            
            switch (input){
                case 'c':
                    Affichage.AfficheMenu();
                    choice = true;
                    break;
                case 'g':
                    MyFrame frame = new MyFrame();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                    choice = true;
                    break;
            }
        }
    }
      
}
