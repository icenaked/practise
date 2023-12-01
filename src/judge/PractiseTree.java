package judge;

import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PractiseTree {
    public static void main(String[] args) {
        PractiseTree practiseTree = new PractiseTree();

        TreeNode t1 =new TreeNode(3);
        TreeNode t2 =new TreeNode(-2);
        TreeNode t3 =new TreeNode(3,t1,t2);
        TreeNode t4 =new TreeNode(1);
        TreeNode t5 =new TreeNode(2,null,t4);
        TreeNode t6 =new TreeNode(5,t3,t5);
        TreeNode t7 =new TreeNode(11);
        TreeNode t8 =new TreeNode(-3,null,t7);
        TreeNode t9 =new TreeNode(10,t6,t8);
        int a=practiseTree.pathSum(t9,8);
    }


    //236. 二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
    //1372. 二叉树中的最长交错路径
    public int longestZigZag(TreeNode root) {
        return Math.max(dfs(root.left, 1, true), dfs(root.right, 1, false)) - 1;
    }
    public int dfs(TreeNode root, int num, boolean left) {
        if (root == null)
            return num;
        if (left) {
            return Math.max(dfs(root.left, 1, true), dfs(root.right, num + 1, false));
        } else {
            return Math.max(dfs(root.left, num + 1, true), dfs(root.right, 1, false));
        }
    }
    //437. 路径总和 III
    public int pathSum(TreeNode root, int targetSum) {
        return dfsSum(root, (long) targetSum);
    }
    public int dfsSum(TreeNode t, long target){
        if (t==null){
            return 0;
        }
        if (t.val==target) {
            System.out.println("a"+t.val);
            return 1+dfsSum2(t.left, target-t.val)+dfsSum2(t.right, target-t.val) + dfsSum(t.left, target)+dfsSum(t.right, target);
        }
        else return dfsSum2(t.left, target-t.val)+dfsSum2(t.right, target-t.val) + dfsSum(t.left, target)+dfsSum(t.right, target);
    }
    public int dfsSum2(TreeNode t, long target){
        if (t==null){
            return 0;
        }
        if (t.val==target) {
            System.out.println("b"+t.val+"  "+target);
            return 1+dfsSum2(t.left, target-t.val)+dfsSum2(t.right, target-t.val);
        }
        else return dfsSum2(t.left, target-t.val)+dfsSum2(t.right, target-t.val);
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
