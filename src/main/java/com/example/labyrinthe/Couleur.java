package com.example.labyrinthe;

import Labyrinthe.EtatCase;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class Couleur
{
    private Map<Integer,Color> colors;
    public Couleur()
    {
        colors = new HashMap<>();

        colors.put(0, Color.WHITE); // Case vide
        colors.put(81, Color.YELLOWGREEN); // Nouvelle valeur avec sa couleur
        colors.put(EtatCase.MUR.getEtat(), EtatCase.MUR.getRepresentation()); // Mur
        colors.put(EtatCase.HERO.getEtat(), EtatCase.HERO.getRepresentation()); // Position du héros
        colors.put(EtatCase.SORTIE.getEtat(), EtatCase.SORTIE.getRepresentation()); // Position de la sortie
        colors.put(4, Color.GREEN); // Nouvelle valeur avec sa couleur
        colors.put(5, Color.YELLOW); // Nouvelle valeur avec sa couleur
        colors.put(6, Color.ORANGE); // Nouvelle valeur avec sa couleur
        colors.put(7, Color.PURPLE); // Nouvelle valeur avec sa couleur
        colors.put(8, Color.CYAN); // Nouvelle valeur avec sa couleur
        colors.put(9, Color.MAGENTA); // Nouvelle valeur avec sa couleur
        colors.put(10, Color.PINK); // Nouvelle valeur avec sa couleur
        colors.put(11, Color.LIME); // Nouvelle valeur avec sa couleur
        colors.put(12, Color.TEAL); // Nouvelle valeur avec sa couleur
        colors.put(13, Color.BROWN); // Nouvelle valeur avec sa couleur
        colors.put(14, Color.GRAY); // Nouvelle valeur avec sa couleur
        colors.put(15, Color.DARKGRAY); // Nouvelle valeur avec sa couleur
        colors.put(16, Color.LIGHTGRAY); // Nouvelle valeur avec sa couleur
        colors.put(17, Color.AQUA); // Nouvelle valeur avec sa couleur
        colors.put(18, Color.BEIGE); // Nouvelle valeur avec sa couleur
        colors.put(19, Color.CRIMSON); // Nouvelle valeur avec sa couleur
        colors.put(20, Color.DARKCYAN); // Nouvelle valeur avec sa couleur
        colors.put(21, Color.DARKGREEN); // Nouvelle valeur avec sa couleur
        colors.put(22, Color.DARKMAGENTA); // Nouvelle valeur avec sa couleur
        colors.put(23, Color.DARKORANGE); // Nouvelle valeur avec sa couleur
        colors.put(24, Color.DARKRED); // Nouvelle valeur avec sa couleur
        colors.put(25, Color.GOLD); // Nouvelle valeur avec sa couleur
        colors.put(26, Color.INDIGO); // Nouvelle valeur avec sa couleur
        colors.put(27, Color.OLIVE); // Nouvelle valeur avec sa couleur
        colors.put(28, Color.TURQUOISE); // Nouvelle valeur avec sa couleur
        colors.put(29, Color.LIGHTPINK); // Nouvelle valeur avec sa couleur
        colors.put(30, Color.SALMON); // Nouvelle valeur avec sa couleur
        colors.put(31, Color.SKYBLUE); // Nouvelle valeur avec sa couleur
        colors.put(32, Color.SEAGREEN); // Nouvelle valeur avec sa couleur
        colors.put(33, Color.DARKSALMON); // Nouvelle valeur avec sa couleur
        colors.put(34, Color.LIGHTCORAL); // Nouvelle valeur avec sa couleur
        colors.put(35, Color.LIGHTSKYBLUE); // Nouvelle valeur avec sa couleur
        colors.put(36, Color.LIGHTSEAGREEN); // Nouvelle valeur avec sa couleur
        colors.put(37, Color.LIGHTSTEELBLUE); // Nouvelle valeur avec sa couleur
        colors.put(38, Color.PALEGREEN); // Nouvelle valeur avec sa couleur
        colors.put(39, Color.PALETURQUOISE); // Nouvelle valeur avec sa couleur
        colors.put(40, Color.LAVENDER); // Nouvelle valeur avec sa couleur
        colors.put(41, Color.LIGHTSALMON); // Nouvelle valeur avec sa couleur
        colors.put(42, Color.LIGHTYELLOW); // Nouvelle valeur avec sa couleur
        colors.put(43, Color.MEDIUMPURPLE); // Nouvelle valeur avec sa couleur
        colors.put(44, Color.MEDIUMSEAGREEN); // Nouvelle valeur avec sa couleur
        colors.put(46, Color.DARKVIOLET); // Nouvelle valeur avec sa couleur
        colors.put(47, Color.DEEPPINK); // Nouvelle valeur avec sa couleur
        colors.put(48, Color.LIGHTBLUE); // Nouvelle valeur avec sa couleur
        colors.put(49, Color.LIGHTGREEN); // Nouvelle valeur avec sa couleur
        colors.put(50, Color.LIGHTSLATEGRAY); // Nouvelle valeur avec sa couleur
        colors.put(51, Color.DARKKHAKI); // Nouvelle valeur avec sa couleur
        colors.put(52, Color.DARKOLIVEGREEN); // Nouvelle valeur avec sa couleur
        colors.put(53, Color.DARKORCHID); // Nouvelle valeur avec sa couleur
        colors.put(54, Color.DARKSEAGREEN); // Nouvelle valeur avec sa couleur
        colors.put(55, Color.DARKSLATEBLUE); // Nouvelle valeur avec sa couleur
        colors.put(56, Color.DARKSLATEGRAY); // Nouvelle valeur avec sa couleur
        colors.put(57, Color.DARKTURQUOISE); // Nouvelle valeur avec sa couleur
        colors.put(58, Color.DARKVIOLET); // Nouvelle valeur avec sa couleur
        colors.put(59, Color.DEEPPINK); // Nouvelle valeur avec sa couleur
        colors.put(60, Color.DEEPSKYBLUE); // Nouvelle valeur avec sa couleur
        colors.put(61, Color.DIMGRAY); // Nouvelle valeur avec sa couleur
        colors.put(62, Color.DODGERBLUE); // Nouvelle valeur avec sa couleur
        colors.put(63, Color.FIREBRICK); // Nouvelle valeur avec sa couleur
        colors.put(64, Color.FORESTGREEN); // Nouvelle valeur avec sa couleur
        colors.put(65, Color.FUCHSIA); // Nouvelle valeur avec sa couleur
        colors.put(66, Color.GAINSBORO); // Nouvelle valeur avec sa couleur
        colors.put(67, Color.GOLDENROD); // Nouvelle valeur avec sa couleur
        colors.put(68, Color.GREENYELLOW); // Nouvelle valeur avec sa couleur
        colors.put(69, Color.HONEYDEW); // Nouvelle valeur avec sa couleur
        colors.put(70, Color.HOTPINK); // Nouvelle valeur avec sa couleur
        colors.put(71, Color.INDIANRED); // Nouvelle valeur avec sa couleur
        colors.put(72, Color.LAWNGREEN); // Nouvelle valeur avec sa couleur
        colors.put(73, Color.LIGHTCORAL); // Nouvelle valeur avec sa couleur
        colors.put(74, Color.LIGHTCYAN); // Nouvelle valeur avec sa couleur
        colors.put(75, Color.LIGHTGOLDENRODYELLOW); // Nouvelle valeur avec sa couleur
        colors.put(76, Color.LIGHTGRAY); // Nouvelle valeur avec sa couleur
        colors.put(77, Color.LIGHTGREEN); // Nouvelle valeur avec sa couleur
        colors.put(78, Color.LIGHTPINK); // Nouvelle valeur avec sa couleur
        colors.put(79, Color.LIGHTSALMON); // Nouvelle valeur avec sa couleur
        colors.put(80, Color.LIGHTSEAGREEN); // Nouvelle valeur avec sa couleur
        colors.put(null,Color.GRAY);

    }


    public Color getColor(int i)
    {
        return colors.get(i);
    }
}
