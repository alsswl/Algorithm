class Solution {
    public String solution(String s) {
        
        String [] arr = s.split(" ");
        int[] arr2 = new int[arr.length];
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE ;
        
        for(int i = 0;i<arr.length;i++){
            arr2[i] = Integer.parseInt(arr[i]);
            max = Math.max(max,arr2[i]);
            min = Math.min(min,arr2[i]);
        }
        
        String answer = min + " " + max;
       
        return answer;
    }
}