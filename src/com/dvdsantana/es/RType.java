package com.dvdsantana.es;

import javax.swing.JFrame;

public class RType extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
 * Crea una instancia del juego y se configuran opciones del escenario como
 * que su tamaño sea a pantalla completa y fijo.
 */
	public RType() {

        add(new Scenario());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setTitle("R-Type");
        setResizable(false);
        setVisible(true);
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RType();
	}

}
