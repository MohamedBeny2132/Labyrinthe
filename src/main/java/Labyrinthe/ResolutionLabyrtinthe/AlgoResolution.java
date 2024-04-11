package Labyrinthe.ResolutionLabyrtinthe;

import Labyrinthe.Case;
import Labyrinthe.Labyrinthe;
import Labyrinthe.Sommet;

import java.util.ArrayList;
import java.util.List;

public abstract class AlgoResolution
{
    protected Labyrinthe labyrinthe;
    protected List<Sommet> chemin;
    protected Sommet positionHero;
    protected Sommet positionSorti;
    public AlgoResolution(Labyrinthe labyrinthe)
    {
        this.labyrinthe = labyrinthe;
        this.positionHero = labyrinthe.getSommetHero();
        this.positionSorti = labyrinthe.getSommetSortie();
        this.chemin = new ArrayList<>();
    }


    public abstract void resolution();
    public abstract List<Sommet> getChemin();



}
