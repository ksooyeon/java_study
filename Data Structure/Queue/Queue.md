# 큐(Queue) #

### 개념 ###
- 가장 먼저 입력된 자료가 가장 먼저 출력되는 자료구조 (FIFO)
- 한쪽 끝에서는 삽입 연산만, 다른 한 쪽은 삭제 연산만 발생
- 두 개의 큐 포인터 변수(front, rear) 사용
- front : 큐의 삭제가 발생하는 지점
- rear : 큐의 삽입이 발생하는 지점
- 삽입 시 rear 증가, 삭제 시 front 감소

### 종류 ###
1. 선형 큐 (Linear Queue)
![](https://media.vlpt.us/images/misun9283/post/05fddbb8-5673-42c3-8acc-502b6c5a84a8/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202020-08-14%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%201.40.44.png)  
  출처 : https://velog.io/@misun9283/Queue  
  - 기본적인 큐의 형태
  - 크기가 제한되어 있고, 빈 공간을 사용하려면 모든 자료를 꺼내거나 한 칸씩 옮겨야 하는 단점이 있다
  
2. 원형 큐 (Circular Queue)
![](https://media.vlpt.us/images/misun9283/post/adc44fa4-d8fd-4586-a856-78b0c1723429/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202020-08-14%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%201.17.13.png)  
출처 : https://velog.io/@misun9283/Queue  
  - front가 큐의 끝에 닿으면 큐의 맨 앞으로 자료를 보내 원형으로 연결하는 방식
  - 선형 큐의 제점을 보완하고자 나옴
  - 마지막 인덱스에서 다음 인덱스로 넘어갈 때 "(index + 1) % 배열의 사이즈"를 이용해 Out of Bounds Exception 오류가 발생하지 않고 0으로 순환되는 구조를 가진다
  - rear의 위치가 n-1 일 때 삽입이 발생하면 rear를 0으로 변경한다
  
3. 우선순위 큐 (Priority Queue)
  - 들어가는 순서에 관계 없이 dequeue 시 우선순위에 맞게 나간다
  - 우선순위 큐의 성능 보장 위해 완전 이진 트리의 구조를 이용해 트리의 균형을 맞춘다
  
### 메소드 ###
- 배열을 이용한 큐
  - getSize() : 큐의 크기 반환
  - isEmpty() : 큐가 비어있으면 true, 그렇지 않으면 false
  - enqueue() : (rear+1) % size 번째 인덱스에 데이터 추가
  - dequeue() : (front+1) % size 번째 인덱스의 데이터 반환
  - clear() : 큐의 모든 데이터 삭제
  
- 연결리스트를 이용한 큐
  - isEmpty() : 큐가 비어있으면 true, 그렇지 않으면 false
  - enqueue() : 큐가 비어있으면 새로운 노드를 front와 rear로 선언, 비어있지 않으면 새로운 노드를 rear 노드의 next로 선언 후 새로운 노드를 rear로 선언
  - dequeue() : front 노드의 데이터 반환 후 front 노드의 next를 front 노드로 선언
  - clear() : 큐의 모든 데이터 삭제
  
### 응용분야 ###
- CPU 관리
- FCFS(FIRST COME FIRST SERVED) 스케줄링 기법
- RR(ROUND ROBIN) 스케줄링 기법 : 대화형 시스템에 사용
  


