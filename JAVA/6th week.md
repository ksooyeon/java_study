# 6주차 : 자바의 상속에 대해 학습하세요.

#### 목표

- 자바 상속의 특징
- super 키워드
- 메소드 오버라이딩
- 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)
- 추상 클래스
- final 키워드
- Object 클래스
------------
### 1. 자바 상속의 특징
상속 : 기존 클래스를 재사용해 새로운 클래스를 만드는 일  
특징  
- 적은 양의 드로 새로운 클래스 작성 가능 -> 코드의 재사용성, 중복코드 제거
- 코드의 추가/변경이 쉽다 -> 유지 보수 요잉
- 자바에서 클래스 구현 시 상속은 한 번만 가능(다중 상속 X)
- 생성자와 초기화 블럭은 상속되지 않는다
- Object 클래스는 모든 클래스의 부모 클래스이다
- 구현 방법 : class 클래스명 extends 부모클래스 {}  
  
------------
### 2. super 키워드
- 부모 클래스로부터 상속받은 멤버를 참조하는데 사용하는 참조 변수
- 부모와 자식의 멤버를 구별하는데 사용된다는 점을 제외하고 this와 비슷함
- super() 메서드
  - 부모 클래스의 생성자를 호출할 때 사용
  - 부모 클래스에 매개변수를 가지는 생성자를 하나라도 선언했다면 부모 클래스에는 자동으로 기본 생성자가 자동 추가되지 않는다
  - 기본 생성자 없이 자식 클래스에서 super() 메서드 사용시 컴파일 오류  
  
```java
class Parent {
  int a;
  Parent() { a = 10; }      // 기본 생성자
  Parent(int n) { a = n; }  // 매개변수 포함한 생성자
}

class Child extends Parent {
  int b;
  Child() {
    //super(40);
    b = 20;
  }
  
  void display() {
    System.out.println(a);
    System.out.println(b);
  }
  
  public class Test {
    public static void main(String[] args) {
      Child ch = new Child();
      ch.display();          // 10, 20 (super(40); 주석처리 해제시 40, 20으로 출력)
    }
  }
}
```  

------------
### 3. 메소드 오버라이딩
- 부모 클래스로부터 상속받은 메서드를 재정의 하는 것
- 메서드의 이름, 배개변수, 반환 타입이 같아야 한다
- 접근제어자는 부모 클래스의 메서드보다 좁은 범위로 변경 불가능하다
- 부모클래스의 메서드보다 많은 예외를 선언할 수 없다
- 인스턴스 메서드와 static 메서드를 서로 변경할 수 없다
- @Override 로 오버라이딩이 정확하게 재정의 됐는지 검사할 수 있다.  
  
```java
public class Parent {
  protected int mult(int num1, int num2) {
    return num1 * num2;
  }
}

class Child extends Parent {
  @Override
  public int mult(int num1, int num2) {
    return super.mult(num1*2, num2*2);   // 부모 클래스의 메소드 재정의
  }
}
```

------------
### 4. 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)
<메소드 디스패치 (Method Dispatch)>  
어떤 메서드를 호출할지 결정하여 실제로 실행시키는 과정.  
자바는 런타임 시 객체를 생성하고, 컴파일 시 생성할 객체 타입에 대한 정보만 보유한다.  
이에 따라 이 과정은 static(정적)과 dynamic(동적)이 있다.
  
- Static Dispatch : 컴파일 시점에서 컴파일러가 특정 메소드를 호출할 것이라고 명확히 알고 있는 경우  
  - 컴파일 시 생성된 바이트 코드에도 이 정보가 그대로 남아있다
  - 런타임이 되지 않아도 미리 결정하는 개념
  - 함수를 오버로딩하여 사용하는 경우 인자의 타입이나 리턴타입 등에 따라 어떤 메소드를 호출할 지 알 수 있는 경우
```java
public class ACar {
    public void print() { 
        System.out.println("A");
    }
}

public class BCar extends ACar {    // 메소드 오버라이딩 - ACar상속 후 함수 재정의
    public void print() {
        System.out.println("BCar");
    }
}

public static void main(String[] args) {
    BCar bcar = new BCar();
    System.out.println(bcar.print());  // BCar 출력
}
```
  
- Dynamic Dispatch : 컴파일러가 어떤 메서드를 호출할지 모르는 경우. 호출할 메서드를 런타임 시점에서 결정한다.  
  - 인터페이스나 추상 클래스에 정의된 추상 메소드를 호출하는 경우이다
  - 컴파일러가 알고 있는 타입에 대한 정보를 토대로 런타임 시 해당 타입의 객체를 생성하고 메소드를 호출  
  
```java
   static class Super {
        void print() {
            System.out.println("super's print");
        }
    }

    static class Sub1 extends  Super{
        @Override
        void print() {
            System.out.println("sub1's print");
        }
    }
    
    public static void main(String[] args) {
        Super reference = new Super(); // "supers's print"
        reference.print();
        reference = new Sub1();       // "sub1's print", upcasting이 이루어지고 자식 객체의 주소를 가리킴.  
        reference.print();
    }
```
------------
#### 5. 추상 클래스
- 객체를 직접 생성할 수 있는 실체 클래스들의 공통적인 특성을 추출해 선언한 클래스
- 추상 클래스가 부모, 실체 클래스가 자식으로 구현된다
- 추상클래스는 객체를 직접 생성해 사용할 수 없기 때문에 new 연산자 사용이 불가능하다
- 실제 클래스 작성할 시간 절약
- abstract 키워드 사용
- 추상메서드가 존재하면 반드시 추상 클래스로 정의해야 한다.  
  
```java
public abstract class AbstractClass {
  abstract void method();
}
```
  
------------
#### 6. final 키워드
- 해당 선언이 최종 상태이고 절대 수정할 수 없음을 뜻함  
- 클래스를 선언할 때 -> 상속할 수 없는 클래스가 된다. 즉, 부모 클래스가 될 수 없어 자식 클래스를 만들 수 없다.  
- 메소드를 선언할 때 -> 오버라이딩 할 수 없는 메소드가 된다. 즉, 자식 클래스에서 재정의 할 수 없다.
- 멤버변수, 지역변수 선언할 때 -> 값을 변경할 수 없다.
 
```java
public final class FinalClass {   // 상속 금지  
	final int num = 100;       // 값 변경 불가  
	
	final void method() {        // 오버라이딩 불가  
		final int num2 = 200;    // 값 변경 불가  
	} 
}
```

------------
#### 7. Object 클래스
- 모든 클래스의 부모가 된다
- extends 키워드가 없는 클래스에 컴파일러는 자동으로 Object 클래스를 상속한다.
- 주요 메서드
  - boolean equals(Object obj) : 두 객체를 비교해 결과 반환
  - String toString() : 현재 객체의 문자열 반환
  - protected Objected clone() : 객체를 복사
  - Class getClass() : 객체의 클래스 타입 반환
  - void wait() : 스레드 일시중지
  - void notifyAll() : wait 상태의 모든 스레드 다시 실행

