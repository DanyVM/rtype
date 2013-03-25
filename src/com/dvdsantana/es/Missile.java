package com.dvdsantana.es;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Missile {

    private int x, y;
    private Image image;
    boolean visible;
    private Scenario sc;

    private final int SCENARIO_WIDTH = sc.getDimension().width;
    private final int MISSILE_SPEED = 2;

    public Missile(int x, int y) {

        ImageIcon ii =
            new ImageIcon(this.getClass().getResource("misil1.png"));
        image = ii.getImage();
        visible = true;
        this.x = x;
        this.y = y;
    }


    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public void move() {
        x += MISSILE_SPEED;
        if (x > SCENARIO_WIDTH)
            visible = false;
    }
}
