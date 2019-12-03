package Onsite;
import java.util.Scanner;

public class baseballGame {
	
	static int makeNumber() {
		int Number=0;
		int[] nums=new int[3];
		int rand;
		for(int i=0;i<3;i++) {
			if(i==0) rand=(int)Math.random()*8+1;
			else rand=(int)Math.random()*9;
			for(int j=0;j<i;j++) {
				if(nums[j]==rand) rand=(rand+1)%9;
				System.out.println(rand);
			}
			nums[i]=rand;
			System.out.println(nums[i]);
			Number+=(Number*10+rand);
		}
		return Number;
	}
	
	static int countStrike(int dest, int guess) {
		int cntStrike=0;
		while(guess>0) {
			int a=dest%10;
			int b=guess%10;
			if(a==b) cntStrike++;
			dest/=10;
			guess/=10;
		}
		return cntStrike;
	}

	static int countBall(int dest, int guess) {
		int cntBall=0;
		int[] nums=new int[3];
		int[] user=new int[3];
		for(int i=0;i<3;i++) {
			nums[i]=dest%10;
			user[i]=guess%10;
			dest/=10;
			guess/=10;
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(j==i) continue;
				if(nums[i]==nums[j]) {
					cntBall++;
					break;
				}
			}
		}
		return cntBall;
	}
	
	static int startGame() {
		Scanner sc=new Scanner(System.in);
		int answer=makeNumber();
		System.out.println("숫자를 입력해주세요: "+answer);
		
		int user_input=sc.nextInt();
		int strike=countStrike(answer, user_input);
		int ball=countBall(answer, user_input);
		
		if(strike!=0) System.out.print(strike+" 스트라이크 ");
		if(strike!=3&&ball!=0) System.out.println(ball+" 볼");
		if(strike==0 && ball==0) System.out.println("낫싱");
		
		if(strike==3) System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임종료\n"
				+ "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		
		int pause=sc.nextInt();
		sc.close();
		return pause;
	}
	public static void main(String[] args) {
		int n=1;
		while(n==1) {
			n=startGame();
		}
	}

}
