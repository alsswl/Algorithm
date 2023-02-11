class Solution {
    public int[] solution(String s) {
        
        char[] arr = s.toCharArray();
        
        int[] answer = new int[arr.length];
        
        answer[0] = -1;
        
        for(int i = 1;i<arr.length;i++){
            for(int j = i-1;j>=0;j--){
                if(arr[j] == arr[i]){
                    answer[i] = i-j;
                    break;
                }          
            }
            if(answer[i] == 0) answer[i] = -1;
        }
        return answer;
    }
}