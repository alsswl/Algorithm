class Solution {
    public int[] solution(int brown, int yellow) {
        //2n + 2m-4 = brown
        // (n-1)*(m-1) = yellow
        //2n = brown - 2m +4
        //m이랑 
        
        int m = 2;
        int n = 0;
        
        while(true){
            n = (brown - 2*m +4)/2;
            if((n-2) * (m-2) == yellow){
                break;
            }
            m++;
        }
        
        int[] answer = new int[2];
        answer[0] = Math.max(n,m);
        answer[1] = Math.min(n,m);
        
        return answer;
    }
}