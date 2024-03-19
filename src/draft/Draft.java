package draft;

import java.util.Arrays;
import java.util.Comparator;

public class Draft {
    static int[] b={4,5,6};
    public static void main(String[] args) {
//        System.out.println(args);
        Integer[] a=new Integer[]{2,3,4,5,18,17,6};
        Arrays.sort(a,new Comparator<Integer>(){
            public int compare(Integer a,Integer b){
                return b-a;
            }
        });
        maxArea(new int[]{2,3,4,5,18,17,6});
    }
    public static int maxArea(int[] height) {
        int n=height.length;
        int l=0,r=n-1;
        int max=0;
        while(l<r){
            int s=(r-l)*Math.min(height[l],height[r]);
            max=Math.max(max,s);
            if(l>r) r--;
            else l++;
        }
        return max;
    }

}
