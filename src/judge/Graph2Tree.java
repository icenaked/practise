package judge;
import java.util.*;
public class Graph2Tree {
    static class GraphNode {
        int val;
        List<GraphNode> neighbors;
        GraphNode(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }
    static class TreeNode {
        int val;
        List<TreeNode> children;
        TreeNode(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
    }
    private Map<GraphNode, TreeNode> visited = new HashMap<>();
    public TreeNode dfsBuildTree(GraphNode node) {
        if (node == null) {
            return null;
        }
        // 如果这个节点已经被访问过了，那么直接返回对应的树节点
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // 创建一个新的树节点
        TreeNode treeNode = new TreeNode(node.val);
        // 标记当前图节点已经被访问
        visited.put(node, treeNode);

        // 对每一个邻接点进行深度优先遍历
        for (GraphNode neighbor : node.neighbors) {
            treeNode.children.add(dfsBuildTree(neighbor));
        }

        return treeNode;
    }
    public static void main(String[] args) {
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        // 添加邻接节点，构造图
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node1.neighbors.add(node4);
        node2.neighbors.add(node3);
        node2.neighbors.add(node4);
        // 更多的节点和邻接点...

        Graph2Tree graph2Tree = new Graph2Tree();
        TreeNode treeRoot = graph2Tree.dfsBuildTree(node1);

        // 遍历树并打印
        printTree(treeRoot, "");
    }
    private static void printTree(TreeNode root, String prefix) {
        if (root == null) {
            return;
        }
        System.out.println(prefix + root.val);
        for (TreeNode child : root.children) {
            printTree(child, prefix + "  ");
        }
    }
}
