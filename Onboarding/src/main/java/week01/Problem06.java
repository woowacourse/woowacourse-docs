package week01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem06 {
    public String[] solution(String[][] arr){
        List<String> strList = similarNameSet(arr);
        String[] s = getEmailList(arr, strList);
        for(int i = 0; i<s.length; i++){
            System.out.println(s[i]);
        }
        return s;
    }
    private static String[] getEmailList(String[][] arr, List<String> strList) {
        ArrayList<String> strAry = new ArrayList<>();
        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j< strList.size(); j++){
                if(arr[i][1].contains(strList.get(j))){
                    strAry.add(arr[i][0]);
                }
            }
        }
        String[] s = strAry.toArray(new String[0]);
        Arrays.sort(s);
        return s;
    }
    private static List<String> similarNameSet(String[][] arr) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < arr.length-1; i++){
            for(int j = i+1; j < arr.length; j++){
                String[] ar = rtString(arr[i][1], arr[j][1]);
                set.add(ar[0]);
                set.add(ar[1]);
            }
        }
        set.remove(null);
        List<String> strList = new ArrayList<>(set); // set의 List화
        return strList;
    }
    private static String[] rtString(String str_1, String str_2){
        String[] answer = new String[2];
        String name_1;
        String name_2;
        for(int i = 0; i< str_1.length()-1; i++){
            name_1 = str_1.substring(i,i+2);
            for(int j = 0; j<str_2.length()-1;j++){
                name_2 = str_2.substring(j,j+2);
                if(name_1.equals(name_2)){
                    answer[0] = str_1;
                    answer[1] = str_2;
                }
            }
        }
        return answer;
    }

}
