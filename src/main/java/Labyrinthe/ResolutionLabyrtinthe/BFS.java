package Labyrinthe.ResolutionLabyrtinthe;

import Labyrinthe.Labyrinthe;
import Labyrinthe.Sommet;

import java.util.*;

public class BFS extends AlgoResolution
{
    private Map<Sommet,Sommet> predecedeur;
    public BFS(Labyrinthe labyrinthe)
    {
        super(labyrinthe);
        this.predecedeur = new HashMap<>();
    }

    @Override
    public void resolution()
    {
        this.predecedeur = new HashMap<>();
        this.chemin = new ArrayList<>();

        Queue<Sommet> fifo = new LinkedList<>();

        Sommet sommetActuel;

        fifo.add(positionHero);
        this.chemin.add(positionHero);
        this.predecedeur.put(positionHero,null);

        while (!fifo.isEmpty())
        {
            sommetActuel = fifo.poll();

            for (Sommet sommetVisite : this.labyrinthe.sommetsVoisin(sommetActuel))
            {
                if (!this.predecedeur.containsKey(sommetVisite))
                {
                    this.predecedeur.put(sommetVisite,sommetActuel);
                    this.chemin.add(sommetVisite);
                    fifo.add(sommetVisite);
                }
            }
        }

    }

    @Override
    public List<Sommet> getChemin()
    {
        List<Sommet> c = new ArrayList<>();
        Sommet sommet;

        resolution();

        sommet = this.predecedeur.get(this.positionSorti);


        while (sommet != null)
        {
            c.add(sommet);
            sommet = this.predecedeur.get(sommet);
        }

        System.out.println(c.size());
        if (!c.isEmpty())
            c.remove(c.size()-1);

        return c;
    }


}
