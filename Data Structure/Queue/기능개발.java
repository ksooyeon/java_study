import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] work = new int[progresses.length];
		
        List<Integer> answer = new ArrayList<Integer>();

        for(int i=0;i<progresses.length;i++) {
          work[i] = (int)Math.ceil((double)(100 - progresses[i]) / speeds[i]);    // 작업이 완료되는 기간 work 배열에 저장
        }

        int comp = work[0];        // 뒤 원소들과 대소 비교하기 위해 첫번째 원소로 초기화

        int day = 1;
        int idx = 1;
        while(idx < work.length) {
          if(work[idx] <= comp)    // 현재 원소가 comp보다 작거나 같으면 배포 날짜 +1
            day += 1;
          else {                   // 현재 원소가 comp보다 클 경우
            answer.add(day);       // 지금까지의 배포 일수 answer list에 삽입
            day = 1;               // 배포 일수 1로 초기화
            comp = work[idx];      // 비교값 현재 원소값으로 초기화
          }
          idx++;
        }
        
        answer.add(day);

        int[] result = new int[answer.size()];
        for(int i=0;i<answer.size();i++)
            result[i] = answer.get(i);

        return result;
    }
}
