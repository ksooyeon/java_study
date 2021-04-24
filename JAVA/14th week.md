# 14주차 : 자바의 제네릭에 대해 학습하세요.

#### 목표

- 제네릭 사용법
- 제네릭 주요 개념 (바운디드 타입, 와일드 카드)
- 제네릭 메소드 만들기
- Erasure

------------
### 1. 제네릭 사용법
제네릭(Generic) : 컴파일 과정에서 타입을 체크해주는 기능. 자바에서 다양한 타입의 객체들을 다루는 메소드나 컬렉션 클래스에서 사용.  
객체의 안정성이 높아지고 캐스팅이 용이하다.  
  
- 사용법
  - <> 구문 안에 원하는 개수만큼 ','로 구분해서 기술할 수 있다.  
  `class ClassName<Type1, Type2, ..., TypeN> { ... }`
  - 제네릭의 타입 파라미터는 일반적으로 알파벳 한 글자로 작성한다
    - <T> : Type
    - <E> : Element
    - <K> : Key
    - <N> : Number
    - <V> : Value
    - <R> : Result
  

------------
### 2. 제네릭 주요 개념 (바운디드 타입, 와일드 카드)
- 바운디드 타입 : 제네릭으로 사용되는 파라미터 타입을 제한할 수 있는 것.  
  
```java
public class Person<T extends Number> { ... }

Person<String> person = new Person<String>();
// Bound mismatch: The type String is not a valid substitute for the bounded parameter <T extends Number> of the type Person<T>
// 바운드 미스매치 오류 발생

```  
  - Number의 하위 클래스가 아닌 클래스를 파라미터로 적용할 경우 컴파일 에러가 발생한다.
  - 바운디드 타입의 대표적인 예는 Comparable.
  - Comparable 인터페이스 구현시 compareTo 메소드를 오버라이딩 해야 하는데 Comparable의 타입 파라미터가 제한되어 있다면 compareTo 메소드에서도 제한된 타입으로만 비교가 가능하게 된다.  
  
- 와일드 카드 : 바운디드 타입과 마찬가지로 타입 파라미터를 제한하는 기능을 가진다. ?를 이용해 표현.  
  - ?는 모든 타입의 객체를 제네릭의 타입 파라미터로 사용 가능하다는 뜻을 지닌다.
  - 와일드카드를 사용하는 경우 <? extends T> 혹은 <? super T>으로 상/하위 타입으로의 변환이 가능하도록 제한하는 기능을 제공한다.
    - <? extends T> : 와일드카드의 상위타입을 제한하는 것으로 T의 하위 타입 클래스만 사용가능
    - <? super T> : 와일드카드의 하위타입을 제한하는 것으로 T의 상위 타입 클래스만 사용 가능
    - <?> : 모든 타입이 가능한 것을 말한다  
  

------------
### 3. 제네릭 메소드 만들기
제네릭 메소드 : 메소드 선언부에 제네릭 타입이 선언된 메소드.  
  
```java
public static <T> void sort(List<T> list, Comparator<? super T> c) {
    list.sort(c);
}
```
- Collections 클래스의 sort 메소드
- 메소드 정의 타입인 T와 매개변수 T는 별개의 것
  
```java
public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Collections.sort(list);
		Collections.<String>sort(list);
		Collections.<Integer>sort(list);
}
```
메서드 앞에 타입을 적어주는 것이 맞지만 대부분 컴파일러가 대입된 타입을 추정할 수 있기 때문에 생략 가능하다.  
  
------------
### 4. Erasure
Erasure : 컴파일 시에는 타입의 제약이 있지만, 런타임 시에는 타입의 제약이 사라지는 것.
  
- unbounded Type -> Object
- bounded Type -> Comparable
- 제네릭 타입을 사용할 수 있는 일반 클래스, 인터페이스, 메소드에만 Erasure 적용

```java
Pair<Integer, String> p1 = new Pair<>(1, "apple");
Pair<Integer, String> p2 = new Pair<>(2, "banana");
boolean same = Util.<Integer, String>compare(p1, p2);

//런타임 시 다음 코드로 변경  
Pair<Integer, String> p1 = new Pair<>(1, "apple");
Pair<Integer, String> p2 = new Pair<>(2, "banana");
boolean same = Util.compare(p1, p2);

```

