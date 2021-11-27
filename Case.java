import java.util.ArrayList;

public class Case {
    private ArrayList<Pion> ListePions;
    private int PositionX;
    private int PositionY;
    private int couleur;

    public Case(Pion pion,int x,int y){
        this.PositionX = x;
        this.PositionY = y;
        this.ListePions = new ArrayList<Pion>();
        this.ListePions.add(pion);
        this.couleur = 4;
    }

    public int getCouleur() {
        return this.couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }

    public Case(int x,int y){
        this.PositionX = x;
        this.PositionY = y;
        this.ListePions = new ArrayList<Pion>();
        this.couleur = 4;
    }

    public Case(){
        this.ListePions = new ArrayList<Pion>();
    }

    public ArrayList<Pion> getListePion() {
        return this.ListePions;
    }

    public int getPositionX() {
        return this.PositionX;
    }

    public int getPositionY() {
        return this.PositionY;
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
