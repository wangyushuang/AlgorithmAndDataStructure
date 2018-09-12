package algorithm.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class No297 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public String toString(){
            return ""+val;
        }
    }

    @Test
    public void unitTest1() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        String s = "[5,2,3,null,null,2,4,3,1]";
        TreeNode node1 = deserialize(s);
        System.out.println(serialize(node1));
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result.toString();
        }
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove(0);
            if (node == null) {
                result.add(null);
            } else {
                result.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            //判断queue中是否全为null
            int i = 0;
            for (; i < queue.size(); i++) {
                if (queue.get(i) != null)
                    break;
            }
            if (i == queue.size())
                break;
        }
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data = data.substring(1, data.length() - 1);//去掉中括号
        if ("".equals(data))
            return null;
        String[] valStrs = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(valStrs[0].trim()));
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean left = true;//标记左右子树
        int i = 1;//节点标号
        TreeNode parent = null;
        while (i < valStrs.length) {
            String valStr = valStrs[i++].trim();
            TreeNode child = null;
            if (!valStr.equals("null")) {
                child = new TreeNode(Integer.parseInt(valStr));
                queue.add(child);
            }
            if (left) {
                parent = queue.remove(0);
                if (parent != null) {
                    parent.left = child;
                }
                left = false;
            } else {
                if (parent != null) {
                    parent.right = child;
                }
                left = true;
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));