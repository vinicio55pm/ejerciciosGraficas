/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Vinnys
 */
public class Ejercicio13 extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        g.setColor(Color.BLACK);
        g.drawLine(250, 0, 250, 500);
        g.drawLine(500, 250, 0, 250);
        
        
        
        for (int i = 0; i < 500; i+=5) {
            g.drawLine(246, i, 254, i);
        }
        
        for (int i = 0; i < 500; i+=5) {
            g.drawLine(i, 254, i, 246);
        }
        
        g.setColor(Color.red);
        
        int res=0;
        int[] puntoAnterior=new int[2];//[x,y]
        
        for (int i = -5; i <=5 ; i++) {
            if(i==-5){
                 res=funcionOriginal(i)*-1;
                 
                 g.drawLine(250+i, 250+res, 250+i, 250+res);
                 
                 puntoAnterior[0]=250+i;
                 puntoAnterior[1]=250+res;
            }
            res=funcionOriginal(i)*-1;
            g.drawLine(250+i, 250+res, puntoAnterior[0], puntoAnterior[1]);
            puntoAnterior[0]=250+i;
            puntoAnterior[1]=250+res;
        }
    }
    
    public static int funcionOriginal(int x){
     return ((x*x*x*x)/4)-((9*x*x)/2);   
    }
    public static int primeraDerivada(int x){
        //System.out.println("Primera derivada: 4x^3");
        return x*x*x -9*x;
    }
    public static int segundaDerivada(int x){
        //System.out.println("Segunda derivada: 12x^2");
        return 3*x*x -9;
    }
    
    public static double puntosCriticos(double x){
        return 3*x*x -9;
    }
            
    public static void main(String[]args){
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame ventana= new JFrame("Ejercicio13");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setBackground(Color.GRAY);
        ventana.setSize(500,500);
        
        Ejercicio13 panel= new Ejercicio13();
        ventana.add(panel);
        
        ventana.setVisible(true);
        
        int inicio=-5;
        int fin=5;
        int resultado=0;
        
        int valorAnterior=0;
        int valorActual=0;
        
        int[] valores=new int [7];
       
        System.out.println("\n_____________________________\n");
        
        String concava="__";
        String atributo="";
        ArrayList<String> infleccionPuntos = new ArrayList<String>();
for (int i = inicio; i <= fin; i++) {
            if (i == inicio) {

                resultado = funcionOriginal(i);
                System.out.println("x= " + i + " , y= " + resultado + " INICIO");
                valorActual = resultado;

            } else {

                resultado = funcionOriginal(i);
                valorAnterior = valorActual;
                valorActual = resultado;

                if (valorActual > valorAnterior) {
                    if (atributo.equals("disminuyendo")) {
                        concava = "Convaba hacia arriba";
                         System.out.println("*" + concava + "*");
                         infleccionPuntos.add("Punto critico en: "+(i-1));
                    }
                    atributo = "aumentando";
                }
                if (valorActual < valorAnterior) {
                    if (atributo.equals("aumentando")) {
                        concava = "Convaba hacia abajo";
                         System.out.println("*" + concava + "*");
                         infleccionPuntos.add("Punto critico en: "+(i-1));
                    }
                    atributo = "disminuyendo";
                }
                System.out.println("x= " + i + " , y= " + resultado + " " + atributo);
            }

        }
        //System.out.println("*" + concava + "*");
        
        System.out.println("\n");
        for (int i = 0; i < infleccionPuntos.size(); i++) {
            System.out.println(infleccionPuntos.get(i));
        }
        
        double puntoCriticoUno=-3;
        double puntoCriticoDos=3;
        double puntoCriticoTres=0;
        
        double p1 = puntosCriticos(puntoCriticoUno);
        double p2 = puntosCriticos(puntoCriticoUno);
        double p3 = puntosCriticos(puntoCriticoUno);
        
        
        
        
        
        
    }
}

