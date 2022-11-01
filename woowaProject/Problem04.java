public class Problem04 {
    public String solution(String word){
        String answer = "";
        int k;
        char c;
        char[] arr = new char[word.length()];
        for(int i = 0; i <word.length(); i++){
            arr[i] = word.charAt(i);
        }
        for(int i = 0; i<arr.length; i++){
            if(arr[i]>64 && arr[i] <91){
                k = arr[i] - 65;
                c = (char)(90 - k);
                answer += c;
            } else if (arr[i] >96 && arr[i] < 123){
                k = arr[i] - 97;
                c = (char)(122 - k);
                answer += c;
            } else if (arr[i] == ' '){
                answer += arr[i];
            }
        }
        return answer;
    }
}
