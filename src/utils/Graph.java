package utils;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
  
  HashMap<String, ArrayList<String>> vertices;
  GraphViewer graphViewer;

  public Graph() {
    this.vertices = new HashMap<>();
    this.graphViewer = new GraphViewer("g");
  }

  public void addVertice(String vertice) {
    this.vertices.putIfAbsent(vertice, new ArrayList<>());
    this.graphViewer.addNode(vertice);
  }

  public void addAresta(String vertice1, String vertice2) {
    this.addVertice(vertice1);
    this.addVertice(vertice2);
    vertices.get(vertice1).add(vertice2);
    vertices.get(vertice2).add(vertice1);
    this.graphViewer.newConnection(vertice1, vertice2);
  }

  public void toDot() {
    this.graphViewer.print();
  }

  public HashMap<String, ArrayList<String>> getVertices() {
    return this.vertices;
  }
}
