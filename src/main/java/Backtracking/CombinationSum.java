package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        getCombinations(candidates, new ArrayList<>(), 0, target);
        return result;
    }

    private void getCombinations(int[] nums, List<Integer> newList, int pos ,int target) {

        if(target == 0){
            System.out.println("Output-->"+ newList);
            result.add(new ArrayList<>(newList));
            return;
        }
        if(target < 0) return;

        for(int i = pos; i< nums.length; i++){

            if(i> pos && nums[i] == nums[i-1]) continue;

            if(nums[i] > target) {
                return;
            }

            newList.add(nums[i]);
            System.out.println("before -->"+ i + "-->" + newList);

            getCombinations(nums, newList, i+1, target-nums[i]);
            newList.remove(newList.size()-1);

            System.out.println("--->after -->"+ i + "-->" +newList);
        }
    }

    public static void main(String[] args) {
        CombinationSum sum = new CombinationSum();
        sum.combinationSum(new int[]{ 1,1,2,5, 6, 7}, 8);  // 1,1,2,5,6,7
    }
}
