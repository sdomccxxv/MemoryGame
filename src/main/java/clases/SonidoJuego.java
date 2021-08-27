package clases;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SonidoJuego extends Thread{
    
    private String[] sonidos = {"soundtrack.wav", "game_over.wav"};
    public enum tiposonido {SECONDS, HOURS, HOURS12};
    private int sonidoseleccionado;
    
    void hiloSonidos(){
        
    }
    
    public void tiposonido (int sonidoseleccionado){
        this.sonidoseleccionado = sonidoseleccionado;
    }
            
       
    public void run() {
        
        File file = new File("");
        switch(sonidoseleccionado){
            case 0:
                file = new File(sonidos[0]);
                break;
            case 1:
                file = new File(sonidos[1]);
                break;
        }
        
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
            if(sonidoseleccionado == 0){
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            
            
        } catch (LineUnavailableException ex) {
            Logger.getLogger(SonidoJuego.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SonidoJuego.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(SonidoJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        (new Thread(new SonidoJuego())).start();
    }
}
