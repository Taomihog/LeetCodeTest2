import java.util.*;
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> sub= new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++){
            if (sub.containsKey(target-nums[i])) return new int[]{i,sub.get(target-nums[i])};
            sub.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}