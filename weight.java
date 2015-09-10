
package textmining;
import java.sql.*;
import java.util.StringTokenizer;

public class wt extends javax.swing.JFrame {

 
    public wt() {
        initComponents();
         try{
            Class.forName("com.mysql.jdbc.Driver");
            connection con =DriverManager//noe localhost and password according to ur own database sql specific;
            Statement st=con.createStatement();
            st.executeQuery("TRUNCATE TABLE `d-pat`");
            st.executeQuery("TRUNCATE TABLE `totwet`");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 90, 550, 230);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton1.setText("Weight");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(120, 20, 100, 30);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton2.setText("Term support");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(250, 20, 120, 30);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton3.setText("IPE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(410, 20, 73, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 610, 70);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(40, 200, 610, 340);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgtxt/textitle.gif"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

         try{
             System.out.println(dpatrn.i1);
    StringTokenizer tok;
    jTextArea1.setText("");
     String[] val=new String[50];
     int k=0;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/txt mine","root","root");
        Statement st=con.createStatement();
        Statement st1=con.createStatement();
        for(int j=0;j<dpatrn.i1;j++){
            System.out.println(dpatrn.pa[j]);
            ResultSet rs=st.executeQuery("SELECT COUNT(`csets`) FROM `rest` WHERE `term`='"+dpatrn.pa[j]+"'");
            while(rs.next()){
                val[k]=rs.getString(1);
                jTextArea1.append("\t\t"+dpatrn.pa[j]+"  ---  "+val[k]+"\n");
                st1.executeUpdate("INSERT INTO `txt mine`.`d-pat` (`term`, `no`) VALUES ('"+dpatrn.pa[j]+"','"+val[k]+"')");
                k++;
            }
        }
        ResultSet rs1=st.executeQuery("SELECT * FROM `d-pat`");
        while(rs1.next()){
            String str=rs1.getString(1);
            String str1=rs1.getString(2);
             tok=new StringTokenizer(str,",");
              int k1=0;
              while(tok.hasMoreTokens())
              {
                  String s=tok.nextToken();
                  st1.executeUpdate("INSERT INTO `txt mine`.`totwet` (`tname`, `tval`) VALUES ('"+s+"','"+str1+"')");
             }
        }

}
catch(Exception e){
    System.out.println(e.getMessage());
}
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
try{
    jTextArea1.setText("");
 Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/txt mine","root","root");
        Statement st=con.createStatement();
         Statement st1=con.createStatement();
         Statement st2=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT DISTINCT `tname` FROM `totwet`");
        while(rs.next()){
              jTextArea1.append("\t\t(");
            ResultSet rs1=st1.executeQuery("SELECT SUM(`tval`) FROM `totwet` WHERE `tname`='"+rs.getString(1)+"'");
            while(rs1.next()){
                jTextArea1.append(rs.getString(1)+","+rs1.getInt(1)+")"+"\n\n");
                 st2.executeUpdate("UPDATE `totwet` SET `sumwt`='"+rs1.getInt(1)+"'"+" WHERE `tname`='"+rs.getString(1)+"'");
                
            }
        }

}
catch(Exception e){
    System.out.println(e.getMessage());
}        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
ipe form=new ipe();
form.setVisible(true);
// TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new wt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
