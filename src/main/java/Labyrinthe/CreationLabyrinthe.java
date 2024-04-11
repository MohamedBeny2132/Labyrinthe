package Labyrinthe;

import java.util.*;

import static javafx.scene.input.KeyCode.Y;

public class CreationLabyrinthe
{
    private static int[][] lab;
    private static Case posHero;
    private static Case posSortie;
    private static List<int[][]> etape;



    public static Labyrinthe creationLabyrhinteAleatoire(int largeur, int hauteur)
    {
        Labyrinthe labyrinthe;
        lab = new int[hauteur][largeur];
        etape = new ArrayList<>();
        initTab();
        etape.add(cloneLab(lab));


        while (!toutEstRelier()) {
            fusionneMurAleatoirement();
            etape.add(cloneLab(lab));
        }

        nettoyerLaLabyrinthe();
        etape.add(cloneLab(lab));

        positionAleaHero(largeur,hauteur);
        lab[posHero.getY()][posHero.getX()] = 2;
        etape.add(cloneLab(lab));
        positionAleaSortie(largeur,hauteur);
        lab[posSortie.getY()][posSortie.getX()] = 3;
        etape.add(cloneLab(lab));
        casseMurAleatoirement(lab);
        etape.add(cloneLab(lab));

        labyrinthe = new Labyrinthe(lab);
        labyrinthe.setEtapeCreation(etape);

        return labyrinthe;
    }

