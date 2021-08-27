package clases;

import com.sdomumgpii.memorygame.FrmJuego;
import com.sdomumgpii.memorygame.FrmLogin;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Samuel David Ortiz
 */
public class UsuarioJuego {

    public String usuario;
    public String email;
    public String contraseña1;
    public String contraseña2;

    public String claveMurci(String texto) {
        texto = texto.replace('m', '0');
        texto = texto.replace('M', '0');
        texto = texto.replace('u', '1');
        texto = texto.replace('U', '1');
        texto = texto.replace('r', '2');
        texto = texto.replace('R', '2');
        texto = texto.replace('c', '3');
        texto = texto.replace('C', '3');
        texto = texto.replace('i', '4');
        texto = texto.replace('I', '4');
        texto = texto.replace('e', '5');
        texto = texto.replace('E', '5');
        texto = texto.replace('l', '6');
        texto = texto.replace('L', '6');
        texto = texto.replace('a', '7');
        texto = texto.replace('A', '7');
        texto = texto.replace('g', '8');
        texto = texto.replace('G', '8');
        texto = texto.replace('o', '9');
        texto = texto.replace('O', '9');
        return texto;
    }

    public void nuevoUsuario() {
        //String usuario, String email, String contraseña1,  String contraseña2){
        try {
            File file = new File("usuarios.txt");

            FileWriter archivo = new FileWriter(file.getAbsoluteFile(), true);

            String texto = claveMurci(usuario) + "," + claveMurci(email) + "," + claveMurci(contraseña1);

            PrintWriter imprimir = new PrintWriter(archivo);
            imprimir.println(texto);

            archivo.close();
        } catch (IOException ex) {
            Logger.getLogger(UsuarioJuego.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Usuario creado exitosamente");
    }

    public boolean validarUsuario(String usuario, String contraseña) {
        String[] u;
        boolean isLogin = false;
        try {
            File myObj = new File("usuarios.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                u = data.split(",");
                //JOptionPane.showMessageDialog(null, u[0] + " - " + claveMurci(usuario));
                //JOptionPane.showMessageDialog(null, u[2] + " - " + claveMurci(contraseña));
                if(u[0].equals(claveMurci(usuario)) && u[2].equals(claveMurci(contraseña))){
                    //JOptionPane.showMessageDialog(null, "Son iguales");
                    isLogin = true;
                    FrmJuego juego = new FrmJuego();
                    juego.setLocationRelativeTo(null);
                    JOptionPane.showMessageDialog(null, "A jugar");
                    juego.setVisible(true);
                    //break;
                    
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        
        return isLogin;
    }
}
