/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class Edge {
    private String Edge_name;
    private Node from_node;
    private Node to_node;
    private double distance;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Edge other = (Edge) obj;
        if (this.from_node != other.from_node && (this.from_node == null || !this.from_node.equals(other.from_node))) {
            return false;
        }
        if (this.to_node != other.to_node && (this.to_node == null || !this.to_node.equals(other.to_node))) {
            return false;
        }
        return true;
    }

   

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public String toString() {
        return "Edge{" + "Edge_name= " + Edge_name + " ,from_node= " + from_node + " ,to_node= " + to_node + " ,distance= " + distance +" "+'}';
    }

    

    public void setEdge_name(String Edge_name) {
        this.Edge_name = Edge_name;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setFrom_node(Node from_node) {
        this.from_node = from_node;
    }

    public void setTo_node(Node to_node) {
        this.to_node = to_node;
    }

    public String getEdge_name() {
        return Edge_name;
    }

    public double getDistance() {
        return distance;
    }

    public Node getFrom_node() {
        return from_node;
    }

    public Node getTo_node() {
        return to_node;
    }

    public Edge(String Edge_name, Node from_node, Node to_node, double distance) {
        this.Edge_name = Edge_name;
        this.from_node = from_node;
        this.to_node = to_node;
        this.distance = distance;
    }
    
}
