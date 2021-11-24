import java.util.ArrayList;

public class Case {
    private ArrayList<Pion> ListePions;
    private int PositionX;
    private int PositionY;

    public Case(Pion pion,int x,int y){
        this.PositionX = x;
        this.PositionY = y;
        this.ListePions = new ArrayList<Pion>();
        this.ListePions.add(pion);
    }

    public Case(int x,int y){
        this.PositionX = x;
        this.PositionY = y;
        this.ListePions = new ArrayList<Pion>();
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
}
