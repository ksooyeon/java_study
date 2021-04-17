import java.util.*;
public class Player {
	int code;  // 노드의 value
	HashSet<Integer> win = new HashSet<Integer>();   // 해당 노드가 이긴 노드들의 집합
	HashSet<Integer> lose = new HashSet<Integer>();  // 해당 노드가 진 노드들의 집합
	
	public Player(int code){
		this.code = code;
	}
}
class Solution {
    public int solution(int n, int[][] results) {
        List<Player> list = new ArrayList<Player>();     // 노드들의 리스트
		
        for(int i=0;i<=n;i++) {
          list.add(new Player(i));                      // i번 선수의 노드를 list에 추가
        }

        for(int[] result : results) {
          list.get(result[0]).win.add(result[1]);        // 이긴 기록 저장
          list.get(result[1]).lose.add(result[0]);       // 진 기록 저장
        }
        for (int depth = 0; depth < n; depth++) {  // depth가 한 번 더 들어갈 수 있기 때문에 n번 반복하게 설정
            for(int i=1;i<=n;i++) {  // 1번부터 n번 선수까지
                Player pl = list.get(i);

                HashSet<Integer> winSet = new HashSet<>();   // i번 선수가 이긴 선수의 이긴 선수들에게도 이겼으므로 추가
                for(Integer win : pl.win) {
                    for(Integer w : list.get(win).win)
                        winSet.add(w);
                }
                pl.win.addAll(winSet);

                HashSet<Integer> loseSet = new HashSet<>();  // i번 선수가 진 선수의 진 선수들에게도 졌으므로 추가
                for(Integer lose : pl.lose) {
                    for(Integer l : list.get(lose).lose)
                        loseSet.add(l);
                }
                pl.lose.addAll(loseSet);
            }
        }
		
        int answer = 0;
        for(int i=1;i<=n;i++) {
          if(list.get(i).win.size() + list.get(i).lose.size() == n-1)  // 자신을 제외 이긴 선수+진 선수가 n-1과 같으면 순위가 확실하므로 answer+1
            answer += 1;
        }
        return answer;
    }
}
