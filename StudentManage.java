import java.util.Scanner;


public class StudentManage {
	//定义对象数组
	 Student[] students=new Student[10];
	 int i=0;
	 //String[] args是什么意思，貌似是可以使方法自动执行
    public  static void main(String[] args){
    	System.out.println("欢迎使用学员通讯录管理系统\n制作人：刘秀");
    	StudentManage a=new StudentManage();
    	//静态调用非静态，用对象
    	a.load();
    }
    void load(){
    	System.out.println("1.登录\t2.注册\t3.找回密码\t0.注销");
    	System.out.println("请选择");
    	Scanner sc =new Scanner(System.in);
    	int a=sc.nextInt();
    	switch(a){
    	case 1:
    		denglu();
    		break;
    	case 2:
    	case 3:
    	case 0:
    		System.out.println("对不起，正在开发中");
    		break;
    	default:System.out.println("输入错误");
    	}
      }
  //用户登录后（在main外面写）
    void denglu(){
	   Scanner sc =new Scanner(System.in);
	   System.out.println("请输入账号");
	   String zhanghao=sc.next();
	   System.out.println("请输入密码");
	   int password=sc.nextInt();
	   System.out.println("登录成功");
	   shouye();
   }
    //为了方便回到操作页面，省去输入账号的麻烦，将这个与登录分开写
    void shouye(){
	   System.out.println("1、添加学员\n2.显示所有学员\n3、查找学员\n4、修改学员\n5、删除学员\n0、退出\n请选择");
	   Scanner sc =new Scanner(System.in);
	   int a=sc.nextInt();
	   
     	switch(a){
    	case 1:
   		  	tianjia();
   		 break;
    	case 2:
   			xianshi();
   		break;
   	  	case 3:
   	  		chazhao();
   		break;
   	  	case 4:
	  		xiugai();
		break;
   	  	case 5:
	  		shanchu();
		break;
   	  	case 0:
   	  		tuichu();
   		break;
   	 default:System.out.println("输入错误");
   	}
	   }
   //----------------------------添加学员----------------------------------

