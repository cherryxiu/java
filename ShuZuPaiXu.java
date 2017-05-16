//对二维数组{{6,7,4},{2,1,8},{9,5,3}}进行排序，结果为{{1,2,3}，{4,5,6},{7,8,9}}
public class ShuZuPaiXu {
	public static void main(String[] args){
		int [][] a=new int[][]{{6,7,4},{2,1,8},{9,5,3}};
		int temp=0;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				for(int m=i;m<a.length;m++){
					for(int n=j;n<a[m].length;n++){
						if(a[i][j]>a[m][n]){
							temp=a[m][n];
							a[m][n]=a[i][j];
							a[i][j]=temp;
							
						}
						
						
						
					}
					
					
				}
				
				
			}
			
			
		}
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]);
				
				
			}
			System.out.println();
			
		}
		
		
		
	}

}
