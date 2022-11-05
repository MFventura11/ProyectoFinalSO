package entidades;

public final class Quantum {
    // Milisegundos
    private final int ms_min = 1000;
    private final int ms_max = 10000;
    // Valor del quatum en entero.
    private int quantum;
    
    // Constructor
    public Quantum() {
        // Genera el valor del quantum
        this.quantum = this.GenerarQuantum();
    }
    
    /***
     * Este método retorna un quantum aleatorio correspondiente 
     * al tiempo de vida de un proceso X en milisegundos, respetando
     * los valores máx y min.
     * @return quantum {TypeDate.int}
     */
    private int GenerarQuantum() {
        this.quantum = (int) (Math.random() * this.ms_max) + this.ms_min;
        this.quantum -= (this.quantum > this.ms_max) ? this.ms_min : 0;
        return this.quantum;
    }
    
    /***
     * Este método retorna el valor del quantum
     * @return quantum {TypeDate.int}
     */
    public int getQuantum() {
        return this.quantum;
    }
}
