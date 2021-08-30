package clases;

/**
 *
 * @author Samuel David Ortiz
 */
public class Casilla {

    private int posFila;
    private int posCol;
    private int numCas;
    
    public Casilla(int posFila, int posCol){
        this.posFila = posFila;
        this.posCol = posCol;
    }
    
    public int getPosfila() {
        return posFila;
    }

    public void setPosfila(int posFila) {
        this.posFila = posFila;
    }

    public int getPoscol() {
        return posCol;
    }

    public void setPoscol(int posCol) {
        this.posCol = posCol;
    }
    
    public void incrementar(){
        this.numCas++;
    }
}
