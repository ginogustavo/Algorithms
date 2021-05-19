package sumindexes;

import java.util.Vector;

public class SumIndexes {

	public static void main(String[] args) {
		int[] ints = new int[] {2,7,11,15};
		int target = 9;
		System.out.println(new SumIndexes().twoSum(ints, target));
		System.out.println(new SumIndexes().twoSum(new int[] {3,2,4}, 6));
				

	}

	public int[] twoSum(int[] nums, int target) {
		int[] result = {0,0};
		
		for (int i = 0; i < nums.length; i++) {
			int valuei = nums[i];
			
			for (int j = 0; j < nums.length; j++) {
			
				if(i==j)
					continue;
				
				int valuej = nums[j];
				int sum = valuei + valuej;
				if(sum == target) {
					result[0] = i;
					result[1] = j;
					break;
				}
			}		
		}
		
		System.out.println(result[0] + " " + result[1]);
		return result;
	}
}
