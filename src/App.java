import java.util.HashMap;

import utils.GraphViewer;
import utils.Matrix;

public class App {
  
  public static void main(String[] args) {
    HashMap<Integer, int[]> boxes = new HashMap<>();
    GraphViewer graph = new GraphViewer("G");

    boxes.put(0, new int[]{ 733, 281, 710 });
    boxes.put(1, new int[]{ 910, 720, 218 });
    boxes.put(2, new int[]{ 743, 512, 162 });
    boxes.put(3, new int[]{ 988, 955, 720 });
    boxes.put(4, new int[]{ 680, 603, 649 });
    boxes.put(5, new int[]{ 336, 326, 615 });
    boxes.put(6, new int[]{ 566, 764, 487 });
    boxes.put(7, new int[]{ 680, 579, 148 });
    boxes.put(8, new int[]{ 629, 222, 697 });

    Matrix resultMatrix = new Matrix(boxes.size(), boxes.size());

    for (int row = 0; row < boxes.size(); row++) {
      final int TARGET_D1 = boxes.get(row)[0];
      final int TARGET_D2 = boxes.get(row)[1];
      final int TARGET_D3 = boxes.get(row)[2];
      final int TARGET_VOLUME = TARGET_D1 * TARGET_D2 * TARGET_D3;

      for (int i = 1; i < boxes.size(); i++) {
        int d1 = boxes.get(i)[0];
        int d2 = boxes.get(i)[1];
        int d3 = boxes.get(i)[2];
        int volume = d1 * d2 * d3;
  
        if (volume < TARGET_VOLUME) {
          String n1 = String.format("%s %s %s", d1, d2, d3);
          String n2 = String.format("%s %s %s", TARGET_D1, TARGET_D2, TARGET_D3);
          graph.newConnection(n1 , n2);
          resultMatrix.setValue(row, i, 1);
        }
      }
    }

    graph.print();
    System.out.println(resultMatrix.toString());    
  }
}