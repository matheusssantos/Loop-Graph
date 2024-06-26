import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import utils.FileTXT;
import utils.Graph;
import utils.GraphViewer;
import utils.Matrix;

public class App {
  
  private static ArrayList<String> data = new ArrayList<>();
  private static Graph graph = new Graph();

  // public static void main(String[] args) {
  //   HashMap<Integer, int[]> boxes = new HashMap<>();
  //   GraphViewer graph = new GraphViewer("G");

  //   boxes.put(0, new int[]{ 733, 281, 710 });
  //   boxes.put(1, new int[]{ 910, 720, 218 });
  //   boxes.put(2, new int[]{ 743, 512, 162 });
  //   boxes.put(3, new int[]{ 988, 955, 720 });
  //   boxes.put(4, new int[]{ 680, 603, 649 });
  //   boxes.put(5, new int[]{ 336, 326, 615 });
  //   boxes.put(6, new int[]{ 566, 764, 487 });
  //   boxes.put(7, new int[]{ 680, 579, 148 });
  //   boxes.put(8, new int[]{ 629, 222, 697 });

  //   Matrix resultMatrix = new Matrix(boxes.size(), boxes.size());

  //   for (int row = 0; row < boxes.size(); row++) {
  //     final int TARGET_D1 = boxes.get(row)[0];
  //     final int TARGET_D2 = boxes.get(row)[1];
  //     final int TARGET_D3 = boxes.get(row)[2];
  //     final int TARGET_VOLUME = TARGET_D1 * TARGET_D2 * TARGET_D3;

  //     for (int i = 1; i < boxes.size(); i++) {
  //       int d1 = boxes.get(i)[0];
  //       int d2 = boxes.get(i)[1];
  //       int d3 = boxes.get(i)[2];
  //       int volume = d1 * d2 * d3;
  
  //       if (volume < TARGET_VOLUME) {
  //         String n1 = String.format("%s %s %s", d1, d2, d3);
  //         String n2 = String.format("%s %s %s", TARGET_D1, TARGET_D2, TARGET_D3);
  //         graph.newConnection(n1 , n2);
  //         resultMatrix.setValue(row, i, 1);
  //       }
  //     }
  //   }

  //   graph.print();
  //   System.out.println(resultMatrix.toString());    
  // }

  public static void main(String[] args) {
    readFile("caixas_5");

    for (int i = 0; i < data.size(); i++) {
      String[] values = data.get(i).split(" ");
      System.out.println(Integer.parseInt(values[0]));

      for (int j = i + 1; j < data.size(); j++) {
        String[] values_aux = data.get(i).split(" ");

        if (Integer.parseInt(values[0]) < Integer.parseInt(values_aux[0])) {
          if (Integer.parseInt(values[1]) < Integer.parseInt(values_aux[1])) {
            if (Integer.parseInt(values[2]) < Integer.parseInt(values_aux[2])) {
              graph.addAresta(data.get(i), data.get(j));
            }
          }
        }
      }
    }

    // graph.toDot();
  }

  private static void readFile(String exampleName) {
    FileTXT file = new FileTXT(exampleName);

    ArrayList<String> rows = file.read();
    rows.remove(0);

    data = rows;
  }

  private static void sortData() {
    for (int j = 0; j < data.size(); j++) {

      String[] arrayOfStrings = data.get(j).split(" ");
      
      int[] arrayOfIntegers = new int[arrayOfStrings.length]; 
      for (int i = 0; i < arrayOfStrings.length; i++) {
        arrayOfIntegers[i] = Integer.parseInt(arrayOfStrings[i]);
      }

      Arrays.sort(arrayOfIntegers);

      data.set(j, Arrays.toString(arrayOfIntegers));
    }
  }
}