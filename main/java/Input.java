package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    public List<Integer> playerNumber(){
        System.out.println("숫자를 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        List<Integer> playerNum = new ArrayList<>();
        String input = scanner.next();

        for(String number: input.split("")){
            playerNum.add(Integer.parseInt(number));
        }
        return playerNum;
    }
}
