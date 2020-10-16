/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Vinnys
 */
public class Ejercicio4 extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

        g.setColor(Color.BLACK);
        g.drawLine(250, 0, 250, 500);
        g.drawLine(500, 250, 0, 250);

        for (int i = 0; i < 500; i += 5) {
            g.drawLine(246, i, 254, i);
        }

        for (int i = 0; i < 500; i += 5) {
            g.drawLine(i, 254, i, 246);
        }

        g.setColor(Color.red);

        int res = 0;
        int[] puntoAnterior = new int[2];//[x,y]

        for (int i = -3; i <= 3; i++) {
            if (i == -3) {
                res = segundaDerivada(i) * -1;
                g.drawLine(250 + i, 250 + res, 250 + i, 250 + res);

                puntoAnterior[0] = 250 + i;
                puntoAnterior[1] = 250 + res;
            } else {
                res = segundaDerivada(i) * -1;
                g.drawLine(250 + i, 250 + res, puntoAnterior[0], puntoAnterior[1]);
                puntoAnterior[0] = 250 + i;
                puntoAnterior[1] = 250 + res;
            }
        }
    }

    public static int funcionOriginal(int x) {
        //System.out.println("Funcion original: x^4");
        return x * x * x * x;
    }

    public static int primeraDerivada(int x) {
        //System.out.println("Primera derivada: 4x^3");
        return 4 * x * x * x;
    }

    public static int segundaDerivada(int x) {
        //System.out.println("Segunda derivada: 12x^2");
        return 12 * x * x;
    }

    public static void main(String[] args) {

        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame ventana = new JFrame("Ejercicio4");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setBackground(Color.GRAY);
        ventana.setSize(500, 500);

        Ejercicio4 panel = new Ejercicio4();
        ventana.add(panel);

        ventana.setVisible(true);

        int inicio = -3;
        int fin = 3;
        int resultado = 0;

        int valorAnterior = 0;
        int valorActual = 0;

        int[] valores = new int[7];

        System.out.println("\n_____________________________\n");

        String concava = "__";
        String atributo = "";
        for (int i = inicio; i <= fin; i++) {
            if (i == inicio) {

                resultado = segundaDerivada(i);
                System.out.println("x= " + i + " , y= " + resultado + " INICIO");
                valorActual = resultado;

            } else {

                resultado = segundaDerivada(i);
                valorAnterior = valorActual;
                valorActual = resultado;

                if (valorActual > valorAnterior) {
                    if (atributo.equals("disminuyendo")) {
                        concava = "Convaba hacia arriba";
                    }
                    atributo = "aumentando";
                } else if (valorActual < valorAnterior) {
                    if (atributo.equals("amuentando")) {
                        concava = "Convaba hacia abajo";
                    }
                    atributo = "disminuyendo";
                }
                System.out.println("x= " + i + " , y= " + resultado + " " + atributo);
            }

        }
        System.out.println("*" + concava + "*");
    }
}
