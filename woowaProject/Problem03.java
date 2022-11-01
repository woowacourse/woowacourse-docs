package woowaProject;


public class Problem03 {
    private static int solution(int number){
        int cnt = 0;
        int[] arr = {0,0,0,0,0};
        for(int i = 1; i <= number; i++){
            int k = i;
            for(int j =0; j< arr.length; j++){
                arr[j] = k%10;
                k/=10;
            }
            cnt = getCnt(cnt, arr);

        }
        return cnt;
    }
    private static int getCnt(int cnt, int[] arr) {
        for(int i = 0; i< arr.length; i++){
            if(arr[i] == 3 || arr[i] == 6 || arr[i] == 9){
                cnt++;
            }
        }
        return cnt;
    }


}
