package judge;

import java.util.*;

public class PractiseHash {
    public static void main(String[] args) {
        PractiseHash practiseHash=new PractiseHash();
        int[] a={1,2,2,1,1,3};
        practiseHash.uniqueOccurrences(a);
        practiseHash.closeStrings("xxa","uau");
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
    //1657. 确定两个字符串是否接近
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character, Integer> h1= new HashMap<Character, Integer>();
        HashMap<Character, Integer> h2= new HashMap<Character, Integer>();
        for (int i=0;i<word1.length();i++){
            char temp = word1.charAt(i);
            if(h1.containsKey(temp)){
                int j=h1.get(temp);
                h1.put(temp,j+1);
            }
            else {
                h1.put(temp,1);
            }
        }
        for (int i=0;i<word2.length();i++){
            char temp = word2.charAt(i);
            if(h2.containsKey(temp)){
                int j=h2.get(temp);
                h2.put(temp,j+1);
            }
            else {
                h2.put(temp,1);
            }
        }
        for (char c:h1.keySet()){
            if (!h2.containsKey(c)) return false;
        }
        List<Integer> l1 = new ArrayList<Integer>(h1.values());
        List<Integer> l2 = new ArrayList<Integer>(h2.values());
        Collections.sort(l1);
        Collections.sort(l2);
        if (l1.size()!=l2.size()) return false;
        for (int i=0;i<l1.size();i++){
            if (!l1.get(i).equals(l2.get(i))) return false;
        }
        return true;
    }
    //1207. 独一无二的出现次数
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
