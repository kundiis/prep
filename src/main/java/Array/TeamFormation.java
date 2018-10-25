package Array;

import java.util.*;

public class TeamFormation {

    private static int findMin(int[] array){

        if(array.length == 0) return 0;

        Map<Integer, Integer> tree = new TreeMap<>();
        for(int i : array){
            tree.put(i, tree.getOrDefault(i, 0)+1);
        }

        List<List<Integer>> output = new ArrayList<>();

        while(true) {
            for (int num : tree.keySet()) {
                if (tree.get(num) > 0) {
                    List<Integer> whatCanBeAdded = whatCanBeAdded(tree, num);
                    reduceFrequencies(tree, whatCanBeAdded);
                    output.add(whatCanBeAdded);
                }
            }
            boolean processComplete = true;
            for(int num : tree.keySet()){
                if(tree.get(num) > 0){
                    processComplete = false;
                }
            }
            if(processComplete){
                break;
            }
        }

        System.out.println(output);
        return 0;
    }

    private static void reduceFrequencies(Map<Integer,Integer> tree, List<Integer> whatCanBeAdded) {
        for(int x : whatCanBeAdded){
            tree.put(x, tree.get(x)-1);
        }
    }

    private static List<Integer> whatCanBeAdded(Map<Integer,Integer> tree, int num) {
        List<Integer> result = new ArrayList<>();
        int start = num;
        while(true){
            if(tree.containsKey(start) && tree.get(start) > 0){
                result.add(start);
                start+=1;
            }else{
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] x = {4, 5, 2, 3, -4, -3, -5 };
        findMin(x);
    }
}
