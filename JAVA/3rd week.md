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


#### 6. assignment(=) operator
------------


#### 7. 화살표(->) 연산자
------------


#### 8. 3항 연산자  
------------


#### 9. 연산자 우선 순위  
------------


#### 10. Java 13. switch 연산자  
