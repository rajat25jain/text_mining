

package textmining;
import java.sql.*;
import javax.swing.JOptionPane;
public class ptm extends javax.swing.JFrame {

int[] sno=new int[50];
int i=0,i1=1,k=0;
String[] p=new String[50];
String[] pw={"this space consist of some test words that u want to search in a meaningful way")}
    public ptm() {
        initComponents();
          try{
            Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/txt mine","root","root");
          Statement stat=con.createStatement();
          stat.executeQuery("TRUNCATE TABLE para");
         stat.executeQuery("TRUNCATE TABLE term");
          }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Back = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 2, 10, 10));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(4, 1, 5, 5));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Paragraph");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Terms");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton3.setText("PTM");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton4.setText("PDM");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        jPanel1.add(jPanel2);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(80, 60, 540, 370);

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back);
        Back.setBounds(190, 460, 120, 30);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        getContentPane().add(Exit);
        Exit.setBounds(390, 460, 120, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgtxt/text1.gif"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 750, 700);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try{
Class.forName("com.mysql.jdbc.Driver");
  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/txt mine","root","root");
  Statement st=con.createStatement();
   Statement st1=con.createStatement();
    Statement st2=con.createStatement();
  ResultSet rs=st.executeQuery("SELECT * FROM `datas` WHERE `data` like '%mm'");
  while(rs.next()){
      sno[i]=rs.getInt(1);
      i++;
  }
 for(int j=1;j<=i;j++){
     if(j==1){
         ResultSet rs1=st.executeQuery("SELECT * FROM `datas` WHERE `sno` BETWEEN 1 AND  "+sno[j]+"");
         jTextArea1.append("dp"+i1+"\n"+"---------------------------------------------------------------------------------------------------------------------------------------------------------"+"\n");
         while(rs1.next()){
         st1.executeUpdate("INSERT INTO `txt mine`.`para` (`category`, `pword`) VALUES ('"+"dp"+i1+"','"+rs1.getString(2)+"')");
         jTextArea1.append("\t"+rs1.getString(2)+"\n");
         }
     }
 else{
       ResultSet rs2=st.executeQuery("SELECT * FROM `datas` WHERE `sno` BETWEEN "+sno[j-1]+"+1 AND  "+sno[j]+"");
       i1++;
        jTextArea1.append("dp"+i1+"\n"+"----------------------------------------------------------------------------------------------------------------------------------------------------------"+"\n");
       while(rs2.next()){           
         st2.executeUpdate("INSERT INTO `txt mine`.`para` (`category`, `pword`) VALUES ('"+"dp"+i1+"','"+rs2.getString(2)+"')");
         jTextArea1.append("\t"+rs2.getString(2)+"\n");
         }
 }

    }
  JOptionPane.showMessageDialog(this,"CALCULATION IS DONE");
}
catch(Exception e){
    System.out.println(e.getMessage());
}
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
try{
    jTextArea1.setText(" "+"\t");
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/txt mine","root","root");
    Statement st=con.createStatement();
    Statement st1=con.createStatement();
    for(int i=1;i<=18;i++){
        ResultSet rs=st.executeQuery("SELECT DISTINCT `category` FROM `para` WHERE `pword`='"+pw[i]+"'");
        while(rs.next()){
            jTextArea1.append("\t"+rs.getString(1)+"\t"+"t"+i+"--"+pw[i]+"\n\t");
            st1.executeUpdate("INSERT INTO `txt mine`.`term` (`paragraphs`, `terms`) VALUES ('"+rs.getString(1)+"','"+"t"+i+"')");
        }
    }
}
catch(Exception e){
    System.out.println(e.getMessage());
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try{
            jTextArea1.setText(" "+"\t");
            //jTextArea1.append("Paragraph "+"\t"+"Terms");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/txt mine","root","root");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("SELECT DISTINCT `paragraphs` FROM `term`");
            while(rs.next()){
                p[k]=rs.getString(1);
                k++;
            }
            for(int j=0;j<k;j++){
                jTextArea1.append("\n"+p[j]+"\n\t");
                ResultSet rs1=st.executeQuery("SELECT `terms` FROM `term` WHERE `paragraphs`='"+p[j]+"'");
                while(rs1.next()){
                     jTextArea1.append("----"+rs1.getString(1)+"\n\t");
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
//dpatrn form=new dpatrn();
//form.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed

        new preprocess().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        
        JOptionPane.showMessageDialog(this,"Thankyou for using!!");
        this.dispose();
    }//GEN-LAST:event_ExitActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ptm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JButton Exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
