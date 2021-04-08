# 힙(Heap) #

### 개념 ###
- 완전 이진트리의 일종
- 반정렬 상태, 완전 이진트리와 다르게 중복값 허용
- 최대 힙(Max Heap) : 부모 노드가 자식 노드보다 크거나 같을 때
- 최소 힙(Min Heap) : 부모 노드가 자식 노드보다 작거나 같을 때
- 배열을 이용해 구현, 쉬운 계산을 위해 1번 인덱스부터 사용한다

![](https://3.bp.blogspot.com/-QGbIGtOsknY/VYxNnlUiIoI/AAAAAAAACCc/a06lp5qTcGo/s1600/Heap_Concept.png)  
출처 : https://muckycode.blogspot.com/2015/01/heap_11.html  
  


-------------------------------------------
### 구현 ###
- 최대 힙에서의 삽입

```java
public static void insertHeap(int[] heap, int size, int item) {  // size=현재 heap의 원소 개수, item=삽입원소
     if(size == heap.length-1) {
        System.out.println("heap 사이즈 초과");
        return;
     }
     
     int i = ++size;     // 다음 item이 들어갈 원소 위치
     
     while(true) {
        if(i == 1) break;   // 힙의 원소가 하나도 없었다면 반복문 탈출
        if(item < heap[i/2]) break;  // item이 부모 노드보다 작다면 반복문 탈출
        
        heap[i] = heap[i/2];  // 부모 노드의 키값을 자식 노드로 이동
        i /= 2;   // i의 위치(원소가 들어갈 자리)를 부모 노드로 변경
     }
     
     heap[i] = item;
}
```

- 최대 힙에서의 삭제 : 루트 노드가 삭제된다    

```java
public static int deleteHeap(int[] heap, int size, int item) {  // size=현재 heap의 원소 개수
      if (heapSize == 0) // 배열이 빈 경우
        return 0;

      int item = maxHeap[1]; // 루트 노드의 값을 저장한다.
      maxHeap[1] = maxHeap[heapSize]; // 마지막 노드의 값을 루트 노드에 둔다.
      maxHeap[heapSize--] = 0; // 힙 크기를 하나 줄이고 마지막 노드를 0으로 초기화한다.

      for (int i=1; i*2<=heapSize;) {
        // 마지막 노드가 왼쪽 노드와 오른쪽 노드보다 크면 반복문을 나간다.
        if (maxHeap[i] > maxHeap[i*2] && maxHeap[i] > maxHeap[i*2+1]) {
          break;
        }
        // 왼쪽 노드가 더 큰 경우, 왼쪽 노드와 마지막 노드를 swap
        else if (maxHeap[i*2] > maxHeap[i*2+1]) {
          swap(i, i*2);
          i = i*2;
        }
        // 오른쪽 노드가 더 큰 경우, 오른쪽 노드와 마지막 노드를 swap
        else {
          swap(i, i*2+1);
          i = i*2+1;
        }
      }
      return item;
}
```
