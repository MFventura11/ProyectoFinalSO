package gui;

import entidades.Background;
import entidades.GestorMemoria;
import entidades.Pagina;
import entidades.Proceso;
import entidades.Tabla;
import javax.swing.JOptionPane;
import simuladorgestormemoriaiii.main;

public class JFrameSimuladorGestorMemoria extends javax.swing.JFrame {

    // Ventana -> creador de procesos
    private static final JFrameCrearProceso CREAR_PROCESO = new JFrameCrearProceso();;
    
    // Modeladores de Tablas
    private static final Tabla TABLA_PROCESO = new Tabla();
    private static final Tabla TABLA_MEMORIA = new Tabla();
    private static final Tabla TABLA_PAGINA = new Tabla();
    private static final Tabla TABLA_PAGINA_MARCO = new Tabla();
    private static final Tabla TABLA_MEMORIA_VIRTUAL = new Tabla();
    
    // Encabezados de tablas
    private final String[] encabezado_tabla_proceso = {"Proceso","PID","Estado","Memoria requerida"};
    private final String[] encabezado_tabla_memoria = {"Marco","Tamaño Marco","En uso (KB)","Disponible (KB)","Proceso"};
    private final String[] encabezado_tabla_pagina = {"Proceso","Página","Tamaño"};
    private final String[] encabezado_tabla_pagina_marco = {"Página","Marco"};
    private final String[] encabezado_tabla_memoria_virtual = {"Proceso","PID","Memoria (KB)"};

    public JFrameSimuladorGestorMemoria() {
        // Antes de inicializar los componentes se instancia un nuevo jpanel de fondo con color
        this.setContentPane(new Background());
        // Se inicializan los componentes (GUI) de la ventana  
        initComponents();
        // Se posiciona la ventana al centro del escritorio de windows
        this.setLocationRelativeTo(null);
        // Se inicializan las tablas, principalmente el encabezado y posteriormente, las filas al momento de crear cada proceso. 
        this.InicializarTabla();
    }

    /***
     * Inicializa los valores por defecto de las tablas
     */
    private void InicializarTabla() {
        // Setter del modelo de las tablas
        this.JTableProceso.setModel(TABLA_PROCESO);
        this.JTableMemoria.setModel(TABLA_MEMORIA);
        this.JTablePagina.setModel(TABLA_PAGINA);
        this.JTableRelacionPaginas_Marco.setModel(TABLA_PAGINA_MARCO);
        this.JTableMemoriaVirtual.setModel(TABLA_MEMORIA_VIRTUAL);
        
        // Inserción de columnas
        TABLA_PROCESO.agregarColumnas(this.encabezado_tabla_proceso);
        TABLA_MEMORIA.agregarColumnas(this.encabezado_tabla_memoria);
        TABLA_PAGINA.agregarColumnas(this.encabezado_tabla_pagina);
        TABLA_PAGINA_MARCO.agregarColumnas(this.encabezado_tabla_pagina_marco);
        TABLA_MEMORIA_VIRTUAL.agregarColumnas(this.encabezado_tabla_memoria_virtual);
    }
    
    /***
     * Vacía la tabla proceso para rellenarla con los valores del procesos en cola 
     */
    public void actualizarTabla_Proceso() {
        TABLA_PROCESO.limpiarTabla();
        for (Proceso proceso : main.COLA_PROCESOS) {
            TABLA_PROCESO.agregarFila(proceso.getDatos());
        }
    }
    
    /***
     * Vacía la tabla memoria para rellenarla con los valores del procesos en cola 
     * más los valores de la memoria
     */
    public void actualizarTabla_memoria() {
        TABLA_MEMORIA.limpiarTabla();
        TABLA_MEMORIA_VIRTUAL.limpiarTabla();
        try {
            for (Proceso p : main.COLA_PROCESOS) {
                if (p.getReferencia_memoria().equals("FISICA")) {
                    Object[] datos = new Object[] {
                        p.getPID(),
                        GestorMemoria.MEMORIA.getCapacidad(),
                        p.getMemoria(),
                        GestorMemoria.MEMORIA.getDisponible(),
                        p.getNombre()
                    };
                    TABLA_MEMORIA.agregarFila(datos);                
                }
                else if (p.getReferencia_memoria().equals("VIRTUAL")){
                    Object[] datos = new Object[] {
                        p.getNombre(),
                        p.getPID(),
                        p.getMemoria()
                    };
                    TABLA_MEMORIA_VIRTUAL.agregarFila(datos);
                }
            }
        } catch (NullPointerException e) {
        }
    }
    
