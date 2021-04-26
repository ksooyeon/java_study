// 초 단위로 기록된 주식가격이 떨어지지 않은 기간 리턴
// [1, 2, 3, 2, 3] -> [4, 3, 1, 1, 0]

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int count = 0;
        answer[answer.length-1] = 0;   // 마지막 원소는 무조건 0
        
        for(int i=0;i<prices.length-1;i++) {
            count = 0;     // 떨어지지 않은 기간 셀 count 변수
            for(int j=i+1;j<prices.length;j++) {
                if(prices[i] <= prices[j]) // 가격이 떨어지지 않았으므로 count+1
                  count++;
                else{        // count 초기값이 0이므로 자신의 기간 포함하도록 count+1 후 break
                    count++;
                    break;
                }
             }
              answer[i] = count;  // answer 배열에 count 값으로 초기화
          }
      
        return answer;
    }
}
