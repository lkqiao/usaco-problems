import java.util.*;

public class TSP {
    public static void main(String[] args) {
        Integer[] node = new Integer[993];
        for (int i = 0; i < 992; i++) {
            node[i] = i + 1;
        }
        node[992] = 1;
        List<Integer> intList = Arrays.asList(node);
        Collections.shuffle(intList);
        intList.toArray(node);
        for (int i = 0; i < 993; i++) {
            if (i == 992) {
                System.out.println(node[i]);
            } else {
                System.out.print(node[i] + " ");
            }
        }
    }
}

