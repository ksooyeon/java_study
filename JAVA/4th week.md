# 4주차 : 자바가 제공하는 제어문을 학습하세요.

#### 목표

- 선택문
- 반복문
------------
#### 1. 선택문
주어진 조건 값의 결과에 따라 프로그램이 다른 명령을 수행하도록 하는 일종의 조건문  
- 모든 값, 범위를 기반으로 판단하는 if문과 달리 정수 값이나 열거된 값, 문자, 문자열만 사용 가능
- if문 : 조건식이 참인 경우 해당 코드 블록 실행  
```java
int a = 5;
if(a > 5)
  System.out.println("a는 5보다 크다");
else if(a < 5)
  System.out.println("a는 5보다 작다.");
else
  System.out.println("a는 5이다.");         // 해당 코드 실행
```  
  
- switch/case 문 : switch의 매개변수에 맞는 조건에 따라 case문 실행, 다중 if문 단점 개선  
```java
int a = 3;
switch(a){
  case 1:
    System.out.println("a는 1");
    break;                                 // switch문 종료 위해 break 키워드 반드시 사용
  case 2:
    System.out.println("a는 2");
    break; 
  case 3:
    System.out.println("a는 3");
    break; 
  default:
    System.out.println("a는 1");
    break; 
}
```
-------------
#### 2. 반복문
코드를 조건에 맞게 반복해주는 구문
- for문 : 초기화 한 값을 가지고 조건문 검사해 초기화 한 값을 증감식 조건에 따라 코드를 반복한다  
```java
for(int i=0;i<10;i++) {
    System.out.println();    // i : 0~9까지 10번 반복
}
```
- while문 : 조건 값이 참일 때까지 계속 반복. 무한루프가 발생할 수 있으므로 탈출 조건 명시해주어야 한다  
```java
int i = 0;
while(i < 10){
  i++;         // i : 0 ~ 9까지 10번 반복
}
```
- do-while문 : 구문을 먼저 실행 후 마지막에 조건 확인. 반드시 한번은 실행한다는 것이 while문과 다른 점.  
```java
int i = 0;
do {
  i++;         // i : 0 ~ 9까지 10번 반복
}while(i<10);
```
- for-each(향상된 for문) : for문보다 직관적이고 반복할 객체를 하나씩 차례로 가져와 사용하는 구조  
```java
int[] nums = {1, 2, 3, 4, 5};
for(int num : nums) {
    System.out.println(num);         // nums 배열의 원소(1~5)를 하나씩 출력
}
```
- Iterator : 자바의 Collection에 저장되어 있는 데이터를 읽어오는 방법을 표준화한 기술 중 하나. hasNext(), next(), remove() 등의 메서드 사용    
```java
Set<String> set = new HashSet<>();
set.add("hello");
set.add("world");
set.add("안녕");

Iterator<String> it = set.iterator();
while(it.hasNext()) {       // iterator에 요소가 있을 때까지
    System.out.println(it.next());    // 요소 출력 후 다음 요소로 이동
    it.remove();            // 요소 삭제
}
// 출력 순서 : 안녕 -> hello -> world
```
-------------
#### 과제  
- 과제 0. JUnit 5 학습하세요.
  - 인텔리J, 이클립스, VS Code에서 JUnit 5로 테스트 코드 작성하는 방법에 익숙해 질 것.   
    
  * JUnit 5란? 자바8 이상에서 사용 가능한 테스팅 프레임워크  
  * JUnit Life-Cycle  
    - @BeforeAll : @Test 메소드들 실행되기 전에 실행
    - @BeforeEach : 각각의 @Test 메소드 실행되기 전에 실행
    - @AfterEach : 각각의 @Test 메소드 실행된 후 실행  
    - @AfterAll : @Test 메소드들 실행된 후 실행
  * JUnit5 Feature  
    - @Test : 기본적인 테스트
    - @Disabled : 만들어놓은 테스트 무시할 때 사용
    - @DisplayNmae("원하는 이름") : 테스트 실행 시 해당 테스트의 이름을 원하는 이름으로 교체할 때 사용
    - @Nested : 계층 구조 테스트 가능(중첩 테스트 클래스)
  * Assert
    - assertAll : 여러개의 assert를 실행하게 해 실패하더라도 모든 결과를 확인할 수 있다
    - assertThrows : 예외 검증 가능
    - assertTimeout : 테스트 실행 시간 검증 가능  
 -----------------------------------------------------------------------------------------------------  
 