    /***
     * Se actualizan los datos en las tablas de pagina
     */
    public void actualizarTabla_pagina() {
        TABLA_PAGINA.limpiarTabla();
        TABLA_PAGINA_MARCO.limpiarTabla();
        try {
            for (Pagina p : main.PAGINAS) {
                // Datos de la pagina
                Object[] datos = new Object[]{
                    p.getProceso().getNombre(),
                    p.getNum_pagina(),
                    p.getTamanio()
                };
                TABLA_PAGINA.agregarFila(datos);
                // Datos pagina y marco
                Object[] datos2 = new Object[]{
                    p.getNum_pagina(),
                    p.getProceso().getPID()
                };
                TABLA_PAGINA_MARCO.agregarFila(datos2);
            }
        } catch (NullPointerException e) {
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTableProceso = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableMemoria = new javax.swing.JTable();
        JButtonCrearProceso = new javax.swing.JButton();
        JButtonLimpiarTablas = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        JTablePagina = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JTableRelacionPaginas_Marco = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        JTableMemoriaVirtual = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulador Gestor de Memoria");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Procesos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Asignación de Memoria");

        JTableProceso.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        JTableProceso.setSelectionBackground(new java.awt.Color(204, 153, 255));
        JTableProceso.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(JTableProceso);

        JTableMemoria.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        JTableMemoria.setSelectionBackground(new java.awt.Color(204, 255, 255));
        jScrollPane2.setViewportView(JTableMemoria);

        JButtonCrearProceso.setBackground(new java.awt.Color(102, 0, 102));
        JButtonCrearProceso.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        JButtonCrearProceso.setForeground(new java.awt.Color(255, 255, 255));
        JButtonCrearProceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/agregar.png"))); // NOI18N
        JButtonCrearProceso.setText("Crear");
        JButtonCrearProceso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JButtonCrearProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonCrearProcesoActionPerformed(evt);
            }
        });

        JButtonLimpiarTablas.setBackground(new java.awt.Color(51, 0, 102));
        JButtonLimpiarTablas.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        JButtonLimpiarTablas.setForeground(new java.awt.Color(255, 255, 255));
        JButtonLimpiarTablas.setText("Limpiar Tablas");
        JButtonLimpiarTablas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JButtonLimpiarTablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonLimpiarTablasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Páginas");

        JTablePagina.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        JTablePagina.setSelectionBackground(new java.awt.Color(204, 255, 255));
        jScrollPane3.setViewportView(JTablePagina);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Tabla de Páginas");

        JTableRelacionPaginas_Marco.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        JTableRelacionPaginas_Marco.setSelectionBackground(new java.awt.Color(204, 255, 255));
        jScrollPane4.setViewportView(JTableRelacionPaginas_Marco);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Memoria Virtual");

        JTableMemoriaVirtual.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        JTableMemoriaVirtual.setSelectionBackground(new java.awt.Color(204, 255, 255));
        jScrollPane5.setViewportView(JTableMemoriaVirtual);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 64, Short.MAX_VALUE)
                                .addComponent(JButtonLimpiarTablas, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JButtonCrearProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JButtonCrearProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JButtonLimpiarTablas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /***
     * Permite visualizar la ventana CREAR PROCESO.
     * @param evt {Class.event}
     */
    private void JButtonCrearProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonCrearProcesoActionPerformed
        CREAR_PROCESO.setVisible(true);
    }//GEN-LAST:event_JButtonCrearProcesoActionPerformed

    /***
     * Permite limpiar las tablas.
     * @param evt {Class.event
     */
    private void JButtonLimpiarTablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonLimpiarTablasActionPerformed
        // Si, la cola de procesos es mayor a 0 y 
        // Si, el creador de procesos mediante el método ValidarColaProcesos() es igual a 0
        // Entonces, no existen procesos en espera ni asignados, es decir, todos han finalizado
        // Por ende, se puede vaciar la cola de procesos y limpiar las tablas.
        if (main.COLA_PROCESOS.size() > 0 && CREAR_PROCESO.ValidarColaProcesos() == 0) {
            TABLA_MEMORIA.limpiarTabla();
            TABLA_MEMORIA_VIRTUAL.limpiarTabla();
            TABLA_PROCESO.limpiarTabla();
            main.COLA_PROCESOS.clear();
            JOptionPane.showMessageDialog(this, "¡Se vaciarón las tablas!");
        } 
        // Caso contrario, no se elimina la cola de procesos, ni se vacian las tablas
        else {
            JOptionPane.showMessageDialog(this, "¡No es posible vacíar las tablas, espere a que finalice los procesos en espera y asignados!");
        }
        
        if (main.PAGINAS.size() > 0) {
            TABLA_PAGINA.limpiarTabla();
            TABLA_PAGINA_MARCO.limpiarTabla();
            main.PAGINAS.clear();
        }
        
    }//GEN-LAST:event_JButtonLimpiarTablasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonCrearProceso;
    private javax.swing.JButton JButtonLimpiarTablas;
    private javax.swing.JTable JTableMemoria;
    private javax.swing.JTable JTableMemoriaVirtual;
    private javax.swing.JTable JTablePagina;
    private javax.swing.JTable JTableProceso;
    private javax.swing.JTable JTableRelacionPaginas_Marco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
