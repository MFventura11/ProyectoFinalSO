package entidades;

public class Memoria {
    // Capacidad máxima de la memoria
    private final int capacidad = 2097152; //KB = 2048 MB
    private int en_uso;
    private int disponible = 0;
    private String tipo;

    public Memoria(String tipo) {
        // Se diferencia el tipo de memoria a utilizar
        this.tipo = tipo;
        // Inicialmente la memoria disponible es igual a su capacidad
        this.disponible = this.capacidad;
    }

    /***
     * Retorna TRUE si se puede consumir la cantidad de memoria solicitada
     * por el parametro, caso contrario retorna FALSE.
     * @param kb {TypeDate.int}
     * @return true or false {TypeDate.boolean}
     */
    public boolean consumir(int kb) {
        if (this.disponible >= kb) {
            this.en_uso += kb;
            this.disponible -= kb;
            return true;
        }
        return false;
    }
    
    /***
     * Libera la memoria en uso mediante el parametro e
     * incrementa el valor de la memoria disponible por el valor a liberar.
     * @param kb {TypeDate.int}
     */
    public void liberar(int kb) {
        this.en_uso -= kb;
        this.disponible += kb;
    }
    
    // SETTERS and GETTERS
    public int getEn_uso() {
        return en_uso;
    }

    public int getDisponible() {
        return disponible;
    }

    public int getCapacidad() {
        return capacidad;
    }
   
}
