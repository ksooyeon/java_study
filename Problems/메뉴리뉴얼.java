// 각 손님이 주문한 단품 요리(A, B, C ..)를 조합해 코스 형태(AB, CDE ..)로 재구성한 메뉴를 구성할 것
// (단, 메뉴는 최소 2가지 이상으로 구성, 최소 2명 이상의 손님으로부터 주문된 단품메뉴 조합에 대해서만 후보에 포함)

// String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
// int[] course = {2, 3, 4};
// String[] result = {"AC", "ACDE", "BCFG", "CDE"};


import java.util.*;
class Solution {
    static Map<String, Integer> hm = new HashMap<>();   // 각 코스에 대해 등장한 횟수 저장할 해쉬맵
    public String[] solution(String[] orders, int[] course) {
        List<String> before = new ArrayList<>();     // 정답 담을 list
	StringBuilder sb = new StringBuilder();      // orders 메뉴들로 조합해서 만든 코스 이름 생성 위한 stringbuilder

	for(String menu : orders) {
		char[] tmp = menu.toCharArray();     // orders 배열의 각 메뉴들 캐릭터 배열로 생성
		Arrays.sort(tmp);                    // 알파벳순으로 정렬
		for(int i : course)                  // 메뉴이름 속 알파벳들을 course 수만큼 조합, ex) "CDE" -> CD, CE, DE
			comb(tmp, sb, 0, 0, i);
	}

	for(int i : course) {
		Set<Map.Entry<String, Integer>> entry2 = hm.entrySet();   // hm의 key, value 연결을 set으로 반환

		int max = 0;
		for(Map.Entry<String, Integer> entry : entry2) {          // 각 엔트리에 대해 course 값과 길이가 같으면 value와 비교해 최댓값 결정 
			if(entry.getKey().length() == i)
				max = Math.max(max, entry.getValue());
		}

		for(Map.Entry<String, Integer> entry : entry2) {           // max가 1보다 크고 엔트리의 value값이 max와 같고 course와 길이가 같다면
			if(max > 1 && entry.getValue() == max && entry.getKey().length() == i)
				before.add(entry.getKey());               // before 리스트에 추가
		}
	}

	Collections.sort(before);

	String[] answer = new String[before.size()];    // 리스트 배열로 
	for(int i=0;i<before.size();i++)
		answer[i] = before.get(i);
        
        return answer;
    }
    
    public static void comb(char[] order, StringBuilder sb, int start, int n, int r) {   // 메뉴 이름 속 알파벳을 r개 만큼 뽑아 조합할 메소드
	if(n == r) {
		hm.put(sb.toString(), hm.getOrDefault(sb.toString(), 0)+1);   // 만들어진 sb 해쉬맵에 키로, 빈도수 value로 저장
		return;
	}
	    
	for(int i=start;i<order.length;i++) {   // sb가 r개 될 때까지 알파벳 조합
		sb.append(order[i]);
		comb(order, sb, i+1, n+1, r);
		sb.delete(n, n+1);
	}
    }
}




// HashMap, 조합으로 풀이
// 테스트케이스 일부 시간 초과
import java.util.*;
class Solution {
    static int max;
    static Map<String, Integer> hm;
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<String>();
	List<Character> list = new ArrayList<Character>();
	for(String order : orders) {   // orders에 등장하는 모든 알파벳 list에 저장
		for(char ch : order.toCharArray()) {
			if(!list.contains(ch))
				list.add(ch);
		}
	}
	Collections.sort(list);
	boolean[] visited;
	for(int r : course) {  // course 길이만큼 조합 만든 후 max값과 비교해 같으면 result 리스트에 해당 조합(코스명) 추가
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
    
    public static void comb(List list, boolean[] visited, int start, int r, String[] orders, int[] course) {  // list에서 나올 수 있는 조합 course 길이만큼 구하는 메소드
	if(r == 0) {
		String tmp = "";   // course 만큼 조합할 임시 문자열
		for(int i=0;i<list.size();i++) {
			if(visited[i] == true)
				tmp += list.get(i);
		}

		int count = 0;
		for(String order : orders) {
			int count2 = 0;
			for(String ch : tmp.split("")) {   // 해당 문자열 string 배열로 분리 후 한 글자씩 비교
				if(!order.contains(ch)) {   // 해당 order가 tmp 요리 중 하나라도 포함하지 않으면 break
					break;
				}
				count2 += 1; 
			}
			if(count2 == tmp.length())  // 현재 order가 tmp의 모든 요리를 포함할 경우 현재 order를 포함하기 위해 count+1
				count += 1;
		}
		if(count > 1)
			hm.put(tmp, count);   // 현재 코스요리(tmp)와 orders에 포함된 갯수(count) hm에 추가
		if(count >= max)
			max = count;          // max값 재정의
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


