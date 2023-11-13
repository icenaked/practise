package judge;

import java.util.*;

public class PractiseHash {
    public static void main(String[] args) {
        PractiseHash practiseHash=new PractiseHash();
        int[] a={1,2,2,1,1,3};
        practiseHash.uniqueOccurrences(a);
        practiseHash.equalPairs(new int[][]{{3,2,1},{1,7,6},{2,7,7}});
    }
    //2352. 相等行列对
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int r=0;
        int[][] a = new int[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                a[i][j]=grid[j][i];
            }
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (Arrays.equals(grid[i],a[j])) r++;
            }
        }
        return r;
    }
    //
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hashmap= new HashMap<Integer, Integer>();
        for(int i:arr){
            if(hashmap.containsKey(i)){
                int j=hashmap.get(i);
                hashmap.put(i,j+1);
            }
            else {
                hashmap.put(i,1);
            }
        }
        return hashmap.size() == new HashSet<>(hashmap.values()).size();
    }
    //2215. 找出两数组的不同
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> a= new HashSet<Integer>();
        Set<Integer> b= new HashSet<Integer>();
        for (int i:nums1){
            if (!a.contains(i)) a.add(i);
        }
        for (int i:nums2){
            if (!b.contains(i)) b.add(i);
        }
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (int i:a){
            if (!b.contains(i)){
                x.add(i);
            }
        }
        for (int i:b){
            if (!a.contains(i)){
                y.add(i);
            }
        }
        List<List<Integer>> r = new ArrayList<>();
        r.add(x);
        r.add(y);
        return r;
    }
}
