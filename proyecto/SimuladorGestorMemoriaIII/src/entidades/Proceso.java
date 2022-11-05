package entidades;

import java.util.logging.Level;
import java.util.logging.Logger;
import simuladorgestormemoriaiii.main;

public class Proceso extends Thread {
    // Attr.
    private final String nombre;
    private final int PID;
    private Estado estado;
    private int memoria;
    // Quantum = tiempo de vida del proceso
    private int quantum;
    
    // Identificador de cual memoria se consumio
    private String referencia_memoria;
    private int id_marco;

    // Constructor del proceso e inicializador de sus atributos mediante los parametros
    public Proceso(String nombre, Estado estado, int memoria) {
        this.nombre = nombre;
        // Asignación del PID correspondiente
        this.PID = ++main.SERIALIZADOR_PID;
        this.id_marco = ++main.SERIALIZADOR_MARCO;
        this.estado = estado;
        this.memoria = memoria;
        // Asignación del tiempo de vida para el proceso presente.
        this.quantum = new Quantum().getQuantum();
        
        // Inicializador del hilo del proceso actual.
        this.Iniciar();
    }

    /***
     * Hilo heredado de thread para evaluar el estado del proceso
     * y decrementar su tiempo de vida.
     */
    @Override
    public void run() {
        // El siguiente método, muestra información de este proceso 
        this.info();
        // El hilo se mantiene en una ejecución constante
        while(true) {
            try {
                // Finalizar hilo si el tiempo de vida es igual o menor a 0
                if (this.quantum <= 0) {
                    this.Finalizar();
                }
                // Contabilizar tiempo de vida del proceso solo si esta asignado
                if (this.estado == Estado.Asignado) {
                    this.estado = Estado.Ejecutando;
                    main.SIMULADOR.actualizarTabla_Proceso();
                    main.SIMULADOR.actualizarTabla_memoria();
                    Thread.sleep(1000);
                }
                if (this.estado == Estado.Ejecutando) {
                    this.quantum -= 1;
                }
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /***
     * Inicializa el proceso actual
     */
    private void Iniciar() {
        this.start();
    }
    
    /***
     * Detiene el proceso
     */
    private void Finalizar() {
        // Se realiza un llamadao al gestor para liberar la memoria utilizada
        // del presente proceso (this=Proceso)
        main.GESTOR_MEMORIA.liberarMemoria_Proceso(this);
        // Cambio de estado
        this.estado = Estado.Finalizado;
        // Presentación de información del proceso
        this.info();
        // Actualización de las tablas
        main.SIMULADOR.actualizarTabla_Proceso();
        main.SIMULADOR.actualizarTabla_memoria();
        
                
                
        // Instancia de pagina
        Pagina pagina = new Pagina(this, main.PAGINAS.size()+1, this.getMemoria());
        main.PAGINAS.add(pagina);
        main.SIMULADOR.actualizarTabla_pagina();
        
        // Culminación del hilo
        this.stop();
    }
    
    /***
     * Permite enviar los datos establecidos dentro de un
     * arreglo para agregar a las filas de las tablas.
     * @return Object[] {Class.Object}
     */
    public Object[] getDatos() {
        return new Object[]{this.nombre,this.PID,this.estado,this.memoria};
    }
    
    /***
     * Permite imprimir por consola el nombre, estado y quantum actual del proceso.
     */
    public void info() {
        System.out.println("Proc.->" + this.nombre + "\n\r{Est=" + this.estado + "/Q=" + this.quantum + "/Mem=" + this.referencia_memoria + "/CMem=" + this.memoria + "}");
    }
    
    // SETTERS and GETTERS
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPID() {
        return PID;
    }

    public String getReferencia_memoria() {
        return referencia_memoria;
    }

    public void setReferencia_memoria(String referencia_memoria) {
        this.referencia_memoria = referencia_memoria;
    }
    
    
}
