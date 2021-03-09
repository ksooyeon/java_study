# 3주차 : 자바가 제공하는 다양한 연산자를 학습하세요.

#### 학습할 것  

- 산술 연산자
- 비트 연산자
- 관계 연산자
- 논리 연산자
- instanceof
- assignment(=) operator
- 화살표(->) 연산자
- 3항 연산자
- 연산자 우선 순위
- (optional) Java 13. switch 연산자

------------


#### 1. 산술 연산자  
------------
사칙 연산(+, -, *, /) + 나머지(%) 연산.  
```java
static public void main(String[] args) {
    
    int a = 10;
    int b = 3;
    
    System.out.println("a + b = " + (a + b));    // 13
    System.out.println("a - b = " + (a - b));    // 7
    System.out.println("a * b = " + (a * b));    // 30
    System.out.println("a / b = " + (a / b));    // 3
    System.out.println("a % b = " + (a % b));    // 1
    
    //type casting 발생
    double c = a / 2;
    double d = a % 2;
    
    //Arithmetic Exception 발생(divided by zero)
    double err1 = c / 0;
    double err2 = c % 0;
}
```
#### 2. 비트 연산자  
------------
- 이항(Binary Operator) :  
  AND(&), OR(|), XOR(^), RIGHT SHIFT(>>), LEFT SHIFT(<<), UNSIGNED RIGHT SHIFT(>>>):비트값을 오른쪽으로 이동 후 왼쪽 공간 모두 0으로 채움  
- 단일항(Unary Operator) :  
  NOT(~)
  
```java
static public void main(String[] args) {
    
    int a = 3 & 1;      // 0011 & 0001 = 0001(1)
    int b = 2 | 1;      // 0010 | 0001 = 0011(3)
    int c = 3 ^ 1;      // 0011 ^ 0001 = 0010(2)
    int d = b >> 1;     // 0011 오른쪽으로 한 칸 이동, 0001(1)
    int e = b << 1;     // 0011 왼쪽으로 한 칸 이동, 0110(6)
    int f = ~a;         // 0001 -> 1111 1111 1111 1111 1111 1111 111 1110
    
    int g = -2147483648 >>> 1;
    // 1000 0000 0000 0000 0000 0000 0000 0000 -> 0100 0000 0000 0000 0000 0000 0000 0000  
}
```

  
#### 3. 관계 연산자  
------------
- 이항(Binary Operator)
    - == : Equal to  
    - != : Not equal to  
    - '>'  : Greater than  
    - <  : Less than  
    - '>=' : Greater than or Equal to  
    - <= : Less than or Equal to  
 - 연산 결과는 boolean  
  

#### 4. 논리 연산자  

------------
- 이항(Binary Operator)
    - <mark>&&</mark> : logical AND  
    - <mark>||</mark> : logical OR  
 - 피연산자 타입은 boolean  
 - 연산 결과 boolean  
   

#### 5. instanceof
------------
- 객체의 타입 확인할 때 사용.  
- 형변환 가능 여부 true/false로 리턴
- 주로 상속 관계에서 부모객체인지 자식객체인지 확인 시 사용  
  
```java
class A {}
class B extends A {}
class Test{
    static public void main(String[] args) {
            A a = new A();
            B b = new B();
            
            System.out.println(a instance of A);    // true. a는 자기 자신의 객체
            System.out.println(b instance of A);    // true. b는 A의 자식 객체
            System.out.println(a instance of B);    // false. a는 B의 부모 객체
            System.out.println(b instance of B);    // true. b는 자기 자신의 객체
            System.out.println(null instance of Object);    // false. null은 어떤 것의 instance도 아님
    }
}
```

