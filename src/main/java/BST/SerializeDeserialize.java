package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserialize {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // level order traversal
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> builder = new ArrayList();

        if(root!=null){
            Queue<TreeNode> q1 = new LinkedList<>();
            q1.add(root);
            while(!q1.isEmpty()){
                TreeNode t = q1.poll();
                if(t!=null){
                    builder.add(t.val+"");
                    q1.add(t.left);
                    q1.add(t.right);
                }else{
                    builder.add("#");
                }
            }
        }
        String output = String.join(",", builder);
        return output;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0)
            return null;

        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i=1;
        while(!queue.isEmpty()){
            TreeNode t = queue.poll();

            if(t==null)
                continue;

            // root, left, right - put left in q and then right

            // for the left element
            if(!arr[i].equals("#")){
                t.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(t.left);
            }else{
                t.left = null;
                queue.offer(null);
            }
            i++;

            // for the right element
            if(!arr[i].equals("#")){
                t.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.offer(t.right);
            }else{
                t.right = null;
                queue.offer(null);
            }
            i++;
        }
        return root;
    }
}
