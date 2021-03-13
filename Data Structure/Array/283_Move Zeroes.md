283. Move Zeroes  
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.  
Note that you must do this in-place without making a copy of the array.  

Example 1:  
Input: nums = [0,1,0,3,12]  
Output: [1,3,12,0,0]  
  
Example 2:  
Input: nums = [0]  
Output: [0]  
  
```java
import java.util.*;
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
		
        for(int num : nums) {
          if(num != 0)                      // 0이 아닌 원소들을 index의 앞부분부터 대입
            nums[index++] = num;
        }

        for(int i=index;i<nums.length;i++)  // 마지막 index 위치(0이 아닌 원소가 끝난 시점)부터 배열의 길이까지 0으로 모두 대입
          nums[i] = 0;

        System.out.println(Arrays.toString(nums));
        
    }
}
```

---------------------------------------------------------

```java
class Solution {
    public void moveZeroes(int[] nums) {
    	
    	int temp = 0, zeroCount = 0;                 // temp = 값을 바꿀 임시 변수, zeroCount = 배열 안 0의 개수
    	if(nums[0] == 0) zeroCount++;
    	
    	for(int i=1; i<nums.length; i++) {
    		if(nums[i] == 0) {                   // 현재 원소값이 0일 경우 zeroCount+1, 다음 원소로 이동
    			zeroCount++;
    			continue;
    		}
    		if(nums[i-zeroCount] == 0) {         // 현재 원소값이 0이 아니고 zeroCount 거리의 원소값이 0이면 해당 위치와 자리 변경
    			temp = nums[i];
    			nums[i] = nums[i-zeroCount];
    			nums[i-zeroCount] = temp;
    		}
    	}
    }
}
```
시간복잡도 : O(n)  
