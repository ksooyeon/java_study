import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();  //각 노드의 연결정보 담을 list
        for(int i=0;i<edge.length;i++)
          list.add(new ArrayList<Integer>());

        int a, b;
        for(int[] node : edge) {        // 각 노드 번호에 연결된 노드 번호 저장
          a = node[0];
          b = node[1];
          list.get(a).add(b);
          list.get(b).add(a);
        }

        int[] count = new int[n+1];     // 1부터의 거리 담겨있는 count 배열
        boolean[] visit = new boolean[n+1];  // 방문 여부 확인할 visited 배열

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[0] = visit[1] = true;

        int now;
        while(!q.isEmpty()) {
          now = q.poll();
          for(int v : list.get(now)) {
            if(!visit[v]) {
              count[v] = count[now] + 1;    // now 노드와 연결되어 있고 방문한 적 없다면 v노드에 now 거리+1 저장
              visit[v] = true;
              q.add(v);           // 방문 처리 된 v 노드 q에 삽입
            }
          }
        }
        int max = 0;
        int answer = 0;
        for(int cnt : count) {     // 최대 거리 구한 후 같은 값 가진 노드 수 구하기
          if(max < cnt) {
            max = cnt;
            answer = 1;
          }
          else if(max == cnt) answer++;
        }
         return answer;
    }
}
