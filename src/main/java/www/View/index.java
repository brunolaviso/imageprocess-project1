package www.View;

import ij.ImagePlus;
import ij.process.ImageProcessor;
import javax.swing.JOptionPane;
import www.Controller.ImageController;

public class index extends javax.swing.JFrame {

    ImagePlus imgOriginal;
    ImagePlus imgProcessada;
    ImageProcessor ipOriginal;
    ImageProcessor ipProcessada;
    ImageController ic = new ImageController();
    int contador=0;
    
    public index() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProcessada = new javax.swing.JScrollPane();
        lblImgProcessada = new javax.swing.JLabel();
        panelOriginal = new javax.swing.JScrollPane();
        lblImgOriginal = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();
        btnAnalisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblResultado = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblImgProcessada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgProcessada.setText("Imagem Analisada");
        panelProcessada.setViewportView(lblImgProcessada);

        lblImgOriginal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgOriginal.setText("Imagem Original");
        panelOriginal.setViewportView(lblImgOriginal);

        btnAbrir.setText("Abrir");
        btnAbrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAbrirMousePressed(evt);
            }
        });

        btnAnalisar.setText("Analisar");
        btnAnalisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAnalisarMousePressed(evt);
            }
        });

        jLabel1.setText("Resultado:");

        lblResultado.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        lblResultado.setText("O copo está cheio");

        btnSalvar.setText("Salvar");
        btnSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSalvarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelProcessada, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAbrir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnalisar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(274, 274, 274)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAbrir)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelOriginal, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelProcessada, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalisar)
                    .addComponent(jLabel1)
                    .addComponent(lblResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbrirMousePressed
        imgOriginal = ij.IJ.openImage();
        imgProcessada = imgOriginal.duplicate();
        
        ipOriginal = imgOriginal.getProcessor();
        ipProcessada = imgProcessada.getProcessor();
        
        ic.exibeImagemProcessada(ipOriginal, lblImgOriginal);
        ic.exibeImagemProcessada(ipProcessada, lblImgProcessada);
    }//GEN-LAST:event_btnAbrirMousePressed

    private void btnAnalisarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAnalisarMousePressed
        
        if (imgOriginal == null) JOptionPane.showMessageDialog(null, "Abra a imagem antes de fazer a análise."); 
        else {
                
        }

        // REALIZAR PROCESSOS PARA DESCOBRIR SE O COPO ESTA CHEIO
        // EXIBIR NA LABEL lblResultado SE O COPO ESTA CHEIO OU VAZIO
    }//GEN-LAST:event_btnAnalisarMousePressed

    private void btnSalvarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarMousePressed
        contador++;
        ij.IJ.save(imgProcessada, "Imagem_Processada"+contador+".png");
        JOptionPane.showMessageDialog(this, "Imagem Salva com Sucesso!");
        
    }//GEN-LAST:event_btnSalvarMousePressed

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
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnAnalisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblImgOriginal;
    private javax.swing.JLabel lblImgProcessada;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JScrollPane panelOriginal;
    private javax.swing.JScrollPane panelProcessada;
    // End of variables declaration//GEN-END:variables
}
