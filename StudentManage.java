import java.util.Scanner;


public class StudentManage {
	//�����������
	 Student[] students=new Student[10];
	 int i=0;
	 //String[] args��ʲô��˼��ò���ǿ���ʹ�����Զ�ִ��
    public  static void main(String[] args){
    	System.out.println("��ӭʹ��ѧԱͨѶ¼����ϵͳ\n�����ˣ�����");
    	StudentManage a=new StudentManage();
    	//��̬���÷Ǿ�̬���ö���
    	a.load();
    }
    void load(){
    	System.out.println("1.��¼\t2.ע��\t3.�һ�����\t0.ע��");
    	System.out.println("��ѡ��");
    	Scanner sc =new Scanner(System.in);
    	int a=sc.nextInt();
    	switch(a){
    	case 1:
    		denglu();
    		break;
    	case 2:
    	case 3:
    	case 0:
    		System.out.println("�Բ������ڿ�����");
    		break;
    	default:System.out.println("�������");
    	}
      }
  //�û���¼����main����д��
    void denglu(){
	   Scanner sc =new Scanner(System.in);
	   System.out.println("�������˺�");
	   String zhanghao=sc.next();
	   System.out.println("����������");
	   int password=sc.nextInt();
	   System.out.println("��¼�ɹ�");
	   shouye();
   }
    //Ϊ�˷���ص�����ҳ�棬ʡȥ�����˺ŵ��鷳����������¼�ֿ�д
    void shouye(){
	   System.out.println("1�����ѧԱ\n2.��ʾ����ѧԱ\n3������ѧԱ\n4���޸�ѧԱ\n5��ɾ��ѧԱ\n0���˳�\n��ѡ��");
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
   	 default:System.out.println("�������");
   	}
	   }
   //----------------------------���ѧԱ----------------------------------

    void tianjia(){
	   Scanner sc =new Scanner(System.in);
	   System.out.println("��������"); 
	   int bi=sc.nextInt();
	   System.out.println("����"); 
	   String na=sc.next();
	   System.out.println("�Ա�"); 
	   String se=sc.next();
	   System.out.println("����"); 
	   int ag=sc.nextInt();
	   System.out.println("�绰"); 
	   int te=sc.nextInt();
	   
	 //�����Էŵ�������
	  Student s=new Student(bi,na,se,ag,te);
	  //�Ѷ���ŵ�������
	  students[i]=s;
	  i++;
	   System.out.println("��Ϣ��ӳɹ�������");
	   option1();
   }
   //------------------ѡ���Ƿ���Ҫ�������ѧԱ-----------------------------
    void option1(){
	   System.out.println("�Ƿ������ӣ���y/n��");
	   System.out.println("��ѡ��");
	   Scanner sc =new Scanner(System.in);
	   String select=sc.next();
	   //����ʹ�á�==������Ҫʹ��equals����Ϊ���ж�ֵ�Ƿ����
	   if(select.equals("y")){
		  tianjia();
		  }else if(select.equals("n")){
			  //�˳�System.exit(-1);???
			  shouye();
			  
		  }else{
			   System.out.println("��������ȷ����"); 
			   option1();
		  }
   }
    //---------------------��ʾ��Ա-----------------------------------
    void xianshi(){
    	System.out.println("���"+"\t"+"����"+"\t"+"�Ա�"+"\t"+"����"+"\t"+"�绰");
    	//����дm<students.length����Ϊ�趨10����Ա������û��10���������пյ�
    	for(int m=0;m<i;m++){
    	 //����ǵ������Ե���˼�ɣ�����
    	//System.out.println(students[m].bianhao+"\t  "+students[m].name+"\t"+students[m].sex+"\t"+students[m].age+"\t"+students[m].tel);		
    		
    		//�������ͬ�����Ե��÷���
    		students[m].print();
    	}    	
    	shouye();
    	
    }
    //----------------------���ҳ�Ա----------------------------------------
    void chazhao(){
       	System.out.println("\t\t-----------");
    	System.out.println("\t\t|1.����Ų���|");
    	System.out.println("\t\t-----------");
    	System.out.println("\t\t|2.����������|");
    	System.out.println("\t\t-----------");
    	System.out.println("\t\t|3.���绰����|");
    	System.out.println("\t\t------------");
    	System.out.println("\t\t|4.���������|");
    	System.out.println("\t\t------------");
    	System.out.println("\t\t�����루1-4��ѡ����ҷ�ʽ��");
    	System.out.println("��ѡ��");
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
    	default:System.out.println("�������");
        	chazhao();
   	}
     
 		   
 	   }
  //---------����Ų���
	   void bianhaocha(){
		   System.out.println("������Ҫ���ҵı�ţ�");
		   Scanner sc =new Scanner(System.in);
		   int b=sc.nextInt();
		   int c=0;
		   for(int j=0;j<i;j++){
			   if(b==students[j].bianhao){
				   System.out.println("���"+"\t"+"����"+"\t"+"�Ա�"+"\t"+"����"+"\t"+"�绰"); 
				  students[j].print();
				  c++;
			   }
		   }
		   //��ֹ����ı��û�з������ݿ�ģ�
		   if(c==0){
			   System.out.println("�����ҵ��û������ڣ�����������Ҫ���ҵı�ţ�");
		   }
		   option21();
		  
	   }
	   //-------------ѡ���Ƿ�Ҫ��������Ų���---
	   void option21(){
		   System.out.println("�Ƿ�������ң���y/n��");
		   System.out.println("��ѡ��");
		   Scanner sc =new Scanner(System.in);
		   String select=sc.next();
		   if(select.equals("y")){
			  bianhaocha();
			  }else if(select.equals("n")){
				  shouye();
				  
			  }else{
				   System.out.println("��������ȷ����"); 
				   option21();
			  }
	   }
	   //---------�����ֲ���
	   void namecha(){
		   System.out.println("������Ҫ���ҵ����֣�");
		   Scanner sc =new Scanner(System.in);
		   String b=sc.next();
		   int c=0;
		   for(int j=0;j<i;j++){
			   if(b.equals(students[j].name)){
				   System.out.println("���"+"\t"+"����"+"\t"+"�Ա�"+"\t"+"����"+"\t"+"�绰"); 
				  students[j].print();
				  c++;
			   }
		   }
		   //��ֹ����ı��û�з������ݿ�ģ�
		   if(c==0){
			   System.out.println("�����ҵ��û������ڣ�����������Ҫ���ҵ����֣�");
		   }
		   option22();
		  
	   }
	   //-------------ѡ���Ƿ�Ҫ���������ֲ���---
	   void option22(){
		   System.out.println("�Ƿ�������ң���y/n��");
		   System.out.println("��ѡ��");
		   Scanner sc =new Scanner(System.in);
		   String select=sc.next();
		   if(select.equals("y")){
			  namecha();
			  }else if(select.equals("n")){
				  shouye();
				  
			  }else{
				   System.out.println("��������ȷ����"); 
				   option22();
			  }
	   }
	   //---------���绰����
	   void telcha(){
		   System.out.println("������Ҫ���ҵĵ绰��");
		   Scanner sc =new Scanner(System.in);
		   int b=sc.nextInt();
		   int c=0;
		   for(int j=0;j<i;j++){
			   if(b==students[j].tel){
				   System.out.println("���"+"\t"+"����"+"\t"+"�Ա�"+"\t"+"����"+"\t"+"�绰"); 
				  students[j].print();
				  c++;
			   }
		   }
		   //��ֹ����ı��û�з������ݿ�ģ�
		   if(c==0){
			   System.out.println("�����ҵ��û������ڣ�����������Ҫ���ҵı�ţ�");
		   }
		   option23();
		  
	   }
	   //-------------ѡ���Ƿ�Ҫ�������绰����---
	   void option23(){
		   System.out.println("�Ƿ�������ң���y/n��");
		   System.out.println("��ѡ��");
		   Scanner sc =new Scanner(System.in);
		   String select=sc.next();
		   if(select.equals("y")){
			  telcha();
			  }else if(select.equals("n")){
				  shouye();
				  
			  }else{
				   System.out.println("��������ȷ����"); 
				   option23();
			  }
	   }
	   //---------���������
	   void agecha(){
		   System.out.println("������Ҫ���ҵ����䣺");
		   Scanner sc =new Scanner(System.in);
		   int b=sc.nextInt();
		   int c=0;
		   for(int j=0;j<i;j++){
			   if(b==students[j].age){
				   System.out.println("���"+"\t"+"����"+"\t"+"�Ա�"+"\t"+"����"+"\t"+"�绰"); 
				  students[j].print();
				  c++;
			   }
		   }
		   //��ֹ����ı��û�з������ݿ�ģ�
		   if(c==0){
			   System.out.println("�����ҵ��û������ڣ�����������Ҫ���ҵı�ţ�");
		   }
		   option24();
		  
	   }
	   //-------------ѡ���Ƿ�Ҫ�����������---
	   void option24(){
		   System.out.println("�Ƿ�������ң���y/n��");
		   System.out.println("��ѡ��");
		   Scanner sc =new Scanner(System.in);
		   String select=sc.next();
		   if(select.equals("y")){
			  agecha();
			  }else if(select.equals("n")){
				  shouye();
				  
			  }else{
				   System.out.println("��������ȷ����"); 
				   option24();
			  }
	   }
    //------------------�޸�ѧԱ-------------------------------
	   	void xiugai(){
	   		System.out.println("������Ҫ�޸ĵ�ѧԱ���");
	   		Scanner sc =new Scanner(System.in);
			   int d=sc.nextInt();
			   for(int j=0;j<i;j++){
				   if(d==students[j].bianhao){
					   System.out.println("����"); 
					   String na=sc.next();
					   students[j].name=na;
					   System.out.println("�Ա�"); 
					   String se=sc.next();
					   students[j].sex=se;
					   System.out.println("����"); 
					   int ag=sc.nextInt();
					   students[j].age=ag;
					   System.out.println("�绰"); 
					   int te=sc.nextInt();
					   students[j].tel=te;
					   System.out.println("ѧԱ��Ϣ�޸ĳɹ�");
				   }
			   }
		  
	   		option3();
	   		
	   	}
	    //------------------ѡ���Ƿ�����޸�ѧԱ------------	 
	   	void option3(){
	   	 System.out.println("�Ƿ�����޸ģ���y/n��");
		   System.out.println("��ѡ��");
		   Scanner sc =new Scanner(System.in);
		   String select=sc.next();
		   if(select.equals("y")){
			  xiugai();
			  }else if(select.equals("n")){
				  shouye();
				  
			  }else{
				   System.out.println("��������ȷ����"); 
				   option3();
			  }

	   	}
	   	//--------------ɾ��ѧԱ------------------------
	   	void shanchu(){
	   	 System.out.println("������Ҫɾ����ѧԱ�ı��");
	   	Scanner sc =new Scanner(System.in);
		   int e=sc.nextInt();
		   for(int j=0;j<i;j++){
			   if(e==students[j].bianhao){
				   for(int k=j;k<i-1;k++){
			//ɾ�����ǰ�����ı�ź�����ݸ���ñ�ŵ�λ�ã����һ��Ϊnull��
				   students[k].bianhao= students[k+1].bianhao;
				   students[k].name= students[k+1].name;
				   students[k].sex= students[k+1].sex;
				   students[k].age= students[k+1].age;
				   students[k].tel= students[k+1].tel;
				   System.out.println("ѧԱ��Ϣɾ���ɹ�");
				   }
				   students[i-1]=null;
				   i--;
			   }
		   }
		   	option4();
	   	}
	   	//-----------------ѡ���Ƿ����ɾ��ѧԱ-------------------
	   	void option4(){
	   		System.out.println("�Ƿ����ɾ������y/n��");
			   System.out.println("��ѡ��");
			   Scanner sc =new Scanner(System.in);
			   String select=sc.next();
			   if(select.equals("y")){
				  shanchu();
				  }else if(select.equals("n")){
					  shouye();
					  
				  }else{
					   System.out.println("��������ȷ����"); 
					   option4();
				  }
	   		
	   		
	   	}
	   	//--------------�˳�ϵͳ------------------------
	   	void tuichu(){
	   		System.out.println("\t\t��ӭ�´�ʹ��"); 
	   		System.exit(0);
	   	}
}
