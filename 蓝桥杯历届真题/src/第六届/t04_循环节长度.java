/*

循环节长度

两个整数做除法，有时会产生循环小数，其循环部分称为：循环节。
比如，11/13=6=>0.846153 846153.....  其循环节为[846153] 共有6位。 
 */
package 第六届;

import java.util.Vector;

public class t04_循环节长度 {

	public static int f(int n, int m)
	{
		n = n % m;	
		Vector v = new Vector();
		//for()
		for(;;)
		{
			v.add(n);
			n *= 10;
			n = n % m;
			if(n==0) return 0;
			//说明找到重复的
			if(v.indexOf(n)>=0)  return v.size() ;  //填空
		}
	}
	public static void main(String[] args) {
		System.out.println(f(11,13));
	}

}
