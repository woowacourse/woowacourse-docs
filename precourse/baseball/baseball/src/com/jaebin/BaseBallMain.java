/*
 * Class:   BaseBallMain
 *
 * Version: 1.0
 *
 * Date:    2019-12-03
 *
 * Author:  Jae Bin Lee
 *
 */
package com.jaebin;
import java.util.Scanner;


public class BaseBallMain {
    private static final String REGAME = "1";
    public static void main(String[] args){
        String status;
        Scanner sc = new Scanner(System.in);
        do {
            BaseBallGame.initCount();
            BaseBallGame.makeAnswer();

            while (BaseBallGame.getStrike() != 3) {
                BaseBallGame.initCount();
                BaseBallGame.parseAndCheckBallNumber(BaseBallGame.getBaseballNumber());
                BaseBallGame.printResult();
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            status = sc.nextLine();
        }while(status.equals(REGAME));
    }
}
