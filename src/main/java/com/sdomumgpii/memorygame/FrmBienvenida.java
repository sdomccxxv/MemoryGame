package com.sdomumgpii.memorygame;

import clases.SonidoJuego;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Font;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Samuel David Ortiz
 */
public class FrmBienvenida extends javax.swing.JFrame implements Runnable {

    private Thread tiempo = null;
    public int  miliseg, seg, min, hora, minuto, segundo;
    boolean estado;
    Thread hilo;
    
    public FrmBienvenida() {
        initComponents();
        this.setLocationRelativeTo(null);
        //AWTUtilities.setWindowOpaque(this, false);
        tiempo = new Thread(this);
        tiempo.start();
        tempo();
        lblReloj.setBackground(Color.black);
        lblReloj.setOpaque(true);
        SonidoJuego soundsT = new SonidoJuego();
        soundsT.tiposonido(0);
        soundsT.start();
    }
    
    public String hora(){
        Calendar calendario = Calendar.getInstance();
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minuto = calendario.get(Calendar.MINUTE);
        segundo = calendario.get(Calendar.SECOND);
        
        String hr;
        hr = null;

        hr = (hora<=9?"0"+hora:hora) + ":" + (minuto<=9?"0"+minuto:minuto) + ":" + (segundo<=9?"0"+segundo:segundo);
            
        return hr;
    }
    
    public void tempo() {
        estado = true;

        hilo = new Thread() {
            public void run() {
                for (;;) {
                    if (estado == true) {
                        try {
                            sleep(1);
                            lblReloj.setText(hora());
                            //lblReloj.setFont(Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("alarm clock.ttf").openStream()));
                        } catch (Exception e) {

                        }
                    } else {
                        break;
                    }
                }
            }
        };
        hilo.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ProgressBar = new javax.swing.JProgressBar();
        lblReloj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\OneDrive - Universidad Mariano Gálvez\\U\\4to Semestre\\2 - Programacion II\\Primer Parcial\\umg.png")); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\OneDrive - Universidad Mariano Gálvez\\U\\4to Semestre\\2 - Programacion II\\Memoria\\MemoryGame\\logo.png")); // NOI18N
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblReloj.setBackground(new java.awt.Color(0, 0, 0));
        lblReloj.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblReloj.setForeground(new java.awt.Color(102, 255, 0));
        lblReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReloj.setText("00:00:00");
        lblReloj.setBorder(new javax.swing.border.MatteBorder(null));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2))
                            .addComponent(lblReloj)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(ProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(lblReloj)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(640, 480));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBienvenida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgressBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblReloj;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            for (int i = 0; i<=100;i++){

                Thread.sleep(30);

                //progress.setText(Integer.toString(i)+"%");
                ProgressBar.setValue(i);
                //clock hora = new clock();
                //Thread h1 = new Thread(hora.h1);
//                h1.start();
//                String hr = hora.hora();
//                reloj.setText(hr);
            }
            this.dispose();
            new FrmMenu().setVisible(true);
        } catch (InterruptedException ex) {
            Logger.getLogger(FrmBienvenida.class.getName()).log(Level.SEVERE, null, ex);
        }
            tiempo = null;
    }
}
