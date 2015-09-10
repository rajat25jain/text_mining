

package textmining;
import java.sql.*;
import java.util.Random;
import javax.swing.JOptionPane;

public class ipe extends javax.swing.JFrame {

int val;
String[] tna=new String[50];
int[] sumt=new int[50];
String[] rwt=new String[50];
int i1=0,k=0;
int denominator,numerator;
 
    public ipe() {
        initComponents();
        try{
           Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/xxxxx","xxxx","xxxx");
        Statement st=con.createStatement();
        st.executeUpdate("TRUNCATE TABLE `offender`");
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
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
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
        jScrollPane1.setBounds(40, 100, 510, 210);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton2.setText("Threshold");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(20, 20, 100, 30);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton1.setText("Detect noise");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(140, 20, 130, 30);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton3.setText("Suffle");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(290, 20, 110, 30);

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton4.setText("IPEvolving");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(430, 20, 130, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 590, 70);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 200, 590, 340);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgtxt/textitle.gif"))); // NOI18N
        jLabel1.setText(" ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 690);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try{
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/txt mine","root","root");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("SELECT DISTINCT `tname`, `sumwt` FROM `totwet`");
        while(rs.next()){
            tna[i1]=rs.getString(1);
            sumt[i1]=rs.getInt(2);
            i1++;
              }
        jTextArea1.append("\n\n Noised Patterns:");
        for(int j=0;j<i1;j++){
            if(sumt[j]>=val){
                rwt[k]=tna[j];
                jTextArea1.append("\n\t"+rwt[k]);
                k++;
            }
            System.out.println("k=="+k);
        }
        
}
catch(Exception e){
    System.out.println(e.getMessage());
}
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

if(load.fname.equalsIgnoreCase("datas1")){
    jTextArea1.append("\t DP Threshold value :"+10);
    val=Integer.parseInt((jTextArea1.getText()).trim().substring(20, 22));
        System.out.println(val);
}
 if(load.fname.equalsIgnoreCase("datas2")){
    jTextArea1.append("\t DP Threshold value :"+7);
    val=Integer.parseInt((jTextArea1.getText()).trim().substring(20, 21));
        System.out.println(val);
}
if(load.fname.equalsIgnoreCase("datas3")){
    jTextArea1.append("\t DP Threshold value :"+11);
    val=Integer.parseInt((jTextArea1.getText()).trim().substring(20, 22));
        System.out.println(val);
}
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
jTextArea1.setText(""+"Termset\n\t\t");
int c=0;
String[] tn=new String[50];
int i1=0;
float v1 = 0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/txt mine","root","root");
            Statement st=con.createStatement();
             Statement st1=con.createStatement();
            //ResultSet rs=st.executeQuery("");
             ResultSet rs=st.executeQuery("SELECT DISTINCT `sumwt`,`tname` FROM `totwet`");
            while(rs.next()){
                c=c+rs.getInt(1);
                tn[i1]=rs.getString(2);
                i1++;
            }
             for(int i=0;i<i1;i++){
                 st1.executeUpdate("UPDATE `totwet` SET `nd`='"+c+"'"+" WHERE `tname`='"+tn[i]+"'");
             }
              
            System.out.println("SUM OF THE VALUE IS:"+c);
            for(int i=0;i<i1;i++){
                jTextArea1.append("("+tna[i]+","+sumt[i]+"/"+c+")\n\t\t");
                
            }
            jTextArea1.append("\n Offender\n\t\t");
            for(int i=0;i<k;i++){
            jTextArea1.append(rwt[i]);
            st.executeUpdate("INSERT INTO `txt mine`.`offender` (`nd`) VALUES ('"+rwt[i]+"')");
            }
            jTextArea1.append("\n\n Experimental Coefficient:"+2);
            ResultSet rs1=st.executeQuery("SELECT DISTINCT `nd`FROM `offender`");
            while(rs1.next()){
                ResultSet rs2=st1.executeQuery("SELECT DISTINCT `sumwt`,`nd` FROM `totwet` WHERE `tname`='"+rs1.getString(1)+"'");
                while(rs2.next()){
                   v1+=(float)rs2.getInt(1)/(float)rs2.getInt(2);    
                }
            }
           
           float res=val*v1;
           System.out.println("offering:"+res);
           double n = res;

  denominator = (int) (1 / (Math.abs(n - (int) n - 0.0001))); //- 0.0001 so the division doesn't get affected by the float point aproximated representation
int units = (int) n;

  numerator = units * denominator + 1;

System.out.println("" + numerator + "/" + denominator);
JOptionPane.showMessageDialog(this, "Suffle Process is done");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

try{
    int n = 0;
jTextArea1.setText("");
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/txt mine","root","root");
Statement st=con.createStatement();
Statement st1=con.createStatement();
ResultSet rs1=st.executeQuery("SELECT DISTINCT `nd`FROM `offender`");
while(rs1.next()){
    st1.executeUpdate("UPDATE `totwet` SET `sumwt`='"+numerator+"',`nd`='"+denominator+"' WHERE `tname`='"+rs1.getString(1)+"'");
}

jTextArea1.append("Results of Shuffling"+"\n\n\t\t");
ResultSet rs=st.executeQuery("SELECT COUNT(`nd`) FROM `offender`");
while(rs.next()){
    n=Integer.parseInt(rs.getString(1));
}
Random r=new Random();

int q=r.nextInt(n)+1;
ResultSet rs2=st.executeQuery("SELECT DISTINCT `tname`,`sumwt`,`nd` FROM `totwet`");
while(rs2.next()){
    jTextArea1.append("("+rs2.getString(1)+","+(rs2.getInt(2)+q)+"/"+(rs2.getInt(3)+q)+")"+"\n\t\t");
}
     

}
catch(Exception e){
    System.out.println(e.getMessage());
}
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ipe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
