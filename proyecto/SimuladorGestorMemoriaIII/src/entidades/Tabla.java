package entidades;

import javax.swing.table.DefaultTableModel;

public class Tabla extends DefaultTableModel {

    /***
     * Permite agregar al modelo el encabezado de la tabla actual
     * @param encabezado[] {Class.String}
     */
    public void agregarColumnas(String encabezado[]) {
        this.setColumnIdentifiers(encabezado);
    }
    
    /***
     * Agrega una fila a la tabla correspondiente
     * @param fila[] {Class.Object}
     */
    public void agregarFila(Object[] fila) {
        this.addRow(fila);
    }

    /***
     * Permite vaciar el modelo de la tabla eliminado todas
     * las filas.
     */
    public void limpiarTabla() {
        if (this.getRowCount() > 0) {
            this.setNumRows(0);
        }
    }
    
    /***
     * Se sobreescribe el presente método para deshabilitar la 
     * edición de las filas y columnas
     * @param row {TypeDate.int}
     * @param column {TypeDate.int}
     * @return FALSE {TypeDate.boolean}
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    
    
}
