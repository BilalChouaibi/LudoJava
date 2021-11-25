import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        Partie test = new Partie();
        Joueur joueurtest = new Joueur(0);
        test.PlacerPion(joueurtest);
        System.out.println( "X : " + joueurtest.getListePionsEnJeu().get(0).getPositionX() + " Y : " + joueurtest.getListePionsEnJeu().get(0).getPositionY());
        test.Move(joueurtest.getListePionsEnJeu().get(0), 4);
        System.out.println( "X : " + joueurtest.getListePionsEnJeu().get(0).getPositionX() + " Y : " + joueurtest.getListePionsEnJeu().get(0).getPositionY());
        test.getPlateau().Display();
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
