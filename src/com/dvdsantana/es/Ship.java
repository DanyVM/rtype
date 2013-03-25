package com.dvdsantana.es;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * 
 * @author santana
 * @version 0.1
 * Representa la nave espacial definida por su posición (x,y) y su imagen.
 * Además, permite su desplazamiento.
 *
 */
public class Ship {
    private String ship = "robot1.png";
    private int dx;
    private int dy;
    private int x;
    private int y;
    private Image image;
    
    private ArrayList<Missile> misiles;

    private final int SHIP_SIZE = 20;
    
/**
 * Construye la nave espacial asignándole una posición inicial {@link #x} e 
 * {@link #y} y una imagen {@link #image}
 * @see Image
 */
    public Ship() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource(ship));
        image = ii.getImage();
        x = 40;
        y = 60;
        misiles = new ArrayList<Missile>();
    }
    
/**
 * Mueve la nave actualizando sus coordenadas x e y según el desplazamiento
 * registrado en el eje x y eje y ({@link #dx} y {@link #dy} respectivamente).
 */
    public void move() {
        x += dx;
        y += dy;
    }
/**
 * Obtiene la posición de la nave en el eje X.
 * @return la posición de la nave en el eje x, {@link #x}
 */
    public int getX() {
        return x;
    }
    
/**
 * Obtiene la posición de la nave en el eje y.
 * @return {@link #y}
 */
    public int getY() {
        return y;
    }
    
/**
 * Obtiene la imagen de la nave espacial.
 * @return la imagen que representa la nave espacial, {@link #image}
 */
    public Image getImage() {
        return image;
    }
    
    public ArrayList<Missile> getMissiles() {
        return misiles;
    }
    
/**
 * Actualiza el desplazamiento en x e y de la nave cada vez que se pulsa una
 * tecla.
 * @param e es el evento disparado cuando se pulsa una tecla. Permite obtener
 * qué tecla se ha pulsado.
 */
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -1;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 1;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -1;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 1;
        }
        
        if (key == KeyEvent.VK_SPACE) {
            fire();
        }
    }
    
/**
 * 
 * @param e es el evento disparado cuando se pulsa una tecla. Permite obtener
 * qué tecla se ha pulsado.
 * @see #keyPressed(KeyEvent)
 */
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
    
    public void fire() {
        misiles.add(new Missile(x + SHIP_SIZE, y + SHIP_SIZE/2));
    }
}
