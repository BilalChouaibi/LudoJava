import java.util.ArrayList;

public class Partie {
    private Plateau plateau;
    private Joueur[] listeJoueurs;

        /*
    Convention : 
    0 : Vert
    1 : Rouge
    2 : Bleu
    3 : Jaune
    */

    public Joueur[] getListeJoueurs() {
        return this.listeJoueurs;
    }

    public Joueur CouleurToJoueur(int Couleur){
        for (Joueur joueur : listeJoueurs) {
            if(joueur.getCouleur() == Couleur){
                return joueur;
            }
        }
        //System.out.println("Couleur introuvable");
        return null;
    }

    public void PlacerPion(Joueur joueur){
        int Couleur = joueur.getCouleur();
        if(joueur.getListePionsEnAttente().size() > 0){
            int size = joueur.getListePionsEnAttente().size() - 1;
            if(Couleur == 0){
                this.plateau.getBoard()[6][1].getListePion().add(joueur.getListePionsEnAttente().get(size));
            }
            if(Couleur == 1){
                this.plateau.getBoard()[1][8].getListePion().add(joueur.getListePionsEnAttente().get(size));
            }
            if(Couleur == 2){
                this.plateau.getBoard()[8][13].getListePion().add(joueur.getListePionsEnAttente().get(size));
            }
            if(Couleur == 3){
                this.plateau.getBoard()[6][1].getListePion().add(joueur.getListePionsEnAttente().get(size));
            }
            joueur.getListePionsEnJeu().add(joueur.getListePionsEnAttente().get(size));
            joueur.getListePionsEnAttente().remove(size);
        }
    }

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
        
        this.plateau.getBoard()[Xdep][Ydep].getListePion().remove(pion);
        if((! this.plateau.getBoard()[X][Y].getListePion().isEmpty()) && this.plateau.getBoard()[X][Y].getListePion().get(0).getCouleur() != pion.getCouleur()){
            this.CouleurToJoueur(this.plateau.getBoard()[X][Y].getListePion().get(0).getCouleur()).getListePionsEnAttente().add();
            this.CouleurToJoueur(this.plateau.getBoard()[X][Y].getListePion().get(0).getCouleur()).getListePionsEnJeu().remove(0);
            this.plateau.getBoard()[X][Y].getListePion().remove(0);
        }
        this.plateau.getBoard()[X][Y].getListePion().add(pion);


    }
}
