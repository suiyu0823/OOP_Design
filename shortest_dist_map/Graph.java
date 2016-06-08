/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
import java.util.ArrayList;
public class Graph {
    private ArrayList<Node> Nodes;
    private ArrayList<Edge>Edges;

    public Graph(ArrayList<Node> Nodes, ArrayList<Edge> Edges) {
        this.Nodes = Nodes;
        this.Edges = Edges;
    }

    public ArrayList<Edge> getEdges() {
        return Edges;
    }

    public ArrayList<Node> getNodes() {
        return Nodes;
    }

    public void setEdges(ArrayList<Edge> Edges) {
        this.Edges = Edges;
    }

    public void setNodes(ArrayList<Node> Nodes) {
        this.Nodes = Nodes;
    }
    
}
