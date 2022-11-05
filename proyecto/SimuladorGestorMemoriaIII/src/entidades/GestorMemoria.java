package entidades;

import java.util.logging.Level;
import java.util.logging.Logger;
import simuladorgestormemoriaiii.main;

public class GestorMemoria extends Thread {
    // Cantidad de memoria min y max que posee los procesos
    private final int memoria_proceso_min = 200000;
    private final int memoria_proceso_max = 400000;
    // Se instancia una memoria general para gestionarla
    public static final Memoria MEMORIA = new Memoria("FISICA");
    public static final Memoria MEMORIA_VIRTUAL = new Memoria("VIRTUAL");
    
    public GestorMemoria() {
        // Se inicializa el hilo del gestor de memoria
        this.Iniciar();
    }
    
    /***
     * Este método heredado de Thread permite evaluar cada segundo 
     * los procesos que están en estado de espera para cambiar su estado
     * de espera a asignado.
     */
    @Override
    public void run() {
        while(true) {
            try {
                this.evaluarProcesosEnEspera();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(GestorMemoria.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /***
     * Método heredado de thread-> inicializa el hilo de este gestor.
     */
    private void Iniciar() {
        this.start();
    }
    
    /***
     * El presente método permite evaluar los procesos que 
     * se encuentran en estado de espera y si la cantidad aleatoria de
     * memoria se puede CONSUMIR(int kb) entonces se hará el cambio de estado
     * y se actualizarán las tablas.
     */
    public void evaluarProcesosEnEspera() {
       
        for (Proceso proceso : main.COLA_PROCESOS) {
            if (proceso.getEstado() == Estado.En_espera) {
                if (MEMORIA.consumir(proceso.getMemoria())) {
                    proceso.setEstado(Estado.Ejecutando);
                    proceso.setReferencia_memoria("FISICA");
                } 
                else 
                if (MEMORIA_VIRTUAL.consumir(proceso.getMemoria())) {
                    proceso.setEstado(Estado.Ejecutando);
                    proceso.setReferencia_memoria("VIRTUAL");
                }
            }
        }
    }
    
 
    /***
     * Este método retorna en KB la cantidad de memoria para el proceso
     * de manera aleatoria, respetando la cantidad min y max.
     * @return random [TypeDate.int]
     */
    private int generarMemoriaAleatoria(){
        int random = (int) (Math.random() * this.memoria_proceso_max) + this.memoria_proceso_min;
        random -= (random > this.memoria_proceso_max) ? this.memoria_proceso_min : 0;
        return random;
    }
    
    /***
     * Este método permite asignar la memoria al proceso correspondiente pasado
     * por parametro, luego retorna la cantidad de memoria asignada simplemente
     * para previsualizar el valor a asignar.
     * @param proceso {Class.Proceso}
     * @return memoria_usar {TypeDate.int}
     */
    public int asignarMemoria(Proceso proceso) {
        int memoria_usar = this.generarMemoriaAleatoria();
        // Si de la memoria fisica se puede consumir la memoria a usar por el proceso
        // Entonces se ejecuta lo siguiente:
        if (MEMORIA.consumir(memoria_usar)) {
            // Al proceso se le asigna la memoria
            proceso.setEstado(Estado.Asignado);
            proceso.setMemoria(memoria_usar);
            proceso.setReferencia_memoria("FISICA");
        }
        // Caso contrario se consume la memoria virtual
        else if (MEMORIA_VIRTUAL.consumir(memoria_usar)) {
            // Al proceso se le asigna la memoria
            proceso.setEstado(Estado.Asignado);
            proceso.setMemoria(memoria_usar);
            proceso.setReferencia_memoria("VIRTUAL");   
        } 
        // Caso contrario, se mantiene en espera, pero se setea el valor a consumir en memoria 
        else {
            proceso.setEstado(Estado.En_espera);
            proceso.setMemoria(memoria_usar);
        }
        this.info();
        return memoria_usar;
    }

    /***
     * Permite liberar la memoria utilizada por un proceso.
     * @param proceso {Class.Proceso}
     */
    public void liberarMemoria_Proceso(Proceso proceso) {
        if (proceso.getReferencia_memoria().equals("FISICA")) {
            MEMORIA.liberar(proceso.getMemoria());
            //proceso.setMemoria(0);
        }
        if (proceso.getReferencia_memoria().equals("VIRTUAL")) {
            MEMORIA_VIRTUAL.liberar(proceso.getMemoria());
            //proceso.setMemoria(0);
        }
        this.info();
    }
    
    public void info() {
        System.out.println("Memoria -> Física: " + MEMORIA.getDisponible() +"/"+ MEMORIA.getCapacidad() + " -> " + MEMORIA.getEn_uso());
        System.out.println("Memoria -> Virtual: " + MEMORIA_VIRTUAL.getDisponible() +"/"+ MEMORIA_VIRTUAL.getCapacidad() + " -> " + MEMORIA_VIRTUAL.getEn_uso());
    }
}
