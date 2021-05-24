// 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
// 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
// 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
// 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
// 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
// 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
// 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

// String new_id = "...!@BaT#*..y.abcdefghijklm";
// String result = "bat.y.abcdefghi";


import java.util.*;
class Solution {
    public String solution(String new_id) {
        String id = new_id.toLowerCase();          // 1단계 : 모두 소문자로 치환
        
        id = id.replaceAll("[^-_.a-z0-9]", "");    // 2단계 : 소문자, 숫자, 빼기, 밑줄, 마침표 제거
        id = id.replaceAll("[.]{2,}", ".");        // 3단계 : 마침표가 두 번 이상일 시 하나의 마침표로 치환
        id = id.replaceAll("^[.]|[.]$", "");       // 4단계 : 처음이나 끝에 마침표가 있으면 제거
        
        if(id.equals(""))                          // 5단계 : 빈 문자열이면 a 대입
            id += "a";
        
        if(id.length() >= 16){                     // 6단계 : 길이가 16자 이상이면 첫 15개 제외 모두 제거
            id = id.substring(0, 15);
            id = id.replaceAll("^[.]|[.]$", "");
        }
        
        if(id.length() <= 2)                       // 7단계 : 길이가 2자 이하면 길이가 3이 될때까지 마지막 문자 반복해서 
            while(id.length() < 3)
                id += id.charAt(id.length() - 1);
        
        return id;
    }
}
