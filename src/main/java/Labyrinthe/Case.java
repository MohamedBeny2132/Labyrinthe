package Labyrinthe;

import java.io.Serializable;

public class Case implements Serializable
{
    private int x,y;

    public Case(int x,int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
