package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {

  private HashMap<String, ArrayList<String>> vertices;
  private GraphViewer graphViewer;

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
    this.graphViewer.newConnection(vertice1, vertice2);
  }

  public ArrayList<String> getAdjacentes(String vertice) {
    return this.vertices.get(vertice);
  }

  public void toDot() {
    this.graphViewer.print();
  }

  public HashMap<String, ArrayList<String>> getVertices() {
    return this.vertices;
  }

  public int findLongestPath() {
    Stack<String> stack = topologicalSort();
    HashMap<String, Integer> dist = new HashMap<>();

    // Inicializa todas as distâncias como mínimas
    for (String vertice : vertices.keySet()) {
      dist.put(vertice, Integer.MIN_VALUE);
    }

    // A distância do ponto de partida para si mesmo é 0
    while (!stack.isEmpty()) {
      String vertice = stack.pop();
      if (dist.get(vertice) == Integer.MIN_VALUE) {
        dist.put(vertice, 0);
      }

      if (dist.get(vertice) != Integer.MIN_VALUE) {
        for (String adj : getAdjacentes(vertice)) {
          if (dist.get(adj) < dist.get(vertice) + 1) {
            dist.put(adj, dist.get(vertice) + 1);
          }
        }
      }
    }

    // Encontra a maior distância
    int maxPath = 0;
    for (int value : dist.values()) {
      if (value > maxPath) {
        maxPath = value;
      }
    }
    return maxPath +1;
  }

  private Stack<String> topologicalSort() {
    Stack<String> stack = new Stack<>();
    HashMap<String, Boolean> visited = new HashMap<>();

    for (String vertice : vertices.keySet()) {
      visited.put(vertice, false);
    }

    for (String vertice : vertices.keySet()) {
      if (!visited.get(vertice)) {
        topologicalSortUtil(vertice, visited, stack);
      }
    }

    return stack;
  }

  private void topologicalSortUtil(String vertice, HashMap<String, Boolean> visited, Stack<String> stack) {
    visited.put(vertice, true);
    for (String adj : getAdjacentes(vertice)) {
      if (!visited.get(adj)) {
        topologicalSortUtil(adj, visited, stack);
      }
    }
    stack.push(vertice);
  }
}
