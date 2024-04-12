package draft;

import java.util.Arrays;
import java.util.Comparator;

public class Draft {
    static int[] b={4,5,6};
    public static void main(String[] args) {
        f("aasdfghjkl","sgtrejkl");
    }
    public static void f(String text1,String text2){
        int m = text1.length(), n = text2.length();
        String[][] dp = new String[m + 1][n + 1];
        for (int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]="";
            }
        }
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + c1;
                } else {
                    if(dp[i - 1][j].length() >= dp[i][j - 1].length() ){
                        dp[i][j]=dp[i - 1][j];
                    }
                    else{
                        dp[i][j]=dp[i][j - 1];
                    }
                }
            }
        }
        System.out.println(dp[m][n]);
    }

}
