class Solution {
    static int[] answer;
    static int n;
    static int[] hal;
    
    
    static void make(int k,int[][] users, int[] emoticons){
        if(k == n){
            check(users, emoticons);
        }
        else{
            for(int i = 1;i<=4;i++){
                hal[k] = i*10;
                make(k+1,users,emoticons);
            }
        }
    }
    
    static void check(int[][] users, int[] emoticons){
            int[] emoticons2 = new int[emoticons.length];
            int monn = 0;
            
            for(int j= 0;j<emoticons.length;j++){
                emoticons2[j] = (emoticons[j] * (100-hal[j]))/100;
            }
            
            int allmon = 0;
            int plus = 0;
            
            for(int j = 0;j < users.length;j++){
                int nowMon = 0;
               for(int k = 0;k<emoticons.length;k++){
                   if(users[j][0] <= hal[k]){
                       nowMon += emoticons2[k];
                   }
               }
                if(nowMon >= users[j][1]){
                    plus++;
                }
                else{
                    allmon+= nowMon;
                }
            }
            
            if(plus > answer[0]){
                answer[0] = plus;
                answer[1] = allmon;
            }
            else if(plus == answer[0]){
                if(allmon >= answer[1]){
                    answer[1] = allmon;
                }
            }
    }
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        n = emoticons.length;
        hal = new int[n];
        make(0,users, emoticons);
        
        return answer;
    }
}