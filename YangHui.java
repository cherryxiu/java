/*
 * ������Ǿ������ֵ��ڸ�Ԫ�����Ϸ�����б�Ϸ�֮��
 * */
public class YangHui {
	public static void main(String[] args){
		int [][] a=new int [10][10];
		//����ֵ1�洢��������Ӧ��λ��
		for(int index=0;index<a.length;index++){
			a[index][0]=1;
			a[index][index]=1;
		}
		//����ֵ��������ǵ��߼��洢��������ȥ
		for(int rIndex=2;rIndex<a.length;rIndex++){
			for(int cIndex=1;cIndex<rIndex;cIndex++){
				a[rIndex][cIndex]=a[rIndex-1][cIndex-1]+a[rIndex-1][cIndex];
				
			}
			
			
			
		}
		//���������ʽ
		for(int rIndex=0;rIndex<a.length;rIndex++){
			for(int cIndex=0;cIndex<=rIndex;cIndex++){
				//��ʹ��println������Ҫ����
				System.out.print(a[rIndex][cIndex]+"\t");
				
			}
			//����
			System.out.println();
		}
		
		
		
	}

}