    void tianjia(){
	   Scanner sc =new Scanner(System.in);
	   System.out.println("请输入编号"); 
	   int bi=sc.nextInt();
	   System.out.println("姓名"); 
	   String na=sc.next();
	   System.out.println("性别"); 
	   String se=sc.next();
	   System.out.println("年龄"); 
	   int ag=sc.nextInt();
	   System.out.println("电话"); 
	   int te=sc.nextInt();
	   
	 //把属性放到对象里
	  Student s=new Student(bi,na,se,ag,te);
	  //把对象放到数组里
	  students[i]=s;
	  i++;
	   System.out.println("信息添加成功！！！");
	   option1();
   }
   //------------------选择是否需要继续添加学员-----------------------------
    void option1(){
	   System.out.println("是否继续添加？（y/n）");
	   System.out.println("请选择");
	   Scanner sc =new Scanner(System.in);
	   String select=sc.next();
	   //不能使用“==”，需要使用equals，因为是判断值是否相等
	   if(select.equals("y")){
		  tianjia();
		  }else if(select.equals("n")){
			  //退出System.exit(-1);???
			  shouye();
			  
		  }else{
			   System.out.println("请输入正确操作"); 
			   option1();
		  }
   }
    //---------------------显示成员-----------------------------------
    void xianshi(){
    	System.out.println("编号"+"\t"+"姓名"+"\t"+"性别"+"\t"+"年龄"+"\t"+"电话");
    	//不能写m<students.length，因为设定10个成员，可能没有10个，可能有空的
    	for(int m=0;m<i;m++){
    	 //这个是调用属性的意思吧？？？
    	//System.out.println(students[m].bianhao+"\t  "+students[m].name+"\t"+students[m].sex+"\t"+students[m].age+"\t"+students[m].tel);		
    		
    		//数组对象同样可以调用方法
    		students[m].print();
    	}    	
    	shouye();
    	
    }
    //----------------------查找成员----------------------------------------
    void chazhao(){
       	System.out.println("\t\t-----------");
    	System.out.println("\t\t|1.按编号查找|");
    	System.out.println("\t\t-----------");
    	System.out.println("\t\t|2.按姓名查找|");
    	System.out.println("\t\t-----------");
    	System.out.println("\t\t|3.按电话查找|");
    	System.out.println("\t\t------------");
    	System.out.println("\t\t|4.按年龄查找|");
    	System.out.println("\t\t------------");
    	System.out.println("\t\t请输入（1-4）选择查找方式：");
    	System.out.println("请选择");
    	Scanner sc =new Scanner(System.in);
 	    int n=sc.nextInt();
 	   switch(n){
   	    case 1:
   		 bianhaocha();
   		break;
   	    case 2:
   		namecha();
     	break;
   	    case 3:
   		telcha();
     	break;
    	case 4:
     	//agecha();
   		 break;
    	default:System.out.println("输入错误");
        	chazhao();
   	}
     
 		   
 	   }
  //---------按编号查找
	   void bianhaocha(){
		   System.out.println("请输入要查找的编号：");
		   Scanner sc =new Scanner(System.in);
		   int b=sc.nextInt();
		   int c=0;
		   for(int j=0;j<i;j++){
			   if(b==students[j].bianhao){
				   System.out.println("编号"+"\t"+"姓名"+"\t"+"性别"+"\t"+"年龄"+"\t"+"电话"); 
				  students[j].print();
				  c++;
			   }
		   }
		   //防止输入的编号没有符合数据库的，
		   if(c==0){
			   System.out.println("您查找的用户不存在，请重新输入要查找的编号：");
		   }
		   option21();
		  
	   }
	   //-------------选择是否要继续按编号查找---
	   void option21(){
		   System.out.println("是否继续查找？（y/n）");
		   System.out.println("请选择");
		   Scanner sc =new Scanner(System.in);
		   String select=sc.next();
		   if(select.equals("y")){
			  bianhaocha();
			  }else if(select.equals("n")){
				  shouye();
				  
			  }else{
				   System.out.println("请输入正确操作"); 
				   option21();
			  }
	   }
	   //---------按名字查找
	   void namecha(){
		   System.out.println("请输入要查找的名字：");
		   Scanner sc =new Scanner(System.in);
		   String b=sc.next();
		   int c=0;
		   for(int j=0;j<i;j++){
			   if(b.equals(students[j].name)){
				   System.out.println("编号"+"\t"+"姓名"+"\t"+"性别"+"\t"+"年龄"+"\t"+"电话"); 
				  students[j].print();
				  c++;
			   }
		   }
		   //防止输入的编号没有符合数据库的，
		   if(c==0){
			   System.out.println("您查找的用户不存在，请重新输入要查找的名字：");
		   }
		   option22();
		  
	   }
	   //-------------选择是否要继续按名字查找---
	   void option22(){
		   System.out.println("是否继续查找？（y/n）");
		   System.out.println("请选择");
		   Scanner sc =new Scanner(System.in);
		   String select=sc.next();
		   if(select.equals("y")){
			  namecha();
			  }else if(select.equals("n")){
				  shouye();
				  
			  }else{
				   System.out.println("请输入正确操作"); 
				   option22();
			  }
	   }
	   //---------按电话查找
	   void telcha(){
		   System.out.println("请输入要查找的电话：");
		   Scanner sc =new Scanner(System.in);
		   int b=sc.nextInt();
		   int c=0;
		   for(int j=0;j<i;j++){
			   if(b==students[j].tel){
				   System.out.println("编号"+"\t"+"姓名"+"\t"+"性别"+"\t"+"年龄"+"\t"+"电话"); 
				  students[j].print();
				  c++;
			   }
		   }
		   //防止输入的编号没有符合数据库的，
		   if(c==0){
			   System.out.println("您查找的用户不存在，请重新输入要查找的编号：");
		   }
		   option23();
		  
	   }
	   //-------------选择是否要继续按电话查找---
	   void option23(){
		   System.out.println("是否继续查找？（y/n）");
		   System.out.println("请选择");
		   Scanner sc =new Scanner(System.in);
		   String select=sc.next();
		   if(select.equals("y")){
			  telcha();
			  }else if(select.equals("n")){
				  shouye();
				  
			  }else{
				   System.out.println("请输入正确操作"); 
				   option23();
			  }
	   }
	   //---------按年龄查找
	   void agecha(){
		   System.out.println("请输入要查找的年龄：");
		   Scanner sc =new Scanner(System.in);
		   int b=sc.nextInt();
		   int c=0;
		   for(int j=0;j<i;j++){
			   if(b==students[j].age){
				   System.out.println("编号"+"\t"+"姓名"+"\t"+"性别"+"\t"+"年龄"+"\t"+"电话"); 
				  students[j].print();
				  c++;
			   }
		   }
		   //防止输入的编号没有符合数据库的，
		   if(c==0){
			   System.out.println("您查找的用户不存在，请重新输入要查找的编号：");
		   }
		   option24();
		  
	   }
	   //-------------选择是否要继续年龄查找---
	   void option24(){
		   System.out.println("是否继续查找？（y/n）");
		   System.out.println("请选择");
		   Scanner sc =new Scanner(System.in);
		   String select=sc.next();
		   if(select.equals("y")){
			  agecha();
			  }else if(select.equals("n")){
				  shouye();
				  
			  }else{
				   System.out.println("请输入正确操作"); 
				   option24();
			  }
	   }
    //------------------修改学员-------------------------------
	   	void xiugai(){
	   		System.out.println("请输入要修改的学员编号");
	   		Scanner sc =new Scanner(System.in);
			   int d=sc.nextInt();
			   for(int j=0;j<i;j++){
				   if(d==students[j].bianhao){
					   System.out.println("姓名"); 
					   String na=sc.next();
					   students[j].name=na;
					   System.out.println("性别"); 
					   String se=sc.next();
					   students[j].sex=se;
					   System.out.println("年龄"); 
					   int ag=sc.nextInt();
					   students[j].age=ag;
					   System.out.println("电话"); 
					   int te=sc.nextInt();
					   students[j].tel=te;
					   System.out.println("学员信息修改成功");
				   }
			   }
		  
	   		option3();
	   		
	   	}
	    //------------------选择是否继续修改学员------------	 
	   	void option3(){
	   	 System.out.println("是否继续修改？（y/n）");
		   System.out.println("请选择");
		   Scanner sc =new Scanner(System.in);
		   String select=sc.next();
		   if(select.equals("y")){
			  xiugai();
			  }else if(select.equals("n")){
				  shouye();
				  
			  }else{
				   System.out.println("请输入正确操作"); 
				   option3();
			  }

	   	}
	   	//--------------删除学员------------------------
	   	void shanchu(){
	   	 System.out.println("请输入要删除的学员的编号");
	   	Scanner sc =new Scanner(System.in);
		   int e=sc.nextInt();
		   for(int j=0;j<i;j++){
			   if(e==students[j].bianhao){
				   for(int k=j;k<i-1;k++){
			//删除就是把输入的编号后的数据赋予该编号的位置，最后一个为null；
				   students[k].bianhao= students[k+1].bianhao;
				   students[k].name= students[k+1].name;
				   students[k].sex= students[k+1].sex;
				   students[k].age= students[k+1].age;
				   students[k].tel= students[k+1].tel;
				   System.out.println("学员信息删除成功");
				   }
				   students[i-1]=null;
				   i--;
			   }
		   }
		   	option4();
	   	}
	   	//-----------------选择是否继续删除学员-------------------
	   	void option4(){
	   		System.out.println("是否继续删除？（y/n）");
			   System.out.println("请选择");
			   Scanner sc =new Scanner(System.in);
			   String select=sc.next();
			   if(select.equals("y")){
				  shanchu();
				  }else if(select.equals("n")){
					  shouye();
					  
				  }else{
					   System.out.println("请输入正确操作"); 
					   option4();
				  }
	   		
	   		
	   	}
	   	//--------------退出系统------------------------
	   	void tuichu(){
	   		System.out.println("\t\t欢迎下次使用"); 
	   		System.exit(0);
	   	}
}
