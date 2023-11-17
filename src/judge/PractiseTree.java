package judge;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PractiseTree {
    public static void main(String[] args) {
        PractiseLink practiseLink = new PractiseLink();
    }


    //1448. 统计二叉树中好节点的数目
    public int goodNodes(TreeNode root) {
        return dfsGood(root, Integer.MIN_VALUE);
    }
    public int dfsGood(TreeNode r, int max){
        int n=0;
        if (r==null){
            return 0;
        }
        if (r.val>=max){
            n++;
            max=r.val;
        }
        n+=dfsGood(r.left,max)+dfsGood(r.right,max);
        return n;
    }
    //872. 叶子相似的树
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        dfsAddToList(root1, a);
        dfsAddToList(root2, b);
        return a.equals(b);
    }
    public void dfsAddToList(TreeNode r,List l){
        if (r==null) return;
        else if (r.left!=null || r.right!=null){
            dfsAddToList(r.left, l);
            dfsAddToList(r.right, l);
        }
        else {
            l.add(r.val);
        }
    }

    //104. 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        else {
            int leftH = maxDepth(root.left);
            int rightH = maxDepth(root.right);
            return Math.max(leftH,rightH)+1;
        }
    }
}
