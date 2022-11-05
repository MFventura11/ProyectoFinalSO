package gui;

import entidades.Background;
import entidades.Estado;
import entidades.Proceso;
import javax.swing.JOptionPane;
import simuladorgestormemoriaiii.main;

// La presente ventana es considerada como el gestor de procesos.
public class JFrameCrearProceso extends javax.swing.JFrame {

    // Procesos de ejemplos
    private final String[] nombre_procesos = {"java.exe","thunderbird.ct","firefox.exe","code.exe","Isolatede web Co.exe","soffice.bin","WebExtensions.exe","gulp.mrt","Chrome.exe","node.exe"}; 
    
    // Constructor de la presente ventana
    public JFrameCrearProceso() {
        // Antes de inicializar los componentes se instancia un nuevo jpanel de fondo con color
        this.setContentPane(new Background());
        // Se inicializan los componentes (GUI) de la ventana  
        initComponents();
        // Se posiciona la ventana al centro del escritorio de windows
        this.setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JTextFieldProceso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JButtonGuardar = new javax.swing.JButton();
        JLabelMemoria = new javax.swing.JLabel();
        JButtonLimpiar = new javax.swing.JButton();
        JButtonRandom = new javax.swing.JButton();

        setTitle("Crear Proceso");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Proceso:");

        JTextFieldProceso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Memoria");

        JButtonGuardar.setBackground(new java.awt.Color(0, 153, 51));
        JButtonGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JButtonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        JButtonGuardar.setText("Guardar");
        JButtonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonGuardarActionPerformed(evt);
            }
        });

        JLabelMemoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JLabelMemoria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        JLabelMemoria.setText("0 KB");
        JLabelMemoria.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        JButtonLimpiar.setBackground(new java.awt.Color(255, 51, 0));
        JButtonLimpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JButtonLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        JButtonLimpiar.setText("Limpiar");
        JButtonLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonLimpiarActionPerformed(evt);
            }
        });

        JButtonRandom.setBackground(new java.awt.Color(0, 102, 153));
        JButtonRandom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JButtonRandom.setForeground(new java.awt.Color(255, 255, 255));
        JButtonRandom.setText("Random");
        JButtonRandom.setToolTipText("Genera X cantidad de Procesos");
        JButtonRandom.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        JButtonRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonRandomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTextFieldProceso)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(JButtonRandom)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JButtonGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(JLabelMemoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextFieldProceso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JLabelMemoria, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonGuardar)
                    .addComponent(JButtonLimpiar)
                    .addComponent(JButtonRandom))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /***
     * Permite evaluar la cantidad de procesos en cola con
     * estado (Asignado y En_espera) y retorna el valor iterado (incremento).
     * @return i {TypeDate.int}
     */
    public int ValidarColaProcesos() {
        int i = 0;
        for (Proceso proceso : main.COLA_PROCESOS) {
            Estado e = proceso.getEstado();
            if (e == Estado.Asignado || e == Estado.En_espera) {
                ++i;
            }
        }
        return i;
    }
    
    /***
     * Almace el proceso dependiendo de lo siguiente:
     * Si, la cola de  procesos es menor a 15 en estado de espera o asignado,
     * se agrega el proceso al listado.
     * Caso contrario, muestra un mensaje de información "¡No se pueden crear más procesos!".
     * @param nombre_proceso {Class.String}
     */
    private void GuardarProceso(String nombre_proceso) {
        // Caso: SI
        if (this.ValidarColaProcesos() < 15) {
            // Se valida que el parametro nombre no este vacio
            if (nombre_proceso.isEmpty()) {
                JOptionPane.showMessageDialog(this, "¡Por favor, complete el campo nombre del proceso!");
                this.JTextFieldProceso.requestFocus();
            } 
            // Se crea y se agrega a la cola el nuevo proceso
            else {
                // Instancia de un nuevo proceso
                Proceso nuevo_proceso = new Proceso(nombre_proceso, Estado.En_espera, 0);
                // Asignación de memoria
                int memoria = main.GESTOR_MEMORIA.asignarMemoria(nuevo_proceso);
                // Presentación de la memoria asignada
                this.JLabelMemoria.setText(memoria + " KB");
                // Se agrega el proceso a la cola 
                main.COLA_PROCESOS.add(nuevo_proceso);
                // Se actualizan las tablas
                main.SIMULADOR.actualizarTabla_Proceso();
                main.SIMULADOR.actualizarTabla_memoria();
            }
        } 
        // CASO: CONTRARIO
        else {
            JOptionPane.showMessageDialog(null, "¡No se pueden crear más procesos!");
        }
    }
    
    /***
     * Simplemente vacia los campos de la (GUI) nombre de proceso y memoria
     */
    private void LimpiarCampos() {
        this.JTextFieldProceso.setText("");
        this.JLabelMemoria.setText("0 KB");
    }
    
    /***
     * Este método es addicional, permite generar una cierta cantidad de procesos 
     * aleatorios con el fin de evaluar el programa sin la necesidad de ingresar un proceso a la vez.
     */
    private void GenerarProcesos() {
        try {
            // Cantidad de procesos a crear
            int x = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese la cantidad de procesos a crear:"));
            // A través del ciclo se crean los procesos
            for (int i = 0; i < x; i++) {
                // CASO: Si, los procesos en cola (asignados y en espera) son menores a 15
                if (this.ValidarColaProcesos() < 15) {
                    // Se genera un random aleatorio para el nombre del proceso
                    int random_proceso = (int) (Math.random() * this.nombre_procesos.length);
                    // Se hace un llamado al método GuardarProceso pasando como parametro el nombre del proceso de ejemplo.
                    this.GuardarProceso(this.nombre_procesos[random_proceso]);
                } 
                // CASO: Contrario, se imprime un sms informativo y se detiene la creación de procesos
                else {
                    JOptionPane.showMessageDialog(null, "¡No se pueden crear más procesos!");
                    break;
                }
            }
        } catch (java.lang.NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "¡Error al ingresar la cantidad de procesos!");
        }
    }
    
    /***
     * El presente evento permite guardar el proceso que el usuario digite (ingrese)
     * @param evt {Class.event} 
     */
    private void JButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonGuardarActionPerformed
        String nombre = this.JTextFieldProceso.getText().trim();
        this.GuardarProceso(nombre);
    }//GEN-LAST:event_JButtonGuardarActionPerformed

    /***
     * Limpia los campos de la GUI, nombre de proceso y memoria
     * @param evt {Class.event} 
     */
    private void JButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonLimpiarActionPerformed
        this.LimpiarCampos();
    }//GEN-LAST:event_JButtonLimpiarActionPerformed

    /***
     * Este evento hace un llamado a la función para generar los procesos automáticamente
     * @param evt {Class.event} 
     */
    private void JButtonRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonRandomActionPerformed
        this.GenerarProcesos();
    }//GEN-LAST:event_JButtonRandomActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonGuardar;
    private javax.swing.JButton JButtonLimpiar;
    private javax.swing.JButton JButtonRandom;
    private javax.swing.JLabel JLabelMemoria;
    private javax.swing.JTextField JTextFieldProceso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
