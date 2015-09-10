

package textmining;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.*;
import javax.swing.JOptionPane;

public class preprocess extends javax.swing.JFrame {


char[] w = new char[501];
Stemmer s = new Stemmer();
String filename;
 File [] files;
    public preprocess() {
        initComponents();
        try{
            Class.forName("com.mysql.jdbc.Driver");
          Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/xxx","xxxx","xxxx");
          Statement stat=con.createStatement();
          stat.executeQuery("TRUNCATE TABLE datas");
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
        stopWordsBtn = new javax.swing.JButton();
        stemmingBtn = new javax.swing.JButton();
        insertBtn = new javax.swing.JButton();
        ptmBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        backBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 700));
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 2, 5, 5));

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(4, 1));

        stopWordsBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        stopWordsBtn.setText("StopWords");
        stopWordsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopWordsBtnActionPerformed(evt);
            }
        });
        jPanel2.add(stopWordsBtn);

        stemmingBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        stemmingBtn.setText("Stemming");
        stemmingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stemmingBtnActionPerformed(evt);
            }
        });
        jPanel2.add(stemmingBtn);

        insertBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        insertBtn.setText("Insert");
        insertBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertBtnActionPerformed(evt);
            }
        });
        jPanel2.add(insertBtn);

        ptmBtn.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ptmBtn.setText(" PTM");
        ptmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ptmBtnActionPerformed(evt);
            }
        });
        jPanel2.add(ptmBtn);

        jPanel1.add(jPanel2);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 110, 610, 280);

        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        getContentPane().add(backBtn);
        backBtn.setBounds(310, 460, 150, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bgtxt/text1.gif"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 830, 700);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void stopWordsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopWordsBtnActionPerformed
try{
    String str,clean;
    FileWriter fw = new FileWriter("D:/effective ptrn/datasets/new.txt");
               BufferedWriter bwf=new BufferedWriter(fw);
    FileReader  fr=new FileReader("D:/effective ptrn/datasets/"+load.fname+".txt");
           BufferedReader br=new BufferedReader(fr);
           while((str=br.readLine())!=null)
           {
            Pattern stopWords = Pattern.compile("\\b(?:i|a|and|about|an|are|the|at|for|it|to|is|in|of|which|on|will|was|what|when|where|from|this|that|there|with|have|most|into|could|should|us|among|be|...)\\b\\s*", Pattern.CASE_INSENSITIVE);
            Matcher matcher = stopWords.matcher(str);
              clean = matcher.replaceAll(" ");
               jTextArea1.append("\n"+clean+"\n\t");
               bwf.write(clean);
               bwf.newLine();
           }
        bwf.close();
 br.close();

 
}
catch(Exception e){
    System.out.println(e.getMessage());
}
        // TODO add your handling code here:
    }//GEN-LAST:event_stopWordsBtnActionPerformed

    private void stemmingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stemmingBtnActionPerformed
   jTextArea1.setText("");
          char[] w = new char[501];
      Stemmer s = new Stemmer();

      try
      {
           FileWriter fw = null;
            try {
                fw = new FileWriter("D:/effective ptrn/datasets/new1.txt");
            } catch (IOException ex) {
                Logger.getLogger(preprocess.class.getName()).log(Level.SEVERE, null, ex);
            }
         BufferedWriter bw=new BufferedWriter(fw);
         FileReader br=new FileReader("D:/effective ptrn/datasets/new.txt");
         BufferedReader in=new BufferedReader(br);
         try
         { while(true)

           {  int ch = in.read();
              if (Character.isLetter((char) ch))
              {
                 int j = 0;
                 while(true)
                 {  ch = Character.toLowerCase((char) ch);
                    w[j] = (char) ch;
                    if (j < 500) j++;
                    ch = in.read();
                    if (!Character.isLetter((char) ch))
                    {
                       for (int c = 0; c < j; c++) s.add(w[c]);
                       s.stem();
                       {
                           String u;
                          u = s.toString();
                          System.out.print(u);
                          bw.write(u);
                         bw.newLine();
                         jTextArea1.append(u+"\n");
                       }
                       break;           
                    }
       
                 }
              }
              if (ch < 0) break;
              System.out.print((char)ch);
           }

           in.close();
           bw.close();
             
         }
         catch (IOException e)
         {  System.out.println("error reading ");
         }
      }
      catch (FileNotFoundException e)
      {  System.out.println("file not found");

      }


    }//GEN-LAST:event_stemmingBtnActionPerformed

    private void insertBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertBtnActionPerformed
try{
     Class.forName("com.mysql.jdbc.Driver");
  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/txt mine","root","root");
  Statement st=con.createStatement();
    String s = null;
  FileReader br=new FileReader("D:/effective ptrn/datasets/new1.txt");
         BufferedReader in=new BufferedReader(br);
         while((s=in.readLine())!=null){
             st.executeUpdate("INSERT INTO `txt mine`.`datas` (`data`) VALUES ('"+s+"')");
         }
         JOptionPane.showMessageDialog(this,"SUCCESSFULLY INSERTED!!!");
}
catch(Exception e){
    System.out.println(e.getMessage());
}

        // TODO add your handling code here:
    }//GEN-LAST:event_insertBtnActionPerformed

    private void ptmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ptmBtnActionPerformed
 ptm form=new ptm();
 form.setVisible(true);
 this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_ptmBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed

        new load().setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_backBtnActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new preprocess().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton insertBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton ptmBtn;
    private javax.swing.JButton stemmingBtn;
    private javax.swing.JButton stopWordsBtn;
    // End of variables declaration//GEN-END:variables

}
