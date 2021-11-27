import java.util.ArrayList;

public class Pion {
    private int Couleur;
    private int id;
    private boolean EstEnJeu;
    private int PositionX;
    private int PositionY;
    private int Xinitial;
    private int Yinitial;

    public Pion(int couleur,int id){
        this.Couleur = couleur;
        this.id = id;
        this.Xinitial = 0;
        this.Yinitial = 0;
        this.EstEnJeu = false;
    }

    public void setEstEnJeu(boolean estEnJeu) {
        this.EstEnJeu = estEnJeu;
    }

    public void setXYinitial(int Xinitial, int Yinitial) {
        this.Xinitial = Xinitial;
        this.Yinitial = Yinitial;
    }

    public int getXinitial() {
        return this.Xinitial;
    }

    public int getYinitial() {
        return this.Yinitial;
    }
    
    public int getCouleur() {
        return this.Couleur;
    }
    public int getPositionX() {
        return this.PositionX;
    }
    public int getPositionY() {
        return this.PositionY;
    }
    public void setPositionXY(int positionX,int positionY) {
        this.PositionX = positionX;
        this.PositionY = positionY;
    }
    

    public void setPositionX(int positionX) {
        this.PositionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.PositionY = positionY;
    }

    public void setCouleur(int couleur) {
        this.Couleur = couleur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getEstEnJeu(){
        return this.EstEnJeu;
    }
}
