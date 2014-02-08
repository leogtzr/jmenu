package jmenu;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 * @author Leo Gutierrez R. <leogutierrezramirez@gmail.com>
 */
public class JMenuForm extends javax.swing.JFrame {

    private static List<String> listInput = null;
    private static String title = "";
    
    static {
        listInput = new ArrayList<>();
        title = "";
    }

    public JMenuForm() {
        initComponents();
        fillListSearch();
        lblCount.setText("");
    }

    private void fillListSearch() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String s : listInput) {
            listModel.addElement(s);
        }
        this.listOcurrences.setModel(listModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOcurrences = new javax.swing.JList();
        lblCount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setDisplayedMnemonic('S');
        jLabel1.setLabelFor(txtSearch);
        jLabel1.setText("Search");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        listOcurrences.setBackground(new java.awt.Color(114, 104, 104));
        listOcurrences.setFont(new java.awt.Font("Courier New", 0, 13)); // NOI18N
        listOcurrences.setForeground(new java.awt.Color(88, 173, 77));
        listOcurrences.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                listOcurrencesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(listOcurrences);

        lblCount.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        lblCount.setText("234");
        lblCount.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCount, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        
        if(evt == null) {
            return;
        }
        
        switch(evt.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
                
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                listOcurrences.requestFocus();
                break;
                
            default:
                String text = txtSearch.getText();
                List<String> listTxtSearchFound = new ArrayList<>();
                // Find matches:
                for(String s : listInput) {
                    if(s.toLowerCase().contains(text.toLowerCase())) {
                        listTxtSearchFound.add(s);
                    }   
                }
                lblCount.setText(listTxtSearchFound.size() + "");
            
                ((DefaultListModel)listOcurrences.getModel()).clear();

                DefaultListModel<String> listModel = (DefaultListModel)listOcurrences.getModel();
                for(String s : listTxtSearchFound) {
                    listModel.addElement(s);
                }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void listOcurrencesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listOcurrencesKeyReleased
        
        switch(evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                System.out.print(listOcurrences.getSelectedValue().toString());
                System.exit(0);
                
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_UP:
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_LEFT:
                    break;
                
            case KeyEvent.VK_BACK_SPACE:
                txtSearch.requestFocus();
                String text = txtSearch.getText();
                if(text.length() > 0) {
                    txtSearch.setText(txtSearch.getText().substring(0, txtSearch.getText().length() - 1));
                }
                break;
                
            default:
                txtSearch.setText(txtSearch.getText() + evt.getKeyChar());
                txtSearchKeyReleased(evt);
                txtSearch.requestFocus();
        }
    }//GEN-LAST:event_listOcurrencesKeyReleased

    public static void main(String args[]) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JMenuForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        title = (args != null && args.length > 0) ? args[0] : "";
        
        try {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                String line;
                while ((line = br.readLine()) != null) {
                    listInput.add(line);
                }
            }
        } catch (IOException ex) {
            System.err.println("Error trying to read stdin.");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JMenuForm form = new JMenuForm();
                form.setTitle(title);
                form.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCount;
    private javax.swing.JList listOcurrences;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
