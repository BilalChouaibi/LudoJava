
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
                    System.out.print("[ ]");
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

    /*
    Convention : 
    0 : Vert
    1 : Rouge
    2 : Bleu
    3 : Jaune
    *

    public void PlacerPion(int Couleur){
        if(Couleur == 0){
            
        }
        if(Couleur == 1){
            
        }
        if(Couleur == 2){
            
        }
        if(Couleur == 3){
            
        }

    }*/

    public void Move(Pion pion,int coupde){
        int X = pion.getPositionX();
        int Y = pion.getPositionY();
        int Xdep = X;
        int Ydep = Y;

         /* A checker Chaque zone :
          ZONE HAUTE    X <= 5 && 6 <= Y <= 8
          ZONE DROITE   6 <= X <= 8 && 9 <= Y <= 14
          ZONE GAUCHE   6 <= X <= 8 && Y <= 5
          ZONE BASSE    9 <= X <= 14 && 6 <= Y <= 8
           */

        if(X <= 5 && 6 <= Y && Y<= 8){

            if ((Y == 6 && X != 0) && coupde > 0){
                if( X - coupde < 0 ){
                    coupde -= X;
                    X = 0;
                }
                else{
                    X -= coupde;
                }
            } 
            
            if((X == 0 && Y != 8) && coupde > 0){
                if(Y + coupde > 8){
                    coupde -= (8-Y);
                    Y = 8;
                } else{
                    Y += coupde;
                }
            }
            if((Y == 8) && coupde > 0){
                if(X + coupde > 5){
                    coupde -= (6 - X);
                    X = 7;
                    Y+=1;
                    Y+= coupde;
                }
                else{
                    X += coupde;
                }
            }
        } else if(9 <= X  && X <= 14 && 6 <= Y && Y <= 8){

            if (Y == 8 && X != 14){
                if( X + coupde > 14 ){
                    coupde -= (14 - X);
                    X = 14;
                }
                else{
                    X += coupde;
                }
            } 
            
            if((X == 14 && Y != 6) && coupde > 0){
                if(Y - coupde < 6){
                    coupde -= (Y - 6);
                    Y = 6;
                } else{
                    Y -= coupde;
                }
            }
            if((Y == 6) && coupde > 0){
                if(X - coupde < 9){
                    coupde -= (X - 9 - 1);
                    X = 9;
                    Y-=1;
                    Y-= coupde;
                }
                else{
                    X -= coupde;
                }
            }

        } else if(6 <= X && X <= 8 && 9 <= Y && Y <= 14){

            if (X == 6 && Y != 14){
                if( Y + coupde > 14 ){
                    coupde -= (14 - Y);
                    Y = 14;
                }
                else{
                    Y += coupde;
                }
            } 
            
            if((Y == 14 && X != 8) && coupde > 0){
                if(X + coupde > 8){
                    coupde -= (8 - X);
                    X = 6;
                } else{
                    X += coupde;
                }
            }
            if((X == 8) && coupde > 0){
                if(Y - coupde < 9){
                    coupde -= (Y - 9 - 1);
                    Y= 8;
                    X+=1;
                    X += coupde;
                }
                else{
                    Y -= coupde;
                }
            }

        } else if(6 <= X  && X <= 8 && Y <= 5){
            if (X == 8 && Y != 0){
                if( Y  - coupde < 0  ){
                    coupde -= Y;
                    Y = 0;
                }
                else{
                    Y -= coupde;
                }
            } 
            
            if((Y == 0 && X != 6) && coupde > 0){
                if(X - coupde < 6){
                    coupde -= (8 - X);
                    X = 6;
                } else{
                    X -= coupde;
                }
            }
            if((X == 6) && coupde > 0){
                if(Y + coupde > 5){
                    coupde -= (5 - Y - 1);
                    Y= 6;
                    X-=1;
                    X -= coupde;
                }
                else{
                    Y += coupde;
                }
            }
        }
        
        this.Board[Xdep][Ydep].getListePion().remove(pion);
        if((! this.Board[X][Y].getListePion().isEmpty()) && this.Board[X][Y].getListePion().get(0).getCouleur() != pion.getCouleur()){
            this.Board[X][Y].getListePion().get(0);
            this.Board[X][Y].getListePion().remove(0);
        }
        this.Board[X][Y].getListePion().add(pion);


    }
}
