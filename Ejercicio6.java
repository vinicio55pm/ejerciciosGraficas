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
public class Ejercicio6 extends JPanel{

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        g.setColor(Color.BLACK);
        g.drawLine(250, 0, 250, 500);
        g.drawLine(500, 250, 0, 250);
        
        for (int i = 0; i < 500; i+=10) {
            g.drawLine(246, i, 254, i);
        }
        
        for (int i = 0; i < 500; i+=5) {
            g.drawLine(i, 254, i, 246);
        }
        
        g.setColor(Color.red);
        
        
    }
    
    public static double funcionOriginal(double x){
        //System.out.println("Funcion original: x^4");
        return ((x*x*x*x)/12)-((x*x*x)/2)+(x*x)+(10);
    }
    public static double primeraDerivada(double x){
        //System.out.println("Primera derivada: 4x^3");
        return ((4*x*x*x)/12)-((3*x*x)/2)+(2*x);
    }
    public static double segundaDerivada(double x){
        //System.out.println("Segunda derivada: 12x^2");
        return x*x-3*x+2;
    }
            
    public static void main(String[]args){
        
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame ventana= new JFrame("Ejercicio4");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setBackground(Color.GRAY);
        ventana.setSize(500,500);
        
        Ejercicio6 panel= new Ejercicio6();
        ventana.add(panel);
        
        ventana.setVisible(true);
        
        double inicio=0.5;
        double fin=2.5;
        double resultado=0.0;
        double val=0.0;
        
        double valorActual=0.0;
        double valorAnterior=0.0;
        
        int banderaCambio=0;
        
        double[] valores=new double [7];
        
        String puntoInfleccion="";
        
        ArrayList<String> infleccionPuntos = new ArrayList<String>();
        
        
        for (double i = 0.5; i < 2.5; i+=0.1) {
            //val=segundaDerivada(i);
            //System.out.println(val+" ___ "+i);
            if(i==inicio){
                
                resultado=segundaDerivada(i);
                System.out.println("x= "+i+" , y= "+resultado+" INICIO");
                valorActual=resultado;
                
            }else{
                    
                    String atributo="";
                   
                    resultado=segundaDerivada(i);
                    valorAnterior=valorActual;
                    valorActual=resultado;
                    
                    if(valorActual>valorAnterior){
                        if(banderaCambio!=1){
                            infleccionPuntos.add("Punto de infleccion en: "+(i-0.1));
                            
                        }
                        banderaCambio=1;
                    }else if(valorActual<valorAnterior){
                       if(banderaCambio!=2){
                            infleccionPuntos.add("Punto de infleccion en: "+(i-0.1));
                        } 
                       banderaCambio=2;
                    }
                    System.out.println("x= "+i+" , y= "+valorActual+" "+banderaCambio);
            }
            
            
        }
        
        System.out.println("");
        for (int i = 0; i < infleccionPuntos.size(); i++) {
            System.out.println(infleccionPuntos.get(i));
        }
}
}
