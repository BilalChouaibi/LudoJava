import java.util.ArrayList;

public class Partie {
    private Plateau plateau;
    private Joueur[] listeJoueurs;
    private int nbjoueurs;

    
    
    public Plateau getPlateau() {
        return this.plateau;
    }

    public Partie(int nbjoueurs){
        this.nbjoueurs = nbjoueurs;
        this.listeJoueurs = new Joueur[4];
        this.listeJoueurs[0] = new Joueur(0);
        this.listeJoueurs[2] = new Joueur(2);
        if(nbjoueurs >=3){
            this.listeJoueurs[1] = new Joueur(1);
            if (nbjoueurs >= 4) {
                this.listeJoueurs[3] = new Joueur(3);
            }
            
        }
        this.plateau = new Plateau();
        initCamps();
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

    public Pion IdtoPion(Joueur j,int id ){
        for (Pion p : j.getListePions()) {
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    public void initCamps(){
        int tmp = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.plateau.getBoard()[i][j] = new Case(this.listeJoueurs[0].getListePions().get(tmp),i,j);
                this.listeJoueurs[0].getListePions().get(tmp).setPositionXY(i,j);
                this.listeJoueurs[0].getListePions().get(tmp).setXYinitial(i,j);
                tmp++;
            }
        }
        tmp = 0;
        for (int i = 13; i < 15; i++) {
            for (int j = 13; j < 15; j++) {
                this.plateau.getBoard()[i][j] = new Case(this.listeJoueurs[2].getListePions().get(tmp),i,j);
                this.listeJoueurs[2].getListePions().get(tmp).setPositionXY(i,j);
                this.listeJoueurs[2].getListePions().get(tmp).setXYinitial(i,j);
                tmp++;
            }
        }
        if(this.nbjoueurs >= 3){
            tmp = 0;
            for (int i = 0; i < 2; i++) {
                for (int j = 13; j < 15; j++) {
                    this.plateau.getBoard()[i][j] = new Case(this.listeJoueurs[1].getListePions().get(tmp),i,j);
                    this.listeJoueurs[1].getListePions().get(tmp).setPositionXY(i,j);
                    this.listeJoueurs[2].getListePions().get(tmp).setXYinitial(i,j);
                    tmp++;
                }
            }

            if(this.nbjoueurs >= 4){
                tmp = 0;
                for (int i = 13; i < 15; i++) {
                    for (int j = 0; j < 2; j++) {
                        this.plateau.getBoard()[i][j] = new Case(this.listeJoueurs[3].getListePions().get(tmp),i,j);
                        this.listeJoueurs[3].getListePions().get(tmp).setPositionXY(i,j);
                        this.listeJoueurs[2].getListePions().get(tmp).setXYinitial(i,j);
                        tmp++;
                    }
                }
            }
        }
        
    }

    public Joueur CouleurToJoueur(int Couleur){
        for (Joueur joueur : listeJoueurs) {
            if(joueur != null && joueur.getCouleur() == Couleur){
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
        int size = joueur.getListePions().size();
        if(size > 0){
            int i =0;
            while(i <size && joueur.getListePions().get(i).getEstEnJeu()){
                i++;
            }
            if(i == size){
                return;
            }
            Pion pion = joueur.getListePions().get(i);
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
            this.plateau.getBoard()[pion.getXinitial()][pion.getXinitial()].getListePion().remove(pion);
            System.out.println(X + "," + Y);
            pion.setPositionXY(X, Y);
            System.out.println(pion.getPositionX() +";" +pion.getPositionY());
            joueur.getListePions().get(i).setEstEnJeu(true);
        }
    }

    public void PlacerPionXY(Joueur joueur,int X, int Y){
        int size = joueur.getListePions().size();
        if(size > 0){
            int i =0;
            while(i <size && joueur.getListePions().get(i).getEstEnJeu()){
                i++;
            }
            Pion pion = joueur.getListePions().get(i);
            this.plateau.getBoard()[pion.getPositionX()][pion.getPositionY()].getListePion().remove(pion);
            pion.setPositionXY(X, Y);
            this.plateau.getBoard()[X][Y].getListePion().add(pion);
            joueur.getListePions().get(i).setEstEnJeu(true);
        }
    }

    public void Move(Pion pion,int coupde){
        int X = pion.getPositionX();
        int Y = pion.getPositionY();
        int Xdep = X;
        int Ydep = Y;

        if(!pion.getEstEnJeu()){
            return;
        }

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
                    coupde = 0;
                }
            } 
            
            if(((X == 0 && Y != 8) || Y == 7) && coupde > 0){
                if (Y == 6){
                Y += 1;
                coupde -= 1;
                }
                if((pion.getCouleur() == 1 ) && Y == 7 && (coupde > 0)){
                    if(X + coupde == 6) { // Gagnant
                        this.CouleurToJoueur(pion.getCouleur()).getListePions().remove(pion);
                        this.plateau.getBoard()[Xdep][Ydep].getListePion().remove(pion);
                        pion = null;
                        return;
                    } else if (X + coupde > 6){
                        while(X < 6){
                            X++;
                            coupde--;
                        }
                        X -= coupde;
                        coupde = 0;
                    } else {
                        X += coupde;
                        coupde = 0;
                    }
                } else if(Y + coupde > 8){
                    coupde -= (8-Y);
                    Y = 8;
                } else{
                    Y += coupde;
                    coupde = 0;
                }
            }
            if((Y == 8) && coupde > 0){
                if(X + coupde > 5){
                    coupde -= (6 - X);
                    X = 6;
                    Y+=1;
                    Y+= coupde;
                }
                else{
                    X += coupde;
                    coupde = 0;
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
                    coupde = 0;
                }
            } 
            
            if(((X == 14 && Y != 6)  || Y == 7 ) && coupde > 0){
                if (Y == 8){
                Y -= 1;
                coupde -= 1;
                }
                if((pion.getCouleur() == 3 ) && Y == 7 && (coupde > 0)){
                    if(X - coupde == 8) { // Gagnant
                        this.CouleurToJoueur(pion.getCouleur()).getListePions().remove(pion);
                        this.plateau.getBoard()[Xdep][Ydep].getListePion().remove(pion);
                        pion = null;
                        return;
                    } else if (X - coupde < 9){
                        while(X > 8){
                            X--;
                            coupde--;
                        }
                        X += coupde;
                        coupde = 0;
                    } else {
                        X -= coupde;
                        coupde = 0;
                    }
                } else if (Y - coupde < 6){
                    coupde -= (Y - 6);
                    Y = 6;
                } else{
                    Y -= coupde;
                    coupde = 0;
                }
            }
            if((Y == 6) && coupde > 0){
                if(X - coupde < 9){
                    coupde -= (X - 9);
                    coupde--;
                    X = 8;
                    Y-=1;
                    Y-= coupde;
                    coupde = 0;
                }
                else{
                    X -= coupde;
                    coupde = 0;
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
                    coupde = 0;
                }
            } 
            
            if(((Y == 14 && X != 8) || X == 7) && coupde > 0){
                if(X == 6){
                X += 1;
                coupde -= 1;
                }
                if((pion.getCouleur() == 2 ) && X == 7 && (coupde > 0)){
                    if(Y - coupde == 8) { // Gagnant
                        this.CouleurToJoueur(pion.getCouleur()).getListePions().remove(pion);
                        this.plateau.getBoard()[Xdep][Ydep].getListePion().remove(pion);
                        pion = null;
                        return;
                    } else if (Y - coupde < 8){
                        while(Y > 8){
                            Y--;
                            coupde--;
                        }
                        Y += coupde;
                        coupde = 0;
                    } else {
                        Y -= coupde;
                        coupde = 0;
                    }
                }
                if(X + coupde > 8){
                    coupde -= (8 - X);
                    X = 8;
                } else{
                    X += coupde;
                    coupde = 0;
                }
            }
            if((X == 8) && coupde > 0){
                if(Y - coupde < 9){
                    //System.out.println(coupde);
                    coupde -= (Y - 9);
                    coupde--;
                    //System.out.println(coupde);
                    Y= 8;
                    X+=1;
                    X += coupde;
                    coupde = 0;
                }
                else{
                    Y -= coupde;
                    coupde = 0;
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
                    coupde = 0;
                }
            } 
            
            if(((Y == 0 && X != 6) || X == 7) && coupde > 0){
                if (X == 8){
                X -= 1;
                coupde -= 1;
                }
                if((pion.getCouleur() == 0 ) && X == 7 && (coupde > 0)){
                    if(Y + coupde == 6) { // Gagnant
                        this.CouleurToJoueur(pion.getCouleur()).getListePions().remove(pion);
                        this.plateau.getBoard()[Xdep][Ydep].getListePion().remove(pion);
                        pion = null;
                        return;
                    } else if (Y + coupde > 6){
                        while(Y < 6){
                            Y++;
                            coupde--;
                        }
                        Y -= coupde;
                        coupde = 0;
                    } else {
                        Y += coupde;
                        coupde = 0;
                    }
                }
                if(X - coupde < 6){
                    coupde -= (8 - X);
                    X = 6;
                    coupde = 0;
                } else{
                    X -= coupde;
                    coupde = 0;
                }
            }
            if((X == 6) && coupde > 0){
                if(Y + coupde > 5){
                    coupde -= (6 - Y);
                    Y= 6;
                    X-=1;
                    X -= coupde;
                    coupde = 0;
                }
                else{
                    Y += coupde;
                    coupde = 0;
                }
            }
        }
        this.plateau.getBoard()[Xdep][Ydep].getListePion().remove(pion);
        try {
            if((! this.plateau.getBoard()[X][Y].getListePion().isEmpty()) && this.plateau.getBoard()[X][Y].getListePion().get(0).getCouleur() != pion.getCouleur() && (!this.plateau.isSafeZone(X, Y))){
            Joueur j = this.CouleurToJoueur(this.plateau.getBoard()[X][Y].getListePion().get(0).getCouleur());
            for (Pion p : this.plateau.getBoard()[X][Y].getListePion()) {
                p.setEstEnJeu(false);
                p.setPositionXY(p.getXinitial(), p.getYinitial());
                this.plateau.getBoard()[p.getXinitial()][p.getYinitial()].getListePion().add(p);

            }
            this.plateau.getBoard()[X][Y].getListePion().removeAll(this.plateau.getBoard()[X][Y].getListePion());
        }
            
        } catch (NullPointerException exception) {
            System.out.println("X : " + X + " Y : " + Y + " ; N'est pas une case du tableau");
        }
        
        pion.setPositionXY(X, Y);
        this.plateau.getBoard()[X][Y].getListePion().add(pion);


    }
}
