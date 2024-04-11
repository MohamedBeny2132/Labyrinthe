package com.example.labyrinthe;

import Labyrinthe.Case;
import Labyrinthe.Labyrinthe;
import Labyrinthe.EtatCase;
import Labyrinthe.Sommet;
import Labyrinthe.CreationLabyrinthe;
import Labyrinthe.ResolutionLabyrtinthe.AlgoResolution;
import Labyrinthe.ResolutionLabyrtinthe.BFS;
import Labyrinthe.ResolutionLabyrtinthe.DFS;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


import java.util.ArrayList;
import java.util.List;


public class Damier extends GridPane
{
    private final int WIDTH = 600;
    private final int HEIGHT = 600;

    private final Color COLOR_HERO = EtatCase.HERO.getRepresentation();
    private final Color COLOR_SORTIE = EtatCase.SORTIE.getRepresentation();
    private final Color COLOR_MUR = EtatCase.MUR.getRepresentation();
    private final Color COLOR_VIDE = EtatCase.LIBRE.getRepresentation();

    private Rectangle[][] damier;
    private ArrayList<Case> posMur;
    private Case posHero;
    private Case posSortie;

    private AlgoResolution algo;

    private Labyrinthe labyrinthe;

    private Couleur couleur;


    public Damier(Labyrinthe lab)
    {
        super();
        int[] dimension = lab.getDimension();
        this.damier = new Rectangle[dimension[1]][dimension[0]];
        this.posMur = lab.retournePosMur();
        this.posHero = lab.getPosHero();
        this.posSortie = lab.getPosSortie();

        this.labyrinthe = lab;
        this.setPrefSize(WIDTH,HEIGHT);

        initDamier();

        if (labyrinthe.getEtapeCreation() != null || !labyrinthe.getEtapeCreation().isEmpty())
        {

            couleur = new Couleur();
            afficheEtapeCreation();


        }








    }


    private void afficheEtapeCreation()
    {
        List<int[][]> etape = labyrinthe.getEtapeCreation();
        double delai = 0.15;
        final int[] i = {0};

        Timeline timeline;

        timeline = new Timeline(new KeyFrame(Duration.seconds(delai), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                if (i[0]++ < etape.size())
                {
                    showEtape(i[0],etape);
                }
            }
        }));
        timeline.setCycleCount(etape.size() - 1);
        timeline.play();

    }

    private void showEtape(int i, List<int[][]> e)
    {
        Couleur couleur = new Couleur();
        int[][] etape = e.get(i);
        Color color;

        effacer();

        for (int y = 0;y<etape.length;y++)
        {
            for (int x = 0;x<etape[0].length;x++)
            {

                color = couleur.getColor(etape[y][x]);

                damier[y][x].setFill(color);
                damier[y][x].setStroke(Color.BLACK);

            }
        }
    }


    public Labyrinthe createRdmMaze(int x,int y)
    {
        return CreationLabyrinthe.creationLabyrhinteAleatoire(x,y);
    }

    private void addMur()
    {
        int x,y;

        for (Case c :this.posMur)
        {
            x = c.getX();
            y = c.getY();

            this.damier[y][x].setFill(COLOR_MUR);
        }
    }

    private void addHero()
    {
        int x = this.posHero.getX();
        int y = this.posHero.getY();

        this.damier[y][x].setFill(COLOR_HERO);
    }

    private void addSortie()
    {
        int x = this.posSortie.getX();
        int y = this.posSortie.getY();

        this.damier[y][x].setFill(COLOR_SORTIE);
    }

    private void initDamier()
    {
        int nbrCaseX;
        int nbrCaseY;
        int widthCase;
        int heightCase;

        nbrCaseX = this.damier[0].length;
        nbrCaseY = this.damier.length;

        widthCase = WIDTH / nbrCaseX;
        heightCase = HEIGHT / nbrCaseY;

        for (int y = 0;y<nbrCaseY;y++)
        {
            for (int x = 0;x<nbrCaseX;x++)
            {
                this.damier[y][x] = new Rectangle(widthCase,heightCase);
                this.damier[y][x].setFill(Color.WHITE);
                this.add(this.damier[y][x],x,y);
            }
        }
    }

    public void setPosHero(Case pos)
    {
        if (this.posHero != null)
            changeUneCaseDeCouleur(this.posHero,Color.WHITE);

        changeUneCaseDeCouleur(pos,COLOR_HERO);
        this.posHero = pos;
    }

    public void setPosSortie(Case pos)
    {
        if (this.posSortie != null)
            changeUneCaseDeCouleur(this.posSortie,Color.WHITE);

        changeUneCaseDeCouleur(pos,COLOR_SORTIE);
        this.posSortie = pos;
    }


    public void effacer()
    {
        for (int y = 0 ; y < damier.length; y++)
            for (int x = 0; x < damier[0].length; x++)
                this.damier[y][x].setFill(COLOR_VIDE);
    }

    public void nettoie()
    {
        effacer();

        addHero();
        addSortie();
        addMur();
    }


    public void afficherPlusPetitChemin(AlgoResolution algo)
    {
        int x,y;

        List<Sommet> chemin = algo.getChemin();



        for (Sommet sommet : chemin)
        {
            x = sommet.getX();
            y = sommet.getY();

            this.damier[y][x].setFill(Color.LIGHTBLUE);
        }
    }


    private void changeUneCaseDeCouleur(Case pos,Color color)
    {
         int x = pos.getX();
         int y = pos.getY();

         this.damier[y][x].setFill(color);
    }

    public Labyrinthe getLabyrinthe()
    {
        return this.labyrinthe;
    }

    public Rectangle[][] getDamier()
    {
        return this.damier;
    }

    public void afficherEtapeDeParcours(AlgoResolution algo)
    {
        int x,y;
        List<Sommet> chemin = algo.getChemin();

        for (Sommet sommet : chemin)
        {

            x = sommet.getX();
            y = sommet.getY();

            this.damier[y][x].setFill(Color.LIGHTBLUE);
        }
    }

}
