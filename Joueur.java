import java.util.ArrayList;

public class Joueur {
    private ArrayList<Pion> ListePionsEnJeu;
    private ArrayList<Pion> ListePionsEnAttente;
    private int Couleur;

    public Joueur(int couleur){
        this.Couleur = couleur;
        this.ListePionsEnJeu = new ArrayList<Pion>();
        this.ListePionsEnAttente = new ArrayList<Pion>();
        for (int i = 0; i < 4; i++) {
            this.ListePionsEnAttente.add(new Pion(couleur));
        }
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
