package com.sdomumgpii.memorygame;

import clases.Casilla;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Samuel David Ortiz
 */
public class FrmJuego2 {
    
    Casilla[][] casillas;
    
    private JFrame ventana;
    private JPanel panelPresentacion, panelJuego;
    private JLabel fondo, titulo, matriz[][];
    private ImageIcon Img;
    private Icon icono;
    
    private int numFila, numCol;
    private int mataleatorio[][];
    private Random aleat;
    private int[][] matAux;
    
    public FrmJuego2(){
        dibujarTablero();
    }
    
    /**
     *
     */
    public void dibujarTablero(){
        ventana = new JFrame("Memoria Game");
        ventana.setSize(800,800);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        
        panelPresentacion = new JPanel();
        panelPresentacion.setSize(ventana.getWidth(),ventana.getHeight());
        panelPresentacion.setLocation(0,0);
        panelPresentacion.setLayout(null);
        panelPresentacion.setVisible(true);
        ventana.add(panelPresentacion);
               
        fondo = new JLabel();
        fondo.setSize(ventana.getWidth(),ventana.getHeight());
        fondo.setLocation(0,0);
        
        Img = new ImageIcon("./src/main/java/images/emoji.png");
        icono = new ImageIcon(Img.getImage().getScaledInstance(ventana.getWidth(), ventana.getHeight(),
                        Image.SCALE_DEFAULT));
        
        fondo.setIcon(icono);
        fondo.setVisible(true);
        panelPresentacion.add(fondo,0);
        
        titulo = new JLabel();
        titulo.setSize(300,150);
        titulo.setLocation(260,5);
        Img = new ImageIcon("./src/main/java/images/logo.png");
        icono = new ImageIcon(Img.getImage().getScaledInstance(300,150,
                        Image.SCALE_DEFAULT));
        
        titulo.setIcon(icono);
        titulo.setVisible(true);
        panelPresentacion.add(titulo,0);
        
        panelJuego = new JPanel();
        panelJuego.setSize(ventana.getWidth(),ventana.getHeight());
        panelJuego.setLocation(0,0);
        panelJuego.setLayout(null);
        panelJuego.setVisible(true);
        
        mataleatorio = new int[8][8];
        matAux = new int[8][8];
        aleat = new Random();
        this.aleatorio();
        imprimirP();
        
        matriz = new JLabel[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matriz[i][j] = new JLabel();
                matriz[i][j].setBounds(125+(i*70),150+(j*75),70,75);
                
                                
                matriz[i][j].setIcon(new ImageIcon("./src/main/java/images/"+ matAux[i][j] +".png"));
                matriz[i][j].setForeground(Color.blue);
                matriz[i][j].setBackground(Color.lightGray);
                matriz[i][j].setOpaque(true);
                matriz[i][j].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                matriz[i][j].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                matriz[i][j].setVisible(true);
                
                panelPresentacion.add(matriz[i][j],0);
            }
            
        }
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                matriz[i][j].addMouseListener(new MouseAdapter(){
                    @Override
                    public void mousePressed(MouseEvent e ){
                        for (int k = 0; k < 8; k++) {
                            for (int l = 0; l < 8; l++) {
                                if(e.getSource() == matriz[k][l]){
                                    //System.out.println(k+" "+l);
                                    matAux[k][l] = mataleatorio[k][l];
                                    System.out.println(matAux[k][l]);
                                    System.out.println(mataleatorio[k][l]);
                                    Img = new ImageIcon("./src/main/java/images/" + matAux[k][l] + ".png");
                                    icono = new ImageIcon(Img.getImage().getScaledInstance(70, 75,
                                            Image.SCALE_DEFAULT));
                                    matriz[k][l].setIcon(icono);
                                }
                                
                            }
                            
                        }
                    }
                });
            }
        }
        
        ventana.setVisible(true);
    }
    
    public void aleatorio() {
        int acumulador = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                mataleatorio[i][j] = 0;
                matAux[i][j] = 0;
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                mataleatorio[i][j] = aleat.nextInt(32) + 1;
                
                do {
                    acumulador = 0;
                    for (int k = 0; k < 8; k++) {
                        for (int l = 0; l < 8; l++) {
                            if (mataleatorio[i][j] == mataleatorio[k][l]) {
                                acumulador += 1;
                            }
                        }
                    }
                    if (acumulador == 3) {
                        mataleatorio[i][j] = aleat.nextInt(32) + 1;
                    }
                }while(acumulador == 3);
            }
        }
    }
    
    public void imprimirP(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(mataleatorio[i][j] + "   ");
            }
            System.out.println("");
        }
    }
}
