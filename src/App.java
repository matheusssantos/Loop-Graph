import java.util.ArrayList;

import utils.FileTXT;
import utils.Graph;
import java.util.Arrays;

public class App {
  
  private static ArrayList<String> data = new ArrayList<>();
  private static Graph graph = new Graph();

  public static void main(String[] args) {
    readFile("caixas_5");

    for (int i = 0; i < data.size(); i++) {
      final String[] aux = data.get(i).split(" ");
      int[] number = new int[3];
      number[0] = Integer.parseInt(aux[0]);
      number[1] = Integer.parseInt(aux[1]);
      number[2] = Integer.parseInt(aux[2]);

      Arrays.sort(number);
      String text = number[0] + " " + number[1] + " " + number[2]; 

      data.set(i, text);
    }


    for (int i = 0; i < data.size(); i++) {
      String[] values = data.get(i).split(" ");
      graph.addVertice(data.get(i));

      for (int j = 0; j < data.size(); j++) {
        String[] values_aux = data.get(j).split(" ");

        if (Integer.parseInt(values[0]) < Integer.parseInt(values_aux[0])) {
          if (Integer.parseInt(values[1]) < Integer.parseInt(values_aux[1])) {
            if (Integer.parseInt(values[2]) < Integer.parseInt(values_aux[2])) {
              graph.addAresta(data.get(i), data.get(j));
            }
          }
        }
      }
    }

    graph.search(data.get(0));

  }

  private static void readFile(String name) {
    FileTXT file = new FileTXT(name);

    ArrayList<String> rows = file.read();
    rows.remove(0);

    data = rows;
  }
}