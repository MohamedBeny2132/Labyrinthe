package Labyrinthe.ResolutionLabyrtinthe;

import Labyrinthe.Labyrinthe;
import Labyrinthe.Case;
import Labyrinthe.Sommet;

import java.util.ArrayList;
import java.util.List;

public class DFS extends AlgoResolution
{
    private boolean[][] passage;
    private int tailleDuChemin;
    private Sommet[][] lab;

    public DFS(Labyrinthe labyrinthe)
    {
        super(labyrinthe);
    }

    @Override
    public void resolution()
    {
        this.tailleDuChemin = Integer.MAX_VALUE;
        this.lab = labyrinthe.getLabyrinthe();
        this.chemin = new ArrayList<>();
        this.tailleDuChemin = Integer.MAX_VALUE;

        initPassage();

        List<Sommet> cheminFait = new ArrayList<>();
        Case posHero = labyrinthe.getPosHero();

        dfs(posHero.getX(),posHero.getY(),0,cheminFait);

    }


    private void dfs(int x,int y,int tailleDuCheminEnCour,List<Sommet> cheminEnCour)
    {
        if (!estCoorect(x, y) || this.passage[y][x])
            return;

        if (tailleDuCheminEnCour >= this.tailleDuChemin)
            return;

        if (this.lab[y][x].estLaSortie())
        {
            if (tailleDuCheminEnCour < this.tailleDuChemin)
            {
                this.chemin = new ArrayList<>(cheminEnCour);
                this.tailleDuChemin = tailleDuCheminEnCour;
            }
            return;
        }

        cheminEnCour.add(lab[y][x]);
        this.passage[y][x] = true;


        dfs(x - 1, y,tailleDuCheminEnCour+1,new ArrayList<>(cheminEnCour));
        dfs(x, y - 1,tailleDuCheminEnCour+1,new ArrayList<>(cheminEnCour));
        dfs(x + 1, y,tailleDuCheminEnCour+1,new ArrayList<>(cheminEnCour));
        dfs(x, y + 1,tailleDuCheminEnCour+1,new ArrayList<>(cheminEnCour));

        this.passage[y][x] = false;
    }

    private void initPassage()
    {
        int l = lab[0].length;
        int h = lab.length;

        this.passage = new boolean[h][l];

        for (int y = 0;y<h;y++)
        {
            for (int x = 0;x<l;x++)
            {
                if (lab[y][x].estUnMur())
                    passage[y][x] = true;
                else
                    passage[y][x] = false;
            }
        }
    }

    private boolean estCoorect(int x,int y)
    {
        return x >= 0 && x < this.lab[0].length && y >= 0 && y < this.lab.length;
    }

    @Override
    public List<Sommet> getChemin()
    {
        resolution();
        this.chemin.remove(0);
        return this.chemin;
    }
}
