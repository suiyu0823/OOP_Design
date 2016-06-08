/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class Node {
    
  
    private String Node_name;

    @Override
    public String toString() {
        return Node_name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node other = (Node) obj;
        if ((this.Node_name == null) ? (other.Node_name != null) : !this.Node_name.equals(other.Node_name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }


    public void setNode_name(String Node_name) {
        this.Node_name = Node_name;
    }

   

    public String getNode_name() {
        return Node_name;
    }

    public Node( String Node_name) {
        
        this.Node_name = Node_name;
    }
    
}
