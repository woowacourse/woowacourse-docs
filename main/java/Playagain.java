package main.java;

import java.util.Scanner;

public class Playagain {
    public boolean playagain(){

        System.out.println("축하합니다! 경기를 다시 시작하겠습니까? 다시시작 : 1, 종료 : 2");
        Scanner scanner = new Scanner(System.in);
        char answer = scanner.next().charAt(0);
        if(answer == '1'){
            return true;
        }
        return false;
    }
}


