package week01;

public class Problem02 {
    public String solution(String cryptogram){
        String result = "";
        while (cryptogram.length()>2){
            result = deleteDuplicate(cryptogram);
            if(result.length() == cryptogram.length())
                break;
            cryptogram = deleteDuplicate(cryptogram);
        }
        if(cryptogram.length() ==2 && (cryptogram.charAt(0) == cryptogram.charAt(1))){
            result ="";
        }
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