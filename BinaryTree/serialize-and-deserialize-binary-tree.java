https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class Codec {
    
//input:
//    1
//   /\
//  2  5
// / \
//3   4

//preorder is 1,2,3,#,#,4,#,#,5,#,#
//Make sure to add # when there is null
//
    
    

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
     StringBuilder SB = new StringBuilder();
     String str = helper(SB,root).toString();
        System.out.println(str);
        return str;
    }
    
    //do a preorder traversal
    StringBuilder helper(StringBuilder SB , TreeNode root) {
        if(root == null) return SB.append('#');
        SB.append(root.val).append(',');
        helper(SB,root.left).append(',');//this "," will kick in after we come out
        helper(SB,root.right);
        return SB;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //this one line is enough to split string based on ',' and create a
        //queue out of it.
        return dhelper(new LinkedList<>(Arrays.asList(data.split(","))));
    
        
        /*
        understandable code
        String[] arrOfStr = data.split(",");
        Queue<String> Q = new LinkedList<>();
        //put all the strings into a queue
        for(String S : arrOfStr) {
            Q.offer(S);
        }
        return dhelper(Q);
        */
    }
    
    TreeNode dhelper(Queue<String> Q) {
        String str  = Q.poll(); 
        if("#".equals(str)){
           return null; 
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = dhelper(Q);
        node.right = dhelper(Q);
        return node;    
    }
}
