169. Majority Element  
  
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:  
Input: nums = [3,2,3]  
Output: 3  

Example 2:  
Input: nums = [2,2,1,1,1,2,2]  
Output: 2  
  
----------------------------------------------------------------------

```java
import java.util.HashMap;
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		for(int i=0;i<nums.length;i++) {                      // Hash Map에 각 원소를 key로, 빈도수를 value로 저장
			if(!hm.containsKey(nums[i]))
				hm.put(nums[i], 1);
			else
				hm.put(nums[i], hm.get(nums[i])+1);
		}
		
		int answer = 0;
		for(int key : hm.keySet()) {
			if(hm.get(key) > nums.length/2)               // value값이 2/n 이상인 key 값 answer에 저장
				answer = key;
		}
        
        return answer;
    }
}
```
시간, 공간 복잡도 : O(n)  

----------------------------------------------------------------------
[Boyer-Moore majority vote algorithm]  
- 현재 candidate가 재등장하면 count+1  
- 현재 candidate와 현재 위치 변수값이 다르면 count-1
- count가 0이면 현재 변수를 candidate로 지정  
  
```java
public int majorityElement3(int[] nums) {
    int count = 0, ret = 0;
    for (int num: nums) {
        if (count == 0)
            ret = num;
        if (num!=ret)
            count--;
        else
            count++;
    }
    return ret;
}
```
공간복잡도 : O(1)  
