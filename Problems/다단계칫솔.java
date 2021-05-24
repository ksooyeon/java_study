// 한 회원이 판매한 칫솔 갯수에 따른 수익을 자신을 추천한 회원에게 10% 분배, 
// 분배받은 회원 또한 해당 분배에 대해 자신을 소개한 회원에게 10% 분배.
// - : 상위 회원이 없음


// String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};  : 다단계 회원 순서
// String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};    : 해당 회원을 추천한 회원
// String[] seller = {"young", "john", "tod", "emily", "mary"};  : 판매한 회원 명단
// int[] amount = {12, 4, 2, 5, 10}; : 판매한 회원의 판매 갯수


import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] result = new int[enroll.length];
		
        Map<String, String> parent = new HashMap<String, String>();           // <회원, 추천회원>
        Map<String, Integer> memberIndex = new HashMap<String, Integer>();    // <회원, 인덱스>, 같은 회원명이 나올 수 있으므로 인덱스로 구분

        for(int i=0;i<enroll.length;i++) {
          parent.put(enroll[i], referral[i]);
          memberIndex.put(enroll[i], i);
        }

        for(int i=0;i<seller.length;i++) {
          String now = seller[i];          // 현재 판매 회원 이름
          int price = amount[i] * 100;     // 칫솔 한 개당 100원 이익

          while(!now.equals("-")) {       // 상위 회원이 없을 때까지 반복
            int forParent = price / 10;   // 추천 회원에게 분배할 10%
            int forChild = price - forParent;   // 자신이 가질 이익

            result[memberIndex.get(now)] += forChild;   // 해당 회원명을 키로 가진 값의 인덱스에 90%의 이익 할당

            now = parent.get(now);     // 현재 회원명을 자신을 추천한 회원의 이름으로 변경
            price /= 10;               // 현재 분배값의 10%로 설정

            if(price < 1)              // 값이 1 미만일 경우 자신이 가지고 끝나므로 break
              break;
          }

        }
        return result;
    }
}
