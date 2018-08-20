package org.nix.learn.tree;

/**
 * @author zhangpei
 * @version 1.0
 * @date 2018/8/18
 */
public class Depth {



    public int maxDepth(TreeNode root) {
        int hl,hr,hmax;
        if (root!=null){
            hl = maxDepth(root.left);
            hr = maxDepth(root.right);
            hmax = hl>hr?hl:hr;
            return hmax+1;
        }
        return 0;
    }

    public boolean isValidBST(TreeNode root) {
        if (root!=null){

        }
        return false;
    }
}
