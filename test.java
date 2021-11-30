import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Partie test = new Partie(4);
        //test.getPlateau().Display();
        //Joueur joueurtest = test.getListeJoueurs()[2];
        test.PlacerPion(test.getListeJoueurs()[3],test.getListeJoueurs()[3].getListePions().get(0));
        Pion p = test.getListeJoueurs()[0].IdToPion(0);
        test.getListeJoueurs()[3].AfficherListePions();
        test.getPlateau().Display();
        test.getPlateau().getBoard()[13][0].AfficherListePions();
        //test.getPlateau().Display();
        //test.PlacerPionXY(test.getListeJoueurs()[0], 8, 0);

        //test.Move(test.getListeJoueurs()[0].getListePions().get(0), 3);
        //test.Move(test.getListeJoueurs()[0].getListePions().get(0), 4);
        //System.out.println(test.getListeJoueurs()[2].getListePions().get(0).getEstEnJeu());
        //System.out.println(test.getListeJoueurs()[2].getListePions().get(0).getEstEnJeu());
        /*
        System.out.println(joueurtest.getListePionsEnJeu().size());
        System.out.println( "X : " + joueurtest.getListePionsEnJeu().get(0).getPositionX() + " Y : " + joueurtest.getListePionsEnJeu().get(0).getPositionY());
        System.out.println( "X : " + joueurtest.getListePionsEnJeu().get(0).getPositionX() + " Y : " + joueurtest.getListePionsEnJeu().get(0).getPositionY());
        test.Move(joueurtest.getListePionsEnJeu().get(0), 5);
        System.out.println(joueurtest.getListePionsEnJeu().size());
        test.getPlateau().Display();
        System.out.println("aaa :" + test.getPlateau().getBoard()[6][0].getCouleur());*/
        //test.getPlateau().Display();
        //test.getListeJoueurs()[2].AfficherListePions();


        /*while(true){
            Random rand = new Random(); 
            int nombreAleatoire = rand.nextInt(6 - 1 + 1) + 1;
            System.out.println(nombreAleatoire);
            test.Move(joueurtest.getListePionsEnJeu().get(0), nombreAleatoire);
            System.out.flush();
            test.getPlateau().Display();
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
            Thread.currentThread().interrupt();
            }
            

        }*/
        
       /* int[][] test = new int[15][15];
        int index = 0;
        while(index < 6){
            for(int j=0; j<3 ;j++){
                test[index][j] = 0;
            }
            index++;
        }

        while(index < 10){
            for(int j=0; j<3 ;j++){
                test[index][j] = 0;
            }
            index++;
        }
        while(index < 15){
            for(int j=6; j<9 ;j++){
                test[index][j] = 0;
            }
            index++;
        }*/
    }
}