    private static int[][] cloneLab(int[][] source) {
        int[][] target = new int[source.length][];
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i].clone();
        }
        return target;
    }

    private static void positionAleaHero(int l, int h)
    {
        Random rdm = new Random();

        int x = rdm.nextInt(l);
        int y = rdm.nextInt(h);

        posHero = new Case(x,y);
    }

    private static void positionAleaSortie(int l,int h)
    {
        Random rdm = new Random();
        int x,y;
        int xH = posHero.getX(), yH = posHero.getY();

        do {
            x = rdm.nextInt(l);
            y = rdm.nextInt(h);

        } while (x == xH && y == yH);

        posSortie = new Case(x,y);
    }


    public static void initTab()
    {
        int nbr = 2;
        for (int y = 0; y < lab.length;y++)
        {
            for (int x = 0; x < lab[0].length; x++)
            {
                if (x%2 == 0 && y%2 == 0) {
                    lab[y][x] = nbr++;
                }
                else {
                    lab[y][x] = 1;
                }
            }
        }
    }

    public static void nettoyerLaLabyrinthe()
    {
        for (int y = 0;y<lab.length;y++)
        {
            for (int x = 0;x< lab[0].length;x++)
                if (lab[y][x] != 1)
                    lab[y][x] = 0;
        }
    }

    private static boolean toutEstRelier()
    {
        int deuxiemeCouleur = 1;

        for (int y = 0; y < lab.length; y++)
        {
            for (int x = 0; x < lab[0].length; x++)
            {
                if (lab[y][x] != 1)
                {
                    if (deuxiemeCouleur == 1)
                        deuxiemeCouleur = lab[y][x];
                    else if (lab[y][x] != deuxiemeCouleur)
                        return false;
                }
            }
        }
        return true;
    }

    private static void fusionneMurAleatoirement()
    {
        Random rdm = new Random();
        List<Case> alea = new ArrayList<>();
        List<Integer> couleur = new ArrayList<>();
        List<Case> casesPossible = retournCaseFusionable();

        if (casesPossible.isEmpty())
            return;

        Case caseAlea = casesPossible.get(rdm.nextInt(casesPossible.size()));
        int x = caseAlea.getX(),y = caseAlea.getY();



        if (x - 2 >= 0 && lab[y][x - 1] == 1 && lab[y][x - 2] != lab[y][x]) {
            alea.add(new Case(x - 1, y));
            couleur.add(lab[y][x-2]);
        }

        if (x + 2 < lab[0].length && lab[y][x + 1] == 1 && lab[y][x + 2] != lab[y][x]) {
            alea.add(new Case(x + 1, y));
            couleur.add(lab[y][x+2]);
        }
        if (y - 2 >= 0 && lab[y - 1][x] == 1 && lab[y - 2][x] != lab[y][x]) {
            alea.add(new Case(x, y - 1));
            couleur.add(lab[y-2][x]);
        }

        if (y + 2 < lab.length && lab[y + 1][x] == 1 && lab[y + 2][x] != lab[y][x]) {
            alea.add(new Case(x, y + 1));
            couleur.add(lab[y + 2][x]);
        }



        if (!alea.isEmpty())
        {
            int rdmV = rdm.nextInt(alea.size());
            Case chosen = alea.get(rdmV);
            int clr = couleur.get(rdmV);
            int xMur = chosen.getX();
            int yMur = chosen.getY();

            lab[yMur][xMur] = lab[y][x];
            changeValeur(xMur, yMur,lab[y][x],clr);
        }


    }

    private static ArrayList<Case> retournCaseFusionable()
    {
        ArrayList<Case> cases = new ArrayList<>();

        for (int y = 0;y< lab.length;y++)
        {
            for (int x = 0;x< lab[0].length;x++)
            {
                if (lab[y][x] != 1)
                {
                    if (x > 1)
                    {
                        if (lab[y][x - 1] == 1 && lab[y][x - 2] != 1 && lab[y][x - 2] != lab[y][x] )
                            cases.add(new Case(x,y));
                    }
                    else if (y > 1)
                    {
                        if (lab[y-1][x] == 1 && lab[y - 2][x] != 1 && lab[y - 2][x] != lab[y][x] )
                            cases.add(new Case(x,y));
                    }
                    else if (x < lab[0].length - 2)
                    {
                        if (lab[y][x+1] == 1  && lab[y][x + 2] != 1 && lab[y][x + 2] != lab[y][x])
                            cases.add(new Case(x, y));
                    }
                    else if (y < lab.length - 2)
                    {
                        if (lab[y+1][x] == 1 && lab[y + 2][x] != 1 && lab[y + 2][x] != lab[y][x])
                            cases.add(new Case(x, y));
                    }
                }
            }
        }

        return cases;
    }

    private static void casseMurAleatoirement(int[][] lab)
    {
        List<Case> listMur = new ArrayList<>();

        for (int i = 0;i<lab.length;i++)
        {
            for (int j = 0;j<lab[0].length;j++)
            {
                if (lab[i][j] == 1)
                    listMur.add(new Case(j,i));
            }
        }

        int nombreACasser = listMur.size()/10;
        Random rdm = new Random();

        for (int i = nombreACasser;i >= 0;i--)
        {
            Case c = listMur.remove(rdm.nextInt(listMur.size()));
            lab[c.getY()][c.getX()] = 0;
        }
    }


    private static void changeValeur(int x,int y,int vlrSection,int cible)
    {
        if (lab[y][x] == 1)
            return;

        lab[y][x] = vlrSection;

        if (x > 0)
            if (lab[y][x - 1] == cible)
                changeValeur(x - 1, y, vlrSection,cible);

        if (y > 0)
            if (lab[y - 1][x] == cible)
                changeValeur(x, y - 1, vlrSection,cible);

        if (x < lab[0].length - 1)
            if (lab[y][x + 1] == cible)
                changeValeur(x + 1, y, vlrSection,cible);

        if (y < lab.length - 1)
            if (lab[y + 1][x] == cible)
                changeValeur(x, y + 1, vlrSection,cible);

    }






    public static Case recherchePositionHero(int[][] lab)
    {
        boolean trouver = false;
        Case posHero = null;

        for (int y = 0;y<lab.length && !trouver;y++)
        {
            for (int x = 0; x<lab[0].length && !trouver;x++)
            {
                if (lab[y][x] == 2)
                {
                    trouver = true;
                    posHero = new Case(x,y);
                }
            }
        }

        return posHero;
    }


    public static Case recherchePositionSortie(int[][] lab)
    {
        boolean trouver = false;
        Case posSortie = null;

        for (int y = 0;y<lab.length && !trouver;y++)
        {
            for (int x = 0; x<lab[0].length && !trouver;x++)
            {
                if (lab[y][x] == 3)
                {
                    trouver = true;
                    posSortie = new Case(x,y);
                }
            }
        }
        return posSortie;
    }

    public static void setMur(ArrayList<Case> posMur,int[][] lab)
    {
        int x,y;

        for (Case pos : posMur)
        {
            x = pos.getX();
            y = pos.getY();
            lab[y][x] = 1;
        }
    }

    public static void setHero(Case co,int[][] lab) { lab[co.getY()][co.getX()] = 2; }

    public static void setSortie(Case co,int[][] lab) { lab[co.getY()][co.getX()] = 3; }



    public static Sommet[][] convert(int[][] lab)
    {
        Sommet[][] labyrinthe = new Sommet[lab.length][lab[0].length];

        for (int y = 0;y< labyrinthe.length;y++)
        {
            for (int x = 0; x < labyrinthe[0].length;x++)
            {
                labyrinthe[y][x] = new Sommet(x,y,EtatCase.convert(lab[y][x]));
            }
        }

        return labyrinthe;
    }



public static Sommet[][] creationLabyrinthe(int largeur,int hauteur,Case posHero,Case posSortie,List<Case> posMur)
{
    Sommet[][] labyrinthe = new Sommet[hauteur][largeur];

    for (int y = 0; y < hauteur; y++)
        for (int x = 0; x < largeur; x++)
            labyrinthe[y][x] = new Sommet(x,y,EtatCase.LIBRE);

    labyrinthe[posHero.getY()][posHero.getX()] = new Sommet(posHero.getX(),posHero.getY(),EtatCase.HERO);
    labyrinthe[posSortie.getY()][posSortie.getX()] = new Sommet(posSortie.getX(),posSortie.getY(),EtatCase.SORTIE);

    for (Case mur : posMur)
        labyrinthe[mur.getY()][mur.getX()] = new Sommet(mur.getX(),mur.getY(),EtatCase.MUR);
    return labyrinthe;
}













}
