import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
		
        PriorityQueue<Integer> heap = new PriorityQueue();

        for(int aScoville : scoville)
          heap.offer(aScoville);

        while(heap.peek() <= K) {
            if(heap.size() == 1)
              return -1;    // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없으므로 -1 리턴

            int mix = heap.poll() + (heap.poll() * 2);   // heap의 가장 작은 두 수 뽑아 섞기

            heap.offer(mix);
            answer++;
        }
        return answer;
    }
}
