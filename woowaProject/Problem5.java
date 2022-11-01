package woowaProject;

public class Problem5 {
    private static int[] rsArr(int money){
        int[] arr = {0,0,0,0,0,0,0,0,0};
        arr[0] = money/50000;
        money%=50000;
        arr[1] = money/10000;
        money%=10000;
        arr[2] = money/5000;
        money%=5000;
        arr[3] = money/1000;
        money%=1000;
        arr[4] = money/500;
        money%=500;
        arr[5] = money/100;
        money%=100;
        arr[6] = money/50;
        money%=50;
        arr[7] = money/10;
        money%=10;
        arr[8] = money;
        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
        return arr;
    }
}