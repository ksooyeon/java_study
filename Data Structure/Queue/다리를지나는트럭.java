import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int idx = 0;

        Queue<int[]> q = new LinkedList<int[]>();      // 다리를 지나는 트럭들을 담을 q 정의

        while(idx < truck_weights.length) {       // truck_weights의 원소들을 다 확인할 때까지
            if(!q.isEmpty() && q.peek()[1] == time) {    // q가 빈 공간이 아니고 front 트럭의 통과 시간이 현재 시간과 같을 때
                int[] tmp = q.poll();                    // front 삭제
                weight += tmp[0];                        // 다리가 현재 견딜 수 있는 무게에 통과한 트럭의 무게 증가
            }

            if(weight >= truck_weights[idx]){           // 현재 트럭의 무게가 weight보다 작을 때
                q.add(new int[] {truck_weights[idx], time+bridge_length});    // q에 [현재 트럭무게, 다리를 다 통과하는 시간]으로 추가
                weight -= truck_weights[idx++];                               // 다리가 버틸 수 있는 무게에 현재 트럭에 무게 빼기
            }
            
            time++;                                                           // 하나씩 체크할 때마다 time 증가
        }
        
        return time + bridge_length;                  // 현재 시간(time)에 마지막 트럭이 통과하는 시간(bridge_length) 추가
    }
}
