package rs2321;

/*
 * rs2321.java
 *
 * 
 */

import java.io.*;
import java.util.*;
import javax.swing.Timer;

/**
 *
 * @author  Administrador
 */
public class rs2321 extends javax.swing.JFrame {
     private ArrayList listeners;
     WriterPort  emisor;
     ReaderPort  reader;
     String a ="";
     String dato;
     Timer reloj;        // Creacion del temporizador
     int eje = 0;
     
     
    /** Creates new form rs2321 */
    public rs2321() {
        initComponents();
        this.emisor= WriterPort.getInstance();
        
        this.reader = ReaderPort.getInstance();
        this.reader.addActionListener(new java.awt.event.ActionListener()  
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ActionEventPort actionEventPort = (ActionEventPort)evt;
                portReadData(actionEventPort);              
            }
        }
        );
        
               
        
    }
 
      public void portReadData(ActionEventPort actionEventPort){
       
        a+=actionEventPort.getReaded();
        
        int flag1=0,flagf=0,flagO=0,flagk=0;
        int l= a.length();
        for (int i=0; i<l; i++){
        char q = a.charAt(i);
          if (q == '@') {flag1=1;}
          if (q == '#') {flagf=1;}
          if (q == '$') {flagO=1;}
          if (q == '%') {flagk=1;}
          
          if ((recibirautomatico.isSelected()&&(flag1 == 1)&& (flagf == 1))){
            String datocaja2=caja2.getText();
            
       try {
        this.emisor.escribir("@"+datocaja2+"$%"+"#");
            a="";
        }
        catch(IOException iOException){}
         }
          if ((flag1 == 1)&& (flagf == 1)){
               dato = a.substring(1,l-1);
                  a="";
               caja2.setText(dato);
                  a="";
                  flag1 = 0;
                  flagf = 0;
          }
           if ((flagO == 1) && (flagk == 1)){
           dato = a.substring(1,l-3);
                  a="";
               caja2.setText(dato);
                  a="";
               caja1.setText("Ok");
                 flagO = 0;
                 flagf = 0;
            }
          }            
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Enviar = new javax.swing.JButton();
        caja1 = new javax.swing.JTextField();
        Borrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        caja2 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        texto = new javax.swing.JLabel();
        barra = new javax.swing.JScrollBar();
        enviarautomatico = new javax.swing.JRadioButton();
        enviarmanual = new javax.swing.JRadioButton();
        ACK = new javax.swing.JButton();
        recibirautomatico = new javax.swing.JRadioButton();
        recibirmanual = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Plantilla Comunicación RS-232");
        setBackground(new java.awt.Color(102, 102, 255));
        getContentPane().setLayout(null);

        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });
        getContentPane().add(Enviar);
        Enviar.setBounds(20, 40, 80, 30);
        getContentPane().add(caja1);
        caja1.setBounds(120, 40, 270, 70);

        Borrar.setText("Borrar");
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });
        getContentPane().add(Borrar);
        Borrar.setBounds(20, 210, 80, 30);

        caja2.setColumns(20);
        caja2.setRows(5);
        jScrollPane1.setViewportView(caja2);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(120, 220, 270, 100);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(10, 170, 390, 30);

        jLabel1.setFont(new java.awt.Font("Algerian", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Transmisión de Datos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 0, 330, 40);

        jLabel2.setFont(new java.awt.Font("Vivaldi", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Recepción de Datos");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(110, 180, 210, 30);
        getContentPane().add(texto);
        texto.setBounds(10, 140, 380, 20);

        barra.setOrientation(javax.swing.JScrollBar.HORIZONTAL);
        barra.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                barraAdjustmentValueChanged(evt);
            }
        });
        getContentPane().add(barra);
        barra.setBounds(120, 120, 270, 17);

        enviarautomatico.setText("automatico");
        enviarautomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarautomaticoActionPerformed(evt);
            }
        });
        getContentPane().add(enviarautomatico);
        enviarautomatico.setBounds(0, 70, 120, 23);

        enviarmanual.setText("manual");
        enviarmanual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarmanualActionPerformed(evt);
            }
        });
        getContentPane().add(enviarmanual);
        enviarmanual.setBounds(0, 90, 120, 23);

        ACK.setText("Ok");
        ACK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACKActionPerformed(evt);
            }
        });
        getContentPane().add(ACK);
        ACK.setBounds(20, 250, 80, 30);

        recibirautomatico.setText("automatico");
        recibirautomatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recibirautomaticoActionPerformed(evt);
            }
        });
        getContentPane().add(recibirautomatico);
        recibirautomatico.setBounds(0, 290, 120, 23);

        recibirmanual.setText("manual");
        recibirmanual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recibirmanualActionPerformed(evt);
            }
        });
        getContentPane().add(recibirmanual);
        recibirmanual.setBounds(0, 310, 120, 23);

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-417)/2, (screenSize.height-383)/2, 417, 383);
    }// </editor-fold>//GEN-END:initComponents

    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed

        a="";
        caja2.setText("");

}//GEN-LAST:event_BorrarActionPerformed

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
    
    String datos = "";
    
    try {
        
    datos = caja1.getText();
    this.emisor.escribir("@"+datos+"#");
    caja1.setText("");
      }
    catch(IOException iOException){
    }
}//GEN-LAST:event_EnviarActionPerformed

