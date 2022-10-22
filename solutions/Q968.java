// import java.util.HashSet;

class Q968 {

    // 0 -> need camera
    // 1 -> is camera
    // 2 -> has surveillance
    public int minCameraCover(TreeNode root) {
        if(root.left == null && root.right == null) {
            return 1;
        }
        
        if(solve(root) == 0) {
            count++;
        }
        return count;
    }
    
    int count = 0;
    public int solve(TreeNode node){
        
        if(node == null) {
            return 2;
        }
            
        int left = solve(node.left);
        int right = solve(node.right);
        
        if(left == 0 || right == 0){ // even if one needs a camera then I put a camera
            count++;
            return 1;       
            
        } else if(left == 1 || right == 1){ // even if one has a camera then I'm safe
            return 2;     
            
        } else{ // if both are surveilled then I need a camera
            return 0;
        }
    }

    // int count;
    // HashSet<TreeNode> covered;

    // public int minCameraCover(TreeNode root) {
    //     if (root == null){
    //         return 0;
    //     }

    //     this.count = 0;
    //     this.covered = new HashSet<>();
    //     this.covered.add(null);
    //     _dfs(root, null);
    //     return this.count;
    // }

    // private void _dfs(TreeNode cur, TreeNode parent){
    //     if (cur == null){
    //         return;
    //     }
    //     _dfs(cur.left, cur);
    //     _dfs(cur.right, cur);

    //     if ((parent == null && !this.covered.contains(cur)) || !this.covered.contains(cur.left) || !this.covered.contains(cur.right)){
    //         this.count++;
    //         this.covered.add(parent);
    //         this.covered.add(cur);
    //         this.covered.add(cur.left);
    //         this.covered.add(cur.right);
    //     }
    //     return;
    // }

    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(0);
        root.left.right = new TreeNode(0);
        root.left.right.left = new TreeNode(0);
        root.left.right.left.right = new TreeNode(0);
        root.left.right.left.right.left = new TreeNode(0);
        Q968 camera = new Q968();
        System.out.println(camera.minCameraCover(root));
    }
}