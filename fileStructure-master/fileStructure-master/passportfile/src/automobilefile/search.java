/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automobilefile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class search extends javax.swing.JFrame {
int no;
    /**
     * Creates new form search
     */
    public search() {
        initComponents();
        no=0;
         Scanner reader;
        String buffer;
        try {
            reader = new Scanner (new File("r.txt"));
            reader.useDelimiter(",");
            while(reader.hasNext())
            {
                buffer=reader.next();
                if(buffer.equals("#"))
                    no++;
            }
            System.out.println("No: "+no);
            
        } catch (Exception ex) {
            System.out.println(ex);
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

        txtNames = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNames.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        getContentPane().add(txtNames, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, 177, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setText("Enter Name to search:");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 230, -1));

        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 190, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product_id", "Product_name", "category_name", "product_quantity", "Product_price", "Date of adding", "Date of birth"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 1070, 180));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automobilefile/Screenshot (210).png"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -30, 1780, 820));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 record re[]=new record[50];  
 for(int i=0;i<no;i++)
           re[i]=new record();
 Scanner reader2;
 String s_name=txtNames.getText().trim();

 int s_ind[]=new int[20];int lo=0,po=0,tempo;
 int s_ordno[]=new int[20]; 
 
 
  //System.out.println(s_name.length());
 int imp=0;
       try{
           reader2=new Scanner(new File("s.txt"));
           reader2.useDelimiter(",");
          
           for(int i=0;i<no;i++)
           {
               re[i].product_name=reader2.next().trim();
               re[i].product_id=reader2.next().trim();
               //System.out.println(re[i].name+" "+re[i].name.length());
               if(re[i].product_name.equals(s_name)){
                   
                   s_ordno[lo]=Integer.parseInt(re[i].product_id);
                   lo++;
               }
           }
       }
       
       catch(Exception e){
          System.out.println("exception1   "+e);
           
       }
       for(int i=0;i<=lo;i++)
            System.out.println("s_ordno   "+s_ordno[i]);
       for(int i=0;i<lo;i++)
            {
                for(int k=0;k<lo-1-i;k++)
                {
                    if(s_ordno[k]>s_ordno[k+1])
                    {
                        tempo=s_ordno[k];
                        s_ordno[k]=s_ordno[k+1];
                        s_ordno[k+1]=tempo;
                    }
                }
            }
       System.out.println("sorted");
       for(int i=0;i<lo;i++)
            System.out.println("s_ordno   "+s_ordno[i]);
           
       if(s_ordno[0]==0){
          JOptionPane.showMessageDialog(rootPane,"record not found");
          txtNames.setText("");
       }
       
       
        Scanner reader3;
 
       try{
           reader3=new Scanner(new File("i.txt"));
           reader3.useDelimiter(",");
           lo=0;
          // for(int i=0;i<no;i++)
               for(int j=0;j<no;j++)
           {
               
               
               
               
               
               
               
               
               
               
               
               re[j].product_id=reader3.next().trim();
               re[j].ind=reader3.next().trim();
               
                //System.out.println("dusra "+re[j].ordno.length()+" "+o+" "+s_ordno);
               if(Integer.parseInt(re[j].product_id)==s_ordno[lo]){
                   s_ind[po]=Integer.parseInt(re[j].ind);
                   lo++;po++;
               }
           }
       }
       catch(Exception e){
           System.out.println("exception2    "+e);
       }
        for(int i=0;i<=po;i++)
            System.out.println("s_ind=   "+s_ind[i]);
        
         for(int i=0;i<po;i++)
            {
                for(int k=0;k<po-1-i;k++)
                {
                    if(s_ind[k]>s_ind[k+1])
                    {
                        tempo=s_ind[k];
                        s_ind[k]=s_ind[k+1];
                        s_ind[k+1]=tempo;
                    }
                }
            }
       System.out.println("sorted");
       for(int i=0;i<po;i++)
            System.out.println("s_ind   "+s_ind[i]);
        
        
        
        
        
        
        
        
        
        
                    Scanner reader4;
 po=0;
       try{
           reader4=new Scanner(new File("r.txt"));
           reader4.useDelimiter(",");
           for(int k=0;k<no;k++)
           {
               re[k].ind=reader4.next().trim();
               re[k].product_id=reader4.next().trim();
               re[k].product_name=reader4.next().trim();
               re[k].category_name=reader4.next().trim();
               re[k].product_quantity=reader4.next().trim();
               re[k].product_Price=reader4.next().trim();
               re[k].dob=reader4.next().trim();
               re[k].doa=reader4.next().trim();
               re[k].hash=reader4.next().trim();
               int pin=Integer.parseInt(re[k].ind);
               //System.out.println("teesra "+re[k].ind.length()+" "+pin+" "+s_ind);
               if(pin==s_ind[po]){
                   imp=pin;
                   po++;
                   System.out.println(re[imp].product_name+" "+re[imp].product_id+" "+re[imp].category_name+" "+re[imp].product_Price+" "+re[imp].product_quantity+" "+re[imp].dob+" "+re[imp].doa+" ");
                    DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
              model.addRow(new Object[]{re[imp].product_id,re[imp].product_name,re[imp].category_name,re[imp].product_quantity,re[imp].product_Price,re[imp].doa,re[imp].dob});
               
               
               
               
               }
              
           }
       }
       
       catch(Exception e){
           System.out.println("exception3   "+e);
       }
       
       //System.out.println(re[imp].name+" "+re[imp].ordno+" "+re[imp].gender+" "+re[imp].place+" "+re[imp].fathername+" "+re[imp].dob+" "+re[imp].doi+" ");
      
       
       
 







// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(search.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new search().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtNames;
    // End of variables declaration//GEN-END:variables
}