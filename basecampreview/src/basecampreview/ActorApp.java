package basecampreview;
import java.util.Scanner;
public class ActorApp {
private static Scanner input=new Scanner(System.in);
public static void main(String[] args)
{
	ActorDetails[] details= {};
	int option;
	do
	{
		option=menu();
		switch(option)
		{
		case 1:
		{
			//add details
			details=addDetails(details);
		}
		break;
		case 2:
		{
			// based on industry
			displayBasedOnIndustry(details);
		}
		break;
		case 3:
		{
			//update salary/industry
			details=update(details);
		}
		break;
		case 4:
		{
			//sort salary
			ActorDetails[] sortDetails= {};
			sortDetails=sort(details);
			int j;
			ActorDetails temp;
			for(int i=1;i<sortDetails.length;i++)
			{
				if(sortDetails[i]!=null)
				{                                             
				j=i;                                                          
				temp=sortDetails[i];
				while(j>0&&sortDetails[j-1].getSalary()>temp.getSalary())
				{
					sortDetails[j]=sortDetails[j-1];
					j--;
				}
				sortDetails[j]=temp;
				}
			}
			for(int i=0;i<sortDetails.length;i++)
			{
				
			if(sortDetails[i]!=null)
			{
			System.out.println(sortDetails[i].getId());
			System.out.println(sortDetails[i].getIndustry());
			System.out.println(sortDetails[i].getName());
			System.out.println(sortDetails[i].getSalary());
			}
			}
		}
		break;
		case 5:
		{
		System.out.println("thank you! visit again");
		}
		break;
		default :
		{
			System.out.println("enter a valid choice:");
		}
		break;
		}
		
		
	}
	while(option!=5);
}
private static ActorDetails[] sort(ActorDetails[] details) {
	// TODO Auto-generated method stub
	ActorDetails[] sortDetails= new ActorDetails[details.length];
	int k=0;
	for(int i=0;i<details.length;i++)
	{
	if(details[i].getSalary()>=1000000)
	{
		sortDetails[k++]=details[i];
	}
	}
	return sortDetails;
}
private static ActorDetails[] update(ActorDetails[] details) {
	int Id;
	System.out.println("enter Id:");
	Id=input.nextInt();
	for(int i=0;i<details.length;i++)
	{
		if(details[i].getId()==Id)
		{
			System.out.println("1. based on salary"+"\n"+"2.based on Industry"+"\n"+"enter your option");
			int choice=input.nextInt();
			if(choice==1)
			{
				System.out.println("enter new salary to update:");
				double newSalary=input.nextDouble();
				details[i].setSalary(newSalary);
			}
			else
			{
				System.out.println("enter new industry to update:");
				String newIndustry=input.next();
				details[i].setIndustry(newIndustry);
			}
				
		}
	}
	return details;
}
private static void displayBasedOnIndustry(ActorDetails[] details) {
	// TODO Auto-generated method stub
	String Industry;
	System.out.println("enter industry:");
	Industry=input.next();
	
	for(int i=0;i<details.length;i++)
	{
		System.out.println(details[i].getIndustry());
		System.out.println(Industry);
		if(details[i].getIndustry().equals(Industry))
		{
			System.out.println(details[i].getId());
			System.out.println(details[i].getName());
			System.out.println(details[i].getSalary());
		}
	}
}
private static ActorDetails[] addDetails(ActorDetails[] details) {
	int Id;
	System.out.println("enter Id:");
	Id=input.nextInt();
	String name;
	System.out.println("enter name:");
	name=input.next();
	String Industry;
	System.out.println("enter industry:");
	Industry=input.next();
	double salary;
	System.out.println("enter salary:");
	salary=input.nextDouble();
	details=fillactordetails(details,Id,name,Industry,salary);
	return details;
}
private static ActorDetails[] fillactordetails(ActorDetails[] details,int Id,String name,String Industry,double salary) {
	ActorDetails[] PT = new ActorDetails[details.length + 1];
	for (int i = 0; i < details.length; i++) {
		PT[i] = details[i];
	}
	
PT[details.length] = new ActorDetails(Id,name,Industry,salary);
return PT;
}
private static int menu() {
	System.out.println("1. Add details to Actor"+"\n"+"2. display based on industry"+"\n"+"3. update salary/industry by Id"+"\n"+"4. sort actors based on salary"+"\n"+"5. exit"+"\n"+"enter your option:");
	int choice=input.nextInt();
	return choice;
}
}
