package utils;

import java.util.ArrayList;

public class GraphViewer {
  private String name;
  private ArrayList<String> nodes;
  private ArrayList<String> connections;

  public GraphViewer(String name) {
    this.name = name;
    this.nodes = new ArrayList<>();
    this.connections = new ArrayList<>();
  }

  public void newConnection(String from, String to) {
    this.addNode(from);
    this.addNode(to);

    from = String.format("\"%s\"", from);
    to = String.format("\"%s\"", to);
    
    this.connections.add(from + "->" + to);
  }

  public void addNode(String node) {
    node = String.format("\"%s\"", node);
    if (!this.nodes.contains(node)) {
      this.nodes.add(node);
    }
  }

  public void print() {
    System.out.println("digraph " + this.name + " {");
    
    for (String n : this.nodes) {
      System.out.println(n);
    }
    
    for (String c : this.connections) {
      System.out.println(c);
    }

    System.out.println("}");
  }

  public ArrayList<String> getNodes() {
    return this.nodes;
  }
}