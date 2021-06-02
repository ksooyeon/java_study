// 각 손님이 주문한 단품 요리(A, B, C ..)를 조합해 코스 형태(AB, CDE ..)로 재구성한 메뉴를 구성할 것
// (단, 메뉴는 최소 2가지 이상으로 구성, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 후보에 포함)

// String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
// int[] course = {2, 3, 4};
// String[] result = {"AC", "ACDE", "BCFG", "CDE"};


// HashMap, 조합으로 풀이
// 테스트케이스 일부 시간 초과
import java.util.*;
class Solution {
    static int max;
	static Map<String, Integer> hm;
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<String>();
		List<Character> list = new ArrayList<Character>();
		for(String order : orders) {
			for(char ch : order.toCharArray()) {
				if(!list.contains(ch))
					list.add(ch);
			}
		}
		Collections.sort(list);
		boolean[] visited;
		for(int r : course) {
			hm = new HashMap<String, Integer>();
			max = Integer.MIN_VALUE;
			visited = new boolean[list.size()];
			comb(list, visited, 0, r, orders, course);
			for(String key : hm.keySet())
				if(hm.get(key) == max)
					result.add(key);
		}
		Collections.sort(result);
		String[] answer = new String[result.size()];
		for(int i=0;i<result.size();i++)
			answer[i] = result.get(i);
        
        return answer;
    }
    
    public static void comb(List list, boolean[] visited, int start, int r, String[] orders, int[] course) {
		if(r == 0) {
			String tmp = "";
			for(int i=0;i<list.size();i++) {
				if(visited[i] == true)
					tmp += list.get(i);
			}

			int count = 0;
			for(String order : orders) {
				int count2 = 0;
				for(String ch : tmp.split("")) {
					if(!order.contains(ch)) {
						break;
					}
					count2 += 1;
				}
				if(count2 == tmp.length())
					count += 1;
			}
			if(count > 1)
				hm.put(tmp, count);
			if(count >= max)
				max = count;
			return;
		}
		else {
			for(int i=start; i<list.size();i++) {
				visited[i] = true;
				comb(list, visited, i+1, r-1, orders, course);
				visited[i] = false;
			}
		}
	}
}