private void enviarautomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarautomaticoActionPerformed
   int valorbarra= barra.getValue();
   if (enviarautomatico.isSelected()){
       enviarmanual.setSelected(false);
       Enviar.setEnabled(false);
     texto.setText("primero debe dar un valor con el scrollbar");  
   }
   
    if ((enviarautomatico.isSelected())&& (valorbarra>0) ){
        enviarmanual.setSelected(false);
        Enviar.setEnabled(false);
        texto.setText("los datos se enviaran automaticamente cada "+valorbarra+" segundos");  
        this.reloj.start();
         }
    
}//GEN-LAST:event_enviarautomaticoActionPerformed

private void enviarmanualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarmanualActionPerformed

    if (enviarmanual.isSelected()){
        enviarautomatico.setSelected(false);
         Enviar.setEnabled(true);
         texto.setText("");
         int valorbarra= barra.getValue();
         valorbarra=0;
         this.reloj.stop();
    }
    
}//GEN-LAST:event_enviarmanualActionPerformed

private void barraAdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_barraAdjustmentValueChanged
int  valorbarra,tiempo;
         valorbarra= barra.getValue();
         tiempo=valorbarra*1000;
         reloj= new Timer (tiempo,new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EVENTO_RELOJ(evt);
                }
        });
        
        
}//GEN-LAST:event_barraAdjustmentValueChanged
public void EVENTO_RELOJ(java.awt.event.ActionEvent evt){
   
          String datos = "";
    
    try {
        
    datos = caja1.getText();
    this.emisor.escribir("@"+datos+"#");
    caja1.setText("");
      }
    catch(IOException iOException){
    }
       
}
    
private void recibirautomaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recibirautomaticoActionPerformed

    if (recibirautomatico.isSelected()){
        recibirmanual.setSelected(false);
         
          ACK.setEnabled(false);
    }
}//GEN-LAST:event_recibirautomaticoActionPerformed

private void recibirmanualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recibirmanualActionPerformed

     if (recibirmanual.isSelected()){
        recibirautomatico.setSelected(false);
         ACK.setEnabled(true);
    }
    
}//GEN-LAST:event_recibirmanualActionPerformed

private void ACKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACKActionPerformed
       String datoscaja2=caja2.getText();
       try {
        this.emisor.escribir("@"+datoscaja2+"$%"+"#");
            a="";
            datoscaja2="";
        }
        catch(IOException iOException){}
     
}//GEN-LAST:event_ACKActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rs2321().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ACK;
    private javax.swing.JButton Borrar;
    private javax.swing.JButton Enviar;
    private javax.swing.JScrollBar barra;
    private javax.swing.JTextField caja1;
    private javax.swing.JTextArea caja2;
    private javax.swing.JRadioButton enviarautomatico;
    private javax.swing.JRadioButton enviarmanual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton recibirautomatico;
    private javax.swing.JRadioButton recibirmanual;
    private javax.swing.JLabel texto;
    // End of variables declaration//GEN-END:variables
    
}
