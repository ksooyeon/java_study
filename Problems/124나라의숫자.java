//10진수의 숫자를 1,2,4로만 표현
//1->1, 2->2, 3->4, 4->11, ...



class Solution {
  public String solution(int n) {
      String[] rem = {"4", "1", "2"};     // 3의 배수인 10진수는 규칙상 무조건 4로 끝나므로 인덱스가 0인 자리에 4를 배치
	    String answer = "";
		
      while(n != 0) {
          answer = rem[n % 3] + answer;   // answer 문자열에 n을 3으로 나눈 나머지의 인덱스에 해당하는 숫자를 입력
          if(n % 3 == 0) n -= 1;          // 나머지가 0일 경우 자리수가 바뀌므로 n 값에 1만큼 빼준다.

          n /= 3;                         // 표현식이 3개이므로 3으로 나누어 다음 연산 실행
      }
      return answer;
  }
}
