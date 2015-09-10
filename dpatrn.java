

package textmining;
import java.sql.*;

public class dpatrn extends javax.swing.JFrame {
String[] te=new String[50];
int i=0;
public static String[] pa=new String[50];
public static int i1=0;
    public dpatrn() {
        initComponents();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //connection manager used accordign to ur database sql specific with localhost and root password 
            Statement st=con.createStatement();
            st.executeQuery("TRUNCATE TABLE `fpatt`");
            st.executeQuery("TRUNCATE TABLE `rest`");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(null);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton1.setText("Composed");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(120, 20, 100, 30);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton2.setText("Result");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(250, 20, 80, 30);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton3.setText("d-pattern");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(360, 20, 90, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 550, 70);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 90, 490, 240);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(70, 190, 550, 360);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgtxt/textitle.gif"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 700);

        jLabel2.setFont(new java.awt.Font("Old English Text MT", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Effective Pattern Discovery ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 260, 640, 60);

        jLabel3.setFont(new java.awt.Font("Old English Text MT", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("for Text Mining");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(170, 310, 410, 70);

        jLabel4.setText("Effective Pattern Discovery for Text Mining");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(400, 50, 207, 14);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try{

Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/txt mine","root","root");
Statement st=con.createStatement();
Statement st1 = con.createStatement();
 Statement st2 = con.createStatement();
 Statement st3 = con.createStatement();
 Statement st4 = con.createStatement();
ResultSet rs=st.executeQuery("SELECT DISTINCT `terms` FROM `term` ");
while(rs.next()){
    te[i]=rs.getString(1);
    i++;
}
System.out.println("i=="+i);

for(int j=0;j<i;j++){
    //one--one
if(j==0){
    while(j!=i-1){
        System.out.println("j=="+j);
    jTextArea1.append("\t\t"+te[0]+","+te[j+1]+" --  {");
ResultSet rs1=st.executeQuery("SELECT `paragraphs` FROM `term` WHERE `terms`IN('"+te[0]+"','"+te[j+1]+"') GROUP BY `paragraphs` HAVING COUNT(*)=2");
while(rs1.next()){
    jTextArea1.append(rs1.getString(1)+",");
    st1.executeUpdate("INSERT INTO `txt mine`.`fpatt` (`fpattern`, `cset`) VALUES ('"+te[0]+","+te[j+1]+"','"+rs1.getString(1)+"')");
}
 jTextArea1.append("}"+"\n");
 j++;
}
   j=1;
    }
//two--one
 System.out.println("j1=="+j);
    if(j==1)
    {
        
    jTextArea1.append("\n\n");
while(j!=i-1){

    jTextArea1.append("\t\t"+te[0]+","+te[1]+","+te[j+1]+" --  {");
ResultSet rs2=st.executeQuery("SELECT `paragraphs` FROM `term` WHERE `terms`IN('"+te[0]+"','"+te[1]+"','"+te[j+1]+"') GROUP BY `paragraphs` HAVING COUNT(*)=3");
while(rs2.next()){
    jTextArea1.append(rs2.getString(1)+",");
    st2.executeUpdate("INSERT INTO `txt mine`.`fpatt` (`fpattern`, `cset`) VALUES ('"+te[0]+","+te[1]+","+te[j+1]+"','"+rs2.getString(1)+"')");
}
 jTextArea1.append("}"+"\n");
 j++;
}
    j=2;
}

 //three--one
  System.out.println("j2=="+j);
    if(j==2)
    {

    jTextArea1.append("\n\n");
while(j!=i-1){
         
    jTextArea1.append("\t\t"+te[0]+","+te[1]+","+te[2]+","+te[j+1]+" --  {");
ResultSet rs3=st.executeQuery("SELECT `paragraphs` FROM `term` WHERE `terms`IN('"+te[0]+"','"+te[1]+"','"+te[2]+"','"+te[j+1]+"') GROUP BY `paragraphs` HAVING COUNT(*)=4");
while(rs3.next()){
    jTextArea1.append(rs3.getString(1)+",");
    st3.executeUpdate("INSERT INTO `txt mine`.`fpatt` (`fpattern`, `cset`) VALUES ('"+te[0]+","+te[1]+","+te[2]+","+te[j+1]+"','"+rs3.getString(1)+"')");
}
 jTextArea1.append("}"+"\n");
 j++;
}
    j=3;
}
  //four--one
  System.out.println("j3=="+j);
    if(j==3)
    {

    jTextArea1.append("\n\n");
while(j!=i-1){

    jTextArea1.append("\t\t"+te[0]+","+te[1]+","+te[2]+","+te[3]+","+te[j+1]+" --  {");
ResultSet rs4=st.executeQuery("SELECT `paragraphs` FROM `term` WHERE `terms`IN('"+te[0]+"','"+te[1]+"','"+te[2]+"','"+te[3]+"','"+te[j+1]+"') GROUP BY `paragraphs` HAVING COUNT(*)=5");
while(rs4.next()){
    jTextArea1.append(rs4.getString(1)+",");
    st4.executeUpdate("INSERT INTO `txt mine`.`fpatt` (`fpattern`, `cset`) VALUES ('"+te[0]+","+te[1]+","+te[2]+","+te[3]+","+te[j+1]+"','"+rs4.getString(1)+"')");
}
 jTextArea1.append("}"+"\n");
 j++;
}
}
}

}
catch(Exception e){
    System.out.println(e.getMessage());
}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
jTextArea1.setText("");

        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/txt mine","root","root");
        Statement st=con.createStatement();
        Statement st1=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT DISTINCT `fpattern` FROM `fpatt`");
        while(rs.next()){
            pa[i1]=rs.getString(1);
            i1++;
        }
        for(int j=0;j<i1;j++){
            jTextArea1.append("\t\t"+pa[j]+"  ---  "+"{");
            ResultSet rs1=st.executeQuery("SELECT `cset` FROM `fpatt` WHERE `fpattern`='"+pa[j]+"'");
            while(rs1.next()){
            jTextArea1.append(rs1.getString(1)+",");
            st1.executeUpdate("INSERT INTO `txt mine`.`rest` (`term`, `csets`) VALUES ('"+pa[j]+"','"+rs1.getString(1)+"')");
            }
            jTextArea1.append("}"+"\n");
        }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
wt form=new wt();
form.setVisible(true);
       
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

     
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dpatrn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

}
