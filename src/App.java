import java.util.ArrayList;
import java.util.Arrays;
import utils.FileTXT;
import utils.Graph;

public class App {

  private static ArrayList<String> data = new ArrayList<>();
  private static Graph graph = new Graph();

  public static void main(String[] args) {
    readFile("caixas_10000");

    // Ordena as dimensões de cada caixa em ordem crescente
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

    // Constrói o grafo adicionando vértices e arestas direcionadas
    for (int i = 0; i < data.size(); i++) {
      String[] values = data.get(i).split(" ");
      graph.addVertice(data.get(i));

      for (int j = 0; j < data.size(); j++) {
        if (i != j) {
          String[] values_aux = data.get(j).split(" ");

          if (Integer.parseInt(values[0]) < Integer.parseInt(values_aux[0])
              && Integer.parseInt(values[1]) < Integer.parseInt(values_aux[1])
              && Integer.parseInt(values[2]) < Integer.parseInt(values_aux[2])) {
            graph.addAresta(data.get(i), data.get(j));
          }
        }
      }
    }

    // Encontra o maior caminho no grafo utilizando ordenação topológica
    //graph.toDot();
    int maxStack = graph.findLongestPath();
    System.out.println(maxStack);
  }

  private static void readFile(String name) {
    FileTXT file = new FileTXT(name);
    ArrayList<String> rows = file.read();
    rows.remove(0); // Remove a primeira linha que é o número de caixas
    data = rows;
  }
}
