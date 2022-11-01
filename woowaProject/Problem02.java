package woowaProject;

/*
암호문을 좋아하는 괴짜 개발자 브라운이 이번에는 중복 문자를 이용한 새로운 암호를 만들었다.
예를 들어 "browoanoommnaon"이라는 암호문은 다음과 같은 순서로 해독할 수 있다.
"browoanoommnaon"
"browoanoommnaon"
"browoannaon"
"browoannaon"
"browoaaon"
"browoon"
"brown"
임의의 문자열 cryptogram이 매개변수로 주어질 때, 연속하는 중복 문자들을 삭제한 결과를 return 하도록 solution 메서드를 완성하라.
제한사항
cryptogram은 길이가 1 이상 1000 이하인 문자열이다.
cryptogram은 알파벳 소문자로만 이루어져 있다.

 */
public class Problem02 {
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
