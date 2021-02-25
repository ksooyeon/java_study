# 1주차 : 자바 소스 파일(.java)을 JVM으로 실행하는 과정 이해하기

#### 목표

- JVM이란 무엇인가
- 컴파일 하는 방법
- 실행하는 방법
- 바이트코드란 무엇인가
- JIT 컴파일러란 무엇이며 어떻게 동작하는지
- JVM 구성 요소
- JDK와 JRE의 차이

------------


#### 1. JVM이란 무엇인가
자바 가상 머신(Java Virtual Machine): 자바로 작성 된 프로그램을 운영체제에 맞게 실행할 수 있도록 하는 프로그램.  
(단, 자바 가상 머신은 운영체제에 종속적이므로 각 운영체제에 맞는 자바 가상 머신을 설치해야 한다.)  
 
 단점: 자바 가상 머신을 한 단계 더 거쳐야 하므로 상대적으로 실행 속도가 느림.  
  
![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbcIXTU%2FbtqMOyctXyu%2FhntrUedTHkmx1S0HA3QNRK%2Fimg.png)
  
출처: https://www.infoworld.com/article/3272244/what-is-the-jvm-introducing-the-java-virtual-machine.html  

------------

#### 2. 컴파일 하는 방법
