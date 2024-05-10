package draft;

public class Exam {
    public static void main(String[] args) {
        int[] in=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int n=in.length;
        int[] a=new int[n];
        int[][] res=new int[n][2];
        for(int i=1;i<n;i++){
            if(in[i]>a[i-1]+in[i]){
                a[i]=in[i];
                res[i]=new int[]{i,i};
            }
            else{
                a[i]=a[i-1]+in[i];
//                int[] t=res[i-1];
                res[i]=new int[]{res[i-1][0],i};
            }
        }
        int max=Integer.MIN_VALUE;
        int p=0;
        for(int i=0;i<n;i++){
            if(a[i]>max){
                max=a[i];
                p=i;
            }
        }
        System.out.println(res[p][0]+","+res[p][1]);
    }
}
