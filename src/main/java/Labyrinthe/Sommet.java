package Labyrinthe;

public class Sommet
{
    private EtatCase etat;
    private int x,y;
    public Sommet(int x,int y,EtatCase etat)
    {
        this.etat = etat;
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }


    public boolean estUnMur()
    {
        return this.etat.getEtat() == 1;
    }
    public EtatCase getEtat()
    {
        return this.etat;
    }

    public boolean estLaSortie()
    {
        return this.etat.getEtat() == 3;
    }
    public void setEtat(EtatCase etat)
    {
        this.etat = etat;
    }


    public String toString()
    {
        return "x : "+x + " - x : "+y+ "  etat : "+etat.getEtat();
    }
}
