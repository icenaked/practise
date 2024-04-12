package judge;
import java.util.*;
public class BST2Link {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    private TreeNode prev = null;

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;

        TreeNode dummy = new TreeNode(0); // 哑节点作为双向链表的头节点
        prev = dummy;

        convert(root);

        // 完成链表的循环
//        prev.right = dummy.right;
//        dummy.right.left = prev;

        return dummy.right;
    }

    private void convert(TreeNode currentNode) {
        if (currentNode == null) return;
        // 遍历左子树
        convert(currentNode.left);
        // 修改当前节点与前驱节点的指针
        prev.right = currentNode;
        currentNode.left = prev;
        // 更新前驱节点
        prev = currentNode;
        // 遍历右子树
        convert(currentNode.right);
    }

    public static void main(String[] args) {
        BST2Link converter = new BST2Link();
        // 构建BST
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        // 转换为双向链表
        TreeNode head = converter.treeToDoublyList(root);
        // 打印转换后的双向链表，从头节点开始
        TreeNode current = head;
        while (current != null) {
            System.out.print(current.val + "==");
            current = current.right;
            if (current == head) break; // 如果链表是循环的，则停止循环
        }
    }
}
