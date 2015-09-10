

package textmining;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;
import java.sql.*;
//@admin :rajat

public class load extends javax.swing.JFrame {
public static String fname;
String str;

    public load() {
        initComponents();
        jTextField1.setVisible(false);       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        loadBtn = new javax.swing.JButton();
        PreprocessBtn = new javax.swing.JButton();
        openBtn = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jComboBox1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(110, 10, 170, 30);

        loadBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        loadBtn.setText("Load");
        loadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadBtnActionPerformed(evt);
            }
        });
        jPanel1.add(loadBtn);
        loadBtn.setBounds(10, 10, 80, 30);

        PreprocessBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        PreprocessBtn.setText("Preprocessing");
        PreprocessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreprocessBtnActionPerformed(evt);
            }
        });
        jPanel1.add(PreprocessBtn);
        PreprocessBtn.setBounds(400, 10, 150, 30);

        openBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        openBtn.setText("Open");
        openBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openBtnActionPerformed(evt);
            }
        });
        jPanel1.add(openBtn);
        openBtn.setBounds(300, 10, 80, 30);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(520, 10, 30, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(60, 190, 560, 50);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(20, 20, 520, 260);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(60, 240, 560, 300);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgtxt/textitle.gif"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 760, 720);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadBtnActionPerformed
 jComboBox1.addItem("List of Data");
        for(int i=1;i<=4;i++){
            jComboBox1.addItem("datas"+i);
        }
 JOptionPane.showMessageDialog(this,"Successfully Loaded!");
    }//GEN-LAST:event_loadBtnActionPerformed

    private void openBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openBtnActionPerformed
try{

  fname=(String) jComboBox1.getSelectedItem();
  jTextField1.setText(fname);
  String s=jTextField1.getText();
  if(!s.equals("")){
           FileReader  fr=new FileReader("D:/effective ptrn/datasets/"+fname+".txt");
           BufferedReader br=new BufferedReader(fr);
           while((str=br.readLine())!=null)
           {
                jTextArea1.append("\n"+str);

           }
           br.close();
   }
 else{
      JOptionPane.showMessageDialog(this,"Must Choose One DataFile...");
 }
 }
 catch(Exception e){
     System.out.println(e.getMessage());
 }




    }//GEN-LAST:event_openBtnActionPerformed

    private void PreprocessBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreprocessBtnActionPerformed
    preprocess form=new preprocess();
        form.setVisible(true);
        this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_PreprocessBtnActionPerformed

     
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new load().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PreprocessBtn;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton loadBtn;
    private javax.swing.JButton openBtn;
    // End of variables declaration//GEN-END:variables

}
