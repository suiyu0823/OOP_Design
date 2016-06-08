/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;

public class Apply_ALgorithm  {
     private ArrayList<Node> Nodes;
     private ArrayList<Edge>Edges;
     private ArrayList<Node> pre_Nodes;
     private ArrayList<Node> post_Nodes;
     private Map<Node, Node> Node_before;
     private Map <Node,Double> distance;


// Constructor to initialize sets of Nodes and Edges
    public Apply_ALgorithm(Graph graph) {
        this.Nodes = new ArrayList<Node>(graph.getNodes());
        this.Edges = new ArrayList<Edge>(graph.getEdges());

    }
    // find the distance between two nodes
    public double getDistance(Node begin, Node end) {
    for (Edge edge : Edges) {
      if (edge.getFrom_node().equals(begin)
          && edge.getTo_node().equals(end)||edge.getFrom_node().equals(end)
          && edge.getTo_node().equals(begin) ){
          //System.out.println(edge.getDistance());
        return edge.getDistance();
      }
    }
    
    System.err.println("cannot find the distance");
    return -1;
    }
    // to define a node is processed or not
    public boolean is_process(Node node) {
    return post_Nodes.contains(node);
  }
// Find a list of neighbor(adjacentNode) of a processing Node that have not processed yet
    
public  ArrayList<Node> getNeighbors (Node node) {
    ArrayList<Node> neighbors = new ArrayList<Node>();
    for (Edge edge : Edges) {
      if (edge.getFrom_node().equals(node)&& !is_process(edge.getTo_node())) {
        neighbors.add(edge.getTo_node());
      }
      if (edge.getTo_node().equals(node)&& !is_process(edge.getFrom_node())) {
        neighbors.add(edge.getFrom_node());
     
      }
          
    }
     
       for(Node n:neighbors){
       
      
        System.out.println("Node"+n.toString());}
    return neighbors;
  }
///////////////////////////////////////////////////////////////////
// get Distance from a node to a node in a graph
public void find_Distances(Node node) {
    ArrayList<Node> adjacentNodes = getNeighbors(node);
    for (Node target : adjacentNodes) {
      if (getShortestDistance(target) > getShortestDistance(node)
          + getDistance(node, target)) {
        distance.put(target,getShortestDistance(node)
            +getDistance(node, target));
        Node_before.put(target,node);
        pre_Nodes.add(target);
      }
    }

  }
///////////////////////////////////////////////////////
// find shortest distance from root to node destination
public double getShortestDistance(Node destination) {
    Double  d = distance.get(destination);
    if (d == null) {
      return Double.MAX_VALUE;
    } else {
        //System.out.println(d);
      return d;
    }
  }
//---------------------------------------------------------------
// to find a minimal distance in the Array_List of Nodes
private Node minimum_distance( ArrayList<Node> Nodes) {
       Node minimum = null;
    for (Node node : Nodes) {
      if (minimum == null) {
        minimum = node;
      } else {
        if (getShortestDistance(node) < getShortestDistance(minimum)) {
          minimum = node;
        }
      }
    }
    return minimum;
  }
// perform the alogrithm
public void ex(Node source) {
    pre_Nodes = new ArrayList<Node>();
    post_Nodes = new ArrayList<Node>();
  
    distance = new HashMap<Node, Double>();
    Node_before = new HashMap <Node, Node>();
    distance.put(source,0.0);
    pre_Nodes.add(source);
    while (pre_Nodes.size() > 0) {
      Node node = minimum_distance(pre_Nodes);
      post_Nodes.add(node);
      pre_Nodes.remove(node);
      find_Distances(node);
    }
} 
    ////////////////////////////////////////////////
    // find a path to the destination:
    public ArrayList<Node> findPath(Node target) {
    ArrayList<Node> path = new ArrayList<Node>();
    Node tmp = target;
    // Check if a path exists
    if (Node_before.get(tmp) == null) {
      System.out.println("cannot find a path \n");
      //return null;
    }
    path.add(tmp);
    while (Node_before.get(tmp) != null) {
      tmp = Node_before.get(tmp);
      path.add(tmp);
    }
    // Put it into the correct order
    Collections.reverse(path);
    System.out.println("Shortest path from source is \n");
     String out = new String();
    for(Node node:path){
       
        out = "Node"+node;
        System.out.println("Node  "+node.toString());
    }
    double total_distance = 0;
    String t="Shortest path from: "+ path.get(0) +" is \n";
    String r = " ";
    for(int i = 0; i <path.size()-1;i++){
        Edge tem1 = new Edge("tmp",path.get(i),path.get(i+1),0);
        Edge tem2 = new Edge("tmp",path.get(i+1),path.get(i),0);
         for(int n = 0; n <Edges.size();n++){
           if(Edges.get(n).equals(tem1)||Edges.get(n).equals(tem2)){
           r = Edges.get(n).getEdge_name();
           }
         }
    total_distance = total_distance + getDistance(path.get(i),path.get(i+1));
    t = t+" From Node "+path.get(i).toString()+ " to node " +path.get(i+1).toString() +
             " --via road-- "+ r+
             " --Distance : "+ getDistance(path.get(i),path.get(i+1))+ " km"
             + ""
             + "\n";
    /* System.out.println("From Node  "+path.get(i).toString()+ "  to node  " +path.get(i+1).toString() +
             "   Distance : "+ getDistance(path.get(i),path.get(i+1))+ " km"
             + ""
             + "/n"); */
    
    }
    
    t = t+"total_distance is: "+ total_distance+" km \n";
    JOptionPane.showMessageDialog(null, t+"\n");
    return path;
  }
  ////////////////////////////////////////////////
    // to print a path from a departure point to the destination:
    public String findPath1(Node destination) {
     ArrayList<Node> path1 = new ArrayList<Node>();
    Node tmp = destination;
    // Check if a path exists
    if (Node_before.get(tmp) == null) {
     return  "cannot find a path \n";
      
    }
    path1.add(tmp);
    while (Node_before.get(tmp) != null) {
      tmp = Node_before.get(tmp);
      path1.add(tmp);
    }
    // Put it into the correct order
    Collections.reverse(path1);
    System.out.println("Shost test path from source is \n");
     String out = new String();
    for(Node node:path1){
       
        out = "Node"+node;
        System.out.println("Node"+node);
    }
    return out;
  }
 /* public static void main(String args[]) {
      ArrayList<Node> N = new ArrayList<Node>();
      ArrayList<Edge> E = new ArrayList<Edge>();
      //Graph G = new Graph(N,E);
      //////////////////////////////////////////////
      Node U0 = new Node("U0");
      Node U1 = new Node("U1");
      Node U2 = new Node("U2");
      Node U3 = new Node("U3");
      Node U4 = new Node("U4");
      Node U5 = new Node("U5");
      //---------------------------------
      N.add(U0);
      N.add(U1);
      N.add(U2);
      N.add(U3);
      N.add(U4);
      N.add(U5);
      
      //------------------------------
      Edge e0 = new Edge ("t0",U0,U2,13.8);
      Edge e1 = new Edge ("t1",U0,U5,8);
      Edge e2 = new Edge ("t2",U0,U4,16);
      Edge e3 = new Edge ("t3",U1,U3,6);
      Edge e4 = new Edge ("t4",U1,U5,10);
      Edge e5 = new Edge ("t5",U2,U3,14);
      Edge e6 = new Edge ("t6",U2,U5,17);
      Edge e7 = new Edge ("t7",U3,U4,5);
      Edge e8 = new Edge ("t8",U3,U5,17);
      Edge e9 = new Edge ("t9",U4,U5,7.2);
      //-------------------------------------
        E.add(e0);
        E.add(e1);
        E.add(e2);
        E.add(e3);
        E.add(e4);
        E.add(e5);
        E.add(e6);
        E.add(e7);
        E.add(e8);
        E.add(e9);
        //----------------------------
        Graph G = new Graph(N,E);
         Apply_ALgorithm A = new  Apply_ALgorithm(G);
          A.ex(U0);
        // A.getNeighbors(U0);
        // A.getShortestDistance(U0);
         A.findPath(U4);
  }*/
  




}
