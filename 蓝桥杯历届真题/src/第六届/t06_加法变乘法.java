/*
�ӷ���˷�

���Ƕ�֪����1+2+3+ ... + 49 = 1225
����Ҫ������������������ڵļӺű�ɳ˺ţ�ʹ�ý��Ϊ2015

���磺
1+2+3+4+5+6...7+8+9+10*11+12+...+27*28+29+...46+47+48+49 = 2015
���Ƿ���Ҫ��Ĵ𰸡�

����Ѱ������һ�����ܵĴ𰸣�����λ�ÿ�ǰ���Ǹ��˺���ߵ������ύ������ʾ���������ύ10����
 */
package ������;

public class t06_�ӷ���˷� {
	static int sum(int s,int t,int []nums) {
		if(s<1||s>49||t>49) return 0;
		int res=0;
		for(int i=s;i<=t ;i++) {
			res+=nums[i];
		}
		return res;
	}
	public static void main(String[] args) {
		//0 1 49
		int []nums=new int[50];
		for(int i=1;i<=49;i++) {
			nums[i]=i;
		}
		//��һ���˺����ֻ�ܵ�46����
		for(int i=1;i<=46;i++) {
			//�ڶ����˺����ֻ�ܵ�48����
			for(int j=i+2;j<=48;j++) {
				int s3=0,s4=0,s5=0;
				int s1=nums[i]*nums[i+1];
				if(i>1) {
					s5=sum(1,i-1,nums);
				}
				if(i+2!=j) {
					s3=sum(i+2,j-1,nums);
				}
				if(j+1>49) continue;
				int s2=nums[j]*nums[j+1];
				s4=sum(j+2,49,nums);
				if(s1+s2+s3+s4+s5==2015) {
					System.out.println(nums[i]);
					System.out.println(nums[j]);
				}
			}
		}
	}

}
