# 2주차 : 자바의 프리미티브 타입, 변수 그리고 배열을 사용하는 방법을 익힙니다.

#### 목표

- 프리미티브 타입 종류와 값의 범위 그리고 기본 값
- 프리미티브 타입과 레퍼런스 타입
- 리터럴
- 변수 선언 및 초기화하는 방법
- 변수의 스코프와 라이프타임
- 타입 변환, 캐스팅 그리고 타입 프로모션
- 1차 및 2차 배열 선언하기
- 타입 추론, var

------------


#### 1. 프리미티브 타입 종류와 값의 범위 그리고 기본 값  
  기본형(Primitive Type)의 특징  
  - 사용 전 반드시 선언되어야 한다.
  - 비객체 타입이므로 null 값을 가질 수 없다.
  - 실제 값을 저장하는 공간으로 스택 메모리에 저장된다.  
  
  ||타입|크기|기본값|데이터 표현 범위|
|-----|----|----|----|---------|
|논리형|boolean|1 byte|false|true, false|
|정수형|byte|1 byte|0|-128 ~ 127|
||short|2 byte|0|-32,768 ~ 32,767|
||int(기본)|4 byte|0|-2,147,483,648 ~ 2,147,483,647|
||long|8 byte|0L|-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807|
|실수형|float|4 byte|0.0F|(3.4 X 10<sup>-38</sup>) ~ (3.4 X 10<sup>38</sup>)의 근사값|
||double(기본)|8 byte|0.0|(1.7 X 10<sup>-308</sup>) ~ (1.7 X 10<sup>308</sup>)의 근사값|
|문자형|char|2 byte (유니코드)|'\u0000'|0 ~ 65,535|  

------------


#### 2. 프리미티브 타입과 레퍼런스 타입  

* ## Primitive Type
  - not object
  - 값 저장 (stack)
* ## Reference Type
  - object
  - 주소 저장 (heap)
  - class, interface, enum, array, String type (기본값 : Null, 크기 : 4 byte(객체의 주소값))


------------


#### 3. 리터럴  
프로그램에서 직접 표현한 값. 코드 내에 직접 쓴 값.  
- 정수  
  접두사 : 0 -> 8진수, 0x -> 16진수, 0b -> 2진수  
  접미사 : L or l -> long 타입
- 실수  
  소수점 형태 or 지수 형태 (float 타입은 f 명시적으로 표기해야 함. double은 생략 가능)
- 문자  
  단일 인용부호(' ')로 문자 표현
- 문자열  
  ""로 문자열 표현.
- 논리  
  boolean 타입 변수에 치환하거나 조건문에 이용  
    
*null 리터럴은 레퍼런스에 대입해서 사용 가능*


------------


#### 4. 변수 선언 및 초기화하는 방법  
선언할 변수의 타입과 변수명을 차례로 작성한다.  
초기화 시 등호를 입력 후 값을 입력한다.  

```java
public class Main {
  public static void main(String[] args) {
  
        int value;          //변수 선언
        int value2 = 10;    //변수 선언 및 초기화
  }
}
```  

------------


#### 5. 변수의 스코프와 라이프타임  
- 스코프(Scope) : 변수의 사용 가능 범위.  
  변수가 선언 된 클래스의 중괄호 내에서 사용 가능하다.  
  
```java
public class Scope {
  static int var1;        //Scope 클래스 내에서 사용 가능
  public static void main(String[] args) {
  
        int var2;         //main 안에서만 사용 가능
  }
}
```   

- 라이프타임(Life Cycle) : 변수가 생성되고 죽는 것을 말한다.  
  
![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FczMkKK%2FbtqNQvTOx5C%2FIy0Cgy4pJVRLOt2GUS5S2k%2Fimg.png)  
출처 : https://catch-me-java.tistory.com/18  
  
    * 전역변수 : 객체가 생성될 때 변수가 생성. 참조가 없을 때 가비지 컬렉터가 객체를 지우면서 같이 소멸된다.
    * 정적변수 : 클래스가 처음 호출 될 때 생성되며 어플리케이션 종료시 같이 소멸된다.
    * 매개변수 : 매개변수가 전달되는 함수가 호출될 때 생성되며 종료 시 해당 매개변수명으로 소멸된다.
    * 지역변수 : 해당 변수가 선언된 괄호 시작 지점에서 생성되며 괄호가 종료되는 시점에 소멸된다.  
  

------------


#### 6. 타입 변환, 캐스팅 그리고 타입 프로모션  
특정 데이터 타입으로 표현된 리터럴을 다른 데이터 타입으로 변환할 수 있다.  
- 캐스팅 타입 : 자신의 표현 범위를 모두 포함하지 못한 데이터 타입으로 변환.(개발자가 명시해야 함)  
    
```java
public class Casting {
  public static void main(String[] args) {
  
       float v1 = 1.23f;
       long v2 = v1;         //long은 8바이트, float은 4바이트로 메모리 할당 크기는 더 크지만 소수점 표현이 불가하므로 컴파일 오류
        
       long v3 = (long) v1;  //다음과 같이 명시적으로 기재해야 형변환 가능
  }
}
```    
      
- 프로모션 타입 : 자신의 표현 범위를 모두 포함한 데이터 타입으로 변환.(자동으로 형변환)  
  
```java
public class Promotion {
  public static void main(String[] args) {
  
        long v1 = 123L;
        float v2 = v1;    //원본 데이터가 손실되지 않으므로 자동으로 형변환 가능
  }
}
```    


------------


#### 7. 1차 및 2차 배열 선언하기  
  
1차 배열 : 타입[] 배열이름 = new 타입[배열길이]; 배열 선언과 초기화 동시에 가능.  
```java
public class Array1 {
  public static void main(String[] args) {
  
        int[] arr = new int[3];
        int[] arr2 = {10, 20, 30};    //할당할 값이 정해져있다면 중괄호로 배열 객체 만들 수 있다.
        int[] arr3;
        arr3 = {40, 50, 60};          //컴파일 오류 발생. 배열 변수는 런타임 스택 영역에, 값은 가비지 컬렉션 힙 영역에 객체가 생성.
                                      //선언 및 초기화 동시에 할 때만 사용할 수 있는 방법이다.
  }
}
```  
  
2차 배열 : 타입[][] 배열이름 = new 타입[배열길이][배열길이]; 배열 선언과 초기화 동시에 가능.  
```java
public class Array1 {
  public static void main(String[] args) {
  
        int[][] arr = new int[2][3];
        int[][] arr2 = {{1,2}, {3,4,5}};
  }
}
```  
  
------------


#### 8. 타입 추론, var  
  
타입 추론(Type Interface) : 변수 타입을 명시하지 않고 컴파일러가 데이터 타입이 무엇인지 추론한다는 의미.

var  
- 지역변수에서만 사용 가능
- 반드시 선언과 초기화 동시에 해야 한다
- null로 초기화 시 작동하지 않는다
- 람다 표현식에는 사용할 수 없다
- 타입 없이 배열에 초기값을 넘겨도 작동하지 않는다  
