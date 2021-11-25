import java.util.ArrayList;

public class Partie {
    private Plateau plateau;
    private Joueur[] listeJoueurs;
    
    public Plateau getPlateau() {
        return this.plateau;
    }

    public Partie(){
        this.plateau = new Plateau();
    }

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
        int X = -1;
        int Y = -1;
        int Couleur = joueur.getCouleur();
        if(joueur.getListePionsEnAttente().size() > 0){ 
            int size = joueur.getListePionsEnAttente().size() - 1;
            Pion pion = joueur.getListePionsEnAttente().get(size);
            if(Couleur == 0){
                X = 6;
                Y = 1;
                this.plateau.getBoard()[X][Y].getListePion().add(pion);
            }
            else if(Couleur == 1){
                X = 1;
                Y = 8;
                this.plateau.getBoard()[X][Y].getListePion().add(pion);
            }
            else if(Couleur == 2){
                X = 8;
                Y = 13;
                this.plateau.getBoard()[X][Y].getListePion().add(pion);
            }
            else if(Couleur == 3){
                 X = 13;
                 Y = 6;
                this.plateau.getBoard()[X][Y].getListePion().add(pion);
            }
            pion.setPositionXY(X, Y);
            joueur.getListePionsEnJeu().add(pion);
            joueur.getListePionsEnAttente().remove(pion);
        }
    }

    public void Move(Pion pion,int coupde){
        int X = pion.getPositionX();
        int Y = pion.getPositionY();
        int Xdep = X;
        int Ydep = Y;

         /* A checker Chaque zone :
          ZONE HAUTE  (ROUGE)  X <= 5 && 6 <= Y <= 8
          ZONE DROITE (BLEUE)  6 <= X <= 8 && 9 <= Y <= 14
          ZONE GAUCHE (VERTE)  6 <= X <= 8 && Y <= 5
          ZONE BASSE  (JAUNE)  9 <= X <= 14 && 6 <= Y <= 8

          LIGNES (Case d'entrée):
          VERT :  X = 7  ; Y = 0
          ROUGE : X = 0  ; Y = 7
          Bleu :  X = 7  ; Y = 14
          Jaune : X = 14  ; Y = 7
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
            
            if(((X == 0 && Y != 8) || Y == 7) && coupde > 0){
                if (Y == 6){
                Y += 1;
                coupde -= 1;
                }
                if((pion.getCouleur() == 0 ) && Y == 7 && (coupde > 0)){
                    if(X + coupde == 6) { // Gagnant
                        this.CouleurToJoueur(pion.getCouleur()).getListePionsEnJeu().remove(pion);
                        pion.setPositionXY(-1, -1);
                    } else if (X + coupde > 6){
                        while(X < 6){
                            X++;
                            coupde--;
                        }
                        X -= coupde;
                    } else {
                        X += coupde;
                    }
                } else if(Y + coupde > 8){
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
            
            if(((X == 14 && Y != 6)  || Y == 7 ) && coupde > 0){
                if (Y == 8){
                Y -= 1;
                coupde -= 1;
                }
                if((pion.getCouleur() == 3 ) && Y == 7 && (coupde > 0)){
                    if(X - coupde == 8) { // Gagnant
                        this.CouleurToJoueur(pion.getCouleur()).getListePionsEnJeu().remove(pion);
                        pion.setPositionXY(-1, -1);
                    } else if (X - coupde < 8){
                        while(X < 8){
                            X--;
                            coupde--;
                        }
                        X += coupde;
                    } else {
                        X -= coupde;
                    }
                } else if (Y - coupde < 6){
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

            

            if ((X == 6 && Y != 14) && coupde > 0){
                
                if( Y + coupde > 14 ){
                    coupde -= (14 - Y);
                    Y = 14;
                }
                else{
                    Y += coupde;
                }
            } 
            
            if(((Y == 14 && X != 8) || X == 7) && coupde > 0){
                if(X == 6){
                X += 1;
                coupde -= 1;
                }
                if((pion.getCouleur() == 2 ) && X == 7 && (coupde > 0)){
                    if(Y - coupde == 8) { // Gagnant
                        this.CouleurToJoueur(pion.getCouleur()).getListePionsEnJeu().remove(pion);
                        pion.setPositionXY(-1, -1);
                    } else if (Y - coupde < 8){
                        while(Y > 8){
                            Y--;
                            coupde--;
                        }
                        Y += coupde;
                    } else {
                        Y -= coupde;
                    }
                }
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
            
            if(((Y == 0 && X != 6) || X == 7) && coupde > 0){
                if (X == 8){
                X -= 1;
                coupde -= 1;
                }
                if((pion.getCouleur() == 0 ) && X == 7 && (coupde > 0)){
                    if(X + coupde == 6) { // Gagnant
                        this.CouleurToJoueur(pion.getCouleur()).getListePionsEnJeu().remove(pion);
                        pion.setPositionXY(-1, -1);
                    } else if (X + coupde > 6){
                        while(X < 6){
                            X++;
                            coupde--;
                        }
                        X -= coupde;
                    } else {
                        X += coupde;
                    }
                }
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
        if((! this.plateau.getBoard()[X][Y].getListePion().isEmpty()) && this.plateau.getBoard()[X][Y].getListePion().get(0).getCouleur() != pion.getCouleur() && (!this.plateau.isSafeZone(X, Y))){
            Joueur j = this.CouleurToJoueur(this.plateau.getBoard()[X][Y].getListePion().get(0).getCouleur());
            for (Pion p : this.plateau.getBoard()[X][Y].getListePion()) {
                j.getListePionsEnAttente().add(p);
                j.getListePionsEnJeu().remove(p);
                p.setPositionXY(-1, -1);
            }
        }
        pion.setPositionXY(X, Y);
        this.plateau.getBoard()[X][Y].getListePion().add(pion);


    }
}
