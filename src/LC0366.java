//Definition for a binary tree node.

import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//I implemented the method appeared in discussion and the solution
class LC0366{
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        level(res, root);
        return res;
    }
    private int level(List<List<Integer>> res, TreeNode node){
        if (node == null) return -1;
        // if this isn't null, 1. get its level, 2. add this node to res, and 3. return the level
        int lv = Math.max(level(res,node.left),level(res,node.right))+1;//find the level of this node;
        if (res.size() == lv) res.add(new ArrayList<Integer>());
        res.get(lv).add(node.val);
        return lv;
    }
}

//This is my original soltuion, I didn't use the level of the tree, and only used recursion to solve the problem.
/*
public class LC0366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        while(root.left!=null || root.right != null){
            List<Integer> a = new ArrayList<>();
            if (root.left!=null) a.addAll(IsLeaf(root,true));
            if (root.right!=null) a.addAll(IsLeaf(root,false));
            res.add(a);
        }
        List<Integer> a = new ArrayList<>();
        a.add(root.val);
        res.add(a);
        return res;
    }
    private List<Integer> IsLeaf(TreeNode prec, boolean dir){//dir == true -> left side
        TreeNode node = dir? prec.left:prec.right;
        List<Integer> a = new ArrayList<>();
        if (node.left == null && node.right == null){
            //node is a leaf;
            if (dir) prec.left = null;
            else prec.right = null;
            a.add(node.val);
            return a;
        }
        else if (node.left != null && node.right == null) return IsLeaf(node,true);
        else if (node.left != null && node.right != null) {
            a.addAll(IsLeaf(node, true));
            a.addAll(IsLeaf(node, false));
            return a;
        }
        else return IsLeaf(node,false);
    }
}
*/