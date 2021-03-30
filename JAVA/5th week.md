# 5주차 : 자바의 Class에 대해 학습하세요.

#### 목표

- 클래스 정의하는 방법
- 객체 만드는 방법 (new 키워드 이해하기)
- 메소드 정의하는 방법
- 생성자 정의하는 방법
- this 키워드 이해하기
------------
#### 1. 클래스 정의하는 방법
클래스 : 객체를 정의해주는 틀
  - 필드(멤버 변수) : 객체의 속성, 멤버 변수
  - 생성자 : 변수에 초기값 대입하듯 클래스를 초기화 하는 역할
  - 메소드 : 기능(행위), 메소드 내 정의된 행위 실행  
  
<접근 지정자>  

접근지정자|클래스 내부|동일 패키지|하위 클래스|그 외 영역|  
--------|-----|------|------|------
public|O|O|O|O
protected|O|O|O|X
default(생략가능)|O|O|X|X
private|O|X|X|X  
  
<명명규칙>
1. 자바의 식별자는 대소문자를 구분한다.
2. 길이 제한은 없음, 공백 포함 불가능
3. 첫 문자가 문자, '_', '$' 의 특수문자로 시작되어야 함, 숫자로 시작 불가능
4. 자바의 키워드는 사용 불가능

```java
public class Person {            // 접근지정자 class 클래스명으로 클래스 생성
  // 필드
  private String name;
  private int age;
  
  // default 생성자, 파라미터 가진 생성자 있을 시 반드시 명시(없으면 생략 가능)
  public Person() {
  }
  
  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }
  
  //메소드, name 리턴 기능
  public String getName() {
    return name;
  }
}
```

------------
#### 2. 객체 만드는 방법 (new 키워드 이해하기)
- 정의한 클래스를 사용하기 위해서 객체를 만들어야 한다. => "클래스의 인스턴스화"  
- 객체는 <b>new</b> 키워드를 이용해 생성 가능. -> 메모리 힙 영역에 데이터를 저장할 영역 할당 받은 후 해당 영역의 주소를 객체에게 반환.  
  
클래스이름 변수명 = new 클래스이름
```java
Person p1 = new Person();
Person p2 = new Person("Kim", 30);
System.out.println(p2.getName());  // Kim
```
------------
#### 3. 메소드 정의하는 방법
- 정의부 : 접근지정자 리턴타입 메소드명 파라미터(선택)
- 호출부 : 메소드 기능 호출
  
```java
public String getName() {  //정의부
  //호출부
  return name;
}
public void setName(String name) {
  this.name = name;
}
```
  
다형성을 이용해 코드의 변경과 확장을 용이하게 해주는 특징
1. 메소드 오버로딩
- 파라미터의 갯수나 타입이 다르면 동일한 이름의 메소드명을 사용해 메소드를 정의할 수 있는 기법(ex.System.out.println())    
- 매개변수 동일하지만 리턴타입이 다를 경우 오버로딩 성립되지 않는다  
- 하나의 이름으로 다양한 기능을 사용할 수 있으므로 편의성 제공
```java
public String getName() { ...}
public String getName(int age) {...}
```
  
2. 메소드 오버라이딩
- 상위클래스가 정의한 메소드를 하위클래스가 가져와 변경하거나 확장하는 기법(재정의)
- 확장과 변경에 용이
```java
class Person {
  public void print() { System.out.println("사람입니다."); }
}
class Child extends Person {
  @Override
  public void print() { System.out.println("어린이입니다."); }
}

Person person = new Person();
Child child = new Child();

person.print();    // 사람입니다.
child.print();     // 어린이입니다.
```
------------
#### 4. 생성자 정의하는 방법
생성자 : 클래스 생성하고 객체 호출할 때 객체를 초기화하기 위해 사용되는 것  
- 리턴 값을 가지지 않는다
- 생성자는 클래스명과 동일하다
- 모든 클래스는 반드시 생성자가 한개 이상 존재한다
- 클래스 내부에 생성자를 선언하지 않으면 컴파일러가 기본 생성자를 선언해 사용한다
- 명시적 생성자를 사용할 경우 묵시적 생성자를 선언해주어야 한다(이미 생성자가 선언되어 있으므로 기본 생성자가 생성되지 않기 때문)  
- 생성자의 종류
  - 기본 생성자 : 클래스 내부에 선언된 생성자가 없는 경우 객체 생성 시 컴파일러가 자동으로 추가해주는 생성자
  - 묵시적 생성자 : 파라미터 값을 가지지 않는 생성자
  - 명시적 생성자 : 파라미터 값을 가지는 생성자  
  
```java
class Person() {}   // 기본 생성자
class Person() {
  
  public Person() {...}  // 묵시적 생성자
  public Person(String name, int age) {...}  // 명시적 생성자
  
}
```
------------
#### 5. this 키워드 이해하기

