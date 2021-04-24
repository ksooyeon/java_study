# 15주차 : 자바의 람다식에 대해 학습하세요.

#### 목표

- 람다식 사용법
- 함수형 인터페이스
- Variable Capture
- 메소드, 생성자 레퍼런스

------------
### 1. 람다식 사용법

람다식 : 익명함수를 생성하기 위한 식, java8부터 지원.  
- 매개변수를 가진 코드블록이지만, 런타임 시에는 익명 구현 객체를 생성한다.
- (매개변수) -> {실행코드} 형태로 작성, 함수 정의의 형태를 띄지만 런타임 시에는 인터페이스의 익명 구현 객체로 생성된다.
- 어떤 인터페이스가 구현되는가는 대입되는 인터페이스에 따라 결정된다.

```java
int add(int x, int y) {
    return x + y;
}

// 람다식 표현
(int x, int y) -> {return x+y};
```
  
매개변수 자료형 생략 가능, 매개변수가 하나인 경우도 생략 가능. 단, 매개변수가 두 개 이상인 경우 괄호 생략 불가능  
```java
x -> {System.out.println(x);}

// 잘못된 형식
x, y -> {System.out.println(x+y);}
```
    
중괄호 안 구현 부분이 한 문장이면 생략 가능하나, return문은 중괄호 생략 불가능  
```java
str -> {System.out.println(str);}

// 잘못된 형식
str -> return str.length();
```  
  
------------
### 2. 함수형 인터페이스
- 람다식을 다루는 인터페이스
- @FunctionalInterface 어노테이션 사용
- @FunctionalInterface가 적용된 인터페이스는 한개의 추상메소드만 선언 가능
- 추상메소드가 1개가 아니면 에러 발생  
  
<java 8부터 기본적으로 제공하는 java.util.function 패키지>  
  
- Function<T, R>  
  제네릭 T를 인수로 받아 R 타입 객체를 반환하는 apply() 추상 메소드 정의  
```java
Function<Integer, Integer> function  = (num) -> num + 10;
int apply = function.apply(10);

// 출력결과 : 20
```
  
- Predicate<T>  
  제네릭 T를 인수로 받아 boolean을 반환, test() 추상 메소드 정의  
```java
Predicate<Integer> predicate = (integer -> integer > 0);
boolean test = predicate.test(10);

//출력결과 : true
```
  
- Consumer<T>  
  제네릭 T를 인수로 받아 리턴타입 없이 accept() 추상 메소드 정의  
```java
Consumer<Integer> consumer = (integer -> System.out.println(integer + 10));
consumer.accept(10);

//출력결과 : 20
```
  
- Supplier  
  파라미터를 받지 않고 리턴타입만 갖는 get() 추상 메소드 정의  
```java
Supplier<String> supplier = () -> "Functional Interface Test";
String result = supplier.get();

//출력결과 : Functional Interface Test
```
  
------------
### 3. Variable Capture

자유 변수(Free Variavble) : 람다식의 함수 파라미터로 전달되는 변수가 아닌 외부 정의 변수  
람다 캡쳐링(Lambda Capturing) : 람다식 내부에서 자유 변수를 참조하는 것  
  
<람다 캡쳐링의 제약 조건>  
1. 외부에 정의된 지역 변수가 <b>final</b> 키워드로 선언되어야 한다.  
2. final로 선언되지 않은 지역 변수는 final처럼 동작해야 한다. 즉, 값이 재할당이 일어나면 안된다.  
  

------------
### 4. 메소드, 생성자 레퍼런스

- 메소드 레퍼런스  
  람다 표현식을 간결하게 표현해주는 방법. `클래스이름::메소드이름` 형식으로 표현, 메소드 괄호는 생략.  
  - static 메소드 레퍼런스  
  ```java
  // 람다 표현식
  (String str) -> Integer.parseInt(str);
  
  // static 메소드 레퍼런스
  Integer::parseInt
  ```  
  
  - 생성자 메소드 레퍼런스  
  ```java
  // 람다 표현식
  () -> new Integer();
  
  // 생성자 메소드 레퍼런스
  Integer::new
  ```  
