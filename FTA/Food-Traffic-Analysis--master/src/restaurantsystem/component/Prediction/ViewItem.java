
package restaurantsystem.component.Prediction;

import java.awt.event.ActionEvent;
import java.util.*;

import restaurantsystem.service.ItemService;
 class ViewItem extends javax.swing.JFrame {

    private final ItemService itemService;

    public ViewItem() {
        initComponents();
        this.itemService = new ItemService();
        performFileRelatedTask();
    }

    public void performFileRelatedTask() {
    	Hashtable<String,Integer> itemQuantity=new Hashtable<String,Integer>(); 
    	
    	ArrayList<String> itemN=new ArrayList<String>();
    	ArrayList<Integer> itemQ=new ArrayList<Integer>();
    	
    	
         itemService.getAll().forEach((item) -> {
        	    
             itemQuantity.put(item.getName(),item.getQuantity());
             
         });
       
         itemService.getAll().forEach((item) -> {
     	    
             itemN.add(item.getName());
             itemQ.add(item.getQuantity());
             
             
         });
        
        int max=0;
        int min=100;
        String minItem="";
        String itemName="";
        String name="";
       int count=0;
       String maxItem="";
      
        for(Map.Entry m:itemQuantity.entrySet()){  
        	if((int)m.getValue()>max) {
        		max=(int)m.getValue();
        		itemName=(String) m.getKey();
        		
        	}
        	  }  
        
        //text.setText("Order with Max Quantity\t"+itemName);
       
        for(int i=0;i<itemN.size();i++)
        {
        	name=itemN.get(i);
        	int freq = Collections.frequency(itemN, name);
        	if(freq>count) {
        		count=freq;
        		maxItem=name;
        	}
        	if(freq<min) {
        		min=freq;
        		minItem=name;
        	}
        	
        }
        StringBuilder fullnames = new StringBuilder();

   
            fullnames.append("Prediction:"+maxItem+" will be the most ordered in future")
                    .append("\n")
                    .append("Suggestion:"+maxItem+" can be prepared in large quantity to reduce wait time")
                    .append("\n")
                    .append("\n")
                    .append("Prediction:"+minItem+" will be the least ordered in future")
                    .append("\n")
                    .append("Suggestion:"+minItem+" can be removed from the menu or improvized upon");
       

      
       // System.out.println("Most ordered Food\n"+maxItem);
        //text.setText("Prediction:"+maxItem+" will be the most ordered in future");
        //text.setText("Suggestion:"+maxItem+"can be prepared in large quantity to reduce wait time");
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

        jLabel1.setText("Item Prediction");

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
