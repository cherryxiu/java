package com.cn.mapao;

public class SelectDemo {
	public static void main(String[] args) {
		int [] a=new int[]{3,5,1,4,2};
		int [] b=new int[2];
		int temp;
		
		for(int i=0;i<a.length-1;i++){
			b[0]=a[i];
			b[1]=i;
			for(int j=i+1;j<a.length;j++){
				if(b[0]>a[j]){
					b[0]=a[j];
					b[1]=j;
				}
			}
			
			if(b[1]!=i){
				temp=a[i];
				a[i]=b[0];
				a[b[1]]=temp;
			}
		}
		
	for(int i=0;i<a.length;i++){
		System.out.println(a[i]);
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
