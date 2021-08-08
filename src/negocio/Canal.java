
package negocio;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafay
 */
public class Canal {
    private int CAN_ID_CANAL;
    private String CAN_NOMBRE;
    private boolean CAN_ESTADO;

    public Canal() {
        this.CAN_ID_CANAL = 0;
        this.CAN_NOMBRE = "";
        this.CAN_ESTADO = true;
    }

    public Canal(int CAN_ID_CANAL, String CAN_NOMBRE, boolean CAN_ESTADO) {
        this.CAN_ID_CANAL = CAN_ID_CANAL;
        this.CAN_NOMBRE = CAN_NOMBRE;
        this.CAN_ESTADO = CAN_ESTADO;
    }

    public int getCAN_ID_CANAL() {
        return CAN_ID_CANAL;
    }

    public void setCAN_ID_CANAL(int CAN_ID_CANAL) {
        this.CAN_ID_CANAL = CAN_ID_CANAL;
    }

    public String getCAN_NOMBRE() {
        return CAN_NOMBRE;
    }

    public void setCAN_NOMBRE(String CAN_NOMBRE) {
        this.CAN_NOMBRE = CAN_NOMBRE;
    }

    public boolean isCAN_ESTADO() {
        return CAN_ESTADO;
    }

    public void setCAN_ESTADO(boolean CAN_ESTADO) {
        this.CAN_ESTADO = CAN_ESTADO;
    }
    
    
}

