package woowaProject;


public class Problem2 {
    private static String solution(String cryptogram){
        String result = "";
        System.out.println(cryptogram);
        while (cryptogram.length()>2){
            result = deleteDuplicate(cryptogram);
            if(result.length() == cryptogram.length())
                break;
            cryptogram = deleteDuplicate(cryptogram);
        }

        if(cryptogram.length() ==2 && (cryptogram.charAt(0) == cryptogram.charAt(1))){
            result ="";

        }
        System.out.println("현재 결과 = " + result);
        System.out.println("현재 크립토그램 =" + cryptogram);
        //크립토그램의 길이가 1 이하인 경우에는 더 이상 중복이 발생할 수 없으므로 고려하지 않는다
        return result;
    }
    private static String deleteDuplicate(String cryptogram){
        String answer = "";
        char prev;
        char pres;
        char next = ' ';
        answer += cryptogram.charAt(0);
        for(int i = 1; i < cryptogram.length()-1;i++){
            prev = cryptogram.charAt(i-1);
            pres = cryptogram.charAt(i);
            next = cryptogram.charAt(i+1);
            if (pres != next && pres != prev){
                answer += pres;
            }
        }
        answer+=next;

        return answer;

    }
}