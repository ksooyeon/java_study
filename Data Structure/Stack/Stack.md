# 스택(Stack) #

### 개념 ###
![다운로드](https://user-images.githubusercontent.com/34119641/111282240-24b9ed80-8681-11eb-95bc-4cb95934f50d.jpg)  
출처 : https://coding-factory.tistory.com/229  
  
- 리스트의 한쪽 끝으로만 자료의 삽입, 삭제 작업이 이루어지는 자료구조
- 가장 마지막에 삽입된 자료가 가장 먼저 삭제되는 후입선출(LIFO) 방식
  
Overflow : 할당받은 메모리 부분의 마지막 주소 이상으로 자료를 삽입하려 할 때 발생  
Underflow : top pointer가 0을 가리키고 있을 때 자료를 삭제하려 할 때 발생  

*스택에 있는 자료를 삭제할 때 먼저 자료가 있는지 없는지부터 확인해야 한다.*  

### 응용분야 ###
- 부 프로그램 호출 시 복귀주소 저장할 때
- 함수의 호출순서 제어
- 인터럽트가 발생하여 복귀주소 저장할 때
- 후외 표기법으로 표현된 수식 연산 할 때
- 0주소 지정방식 명령어의 자료 저장소
- 재귀프로그램의 순서 제어
- 컴파일러를 이용한 언어 번역  
  
### 연산 ###
- pop() : 가장 위에 있는 항목 제거
- push(item) : 가장 윗부분에 item 추가
- peek() : 가장 위에 있는 항목 반환
- isEmpty() : 스택이 비어 있을 때 true 반환

### 구현 ###
```java
public class MyStack {
  private static class StackNode {
    private T data;
    private StackNode next;

    public StackNode(T data) {
      this.data = data;
    }
  }

  private StackNode top;

  public T pop() {
    if (top == null) throw new NoSuchElementException();
    T item = top.data;
    top = top.next;

    return item;
  }

  public void push(T item) {
    StackNode t = new StackNode(item);
    t.next = top;
    top = t;
  }

  public T peek() {
    if (top == null) throw new NoSuchElementException();
    return top.data;
  }

  public boolean isEmpty() {
    return top == null;
  }
}
```
