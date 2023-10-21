package judge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PractiseString {

    public static void main(String[] args) {
        PractiseString practiseString = new PractiseString();

        practiseString.romanToInt("III");

        String[] a = new String[]{"flower","flower","flower","flower"};
        practiseString.longestCommonPrefix(a);

        practiseString.gcdOfStrings("leet","code");

        int[] b = new int[]{1,0,0,0,1};
        practiseString.canPlaceFlowers(b,2);

    }

    //605. 种花问题
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int x = 0;
        for (int i=0;i<flowerbed.length;i++){
            if (flowerbed[i]==0){
                if (flowerbed.length==1){
                    return n<=1;
                }
                if (i==0){
                    if (flowerbed[i+1]==0){
                        flowerbed[i]=1;
                        x++;
                    }
                }
                else if (i==flowerbed.length-1){
                    if (flowerbed[i-1]==0){
                        flowerbed[i]=1;
                        x++;
                    }
                }
                else {
                    if (flowerbed[i-1]==0&&flowerbed[i+1]==0){
                        flowerbed[i]=1;
                        x++;
                    }
                }
            }
        }
        return x>=n ? true:false;
    }
    //1431. 拥有最多糖果的孩子
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int a: candies){
            if (a>max) max = a;
        }
        List<Boolean> r = new ArrayList<>();
        for (int i=0;i<candies.length;i++){
            if (candies[i]+extraCandies>=max) r.add(true);
            else r.add(false);
        }
        return r;
    }
    //1071. 字符串的最大公因子
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        int p = l1;
        while(p>=0){
            if (p==0) break;
            int judge=1;
            if (l1%p==0 && l2%p==0){
                String temp = str1.substring(0,p);
                int a = l1/p;int b = l2/p;
                for (int i=0;i<a;i++){
                    if (!str1.substring(p*i,p+p*i).equals(temp)){
                        judge=0;break;
                    }
                }
                for (int i=0;i<b;i++){
                    if (!str2.substring(p*i,p+p*i).equals(temp)){
                        judge=0;break;
                    }
                }
                if (judge==1) {
                    return str1.substring(0,p);
                }
                else {
                    p--;
                }
            }
            else {
                p--;
            }
        }
        if (p==0) return "";
        else return str1.substring(0,p);
    }
    //1768. 交替合并字符串
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int p = 0;
        int q = 0;
        String r = "";
        while (p<l1 && q<l2){
            r = r+word1.substring(p,p+1)+word2.substring(q,q+1);
            p++;q++;
        }
        if (p==l1){
            if (q<l2){
                r=r+word2.substring(q,l2);
            }
        }
        else if (q==l2){
            if (p<l1){
                r=r+word1.substring(p,l1);
            }
        }
        return r;
    }
    //14. 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        int tempInt=1;
        int p=1;
        while(true){
            for (String s : strs){
                if (s.equals("")) return "";
                if (s.length()<tempInt) return strs[0].substring(0,tempInt-1);
                String tempStr=strs[0].substring(0,tempInt);
                String subStr = s.substring(0,tempInt);
                String tempSubString = tempStr.substring(0,tempInt);
                if(!subStr.equals(tempSubString)){
                    p=0;
                    break;
                }
            }
            if (p == 0) break;
            else tempInt++;
        }
        if (tempInt == 1) return "";
        else return strs[0].substring(0,tempInt-1);
    }
    //13. 罗马数字转整数
    public int romanToInt(String s) {
                int a=0;
                char[] c = s.toCharArray();
                int p=0;
                while (p<c.length){
                    switch (c[p]){
                        case 'I':
                            if (p<c.length-1){
                                if (c[p+1]=='V') {
                                    a=a+4;
                                    p=p+2;
                                }
                                else if (c[p+1]=='X'){
                                    a=a+9;
                                    p=p+2;
                                }
                                else {
                                    a=a+1;
                                    p=p+1;
                                }
                            }
                            else {
                                a=a+1;
                                p=p+1;
                            }
                            break;
                        case 'V':
                            a=a+5;
                            p=p+1;
                            break;
                        case 'X':
                            if (p<c.length-1){
                                if (c[p+1]=='L') {
                                    a=a+40;
                                    p=p+2;
                                }
                                else if (c[p+1]=='C'){
                                    a=a+90;
                                    p=p+2;
                                }
                                else {
                                    a=a+10;
                                    p=p+1;
                                }
                            }
                            else {
                                a=a+10;
                                p=p+1;
                            }
                            break;
                        case 'L':
                            a=a+50;
                            p=p+1;
                            break;
                        case 'C':
                            if (p<c.length-1){
                                if (c[p+1]=='D') {
                                    a=a+400;
                                    p=p+2;
                                }
                                else if (c[p+1]=='M'){
                                    a=a+900;
                                    p=p+2;
                                }
                                else {
                                    a=a+100;
                                    p=p+1;
                                }
                            }
                            else {
                                a=a+100;
                                p=p+1;
                            }
                            break;
                        case 'D':
                            a=a+500;
                            p=p+1;
                            break;
                        case 'M':
                            a=a+1000;
                            p=p+1;
                            break;
                        default:
                            break;
                    }
                }
                return a;
//        }
    }
}
