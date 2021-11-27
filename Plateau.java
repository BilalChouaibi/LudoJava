
public class Plateau {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public Case[][] Board;
    public Plateau(){
        this.init();
    }
    
    public void init(){
        this.Board = new Case[15][15];
        int index = 0;
        while(index < 6){
            for (int j = 0; j < 6 ; j++) {
                this.Board[index][j] = null;
            }
            for(int j=6; j<9 ;j++){
                this.Board[index][j] = new Case(index,j);
                
            }
            index++;
        }
        while(index < 9){
            for(int j=0; j<6 ;j++){
                this.Board[index][j] = new Case(index,j);
            }
            for(int j=6; j<9 ;j++){
                this.Board[index][j] = null;
            }
            for(int j=9; j<15 ;j++){
                this.Board[index][j] = new Case(index,j);
            }
            index++;
        }
        while(index < 15){
            for (int j = 0; j < 6 ; j++) {
                this.Board[index][j] = null;
            }
            for(int j=6; j<9 ;j++){
                this.Board[index][j] = new Case(index,j);
            }
            index++;
        }

        // COULEUR VERTE
        this.Board[6][1].setCouleur(0);
        for (int i = 1; i <= 5; i++) {
            this.Board[7][i].setCouleur(0);
        }

        // COULEUR ROUGE
        this.Board[1][8].setCouleur(1);
        for (int i = 1; i <= 5; i++) {
            this.Board[i][7].setCouleur(1);
        }

        // COULEUR BLEU

        this.Board[8][13].setCouleur(2);
        for (int i = 9; i <= 13; i++) {
            this.Board[7][i].setCouleur(2);
        }

        // COULEUR JAUNE

        this.Board[13][6].setCouleur(3);
        for (int i = 9; i <= 13; i++) {
            this.Board[i][7].setCouleur(3);
        }



    }
    public void Display(){
        for(int i=0; i<15 ;i++){
            for(int j=0; j<15 ;j++){
                if(this.Board[i][j] != null){
                    int couleurcroch = this.Board[i][j].getCouleur();
                    String ansivaluecroch = (couleurcroch == 4 ? ANSI_WHITE :couleurcroch == 0 ? ANSI_GREEN : couleurcroch == 1 ? ANSI_RED : couleurcroch == 2 ? ANSI_BLUE : couleurcroch == 3 ? ANSI_YELLOW : "");
                    if(this.Board[i][j].getListePion().size() > 0 ){
                        int size = this.Board[i][j].getListePion().size();
                        int couleurpion = this.Board[i][j].getListePion().get(size - 1).getCouleur();
                        String ansivaluepion = (couleurpion == 0 ? ANSI_GREEN : couleurpion == 1 ? ANSI_RED : couleurpion == 2 ? ANSI_BLUE : couleurpion == 3 ? ANSI_YELLOW : "");
                        System.out.print(ansivaluecroch + "[" + ANSI_RESET + ansivaluepion + this.Board[i][j].getListePion().get(this.Board[i][j].getListePion().size() - 1).getId()+ ANSI_RESET + ansivaluecroch + "]" + ANSI_RESET);
                    } else{
                    System.out.print(ansivaluecroch + "[ ]" + ANSI_RESET);
                    }
                }
                else{
                    System.out.print("   ");
                }
            }
            System.out.print("\n");
        }
    }
    public Case[][] getBoard() {
        return this.Board;
    }

    public boolean isSafeZone(int X, int Y){
        return (X == 6 && Y == 1) || (X == 1 && Y == 8) || (X == 8 && Y == 13) || (X == 13 && Y == 6);
    }

    /*
    Convention : 
    0 : Vert
    1 : Rouge
    2 : Bleu
    3 : Jaune
    *

    }*/

    
}
