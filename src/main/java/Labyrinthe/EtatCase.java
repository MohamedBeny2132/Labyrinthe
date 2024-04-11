package Labyrinthe;

import javafx.scene.paint.Color;

public enum EtatCase
{
    LIBRE(0,Color.WHITE),
    MUR(1,Color.BLACK),
    HERO(2,Color.RED),
    SORTIE(3,Color.BLUE);


    private int etat;
    private Color representation;

    EtatCase(int etat,Color representation)
    {
        this.etat = etat;
        this.representation = representation;
    }

    public int getEtat()
    {
        return this.etat;
    }
    public Color getRepresentation()
    {
        return this.representation;
    }

    public static EtatCase convert(int v)
    {
        for (EtatCase etatCase : EtatCase.values()) {
            if (etatCase.getEtat() == v) {
                return etatCase;
            }
        }

        return null;
    }

}
