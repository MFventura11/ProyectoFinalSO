package simuladorgestormemoriaiii;

import entidades.GestorMemoria;
import entidades.Pagina;
import entidades.Proceso;
import gui.JFrameSimuladorGestorMemoria;
import java.util.ArrayList;

public class main {

    // ITERADOR DE PID
    public static int SERIALIZADOR_PID = 0;
    // ITERADOR DE PAGINA Y MARCO
    public static int SERIALIZADOR_MARCO = 0;
    
    // Gestor de memoria
    public static final GestorMemoria GESTOR_MEMORIA = new GestorMemoria();;
    
    // COLA DE PROCESOS
    public static ArrayList<Proceso> COLA_PROCESOS = new ArrayList<>(); // Hasta 15 procesos

    // PAGINAS
    public static ArrayList<Pagina> PAGINAS = new ArrayList<>();
    
    // SIMULADOR
    public static JFrameSimuladorGestorMemoria SIMULADOR = new JFrameSimuladorGestorMemoria();
    
    public static void main(String[] args) {
        SIMULADOR.setVisible(true);
    }
    
}
