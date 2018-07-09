package BT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by km on 6/15/18.
 */
public class VerticalPrint {

    Map<Integer, List<Node>> dataList = new HashMap<>();

    // left is -1 and right is +1
    public void VerticalPrint(Node root, int hd){

        if(root == null){
            return;
        }

        if(dataList.containsKey(hd) ){
            dataList.get(hd).add(root);
        }else{
            List<Node> n = new ArrayList<>();
            n.add(root);
            dataList.put(hd, n);
        }

        VerticalPrint(root.getLeft(),hd-1);
        VerticalPrint(root.getRight(), hd+1);

    }
}
