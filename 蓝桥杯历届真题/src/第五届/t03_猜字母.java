/*��Ŀ������
 * 
 * ���⣺����ĸ

    ��abcd...s��19����ĸ��ɵ������ظ�ƴ��106�Σ��õ�����Ϊ2014�Ĵ���

    ������ɾ����1����ĸ������ͷ����ĸa�����Լ���3������5������������λ�õ���ĸ��

    �õ����´��ٽ���ɾ������λ����ĸ�Ķ����������ȥ�����ֻʣ��һ����ĸ����д������ĸ��

����һ��Сд��ĸ����ͨ��������ύ�𰸡���Ҫ��д�κζ�������ݡ�
 *�𰸣�q 
 */
package �����;

public class t03_����ĸ {

	public static void main(String[] args) {
		String s= "abcdefghijklmnopqrs";
		String news="";
		for(int i=1;i<=106;i++) {
			news+=s;
		}
		char[] c=news.toCharArray();
		int length=c.length;
		while(length>1) {
			int k=0;
			//��ԭ�����Ͻ��и���
			for(int i=0;i<length;i++) {
				if(i%2==1) {//�±�Ϊ����  ����ǰ���ż���±꣨ԭ������Ҫɾ��������
					c[k++]=c[i];
				}else {
					length--;//û����һ��ż���±곤�Ⱦͼ�1
				}
			}
		}
		System.out.println(c[0]);
		

	}

}
