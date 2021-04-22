# 12주차 : 자바의 애노테이션에 대해 학습하세요.

#### 목표

- 애노테이션 정의하는 방법
- @retention
- @target
- @documented
- 애노테이션 프로세서

------------
### 1. 애노테이션 정의하는 방법

메타 데이터 = 데이터에 대해 설명하는 데이터.
애노테이션 : 주석이라는 뜻, 소스코드에 메타코드를 주는 것. 프로그램의 일부에 대해 추가적인 정보를 제공하는 것.  
  - 런타임과 파일 시에 해석된다
  - 데이터의 유효성 검사를 Model 클래스에 직접 명시함으로써 데이터들에 대한 유효조건을 쉽게 파악
  

정의하는 방법 : 사용하려는 클래스 혹은 메소드 앞에 애노테이션을 붙인다.
```java
public class Test {
  @Override
  public boolean isTrue() {
      return false;
  }
}
```

Java Built-in 애노테이션  
- @Override : 해당 메소드가 상위 클래스의 메소드를 오버라이딩하고 있다는 것을 컴파일러에게 알려준다
- @Deprecated : 마커 애노테이션으로, 차후에 지원되지 않을 가능성이 있으니 더이상 사용하지 말라고 알려준다
- @SurpressWarning : 경고를 제거한다  
  
  
------------
### 2. @retention
@Retention : 애노테이션이 실제로 적용되고 유지되는 범위를 나타내기 위해 사용.
  
`@Retention(RetentionPolicy.요소)` 형태로 사용, 요소에는 다음의 것들이 들어갈 수 있다.  
- SOURCE : 컴파일 후에도 JVM에 의해서 계속 참조가 가능하다
- CLASS : 컴파일러가 클래스를 참조할 때까지 유효하다
- RUNTIME : 컴파일 전까지만 유효하고, 컴파일 후에는 사라진다.
  
------------
### 3. @target

<메타 애노테이션>  
: 애노테이션을 선언할 때 사용하는 애노테이션. 종류에는 @Taget, @Rentation, @Document 등이 있다.  
  
@Target : 자바 컴파일러가 애노테이션이 어디에 적용될지 결정하기 위해 사용.  
`@Target(Element.요소)` 형태로 사용  
요소  
- COUNSTRUCTOR :생성자 선언 시
- FIELD : enum 상수를 포함한 필드값 선언 시
- LOCAL_VARIALBE : 역 변수 선언 시
- METHOD : 메소드 선언 시
- PACKAGE :패키지 선언 시
- PARAMETER : 매개변수 선언 시
- TYPE : 클래스, 인터페이스, Enum 등 선언 시
  
```java
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) // 메소드 선언에만 해당 어노테이션을 사용할 수 있다. 
public @interface Custom {
}
```
  
------------
### 4. @documented

@Documented : 애노테이션이 지정된 대상의 JavaDoc에 이 애노테이션의 존재를 표기하도록 지정하기 위해 사용.  
@Override, @SuppressWarnings를 빼고 기본적으로 애노테이션은 JavaDoc에 포함되지 않는다.

*JavaDoc : Java 코드에서 API 문서를 HTML 형식으로 생성해주는 도구*

------------
### 5. 애노테이션 프로세서
애노테이션 프로세서 : 애노테이션을 이용해 프로세스를 처리하는 것. 컴파일 단계에서 애노테이션에 정의된 액션을 처리한다.  
애노테이션 프로세서를 통해 실행되기 전에 체크하면서 애노테이션이 의도한 대로 이루어지지 않는 경우 에러나 경고를 표시해 주기도 하며, 소스코드(.java)와 바이트코드(.class) 파일을 만들어 주기도 한다.  
예)Lombok   
  
  

