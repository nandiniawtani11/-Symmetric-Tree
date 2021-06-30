/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root.left==null && root.right==null)
            return true;
        if(root.left==null && root.right!=null)
            return false;
         if(root.left!=null && root.right==null)
            return false;
        else if(root.left.val!=root.right.val)
            return false;    
        Queue<TreeNode> q1=new LinkedList<>();
        Queue<TreeNode> q2=new LinkedList<>();
        q1.add(root.left);
        q2.add(root.right);
        TreeNode temp1=null;
        TreeNode temp2=null;
        while(!q1.isEmpty() && !q2.isEmpty())
        {
            temp1=q1.peek();
            q1.remove();
            temp2=q2.peek();
            q2.remove();
            if(temp1!=null && temp2!=null)
            {
                if(temp1.val==temp2.val)
                {
                    q1.add(temp1.left);
                    q1.add(temp1.right);
                    q2.add(temp2.right);
                    q2.add(temp2.left);
                }
                else
                    return false;      
            }
            else if(temp1==null && temp2==null)
                continue;
            else if(temp1!=null || temp2!=null)
                return false;       
        }
        return true;
        
    }
}
