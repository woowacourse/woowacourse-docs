package main.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GnerateRandomNUm {
    public int randomMake(){
        Random random = new Random();
        return random.nextInt(9) + 1;
    }
    public List<Integer> create(){
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3){
            int randomNumber = randomMake();
            if(computerNumber.contains(randomNumber)){
                continue;
            }else{
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}
