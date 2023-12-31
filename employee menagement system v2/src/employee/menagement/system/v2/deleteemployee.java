/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package employee.menagement.system.v2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author User
 */
public class deleteemployee extends javax.swing.JFrame {

    /**
     * Creates new form deleteemployee
     */
    public deleteemployee() {
        initComponents();
          try {
           Connection conn = null;
             ResultSet rs = null;
            conn = dbconnection.connect();


          
           
          
            
        
            
            PreparedStatement statement = conn.prepareStatement("SELECT name, surname FROM workers ");
            ResultSet resultSet = statement.executeQuery();
             while (resultSet.next()) {
        String name = resultSet.getString("name");
        String surname = resultSet.getString("surname");
        String fullName = name + " " + surname;
        ComboBox.addItem(fullName);
    }

    

    resultSet.close();
    statement.close();
    conn.close();
} catch (Exception e) {
    e.printStackTrace();
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

        jButton1 = new javax.swing.JButton();
        ComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/employee/menagement/system/v2/My project-1 (2).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
               String selectedName = (String) ComboBox.getSelectedItem();
        try {
             Connection conn = null;
             
            conn = dbconnection.connect();


            PreparedStatement statement = conn.prepareStatement("DELETE FROM workers WHERE name = ?");
            statement.setString(1, selectedName);
            
            int rowsAffected = statement.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Worker deleted successfully.");
            } else {
                System.out.println("Failed to delete worker.");
            }
            
            statement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxActionPerformed
         String selectedFullName = (String) ComboBox.getSelectedItem();
        String selectedName = selectedFullName.split(" ")[0];
        
        try {
           Connection conn = null;
            conn = dbconnection.connect();


            ResultSet rs = null;
           
          
            
        
            
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM workers WHERE name = ?");
            statement.setString(1, selectedName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String surname = resultSet.getString("surname");
                String role = resultSet.getString("role");
                int id = resultSet.getInt("id");
                double salary = resultSet.getDouble("salary");
                String startDate = resultSet.getString("start date");
                String name = resultSet.getString("name");
                  String nameTextField = (name);
                String nameTextField1 =(surname);
                String nameTextField2 =(role);
                String nameTextField3 =(Integer.toString(id));
                
            
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_ComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(deleteemployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(deleteemployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(deleteemployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(deleteemployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new deleteemployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
