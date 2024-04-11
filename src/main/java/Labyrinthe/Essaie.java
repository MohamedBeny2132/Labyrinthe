package Labyrinthe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Essaie {
    static int[][] labyrinthe;

    public static void main(String[] args) {
        int[][] plateau = {
                {1, 0, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 3, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 0, 1},
                {1, 2, 0, 0, 1}

        };

        labyrinthe = plateau;


        List<Case> f = cheminLePlusCourt(1,5);




        System.out.println(f.size());
        for (Case z  : f)
        {
            System.out.println(z.getX() + " -- " +z.getY());
        }


    }

    // pLUS PETIT CHEMIN
    private static void solution(int x, int y, boolean[][] passage,List<Case> chemin,List<Case> cheminPlusCourt)
    {
        if (!estCoorect(x, y) || passage[y][x])
            return;


        passage[y][x] = true;
        chemin.add(new Case(x,y));


        if (labyrinthe[y][x] == 3) {


            if (!cheminPlusCourt.isEmpty())
            {
                System.out.println(cheminPlusCourt.size());
                if (cheminPlusCourt.size() > chemin.size()) {
                    cheminPlusCourt = chemin;
                    System.out.println(cheminPlusCourt.size());
                }
            }
            else
            {
                cheminPlusCourt = chemin;

            }
        }




        //System.out.println(chem.size()+" gauche  "+x+" - "+y);
        solution(x - 1, y, passage,copyList(chemin),cheminPlusCourt);
        //System.out.println(chem.size()+" haut  "+x+" - "+y);
        solution(x, y - 1, passage,copyList(chemin),cheminPlusCourt);
        //System.out.println(chem.size()+" droite  "+x+" - "+y);
        solution(x + 1, y, passage,copyList(chemin),cheminPlusCourt);
        //System.out.println(chem.size() +" bas  "+x+" - "+y);
        solution(x, y + 1, passage,copyList(chemin),cheminPlusCourt);
        //System.out.println(" return "+chem.size());



    }

    public static List<Case> copyList(List<Case> cc)
    {

        return  new ArrayList<>(cc);
    }

    public static List<Case> cheminLePlusCourt(int x, int y) {
        boolean[][] plat = initPlateauBoolean();

        List<Case> plusPetit_chemin = new ArrayList<>();
        solution(x, y, plat,new ArrayList<>(),plusPetit_chemin);
        return plusPetit_chemin;
    }

    private static List<Case> plusPetitChemin(List<List<Case>> chemin) {
        List<Case> plusCourtChemin = new ArrayList<>();

        if (!chemin.isEmpty())
        {
            plusCourtChemin = chemin.get(0);
            int taillePlusPetitChemin = plusCourtChemin.size();


            for (List<Case> list : chemin) {
                if (list.size() < taillePlusPetitChemin) {
                    taillePlusPetitChemin = list.size();
                    plusCourtChemin = list;
                }
            }
        }


        return plusCourtChemin;
    }


    private static boolean estCoorect(int x, int y) {
        return x >= 0 && y >= 0 && x < labyrinthe[0].length && y < labyrinthe.length;
    }


    private static boolean[][] initPlateauBoolean() {
        boolean[][] plat = new boolean[labyrinthe.length][labyrinthe[0].length];

        for (int i = 0; i < plat.length; i++) {
            for (int j = 0; j < plat[0].length; j++) {
                if (labyrinthe[i][j] == 1)
                    plat[i][j] = true;
            }
        }

        return plat;
    }
}
