import java.util.ArrayList;

import utils.FileTXT;
import utils.Graph;

public class App {
  
  private static ArrayList<String> data = new ArrayList<>();
  private static Graph graph = new Graph();

  public static void main(String[] args) {
    readFile("caixas_5");

    for (int i = 0; i < data.size(); i++) {
      graph.addVertice(data.get(i));
    }

    graph.addAresta(data.get(0), data.get(1));

    graph.toDot();
  }

  private static void readFile(String name) {
    FileTXT file = new FileTXT(name);

    ArrayList<String> rows = file.read();
    rows.remove(0);

    data = rows;
  }
}