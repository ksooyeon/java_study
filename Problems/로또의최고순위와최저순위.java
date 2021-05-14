// lottos = [44, 1, 0, 0, 31, 25] 구매한 로또 번호
// win_nums = [31,10,45,1,6,19] 당첨 번호
// 0 -> 어느 번호든 당첨 가능
// 1~6위 중 최고, 최저 순위 리턴


class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] record = {0, 6, 5, 4, 3, 2, 1};  // 맞은 갯수에 따른 순위 인덱스별 저장
        int[] result = new int[2];

        int maxWin = 0, minWin = 0;

        for(int i=0;i<lottos.length;i++)   // 0의 갯수만큼 당첨수 증가
          if(lottos[i] == 0)
            maxWin += 1;

        for(int i=0;i<lottos.length;i++) {     // 당첨번호와 구입번호 일치만큼 최소 당첨수 증가
          for(int j=0;j<win_nums.length;j++)
            if(lottos[i] == win_nums[j])
              minWin += 1;
        }

        maxWin += minWin;          // 최대 당첨수에 최소 당첨수 추가

        for(int i=1;i<record.length;i++) {    // 각 당첨갯수에 따른 순위(인덱스) result 배열에 담기
          if(maxWin == record[i]) 
            result[0] = i;
          if(minWin == record[i])
            result[1] = i;
        }

        if(minWin == 0)            // 최소/최대 당첨수가 0일 경우 최저 순위 6 저장
          result[1] = 6;
        if(maxWin == 0)
          result[0] = 6;
            
        return result;
    }
}