#### 6. assignment(=) operator
------------
- 할당 연산자 : 객체에 값을 할당
- 다른 연산자와 묶어서 사용 가능
- 레퍼런스 타입일 경우 주소값을 할당  
- 이항(Binary Operator)
    - =  : Assign  
    - +=, -=, *=, /=, %= : Add, Subtract, Multiply, Divide, Modulo and Assign  
    - &=, ^=, |= : AND, XOR, OR and Assign  
    - <<=, >>=, >>>= : Left Shift, Right Shirft, UNSIGNED Right Shift and Assign  
  
```java
class Test {
    int value;
    Test(int input){
        value = input;
    }
}
class AssignmentOperator{
    static public void main(String[] args) {
           Test t1 = new Test(1);      // t1은 value가 1인 Test 클래스 타입의 객체 주소값을 가짐
           Test t2 = new Test(2);      // t2는 value가 2인 Test 클래스 타입의 객체 주소값을 가짐
           t1 = t2;                    // 할당 연산 후 t1은 t2와 동일한 주소값을 가짐(t1의 value = 2)
    }
}
```

#### 7. 화살표(->) 연산자
------------
- 람다식 표현에 사용되는 연산자  
- 람다식 표현 : 함수 정의를 따로 만들지 않고 실제 사용되는 코드에서 함수를 정의해 사용하는 것  
- JAVA 8부터 람다 표현식이 적용  
- 함수형 프로그래밍(Functional Programmin) 표현 : side-effect 발생을 최소화 하기 위함  
    - 조건  
        - 순수함수(Pure function) : 부작용 없는 함수, 함수의 실행이 외부의 상태를 변경시키지 않는 함수  
        - 익명함수(Annonymous function) : 이름 없는 함수  
        - 고계함수(Higher-order function) : 함수를 하나의 값으로 취급해 함수의 인자로 함수를 전달할 수 있는 상위 함수  
  
```java
interface Test{
    int func(int a);
}
class Test2 {
    public void func(Test test) {
        int value = test.func(3);
        System.out.println(value);
    }
}
class Operator {
    public static void main(String[] args) {
        Test2 t2 = new Test2();
        
        // 람다 표현 사용 x
        t2.func(new Test() {
            public int func(int a) {
                return a+2;
            }
        });
        
        // 람다 표현 사용
        t2.func((a) -> {
            return a+2;
        });
    }
}
```

#### 8. 3항 연산자  
------------
- 구조 -> Conditional Expression <b>?</b> true <b>:</b> false;
- 조건식이 참일시 true 표현 처리, 거짓일 시 false 표현 처리

```java
class Test {
    public static void main(String[] args) {
        int value = 3;
        System.out.println(value == 10 ? (value *= 3) : (value -= 100));  // 30 출력
    }
}
```


#### 9. 연산자 우선 순위  
------------
  |우선순위|연산자|
|----|-------|
|1|(), []|
|2|!, ~, ++, --|
|3|*, /, %|
|4|+, -|
|5|<<, >>, >>>|
|6|<, <=, >, >=|
|7|==, !=|
|8|&|
|9|^|
|10|｜|
|11|&&|
|12|││|
|13|? :|
|14|=, +=, -=, *=, /=, <<=, >>=, &=, ^=, ~=|
  
- 동일 선상에 있는 연산자들은 동일한 우선순위를 가짐
- 할당 연산 제외 이항 연산자들은 왼쪽 -> 오른쪽 순서로 연산
- 할당 연산은 오른쪽 -> 왼쪽으로 연산  
  
#### 10. Java 13. switch 연산자  
- java 13에서의 switch는 statement가 아닌 operator(또는 expression). 즉, 처리한 결과가 존재한다는 것.  
- swtich 자체가 연산자로 작동하여 하나의 값으로 취급될 수 있다.  
  
```
switch(expression) {
    case expression -> expression;     // case: 외에 case -> 도 사용 가능
    ...
    default -> expression
};
switch(expression) {
    case expression: {          // {} 블록 이용해 추가 로직 실행할 수 있다.
        expression;
        yield expression;
    }
    ...
    case "a", "b", "c" -> expression;
    default:
        expression;
        yield expression;       // break 대신 yield 사용
};
```
