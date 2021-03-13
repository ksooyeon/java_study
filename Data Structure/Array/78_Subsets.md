### 78. Subsets ###

Given an integer array nums of unique elements, return all possible subsets (the power set).  
The solution set must not contain duplicate subsets. Return the solution in any order.  
  
Example 1:  
Input: nums = [1,2,3]  
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]  
  
Example 2:  
Input: nums = [0]  
Output: [[],[0]]  
  
------------------------------------------------------------------
- 백트래킹 (Backtracking) 알고리즘 : 특정조건을 만족하는 모든 경우의 수를 찾을 때 사용  
- 조건을 만족하지 않으면 부모 노드로 돌아가기 때문에 문제 풀이 시간이 단축될 수 있다  

```java
class Solution {
    public static List<List<Integer>> answer;                 // 리턴 할 answer list
    
    public List<List<Integer>> subsets(int[] nums) {
        answer = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[nums.length];
		
        for(int i=0;i<=nums.length;i++)                       // 0부터 nums의 길이만큼 까지 조합 추출해 answer에 추가
          comb(nums, visited, 0, nums.length, i);
        
        return answer;
    }
    
    public static void comb(int[] arr, boolean[] visited, int start, int n, int r) {       // r값(0~nums.length까지)에 따른 조합 구하기
        if(r == 0) { // r개의 숫자를 뽑은 경우
          List<Integer> tmp = new ArrayList<Integer>();
          for(int i=0;i<n;i++) {
            if(visited[i]) {      // visited가 참일 경우 = 조합에 뽑힌 경우
              tmp.add(arr[i]);    // 임시 리스트 tmp에 해당 원소 추가
            }
          }
          answer.add(tmp);        // answer 리스트에 r개 원소의 조합인 배열 추가
          return;
        }

        for(int i=start;i<n;i++) {          // 조합(Combination) 이용해 뽑을 원소 선택
          visited[i] = true;
          comb(arr, visited, i+1, n, r-1);
          visited[i] = false;
        }
	 }
}
```
----------------------------------------------------------------
- 비트 마스크(Bit Mask) 알고리즘 : 이진수를 사용하는 컴퓨터의 연산 방식을 이용하여, 정수의 이진수 표현을 자료 구조로 쓰는 기법
- 장점 : 수행시간 빠름, 메모리 사용량 적음, 다이나믹 프로그래밍 가능  
  
```java
 public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();    // 결과 리스트인 result

        for (int i = 0; i < 1 << nums.length; ++i) {       // (1 << nums.length) => 8, nums 배열의 전체 조합 갯수(공집합 포함), 2^nums.length
            List<Integer> subSet = new ArrayList<>();      // result에 추가할 subSet 리스트

            for (int b = 0; b < nums.length; ++b) {
                if (((i >> b) & 1) == 1) {                 // 현재 비교할 원소(b)가 지금의 i값의 이진수 표현에 포함되어 있는지 확인,  
                    subSet.add(nums[b]);                   // ex) i = 6(110), b = 2(10)일 경우 i >> b = 1(001), 1&1=1
                }
            }

            result.add(subSet);
        }

        return result;
    }
}
```

![](https://miro.medium.com/max/564/1*6sM5W2Svvd0dvB_9TjFGyg.png)  
출처 : https://medium.com/@ray644302280/leetcode-78-subsets-8ee65c0b3e54
