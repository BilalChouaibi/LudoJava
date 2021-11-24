import java.util.ArrayList;

public class Pion {
    private int Couleur;
    private int id;
    private boolean EstEnJeu;
    private int PositionX;
    private int PositionY;

    public Pion(){
        this.EstEnJeu = false;
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
