package judge;

import java.util.Arrays;

public class PractiseArray {



    public static void main(String[] args) {
        PractiseArray practiseArray = new PractiseArray();

        int[] a = new int[]{4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
        int c = practiseArray.maxOperations(a,2);
//        int[] a = new int[]{1,7,3,6,5,6};
        int b = practiseArray.pivotIndex(a);
    }


    //1679. K 和数对的最大数目
    public int maxOperations(int[] nums, int k) {
        int n=0;
        int p=0;
        int q=nums.length-1;
        Integer[] x = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(x, (a,b)->{
            return b-a;
        });
        while(p<q){
            if(x[p]+x[q]==k){
                p++;
                q--;
                n++;
            }
            else if(x[p]+x[q]<k){
                q--;
            }
            else{
                p++;
            }
        }
        return n;
    }
    //724. 寻找数组的中心下标
    public int pivotIndex(int[] nums) {
        int pre=0;
        int sum=0;
        int n=nums.length;
        int left=0;
        int right=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        for(int i=0;i<n;i++){
            left=pre;
            right=sum-left-nums[i];
            if(left==right) return i;
            pre+=nums[i];
        }
        return -1;
    }
    //334. 递增的三元子序列
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }
    //238. 除自身以外数组的乘积
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] L = new int[length];
        int[] R = new int[length];
        int[] answer = new int[length];
        // L[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;
    }
    //66. 加一
    public int[] plusOne(int[] digits) {
        int k=0;
        for (int i=0;i<digits.length;i++){
            if(digits[i]==9) k++;
        }
        if (k==digits.length){
            int[] newDigits = new int[digits.length+1];
            newDigits[0]=1;
            for (int i=1;i<newDigits.length;i++) newDigits[i]=0;
            return newDigits;
        }
        else{
            for (int i=digits.length-1;i>=0;i--){
                if (digits[i]==9){
                    digits[i]=0;
                }
                else {
                    digits[i]++;
                    return digits;
                }
            }
            return digits;
        }
    }
    //35. 搜索插入位置
    public int searchInsert(int[] nums, int target) {
        if (nums.length==1){
            if (target<=nums[0]){
                return 0;
            }
            else return 1;
        }
        else{
            for (int i=0;i<nums.length-1;i++){
                if (nums[i]==target){
                    return i;
                }
                else if (nums[i]>target){
                    return i;
                }
                else{
                    if (nums[i+1]>=target) return i+1;
                }
            }
            return nums.length;
        }
    }
    //27. 移除元素
    public int removeElement(int[] nums, int val) {
        int j = nums.length - 1;
        for (int i = 0; i <= j; i++) {
            if (nums[i] == val) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i--;j--;
            }
        }
        return j + 1;
    }
    //1. 两数之和
    public int[] twoSum(int[] nums, int target) {
        for (int i=0;i<(nums.length-1);i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    //26. 删除有序数组中的重复项
    public int removeDuplicates(int[] nums) {
        int p=0;
        int q=1;
        while (q<nums.length){
            if (nums[p]==nums[q]){
                q++;
            }
            else {
                nums[p+1] = nums[q];
                p++;
            }
        }
        return p+1;
    }


}
