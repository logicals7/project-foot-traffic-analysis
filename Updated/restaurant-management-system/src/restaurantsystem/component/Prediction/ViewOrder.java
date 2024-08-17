
package restaurantsystem.component.Prediction;

import java.awt.event.ActionEvent;
import java.util.*;
import restaurantsystem.service.OrderService;

 class ViewOrder extends javax.swing.JFrame {

    private final OrderService orderService;

    public ViewOrder() {
        initComponents();
        this.orderService = new OrderService();
        performFileRelatedTask();
    }

    public void performFileRelatedTask() {
    	
    	ArrayList<Double> itemN=new ArrayList<Double>();
    	ArrayList<String> itemQ=new ArrayList<String>();
       
    	orderService.getAll().forEach((item) -> {
     	    
            itemN.add(item.getPrice());
            itemQ.add(item.getDate());
                        
            
        });
        

       String maxFreq="";
       int max=0;
       String date_="";

       
        for(int i=0;i<itemQ.size();i++)
        {
        	maxFreq=itemQ.get(i);
        	int freq = Collections.frequency(itemQ, maxFreq);
        	if(freq>max) {
        		max=freq;
        		date_=maxFreq;
        	}
        	
        }
        String date1="";
        Double item1=0.0;
        double maxi=0.0;
        
        for(int i=0;i<itemN.size();i++)
        {
        	item1=itemN.get(i);
        	if(item1>maxi) {
        		maxi=item1;
        		date1=itemQ.get(i);
        	}
        	
        }
       
       int month=Integer.parseInt(date_.substring(3,5));
       String monthName="";
       switch(month){
       case 1:
           monthName = "January";
           break;
       case 2:
           monthName = "February";
           break;
       case 3:
           monthName = "March";
           break;
       case 4:
           monthName = "April";
           break;
       case 5:
           monthName = "May";
           break;
       case 6:
           monthName = "June";
           break;
       case 7:
           monthName = "July";
           break;
       case 8:
           monthName = "August";
           break;
       case 9:
           monthName = "September";
           break;
       case 10:
           monthName = "October";
           break;
       case 11:
           monthName = "November";
           break;
       case 12:
           monthName = "December";
           break;
       default:
           monthName = "Invalid month";
           break;
   }
       int mon=Integer.parseInt(date1.substring(3,5));
      
       String monthN="";
       switch(month){
       case 1:
           monthN = "January";
           break;
       case 2:
           monthN = "February";
           break;
       case 3:
           monthN = "March";
           break;
       case 4:
           monthN = "April";
           break;
       case 5:
           monthN = "May";
           break;
       case 6:
           monthN = "June";
           break;
       case 7:
           monthN = "July";
           break;
       case 8:
           monthN = "August";
           break;
       case 9:
           monthN = "September";
           break;
       case 10:
           monthN = "October";
           break;
       case 11:
           monthN = "November";
           break;
       case 12:
           monthN = "December";
           break;
       default:
           monthN = "Invalid month";
           break;
   }
    	   
        StringBuilder fullnames = new StringBuilder();

   
            fullnames.append("Prediction:"+monthName+" will be most visited")
                    .append("\n")
                    .append("Suggestion:You can be more active on these months")
                    .append("\n")
                    .append("\n")
                    .append("Prediction:"+monthN+" will have most transactions")
                    .append("\n")
                    .append("Suggestion:You can open the restaurants early to get good turnover");
                    
       
        text.setText(fullnames.toString());
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204,204,204));

        text.setBackground(new java.awt.Color(192,192,192));
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Order Prediction");

        jLabel2.setText("");

        jLabel3.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(backButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1)
                                .addGap(54, 54, 54)
                                .addComponent(jLabel2)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel3)))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(backButton)
                .addGap(50, 50, 50))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
    	PredictionManagement im = new PredictionManagement();
        im.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ViewItem().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea text;
    // End of variables declaration//GEN-END:variables

    public void actionPerformed(ActionEvent e) {

    }
}
