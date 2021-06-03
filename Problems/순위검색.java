// query 배열의 조건에 맞고 X점 이상 받은 사람은 info에서 몇 명인지 카운트 후 리턴


// String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
// String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};


import java.util.*;
class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] result = new int[query.length];
        Map<String, List<Integer>> hm = new HashMap<>();       // <점수 제외 info로 가능한 모든 조합, 점수들 리스트>

        for(String in : info) {
          String[] split = in.split(" ");
          int score = Integer.parseInt(split[4]);

          for(int i=0;i<(1<<4);i++) {                         // 비트연산으로 조합할 수 있는 모든 key 구하기. i가 1001(2)이면 0, 3번 인덱스에 해당하는 조건이 선택되어 조합을 만듦.
            StringBuilder key = new StringBuilder();
            for(int j=0;j<4;j++)
              if((i & (1 << j)) > 0)
                key.append(split[j]);

            hm.computeIfAbsent(key.toString(), s-> new ArrayList<>()).add(score);     // value 없을 시 새로운 arraylist만들어 점수를 넣어준다
          }
        }
		
        List<Integer> empty = new ArrayList<>();
        for(Map.Entry<String, List<Integer>> entry : hm.entrySet()) {     // value인 점수 list를 오름차순으로 정렬
          entry.getValue().sort(null);
        }

        for(int i=0;i<query.length;i++) {
          String[] split = query[i].replaceAll("-", "").split(" and | ");
          String key = String.join("", split[0], split[1], split[2], split[3]);
          int score = Integer.parseInt(split[4]);

          List<Integer> list = hm.getOrDefault(key, empty);   // 현재 key에 해당하는 list를 hm으로부터 받아온다, 기존에 없다면 빈 리스트 반환

          int s = 0, e = list.size();

          while(s < e) {                // 이분 탐색을 통해 값이 일치하는 인덱스 중 가장 작은 값(lower_bound)을 찾아 list의 길이에서 빼주면 점수 이상인 사람의 수가 나온다.
            int mid = (s + e) / 2;

            if(list.get(mid) < score)
              s = mid + 1;
            else
              e = mid;
          }
          result[i] = list.size() - s;
        }
        return result;
    }
}



