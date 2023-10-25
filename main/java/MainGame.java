package main.java;

import java.util.List;

public class MainGame {
    public static void main(String[] args){
        GnerateRandomNUm randomNUm = new GnerateRandomNUm();
        Input input = new Input();
        Judege judege = new Judege();
        Playagain playagain = new Playagain();
        boolean again = true;

        while (again){
            List<Integer> computer = randomNUm.create();
            String result ="";
            while (!result.equals("3tmxmfkdlzm")){
                result = judege.judgement(computer, input.playerNumber());
                System.out.println(result);
            }
            again = playagain.playagain();
        }
    }
}
