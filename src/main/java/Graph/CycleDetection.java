package Graph;

/**
 * Created by km on 5/27/18.
 */
public class CycleDetection {

    public void DFSRecursion(Vertex v){
        // recursion

        v.setBeingVisited(true);
        System.out.println(v.getData());

        for(Vertex neighbour: v.getNeighbours()){

            if(neighbour.isBeingVisited()){
                System.out.println(" cycle detected ");
                return;
            }

            if(! neighbour.isVisited())  {
                DFSRecursion(neighbour);
            }
        }

        v.setVisited(true);
        v.setBeingVisited(false);
    }
}

