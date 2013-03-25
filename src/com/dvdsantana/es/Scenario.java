package com.dvdsantana.es;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * 
 * @author santana
 * @version 0.1
 * Representa el escenario donde se dibujarán los elementos del juego. En él se
 * repintarán los elementos en un intervalo de tiempo definido en {@link #timer}
 * y se mantendrán escuchas del evento de pulsación de tecla para mover la nave.
 *
 */
public class Scenario extends JPanel implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
    private Ship ship;
    private Dimension dimension;

/**
 * Construye el escenario de juego
 */
    public Scenario() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setDimension(toolkit.getScreenSize());

        ship = new Ship();

        timer = new Timer(5, this);
        timer.start();
    }
    
/**
 * Hook de swing para dibujar componentes en pantalla.
 */
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(ship.getImage(), ship.getX(), ship.getY(), this);
        
        ArrayList<Missile> ms = ship.getMissiles();

        for (int i = 0; i < ms.size(); i++ ) {
            Missile m = (Missile) ms.get(i);
            g2d.drawImage(m.getImage(), m.getX(), m.getY(), this);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
    
/**
 * Hook lanzado cuando se produce un evento. Mueve la nave y se vuelve a dibujar
 * en la pantalla.
 * @see move
 */
    public void actionPerformed(ActionEvent e) {
    	ArrayList<Missile> ms = ship.getMissiles();

        for (int i = 0; i < ms.size(); i++) {
            Missile m = (Missile) ms.get(i);
            if (m.isVisible()) 
                m.move();
            else ms.remove(i);
        }
        ship.move();
        repaint();  
    }

/**
 * 
 * @return las dimensiones del escenario.
 */
public Dimension getDimension() {
	return dimension;
}

/**
 * 
 * @param dimension
 */
public void setDimension(Dimension dimension) {
	this.dimension = dimension;
}

private class TAdapter extends KeyAdapter {

    public void keyReleased(KeyEvent e) {
        ship.keyReleased(e);
    }

    public void keyPressed(KeyEvent e) {
        ship.keyPressed(e);
    }
}

}
