package Labyrinthe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Labyrinthe implements Serializable
{
    private Case posSortie;
    private Case posHero;
    private Sommet[][] labyrinthe;

    private List<Case> plusPetitChemin;
    private List<int[][]> etapeCreation;

    public Labyrinthe(int[][] labyrinthe)
    {
        this.labyrinthe = CreationLabyrinthe.convert(labyrinthe);

        this.posHero = CreationLabyrinthe.recherchePositionHero(labyrinthe);
        this.posSortie = CreationLabyrinthe.recherchePositionSortie(labyrinthe);
    }

    public Labyrinthe(int largeur,int hauteur,ArrayList<Case> posMur,Case posHero,Case posSortie)
    {
        this.labyrinthe = new Sommet[hauteur][largeur];
        this.posHero = posHero;
        this.posSortie = posSortie;

        this.labyrinthe = CreationLabyrinthe.creationLabyrinthe(largeur,hauteur,posHero,posSortie,posMur);
    }


    public void setEtapeCreation(List<int[][]> etape)
    {
        this.etapeCreation = etape;
    }


    public ArrayList<Case> retournePosMur()
    {
        ArrayList<Case> posMur = new ArrayList<>();

        for (int y = 0;y<this.labyrinthe.length;y++)
            for (int x = 0; x<this.labyrinthe[0].length;x++)
                if (this.labyrinthe[y][x].estUnMur())
                    posMur.add(new Case(x,y));

        return posMur;
    }

    public void deplaceHero(int x,int y)
    {
        this.labyrinthe[y][x].setEtat(EtatCase.HERO);
        this.labyrinthe[this.posHero.getY()][this.posHero.getX()].setEtat(EtatCase.LIBRE);
        this.posHero = new Case(x,y);
    }

    public Set<Sommet> sommetsVoisin(Sommet sommet)
    {
        Set<Sommet> voisin = new HashSet<>();
        Sommet sommetVoisin;

        int x = sommet.getX();
        int y = sommet.getY();

        sommetVoisin = getSommet(x+1,y);
        if (sommetVoisin != null)
            voisin.add(sommetVoisin);

        sommetVoisin = getSommet(x-1,y);
        if (sommetVoisin != null)
            voisin.add(sommetVoisin);

        sommetVoisin = getSommet(x,y+1);
        if (sommetVoisin != null)
            voisin.add(sommetVoisin);

        sommetVoisin = getSommet(x,y-1);
        if (sommetVoisin != null)
            voisin.add(sommetVoisin);


        return voisin;

    }

    private Sommet getSommet(int x,int y)
    {
        Sommet sommet = null;

        if (x >= 0 && x < this.labyrinthe[0].length && y >= 0 && y < this.labyrinthe.length)
        {
            if (!this.labyrinthe[y][x].estUnMur())
                sommet = this.labyrinthe[y][x];
        }

        return sommet;
    }



    public List<int[][]> getEtapeCreation()
    {
        return this.etapeCreation;
    }
    public boolean estResolvable(){ return !this.plusPetitChemin.isEmpty();}
    public List<Case> getPlusPetitChemin() { return this.plusPetitChemin; }
    public int[] getDimension()
    {
        return new int[]{this.labyrinthe[0].length,this.labyrinthe.length};
    }
    public Sommet[][] getLabyrinthe() {return this.labyrinthe;}
    public Case getPosSortie()
    {
        return this.posSortie;
    }
    public Case getPosHero(){ return this.posHero; }
    public Sommet getSommetHero()
    {
        return this.labyrinthe[posHero.getY()][posHero.getX()];
    }
    public Sommet getSommetSortie()
    {
        return this.labyrinthe[posSortie.getY()][posSortie.getX()];
    }

}
