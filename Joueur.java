import java.util.ArrayList;

public class Joueur {
    private ArrayList<Pion> ListePions;
    private int Couleur;

    public Joueur(int couleur){
        this.Couleur = couleur;
        this.ListePions = new ArrayList<Pion>();
        for (int i = 0; i < 4; i++) {
            this.ListePions.add(new Pion(couleur,i+1));
        }
    }
    public ArrayList<Pion> getListePions() {
        return this.ListePions;
    }

    public boolean AdesPionsEnjeu(){
        for (Pion pion : this.ListePions) {
            if(pion.getEstEnJeu()){
                return true;
            }
        }
        return false;
    }

    public Pion IdToPion(int id){
        for (Pion pion : this.ListePions) {
            if(id == pion.getId()){
                return pion;
            }
        }
        return null;
    }

    public int getCouleur() {
        return this.Couleur;
    }

    public void AfficherListePions(){
        System.out.println("Liste des pions : ");
        for (Pion pion : this.ListePions) {
            if(pion.getEstEnJeu()){
              System.out.println( + pion.getId() + " (En jeu)");  
            }else{
                System.out.println( + pion.getId() + " (En Attente)");
            }
            
        }

    }
}
