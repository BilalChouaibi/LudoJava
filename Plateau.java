
public class Plateau {

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
    }
    public void Display(){
        for(int i=0; i<15 ;i++){
            for(int j=0; j<15 ;j++){
                if(this.Board[i][j] != null){
                    if(this.Board[i][j].getListePion().size() > 0 ){
                        System.out.print("[P]");
                    } else{
                    System.out.print("[ ]");
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
