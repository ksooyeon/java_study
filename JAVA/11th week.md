# 11주차 : 자바의 열거형에 대해 학습하세요.

#### 목표

- enum 정의하는 방법
- enum이 제공하는 메소드 (values()와 valueOf())
- java.lang.Enum
- EnumSet

------------
### 1. enum 정의하는 방법

Enum : 자바에서 서로 관련 있는 상수를 모아놓은 집합.
  
- enum 키워드를 이용해 정의, 열거할 상수들을 콤마로 구분하여 넣어준다.  
```java
public enum Language {
   C, JAVA, PYTHON, JAVASCRIPT
}
```  
  
- class처럼 생성자를 이용해 상수 값을 지정해 주는 것이 가능하다
```java
public enum Day {
	MON(1), TUE(2), WED(3), THU(4), FRI(5), SAT(6), SUN(7);
	
	private int value;
	
	Day(int value){
		this.value = value;
	}
	
	public int getDay() {
		return value;
	}
}
```


------------
### 2. enum이 제공하는 메소드 (values()와 valueOf())
- values() : Enum에 열거되어 있는 상수들을 배열 형태로 반환  
```java
public class Test {
	public static void main(String[] args){
		Day[] days = Day.values();
		
		for(Day day : days)
			System.out.println(day);
	}
}

// 결과
MON
TUE
WED
THU
FRI
SAT
SUN
```
  
- valueOf() : Enum에 열거되어 있는 상수 중 메소드의 파라미터 값과 동일한 상수를 반환한다. 대소문자, 공백이 모두 동일한 경우만 반환, 해당 상수가 없을 경우 IllegalArgumentException 예외를 발생시킨다.  
```java
public class Practice {
	public static void main(String[] args){
		Day Mon = Day.valueOf("MON");
		System.out.println(Mon.getDay());
		
		Day Tuesday = Day.valueOf("Tuesday");
		System.out.println(Tuesday.getDay());
	}
}

// 결과
1
Exception in thread "main" java.lang.IllegalArgumentException: No enum constant Day.Tuesday
	at java.lang.Enum.valueOf(Enum.java:238)
	at Day.valueOf(Day.java:1)
```

------------
### 3. java.lang.Enum
java.lang.Enum = 모든 Enum 타입의 상위 클래스.  
  
<주요 메소드>
- String name() : 열거된 상수의 이름 반환
- int ordinal() : 열거된 상수의 위치 반환
- String toString() : 열거된 상수를 나타내는 String 객체 반환. name()과 같은 역할이지만 오버라이딩 가능
- boolean equals() : 열거된 상수와 동일한 객체인지 판단
- int compareTo(E obj) : 열거된 상수의 ordinal 값 기준으로 지정된 객체와 비교
  

------------
### 4. EnumSet

EnumSet : 열거형 타입 상수들을 하나의 배열처럼 사용할 수 있게 해준다. 비트 연산을 이용하므로 메모리 공간 차지가 적고 속도가 빠르다.  
new 연산자로 선언 불가능 -> `EnumSet.allOf(열거형 클래스.class);` 형식으로 선언  
  

```java
public class Practice {
	public static void main(String[] args){
		EnumSet<Day> enumSet = EnumSet.allOf(Day.class);
		System.out.println(enumSet);
	}
}

// 결과
[MON, TUE, WED, THU, FRI, SAT, SUN]
```
  
