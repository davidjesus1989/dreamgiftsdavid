/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Conexion.Conexion;
import static com.sun.source.tree.Tree.Kind.AND;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import controlador.Canal;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Usuario
 */
public class frmPack extends javax.swing.JFrame {
DefaultTableModel modelo; 
 
  Conexion cone=new Conexion();
  Connection con=cone.ConexionBD();
  
  int id;
  
    DefaultTableModel model = new DefaultTableModel();  
    PreparedStatement ps = null;
    Statement st = null;
    ResultSet rs = null; 
    /**
     * Creates new form frmPack
     */
    public frmPack()  {
        initComponents();
        DesplegarDatosBusca("");
        setLocationRelativeTo(null);
        MostrarDatos();
    }
    
    private void MostrarDatos(){
        
       
    
      
        String [] titulos = {"Código pack", "Nombre pack", "Unidades bodega", "Estado"};
        String [] registros = new String [4];
        
       
       
      
      DefaultTableModel modelo = new DefaultTableModel(null, titulos); 
     
      


     
       
        String Sql = "select * from pack";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(Sql);
        
           

            while (rs.next()) {
                registros[0] = rs.getString("PCK_ID_PACK");
                registros[1] = rs.getString("PCK_NOMBRE");
                registros[2] = rs.getString("PCK_STOCK");
                registros[3] = rs.getString("PCK_ESTADO");
                int tipoObt2= Integer.valueOf(registros[3]);
                
                if ((tipoObt2 == 0)){
                    registros[3] = "Desactivado";
                } else {
                    registros[3] = "Activado";
                }

             modelo.addRow(new Object[]{registros[0],registros[1],registros[2],registros[3]});
                //modelo.addRow(registros);
            }
            Tabla_pack.setModel(modelo);
                
        }   catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al mostrar datos" + e.getMessage());
        }
        
    }
        
                
            
    
    public void DesplegarDatosBusca(String valor){
    DefaultTableModel modelo= new DefaultTableModel();
    modelo.addColumn("Código pack");
    modelo.addColumn("Nombre pack");
    modelo.addColumn("Unidades bodega");
    modelo.addColumn("Estado");
    String sql="";
    if(valor.equals(""))
    {
        sql="SELECT * FROM pack";
    }
    else{
        sql="SELECT * FROM pack WHERE PCK_NOMBRE='"+valor+"'";
        //sql="SELECT * FROM canal WHERE CAN_ID_CANAL='"+valor+"'";
    }
 
    String []datos = new String [4];
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                datos[0]=rs.getString("PCK_ID_PACK");
                datos[1]=rs.getString("PCK_NOMBRE");
                datos[2]=rs.getString("PCK_STOCK");
                datos[3]=rs.getString("PCK_ESTADO");
             
                
   
                //modelo.addRow(new Object[]{datos[0],datos[1],datos[2],datos[3]});
                modelo.addRow(datos);
            }
            Tabla_pack.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(frmCanal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla_producto = new javax.swing.JTable();
        btn_izquierda = new javax.swing.JButton();
        btn_derecha = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabla_precio_pack = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtxt_pack = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxt_unidades = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtxt_precio_pack = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jtxt_codigopck = new javax.swing.JTextField();
        jtxt_buscar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla_pack = new javax.swing.JTable();
        btn_editar = new javax.swing.JButton();
        btn_desactivar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_reestablecer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Packs"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Tabla_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane1.setViewportView(Tabla_producto);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 240, 110));

        btn_izquierda.setText(">");
        jPanel1.add(btn_izquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 90, -1));

        btn_derecha.setText("<");
        jPanel1.add(btn_derecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 90, -1));

        Tabla_precio_pack.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        jScrollPane2.setViewportView(Tabla_precio_pack);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, 280, 110));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jtxt_pack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_packActionPerformed(evt);
            }
        });
        jPanel1.add(jtxt_pack, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 130, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Precio pack");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        jtxt_unidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_unidadesActionPerformed(evt);
            }
        });
        jPanel1.add(jtxt_unidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 40, -1));

        jLabel3.setText("Unidades");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));
        jPanel1.add(jtxt_precio_pack, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 90, -1));

        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, -1, -1));

        jButton4.setText("Crear pack");
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, -1, -1));

        jtxt_codigopck.setEditable(false);
        jtxt_codigopck.setEnabled(false);
        jtxt_codigopck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_codigopckActionPerformed(evt);
            }
        });
        jPanel1.add(jtxt_codigopck, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 80, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 670, 200));

        jtxt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxt_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(jtxt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 230, 80, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tabla packs");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, -1, -1));

        jLabel5.setText("Buscar");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, -1));

        Tabla_pack.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Pack", "Nombre Pack", "Unidades bodega", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla_pack.getTableHeader().setReorderingAllowed(false);
        Tabla_pack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabla_packMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tabla_pack);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 650, 107));

        btn_editar.setText("Actualizar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, 80, -1));

        btn_desactivar.setText("Desactivar");
        btn_desactivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desactivarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_desactivar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 380, -1, -1));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 230, -1, -1));

        btn_reestablecer.setText("Reestablecer");
        btn_reestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reestablecerActionPerformed(evt);
            }
        });
        getContentPane().add(btn_reestablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 100, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxt_packActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_packActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_packActionPerformed

    private void jtxt_unidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_unidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_unidadesActionPerformed

    private void jtxt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_buscarActionPerformed

    private void Tabla_packMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabla_packMouseClicked

        int cor = Tabla_pack.getSelectedRow();
        jtxt_pack.setText(Tabla_pack.getValueAt(cor, 1).toString());
        jtxt_codigopck.setText(Tabla_pack.getValueAt(cor, 0).toString());

    }//GEN-LAST:event_Tabla_packMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
         DesplegarDatosBusca(jtxt_buscar.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_desactivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desactivarActionPerformed
               try {
        PreparedStatement pst = con.prepareStatement("UPDATE pack SET PCK_ESTADO=0 WHERE PCK_ESTADO=1 AND PCK_ID_PACK='"+jtxt_codigopck.getText()+"'");
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Pack desactivado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        MostrarDatos();
    } catch (Exception e) {
        System.out.print(e.getMessage());
          JOptionPane.showMessageDialog(null, "Error al intentar desactivar Pack", "AVISO", JOptionPane.ERROR_MESSAGE);
    
    }                                            

    }//GEN-LAST:event_btn_desactivarActionPerformed

    private void btn_reestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reestablecerActionPerformed
          MostrarDatos();
    }//GEN-LAST:event_btn_reestablecerActionPerformed

    private void jtxt_codigopckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxt_codigopckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxt_codigopckActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        try {
        PreparedStatement pst = con.prepareStatement("UPDATE pack SET PCK_NOMBRE='"+jtxt_pack.getText()+"' WHERE PCK_ID_PACK='"+jtxt_codigopck.getText()+"'");
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Nombre de canal actualizado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        MostrarDatos();
    } catch (Exception e) {
        System.out.print(e.getMessage());
          JOptionPane.showMessageDialog(null, "Error al intentar guardar el Canal", "AVISO", JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_btn_editarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPack().setVisible(true);
            }
        });
    
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabla_pack;
    private javax.swing.JTable Tabla_precio_pack;
    private javax.swing.JTable Tabla_producto;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_derecha;
    private javax.swing.JButton btn_desactivar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JButton btn_izquierda;
    private javax.swing.JButton btn_reestablecer;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jtxt_buscar;
    private javax.swing.JTextField jtxt_codigopck;
    private javax.swing.JTextField jtxt_pack;
    private javax.swing.JTextField jtxt_precio_pack;
    private javax.swing.JTextField jtxt_unidades;
    // End of variables declaration//GEN-END:variables

  
}
