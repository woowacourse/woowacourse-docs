/*
 * Class:   BaseBallGame
 *
 * Version: 1.0
 *
 * Date:    2019-12-03
 *
 * Author:  Jae Bin Lee
 *
 */
package com.jaebin;

import java.util.*;

public class BaseBallGame {
    private static int strike;
    private static int ball;
    private static int answer[]={0,0,0};

    public static int getStrike(){
        return strike;
    }

    public static int getBall(){
        return ball;
    }

    public static void addStrike(){
        strike++;
    }

    public static void addBall(){
        ball++;
    }

    public static void initCount(){
        strike=0;
        ball=0;
    }

    public static void printResult(){
        if(getStrike()==0 && getBall()==0) {
            System.out.println("낫싱");
        }else if(getBall()==4){
            System.out.println("4볼");
        }else {
            System.out.println(getStrike() + " 스트라이크" + getBall() + " 볼");
        }
    }

    public static void makeAnswer(){
        List<Integer> numberList = new ArrayList<Integer>();

        for(int i=1;i<10;i++){
            numberList.add(i);
        }

        Collections.shuffle(numberList);

        for(int i=0;i<3;i++){
            answer[i]=numberList.get(i);
        }
    }

    public static String getBaseballNumber(){
        System.out.print("숫자를 입력해주세요: ");
        Scanner sc = new Scanner(System.in);
        String ball = sc.nextLine();
        return ball;
    }

    public static void parseAndCheckBallNumber(String ballNumber){
        int[] iBallNumber =new int[3];
        for(int i=0;i<3;i++){
            iBallNumber[i]= Integer.parseInt(ballNumber.substring(i,i+1));
        }

        for(int i=0;i<3;i++) {
            checkNumber(iBallNumber[i],i);
        }
    }

    public static void checkDigit(int digit,int answerDigit){
        if(digit==answerDigit){
            addStrike();
        }else{
            addBall();
        }
        return;
    }

    public static void checkNumber(int ballNumber,int digit){
        for(int i=0;i<3;i++){
            if(ballNumber==answer[i]){
                checkDigit(digit,i);
            }
        }
    }

}
