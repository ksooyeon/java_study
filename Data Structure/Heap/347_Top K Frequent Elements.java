class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        // hm 원소로 하는 최소힙 pq 초기화 (value 내림차순)
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparing(e -> e.getValue()));
        
        //map에 <원소, 빈도수> 삽입
        for(int num : nums) {
          hm.put(num, hm.getOrDefault(num, 0)+1);
        }

        // k만큼의 길이 유지하면서 pq에 map의 entry 삽입 (value가 큰 k개의 entry만 pq에 저장) 
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()) {
          pq.offer(entry);
          if(pq.size() > k)
            pq.poll();
        }

        int[] result = new int[k];
        for(int i=0;i<k;i++)
          result[i] = pq.poll().getKey();
        
        return result;
    }
}
