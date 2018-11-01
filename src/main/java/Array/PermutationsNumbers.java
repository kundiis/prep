package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsNumbers {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();
        permutations(nums, new ArrayList<>(), output);
        return output;

    }

    private void permutations(int[] nums, List<Integer> newList, List<List<Integer>> output ){

        if(nums.length == 0){
            System.out.println(" pair-->"+ newList);
            output.add(newList);
        }else {
            for (int i = 0; i < nums.length; i++) {
                int current = nums[i];

                int[] remainingPart1 = Arrays.copyOfRange(nums, 0, i);
                int[] remainingPart2 = Arrays.copyOfRange(nums, i + 1, nums.length);

                int[] array1and2 = new int[remainingPart1.length + remainingPart2.length];
                System.arraycopy(remainingPart1, 0, array1and2, 0, remainingPart1.length);
                System.arraycopy(remainingPart2, 0, array1and2, remainingPart1.length, remainingPart2.length);

                List<Integer> newArrayList = new ArrayList<>();
                newArrayList.addAll(newList);
                newArrayList.add(current);
                //System.out.println("remaining -->" + Arrays.toString(remaining));
                //System.out.println(newArrayList);

                permutations(array1and2, newArrayList, output);
            }
        }
    }

    public static void main(String[] args) {
        PermutationsNumbers numbers = new PermutationsNumbers();
       // numbers.permute(new int[]{1,2,3});

        numbers.permute2(new int[]{1,2,3});
    }

    public List<List<Integer>> permute2(int[] nums) {

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> input = new ArrayList<>();
        for(int i = 0; i< nums.length; i++){
            input.add(nums[i]);
        }
        permutations2(input, new ArrayList<>(), output);
        return output;

    }

    private void permutations2(List<Integer> input, List<Integer> numbers, List<List<Integer>> output) {

        if(input.isEmpty()){
            output.add(numbers);
            System.out.println(" pair-->"+ numbers);
            return;
        }
        for(int i = 0; i< input.size(); i++){

            int n = input.get(i);
            List<Integer> newInput = new ArrayList<>();
            newInput.addAll(input.subList(0, i));
            newInput.addAll(input.subList(i+1, input.size()) );

            List<Integer> newArrayList = new ArrayList<>();
            newArrayList.add(n);
            newArrayList.addAll(numbers);

            permutations2(newInput, newArrayList, output);
        }
    }

}

