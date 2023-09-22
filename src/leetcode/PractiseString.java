package leetcode;

public class PractiseString {

    public static void main(String[] args) {
        PractiseString practiseString = new PractiseString();

        practiseString.romanToInt("III");

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
