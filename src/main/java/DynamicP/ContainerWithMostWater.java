package DynamicP;

public class ContainerWithMostWater {

    //https://www.youtube.com/watch?v=cdRaaEYk6tI

    public int maxArea(int[] height) {

        int maxArea = 0;
        if(height == null) return maxArea;

        int left = 0;
        int right = height.length-1;

        while(left < right){
            int area = (right -left) * Math.min(height[left], height[right]);  // area formula
            maxArea = Math.max(area, maxArea);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }

        }

        return maxArea;

    }

}
