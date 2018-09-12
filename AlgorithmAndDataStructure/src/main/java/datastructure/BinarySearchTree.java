package datastructure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by WYS on 2018/5/31.
 */
public class BinarySearchTree {


    int val;
    public BinarySearchTree left = null;
    public BinarySearchTree right = null;
    public BinarySearchTree parent = null;

    public BinarySearchTree() {
    }

    public BinarySearchTree(int val) {
        this.val = val;
    }

    public BinarySearchTree maximum(BinarySearchTree bst) {
        BinarySearchTree treeNode = bst;
        while (treeNode.right != null) {
            treeNode = treeNode.right;
        }
        return treeNode;
    }

    public BinarySearchTree minimum(BinarySearchTree bst) {
        BinarySearchTree treeNode = bst;
        while (treeNode.left != null) {
            treeNode = treeNode.left;
        }
        return treeNode;
    }

    /**
     * 寻找后继节点
     *
     * @param bst 当前节点
     * @return 当前节点的后继节点
     */
    public BinarySearchTree successor(BinarySearchTree bst) {
        if (bst == null)
            return null;
        if (bst.right != null) {
            return minimum(bst.right);
        }
        BinarySearchTree cNode = bst;
        BinarySearchTree pNode = bst.parent;
        while (pNode != null && pNode.right == cNode) {
            cNode = pNode;
            pNode = pNode.parent;
        }
        return pNode;
    }

    public BinarySearchTree predecessor(BinarySearchTree bst) {
        if (bst == null)
            return null;
        if (bst.left != null) {
            return maximum(bst.left);
        }
        BinarySearchTree cNode = bst;
        BinarySearchTree pNode = bst.parent;
        while (pNode != null && pNode.left == cNode) {
            cNode = pNode;
            pNode = pNode.parent;
        }
        return pNode;
    }

    public void insert(BinarySearchTree bst, int val) {
        BinarySearchTree newNode = new BinarySearchTree(val);
        if (bst == null) {
            bst = newNode;
            return;
        }
        BinarySearchTree cNode = bst;
        BinarySearchTree pNode = cNode;
        while (cNode != null) {
            pNode = cNode;
            if (val < cNode.val) {
                cNode = cNode.left;
            } else {
                cNode = cNode.right;
            }
        }
        if (val < pNode.val) {
            pNode.left = newNode;
        } else {
            pNode.right = newNode;
        }
        newNode.parent = pNode;
    }

    public void delete(BinarySearchTree bst) {
        if (bst.left == null) {
            transplant(bst, bst.right);
            return;
        }
        if (bst.right == null) {
            transplant(bst, bst.left);
            return;
        }
        BinarySearchTree replaceNode = minimum(bst.right);
        if (bst.right != replaceNode) {
            transplant(bst, bst.right);
            replaceNode.right = bst.right;
            bst.right.parent = replaceNode;
        }
        transplant(bst, replaceNode);
        replaceNode.left = bst.left;
        bst.left.parent = replaceNode;
    }

    /**
     * node2替换node1并成为其双亲节点的孩子节点
     *
     * @param node1 被替换节点
     * @param node2 替换节点
     */
    public void transplant(BinarySearchTree node1, BinarySearchTree node2) {
        if (node1 == null) {
            node1 = node2;
            return;
        }
        if (node1.parent.left == node1) {
            node1.parent.left = node2;
        } else {
            node1.parent.right = node2;
        }
        node2.parent = node1.parent;
    }

    @Override
    public String toString() {
        if (this == null)
            return "";
        List<BinarySearchTree> list1 = new ArrayList<>();
        List<BinarySearchTree> list2 = new ArrayList<>();
        String result = "";
        list1.add(this);
        BinarySearchTree tmp = null;
        while (!list1.isEmpty() || !list2.isEmpty()) {
            while (!list1.isEmpty()) {
                tmp = list1.remove(0);
                if (tmp != null) {
                    list2.add(tmp.left);
                    list2.add(tmp.right);
                    result += tmp.val + " ";
                } else
                    result += "  ";
            }
            result += "\n";
            while (!list2.isEmpty()) {
                tmp = list2.remove(0);
                if (tmp != null) {
                    list1.add(tmp.left);
                    list1.add(tmp.right);
                    result += tmp.val + " ";
                } else {
                    result += "  ";
                }
            }
            result += "\n";
        }
        return result;
    }
}
