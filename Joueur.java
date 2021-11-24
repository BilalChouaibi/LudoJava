import java.util.ArrayList;

public class Joueur {
    private ArrayList<Pion> ListePionsEnJeu;
    private ArrayList<Pion> ListePionsEnAttente;
    private int Couleur;

    public Joueur(){
        this.ListePionsEnJeu = new ArrayList<Pion>();
        this.ListePionsEnAttente = new ArrayList<Pion>();
    }
    public ArrayList<Pion> getListePionsEnJeu() {
        return this.ListePionsEnJeu;
    }

    public ArrayList<Pion> getListePionsEnAttente() {
        return this.ListePionsEnAttente;
    }

    public int getCouleur() {
        return this.Couleur;
    }
}
