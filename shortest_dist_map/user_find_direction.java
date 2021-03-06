
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * user_find_direction.java
 *
 * Created on Apr 1, 2013, 10:20:25 PM
 */
/**
 *
 * @author Daniel
 */
public class user_find_direction extends javax.swing.JFrame {
     ArrayList<Node> nodes = new ArrayList<Node>();
     ArrayList<Edge> edges = new ArrayList<Edge>();
    /** Creates new form user_find_direction */
    public user_find_direction() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        from_node = new javax.swing.JTextField();
        to_node = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Find Direction");

        jLabel2.setText("From place:");

        jLabel3.setText("To pplace:");

        jButton1.setText("Find");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cancel.setText("cancel/back");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(to_node)
                            .addComponent(from_node, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(from_node, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(to_node, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel)
                    .addComponent(jButton1))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
         this.setVisible(false);
         new user_form().setVisible(true);
    // TODO add your handling code here:
}//GEN-LAST:event_cancelActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

    //***************************************************************************************
         BufferedReader  fin_temp1;		

		try
		{
		    // Open an input stream
		    fin_temp1 = new BufferedReader (new FileReader("Node.txt"));
                  
                    
                    while(fin_temp1.ready()){
		    //System.out.println( fin2.readLine());
                    String text = fin_temp1.readLine();
                
                //JOptionPane.
                 Node n = new Node(text);
                
                  nodes.add(n);  
		}
                    fin_temp1.close();
                }
		// Catches any error conditions
		catch (IOException e)
		{
	         System.err.println ("Node.txt is empty");
			//System.exit(-1);
		}
//*******************************************************************************************
                BufferedReader  fin_temp2;		

		try
		{
		    // Open an input stream
		    fin_temp2 = new BufferedReader (new FileReader("Edge.txt"));
                  
                    
                    while(fin_temp2.ready()){
		    //System.out.println( fin2.readLine());
                       String text3 = fin_temp2.readLine();
                StringTokenizer tokenizer = new StringTokenizer(text3," ");
                String title1 = tokenizer.nextToken();
                String node_name = tokenizer.nextToken();
                String user_pass = tokenizer.nextToken();
                String fromnode = tokenizer.nextToken();
                //------------
                String title2 = tokenizer.nextToken();
                String tonode = tokenizer.nextToken();
                String title3 = tokenizer.nextToken();
                Double d = Double.parseDouble(tokenizer.nextToken());
                //JOptionPane.
                Node n1 = new Node(fromnode);
                Node n2 = new Node(tonode);
                Edge e  = new Edge(node_name,n1,n2,d);
                
                  edges.add(e);  
		}
                    fin_temp2.close();
                }
		// Catches any error conditions
		catch (IOException e)
		{
	         System.err.println ("Edge.txt empty");
			//System.exit(-1);
		}
//*******************************************************************************************
                     boolean T = false;
                     Graph g = new Graph(nodes,edges);
                     Apply_ALgorithm A1 = new  Apply_ALgorithm(g);
                     for(int l = 0;l<nodes.size();l++){
                     if(nodes.contains(new Node(from_node.getText())) && 
                    
                         nodes.contains(new Node(to_node.getText())))
                       { 
                           T = true;
                           }
                     }
                     if (T == false){
                         JOptionPane.showMessageDialog(null, "the places are not real, please double check");
                     this.setVisible(false);
                     new user_form().setVisible(true);
                     }
                     else{ A1.ex(new Node(from_node.getText()));
        // A.getNeighbors(U0);
        // A.getShortestDistance(U0);
                     A1.findPath(new Node(to_node.getText()));
    //***************************************************************************************
                     this.setVisible(false);
                     new user_form().setVisible(true);}
    // TODO add your handling code here:
    
    // TODO add your handling code here:
}//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JTextField from_node;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField to_node;
    // End of variables declaration//GEN-END:variables
}
