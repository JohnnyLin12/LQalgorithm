/*
/*
���⣺�˿�����

A A 2 2 3 3 4 4�� һ��4���˿��ơ�����������ų�һ�С�
Ҫ������A�м���1���ƣ�����2֮����2���ƣ�����3֮����3���ƣ�����4֮����4���ơ�

����д�����з���Ҫ��������У��ֵ�����С���Ǹ���

���磺22AA3344 �� A2A23344 �ֵ���С����Ȼ�����Ƕ���������Ҫ��Ĵ𰸡�


��ͨ��������ύ�𰸡���A��һ����Ҫ��Сд��ĸa��Ҳ��Ҫ�á�1�����档�ַ���һ����Ҫ���ո�
 */
/*
 dfsȫ����+check��֦
 
 */
package �����;

public class t07_�˿�����_�������� {
	
	static void dfs(char[] pork,int index) {
		//System.out.println(s+" "+cnt);
		if(index==8) {
			String s=new String(pork);
			if(check(s)) {
				System.out.println(s);
				
			}
			return;
		}
		for(int i=index;i<8;i++) {
			char c=pork[index];
			pork[index]=pork[i];
			pork[i]=c;
			
			dfs(pork,index+1);
			
			c=pork[i];
			pork[i]=pork[index];
			pork[index]=c;
		}
		
		
	}

	private static boolean check(String s) {
		if(s.lastIndexOf('A')-s.indexOf('A')==2&&
			s.lastIndexOf('2')-s.indexOf('2')==3&&
			s.lastIndexOf('3')-s.indexOf('3')==4&&
			s.lastIndexOf('4')-s.indexOf('4')==5) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		char[] pork= {'2','2','3','3','4','4','A','A'};
		dfs(pork,0);

	}

}
