package judge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFind {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 3, 0, 0, 0, 0},
                {1, 0, 2, 0, 0, 0, 0},
                {3, 2, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 3, 0, 9},
                {0, 0, 0, 3, 0, 5, 0},
                {0, 0, 0, 0, 5, 0, 7},
                {0, 0, 0, 9, 0, 7, 0}
        };
        int n=matrix.length;
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (matrix[i][j] >0) {
                    union(parent, i, j);
                }
            }
        }
        //根+它的麾下
        Map<Integer, List<Integer>> sets = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int root = find(parent,i);
            sets.putIfAbsent(root, new ArrayList<>());
            sets.get(root).add(i);
        }

        for(Map.Entry<Integer, List<Integer>> entry: sets.entrySet()){
            int id= entry.getKey();
            List<Integer> list=entry.getValue();
            System.out.print(id+": ");
            for(int i=0;i<list.size();i++){
                System.out.print(list.get(i)+" ");
            }
            System.out.println();
        }
    }
    public static void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }
    public static int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
