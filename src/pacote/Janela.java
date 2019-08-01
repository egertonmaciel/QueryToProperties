package pacote;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 *
 * @author Egerton Maciel
 */
public class Janela extends javax.swing.JFrame {

    public Janela() {
        initComponents();
    }

    public void copiarAreaTransferecia(String texto) {
        rotulo.setText("");
        Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection ss = new StringSelection(texto);
        clip.setContents(ss, ss);
        rotulo.setText("Copiado para Área de Transferência");
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        campo = new javax.swing.JTextArea();
        botaoToProperties = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        botaoToSQL = new javax.swing.JButton();
        rotulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Query To Properties");

        campo.setColumns(20);
        campo.setRows(5);
        jScrollPane1.setViewportView(campo);

        botaoToProperties.setText("To Properties");
        botaoToProperties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoToPropertiesActionPerformed(evt);
            }
        });

        botaoLimpar.setText("Limpar");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });

        botaoToSQL.setText("To SQL");
        botaoToSQL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoToSQLActionPerformed(evt);
            }
        });

        rotulo.setForeground(new java.awt.Color(0, 51, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rotulo, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoToSQL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoToProperties)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoToProperties)
                    .addComponent(botaoLimpar)
                    .addComponent(botaoToSQL)
                    .addComponent(rotulo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        campo.setText("");
        rotulo.setText("");
        campo.requestFocus();
    }//GEN-LAST:event_botaoLimparActionPerformed

    private void botaoToPropertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoToPropertiesActionPerformed
        String antigo = campo.getText();
        String novo = "\\\n";

        for (String x : antigo.split("\n")) {
            if (!x.trim().isEmpty()) {
                novo += x + " \\\n";
            }
        }
        novo = novo.replaceAll(" \\\\\n$", "");
        campo.setText(novo);
        campo.requestFocus();
        campo.selectAll();
        copiarAreaTransferecia(campo.getText());
    }//GEN-LAST:event_botaoToPropertiesActionPerformed

    private void botaoToSQLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoToSQLActionPerformed
        String antigo = campo.getText();
        String novo = "";

        for (String x : antigo.split("\n")) {
            novo += x.replaceAll(" \\\\$", "\n").replaceAll("^\\\\$", "");
        }
        campo.setText(novo);
        campo.requestFocus();
        campo.selectAll();
        copiarAreaTransferecia(campo.getText());
    }//GEN-LAST:event_botaoToSQLActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Janela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Janela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoToProperties;
    private javax.swing.JButton botaoToSQL;
    private javax.swing.JTextArea campo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rotulo;
    // End of variables declaration//GEN-END:variables
}
