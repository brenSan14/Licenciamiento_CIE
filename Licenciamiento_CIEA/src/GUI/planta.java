/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.proveedor.res;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sal
 */
public class planta extends javax.swing.JFrame {

    /**
     * Creates new form planta
     */
    
    String query;
    JTable nameModelTable;
    String [] columnas = new String [2];
    
    public planta() {
        initComponents();
        valores();
        licenciamiento_ciea.conexion.loadTable(query, nameModelTable, columnas);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPlanta = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Plantas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable_Plantas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Id_Planta", "Planta", "Ver Detalles", "Actualizar", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(jTable_Plantas);

        jButton1.setText("Añadir Planta");

        jLabel1.setText("CATALOGO DE PLANTAS");

        javax.swing.GroupLayout jPanelPlantaLayout = new javax.swing.GroupLayout(jPanelPlanta);
        jPanelPlanta.setLayout(jPanelPlantaLayout);
        jPanelPlantaLayout.setHorizontalGroup(
            jPanelPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPlantaLayout.createSequentialGroup()
                .addGroup(jPanelPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPlantaLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanelPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelPlantaLayout.createSequentialGroup()
                        .addGap(373, 373, 373)
                        .addComponent(jLabel1)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        jPanelPlantaLayout.setVerticalGroup(
            jPanelPlantaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPlantaLayout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPlanta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPlanta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(planta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(planta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(planta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(planta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new planta().setVisible(true);
            }
        });
    }
   public void valores(){
        
        //Consulta
        query = "SELECT * FROM planta";
        
        //Se asigna el nombre del modelo de la tabla de la interfaz
        nameModelTable = jTable_Plantas;
        
        //Columnas a mostrar
        columnas[0] ="id_planta";
        columnas[1] = "planta";
    }
    
    
    public void Cargar_plantas(){
        DefaultTableModel modelo = (DefaultTableModel) jTable_Plantas.getModel();
        modelo.setRowCount(0);
        res = licenciamiento_ciea.conexion.Consulta("select * from planta");
        try{
            while(res.next()){
                Vector v = new Vector();
                v.add(res.getInt("id_planta"));
                v.add(res.getString("planta"));
                
                modelo.addRow(v);
                jTable_Plantas.setModel(modelo);
            }
        }catch(SQLException e){
                    
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelPlanta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Plantas;
    // End of variables declaration//GEN-END:variables
}
