/*
 * 杨辉三角就是数字等于该元素正上方与左斜上方之和
 * */
public class YangHui {
	public static void main(String[] args){
		int [][] a=new int [10][10];
		//将数值1存储到数组相应的位置
		for(int index=0;index<a.length;index++){
			a[index][0]=1;
			a[index][index]=1;
		}
		//其他值则按杨辉三角的逻辑存储到数组中去
		for(int rIndex=2;rIndex<a.length;rIndex++){
			for(int cIndex=1;cIndex<rIndex;cIndex++){
				a[rIndex][cIndex]=a[rIndex-1][cIndex-1]+a[rIndex-1][cIndex];
				
			}
			
			
			
		}
		//控制输出格式
		for(int rIndex=0;rIndex<a.length;rIndex++){
			for(int cIndex=0;cIndex<=rIndex;cIndex++){
				//不使用println，不需要换行
				System.out.print(a[rIndex][cIndex]+"\t");
				
			}
			//换行
			System.out.println();
		}
		
		
		
	}

}
