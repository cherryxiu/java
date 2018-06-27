import java.util.Scanner;


public class Student {
	int bianhao;
	String name;
	String sex;
	int age;
	int tel;
	
	public Student(int bi,String na,String se,int ag,int te){
		
		bianhao=bi;
		name=na;
		sex=se;
		age=ag;
		tel=te;
		
		
	}
	public void print(){
		
		System.out.println(bianhao+"\t"+name+"\t"+sex+"\t"+age+"\t"+tel);
	}
	
	

}
