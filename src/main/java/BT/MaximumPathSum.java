package BT;


//https://algorithms.tutorialhorizon.com/given-a-binary-tree-find-the-maximum-path-sum-between-any-two-leaves/
public class MaximumPathSum {
    class Max{
        int max = Integer.MIN_VALUE;
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }

    public int maxPathSum(TreeNode root) {
        Max m = new Max();
        findMax(root, m);
        return m.max;
    }

    private Integer findMax(TreeNode root, Max m){

        if(root == null){
            return 0;
        }

        // post order traversal
        int leftSum = findMax(root.left, m);
        int rightSum = findMax(root.right,m );

        //max of left +root or right+root or root or root+left+right
        int maxData = Math.max(root.val, Math.max(leftSum, rightSum)+root.val);
        int maxSingle = Math.max(maxData, root.val+leftSum+rightSum);

        m.max = Math.max(maxSingle, m.max);
        //System.out.println(m.max);

        return maxData;

    }
}