- 과제 1. live-study 대시 보드를 만드는 코드를 작성하세요.
  - 깃헙 이슈 1번부터 18번까지 댓글을 순회하며 댓글을 남긴 사용자를 체크 할 것.
  - 참여율을 계산하세요. 총 18회에 중에 몇 %를 참여했는지 소숫점 두자리가지 보여줄 것.  
  
  GithubApi.java  
  ```java
  import org.apache.commons.lang3.tuple.Pair;
  import org.kohsuke.github.*;

  import java.io.IOException;
  import java.util.ArrayList;
  import java.util.HashMap;
  import java.util.List;
  import java.util.Map;
  import java.util.stream.Collectors;

  import static java.util.stream.Collectors.toList;

  public class GithubApi {
      public List<Pair<String, Double>> getParticipationRates(String token, String repoName) throws IOException {
          GitHub gitHub = new GitHubBuilder().withOAuthToken(token).build();
          gitHub.checkApiUrlValidity();

          GHRepository repo = gitHub.getRepository(repoName);
          List<GHIssue> issues = repo.getIssues(GHIssueState.ALL);

          //key = name, value = cnt
          Map<String, Integer> memberCounts = new HashMap<>();
          for(GHIssue issue : issues){
              // 참여자 이름 얻기
              List<String> participantNames = issue.getComments().stream().map(comment -> {
                  try {
                      return comment.getUser().getName();
                  }catch (IOException e){
                      throw new RuntimeException(e);
                  }
              }).distinct().collect(toList());

              participantNames.forEach(name -> memberCounts.merge(name, 1, Integer::sum));
          }

          int issueCount = issues.size();
          List<Pair<String, Double>> participationRate = new ArrayList<>();
          for(String key : memberCounts.keySet()){
              participationRate.add(Pair.of(key, (double) memberCounts.get(key) / issueCount * 100));
          }
          return participationRate;
      }
  }
  ```
  GithubApiTest.java    
  ```java
  import org.apache.commons.lang3.tuple.Pair;
  import org.junit.jupiter.api.Test;

  import java.util.ArrayList;
  import java.util.List;

  import static org.junit.jupiter.api.Assertions.*;

  class GithubApiTest {
      GithubApi githubApi = new GithubApi();

      @Test
      void githubConnectionTest() {
          String token = "28a3397b2416fc79268d4df4230012d3ecff7f09";
          String repoName = "whiteship/live-study";

          List<Pair<String, Double>> rates = new ArrayList<>();
          try {
              rates = githubApi.getParticipationRates(token, repoName);
          }catch (Exception e){
              fail();
          }

          rates.forEach(rate -> System.out.println(rate.getLeft() + ": " + Math.round(rate.getRight() * 100) / 100.0));
      }
  }
  ```  
    
  ![실행1](https://user-images.githubusercontent.com/34119641/111151921-7441e000-85d3-11eb-8d37-8224584f471b.JPG)  
    
  
- 과제 2. LinkedList를 구현하세요.
  - LinkedList에 대해 공부하세요.
  - 정수를 저장하는 ListNode 클래스를 구현하세요.
  - ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.
  - ListNode remove(ListNode head, int positionToRemove)를 구현하세요.
  - boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.
  
- 과제 3. Stack을 구현하세요.
  - int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
  - void push(int data)를 구현하세요.
  - int pop()을 구현하세요.
  
- 과제 4. 앞서 만든 ListNode를 사용해서 Stack을 구현하세요.
  - ListNode head를 가지고 있는 ListNodeStack 클래스를 구현하세요.
  - void push(int data)를 구현하세요.
  - int pop()을 구현하세요.
  
- 과제 5. Queue를 구현하세요.
  - 배열을 사용해서 한번
  - ListNode를 사용해서 한번.

