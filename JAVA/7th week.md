# 7주차 : 자바의 패키지에 대해 학습하세요.

#### 목표

- package 키워드
- import 키워드
- 클래스패스
- CLASSPATH 환경변수
- classpath 옵션
- 접근지시자
------------
### 1. package 키워드
패키지(package) : 클래스, 인터페이스 등을 모은 단위(폴더 개념)  
- 관련 클래스를 그룹화하고 포함된 클래스의 네임스페이스를 정의하는 역할
- 모든 클래스에는 정의된 클래스 이름과 패키지 이름이 있다.  
  이 둘을 합쳐야 완전하게 한 클래스를 표현한다고 할 수 있다 = FQCN(Fully Qualified Class Name)  
- ex. String 클래스의 패키지 = "java.lang", FQCN = "java.lang.String  
  
package 키워드 사용법
- 클래스가 포함될 패키지를 지정할 때 사용
```java
package com.sample.practice.week7;
class Sample { ... }   // Sample 클래스의 FQCN = com.sample.practice.week7.Sample

class Example {   // 동일 패키지 클래스 사용시 패키지 명시 불필요
  Sample sample = new Sample();
}
```
------------
### 2. import 키워드
- 다른 패키지에 있는 클래스나 인터페이스 참조 시 사용
- 동일 패키지의 클래스나 java.lang 패키지 클래스는 import 구문 없이 참조 가능(ex. System.out.println(), String)
```java
package com.sample.practice.week7.model;

import com.sample.practice.week7.Sample;
import com.sample.practice.week7.Example;
// 한 패키지의 여러 클래스를 임포트 한다면 week7.* 로도 가능

public class Model {
  Sample sample = new Sample();
  Example example = new Example();
}
```
- static 멤버도 임포트 가능
```java
import static java.lang.System.out;

public class Model
  public void print() {
      out.println("println");
      out.print("print");
  }
}
```
------------
### 3. 클래스패스
- JVM이 프로그램을 실행할 때, 클래스 파일을 찾는데 사용되는 경로
- 소스코드(.java)를 컴파일하면 바이트코드(.class)로 변환되고 이를 실행하려면 해당 파일을 찾아야 한다
- classpath는 .class 파일이 포함된 디렉토리와 파일을 콜론(;)으로 구분한 목록이다
- classpath 지정하는 두 가지 방법
  - CLASSPATH 환경변수
  - classpath 옵션 사용
  
------------
### 4. CLASSPATH 환경변수
- 컴퓨터 시스템 변수 설정을 통해 지정
- JVM이 시작될 때 JVM의 클래스 로더는 이 환경 변수를 호출한다. 
- 그래서 환경 변수에 설정되어 있는 디렉토리가 호출되면 그 디렉토리에 있는 클래스들을 먼저 JVM에 로드한다  
![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcgTFrB%2FbtqRqb5kigF%2FTIDMKzmCWECK2NDscHxQH0%2Fimg.png)  
  
------------
### 5. classpath 옵션
- 자바 컴파일러가 컴파일 하기 위해 필요로 하는 참조할 클래스 파일들을 찾기 위해 컴파일 시에 파일 경로를 지정해주는 옵션
- 즉, 다른 클래스에 의존하는 클래스의 소스 파일을 컴파일 하기 위해 다른 클래스가 위치하는 경로를 나타내주는 것
```
javac <options> <source files>

//Hello.java -> C:/Java에 존재, 다른 필요한 클래스가 C:/Java/Engclasses에 있다면
javac -classpath .;C:/JAVA/Engclasses;C:/Java/Hello.java
//단축어인 -cp 대신 사용 가능
```

------------
### 6. 접근지시자
- 멤버 변수나 메소드들의 접근 범위 정의하기 위해 사용
  
지시자|클래스 내부|동일 패키지|하위 클래스|그 외 영역|  
--------|-----|------|------|------
public|O|O|O|O
protected|O|O|O|X
default(생략가능)|O|O|X|X
private|O|X|X|X  
