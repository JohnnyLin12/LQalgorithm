/*
 
���⣺�ѵļ���

����֪������N��Ԫ�صĶѿ��Կ�����һ�ð���N���ڵ����ȫ��������  
ÿ���ڵ���һ��Ȩֵ������С������˵�����ڵ��Ȩֵһ��С�����ӽڵ��Ȩֵ��  

����N���ڵ��Ȩֵ�ֱ���1~N���������һ���ж����ֲ�ͬ��С������  

�������N=4������3�֣�

    1
   / \
  2   3
 /
4

    1
   / \
  3   2
 /
4

    1
   / \
  2   4
 /
3

�����������ܳ������ͷ�Χ����ֻ��Ҫ����������1000000009��������  


�������ʽ��
һ������N��  
����40%�����ݣ�1 <= N <= 1000  
����70%�����ݣ�1 <= N <= 10000  
����100%�����ݣ�1 <= N <= 100000

�������ʽ��
һ��������ʾ�𰸡�  

������������
4  

�����������
3


��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 1000ms


���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�

���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��

 */
/*
 *����С��������  �ݹ��㷨���
 ��1~N��Χ С���ѵĸ���1~N��Χ����Сֵ1
 Ϊ������ѡ�� ������l�� Ϊ������ѡ�� ������r�� 
 ��1Ϊ���������������� ����ʣ��N-1��������ѡ��û�б�ѡ����
 �Ҵ��ڸ���������Ϊ�������ĸ� ����һ���ݹ齨��С���ѵĹ���
 
 ʵ����Ϊ��������ѡ���Ĺ��̾��൱�ڸ����������ּ��ϵĹ��� 
����Ϊ������ѡ��lsize����� ���ҽ����Ҳȷ�������� 
�ܵ�ѡ��������Ϊ :N-1ѡlisze�������  ��C(N-1,lisze)
���ܵĶѵĸ���Ϊ��d(1)=C(N-1,lsize)*d(l)*d(r)
����d(i)��ʾ�Ա��Ϊi�Ľ��Ϊ���Ķѵķ�����

1��ȷ��N-1��l��r
Ŀ��ʽ�ӵĵ���ʽ��
d(x)=C(size(x)-1,size(2*x))*d(2*x)*d(2*x+1)
����size(i)��ʾ���ڵ��Ǳ��Ϊi�Ľ������Ľ������Ŀ
����N=5ʱ
d(1)=C(4,3)*d(2)*d(3)
d(2)=C(2,1)*d(4)*d(5)
Ҷ�ӽڵ�Ķѵķ�����Ϊ1
d(3)=C(1,1)=1
d(4)=d(5)=1
�����ܵķ�������d(1)=4*2=8

2���������C(N,lsize)
c(N,lsize)=N!/(N-lsize)!/ lsize!
�Խ׳˽���Ԥ����
����׳˹����Ѿ�����ʽ�������
�����������������Ҫ����
��������Ҫ���ݷ���С����ת��Ϊģ����Ԫ ����Ͳ�չ������
�ٸ�����
a/b %modģ�ĳ���û�з����� ������a%mod /b%mod
���ǵ���a*(b����ģ����Ԫ)
��b����ģ����ԪΪ a^(mod-2)
���ݹ���ʹ�ÿ�����
����c(N,lsize)=N!* quicikPow( (N-lsize)!,mod-2 ) * quickPow(lsize!,mod-2)
lsize






 
 
 */
package �ھŽ�;

import java.util.Scanner;

/**
* @author JohnnyLin
* @version Creation Time��2020��6��1�� ����9:54:08
*/
public class t10_�ѵļ���2 {
	static final int mod= 1000000009;
	static int N;
	static int[]size;//��¼ÿ������size 	size[i]��ʾ���ڵ��Ǳ��Ϊi�Ľ��������ܽ����
	static long[] a;//��¼1~N�Ľ׳� 	a[i]��ʾi!
	static long[] inv;//��¼1~N�׳˵���Ԫ 	inv[i]��ʾi����Ԫ
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		N = reader.nextInt();
		size=new int[N+1];
		a=new long[N+1];
		inv=new long[N+1];
		initSize();
		initA();
		System.out.println(dp());
	}
	private static void initSize() {
//		for(int i=N;i>=1;i--) {
//			if(2*i+1<=N) {
//				size[i]=size[2*i]+size[2*i+1]+1;
//			}else if(2*i<=N) {
//				size[i]=size[2*i+1]+1;
//			}else {
//				size[i]=1;
//			}
//		}
		//�ɼ�д������
		for(int i=N;i>=1;i--) {//
			size[i] = 1 + (2*i<=N?size[2*i]:0)+(2*i+1<=N?size[2*i+1]:0);//size[i]<=n���Բ���ȡ��
			}
	}
	private static void initA() {
		a[0]=1;
		inv[0]=1;//ǧ��ע��Ҫ��ʼ�� 
		for(int i=1;i<=N;i++) {
			//��׳˹��̿��ܳ���int ���Ҫ��ȡ��
			a[i]=a[i-1]*i%mod;
			//��i�׳˵���Ԫ
			inv[i]=quickPow(a[i],mod-2);
		}
		//show2(a)
	}
	private static long dp() {
		//dp[i]��ʾ���Ϊi��С��������
		long [] d=new long[N+1];
		for(int x=N;x>=1;x--) {
			if(2*x+1<=N)
				d[x]=C(size[x]-1,size[2*x])*d[2*x]%mod*d[2*x+1]%mod;
			else if(2*x<=N)
				d[x]=C(size[x]-1,size[2*x])*d[2*x]%mod;
			else 
				d[x]=1;
				
		}
		return d[1];
	}
	//���������
	static long C(int N,int lsize) {
		//c(n,lsize)=N!* quicikPow( (N-lsize)!,mod-2 ) * quickPow(lsize!,mod-2)
		return a[N]*inv[ lsize ]%mod*inv[ N-lsize ]%mod;
	}
	
	/**
	 * @param a
	 * @param y
	 * @return 
	 * �������x��y�η�
	 */
	private static long quickPow(long a, int n) {
		if(a==0)
			return 0;
		long ans=1;
		long x=a;
		while(n>0) {
			if((n&1)==1)
				ans=ans*x%mod;
			n>>=1;
			x=x*x%mod;
		}
		return ans;
	}
	private static void show(long[] d) {
		for(int i=N;i>=1;i--) {
			System.out.print(d[i]+" ");
		}
		System.out.println();
	}
	private static void show2(int[] d) {
		for(int i=N;i>=1;i--) {
			System.out.print(d[i]+" ");
		}
		System.out.println();
		
	}



}
