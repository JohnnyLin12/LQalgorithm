package 公式求值类;

import java.util.Scanner;

public class 公式求值 {
	static double mypow(int x,int y) {
		double res=1.0;
		for(int i=1;i<=y;i++) {
			res*=x;
		}
		return res;
		
	}

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		int n=reader.nextInt();
		int m=reader.nextInt();
		int k=reader.nextInt();
		
		int a=1,b=1;
		for(int i=n;i>=1;i--) {
			a*=i;
			if(i==m) {
				b*=i;
			}
		}
	}

}
