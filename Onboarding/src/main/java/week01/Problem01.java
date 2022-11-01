package week01;

public class Problem01 {
    public int solution(int[] pobi, int[] crong){
        int answer;
        int left_high_num;
        int right_high_num;
        int pobi_max_num;
        int crong_max_num;

        left_high_num = Math.max(sum(pobi[0]),multiply(pobi[0]));
        right_high_num = Math.max(sum(pobi[1]),multiply(pobi[1]));
        pobi_max_num = Math.max(left_high_num,right_high_num);

        left_high_num = Math.max(sum(crong[0]),multiply(crong[0]));
        right_high_num = Math.max(sum(crong[1]),multiply(crong[1]));
        crong_max_num = Math.max(left_high_num,right_high_num);

        if(pobi[0] != pobi[1]+1 || crong[0] != crong[1]+1)
            answer = -1;
        else if(pobi_max_num > crong_max_num)
            answer = 1;
        else if (pobi_max_num < crong_max_num)
            answer = 2;
        else if (pobi_max_num == crong_max_num)
            answer = 0;
        else
            answer = -1;
        return answer;
    }
    public int sum (int num){
        int hap = 0;
        while(num!=0){
            hap += num%10;
            num/=10;
        }
        return hap;
    }

    public int multiply(int num){
        int multiple = 1;
        while(num!=0){
            multiple *= num % 10;
            num/=10;
        }
        return multiple;
    }
}
