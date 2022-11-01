package woowaProject;

import java.util.Random;
public class Problem01 {

    public int solution(int[] pobi, int[] crong){
        int answer;
        int left_high_num;
        int right_high_num;
        int pobi_max_num;
        int crong_max_num;
        Random random = new Random();
        int pobiPage = random.nextInt(399)+1;
        int crongPage = random.nextInt(399)+1;
        if (pobiPage % 2 == 0){
            pobi[0] = pobiPage-1;
            pobi[1] = pobiPage;
        } else {//홀수면
            pobi[0] = pobiPage;
            pobi[1] = pobiPage+1;
        }
        left_high_num = Math.max(sum(pobi[0]),multiply(pobi[0]));
        right_high_num = Math.max(sum(pobi[1]),multiply(pobi[1]));
        pobi_max_num = Math.max(left_high_num,right_high_num);
        if (crongPage % 2 == 0){
            crong[0] = crongPage-1;
            crong[1] = crongPage;
        } else {
            crong[0] = crongPage;
            crong[1] = crongPage+1;
        }
        left_high_num = Math.max(sum(crong[0]),multiply(crong[0]));
        right_high_num = Math.max(sum(crong[1]),multiply(crong[1]));
        crong_max_num = Math.max(left_high_num,right_high_num);
        if(pobi_max_num > crong_max_num)
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

