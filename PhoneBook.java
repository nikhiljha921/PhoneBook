import java.util.*;
import java.io.*;

public class PhoneBook{

	static Node head;
sss
	static class Node{
		double mobileNo;
		String name; 
        Node prev; 
        Node next; 
  
        // Constructor to create a new node 
        // next and prev is by default initialized as null 
        Node(double d,String s) {
         mobileNo = d;
         name=s; 
        } 
     
	}
	static void create(){
		
	}

	static void add(){
		System.out.println("Enter Name to add");
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		System.out.println("Enter Mobile No");
		double  number=sc.nextDouble();

		Node new_node = new Node(number,name); 

		Node last = head;
  
    	if (head == null) { 
            new_node.prev = null; 
            head = new_node; 
            
        } 
        else if (head !=null) {
        	 while (last.next != null) 
             last = last.next; 
  
        
       		 last.next = new_node; 
  
       
        	new_node.prev = last;
        }


        if (head !=null) {
        	System.out.println("Data Added Sucessfully");
        }

	}

	static void delete(){
		System.out.println("Enter the name  you want to delete");
		Scanner sc=new Scanner(System.in);
		String del= sc.nextLine();

		if (head==null) {
			System.out.println("No data found to delete");
		}
		if (head.name==del) { // 1st node deletion
			Node last=head;
			head=head.next;
			head.prev=null;
			last=null;
		}
		else if (head!=null) {//data is bwtween 2 node
			Node temp=head;
			while(temp.name!=del){
				temp=temp.next;

			}
			Node a=temp.next;
			Node b=temp.prev;
			b.next=a;
			a.prev=b;
			temp=null;


		}


	}
	 static void display(){
		Node last = null; 

		System.out.println("Wait a second!!!"); 
		if (head==null) {
			System.out.println("No data Found");
		}
        while (head != null) { 
        System.out.println(head.name + " "); 
            System.out.println(head.mobileNo + " "); 
            last = head; 
            head = head.next; 
        

	}
}
	
	static void search(){

	}



	public static void main(String[] args) {

		PhoneBook phone=new PhoneBook();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter your choice from the following");
		System.out.println("Press 1  to add Number");
		System.out.println("Press 2 to Modify Number");
		System.out.println("Press 3 to delete Number");
		System.out.println("Press 4 to Display Number");
		System.out.println("Press 5 to Search Number");

		int input=sc.nextInt();

		switch(input){
			case 1:
			create();
			break;

			case 2:
			add();
			break;

			case 3:
			delete();
			break;

			case 4:
			display();
			break;

			case 5:
			search();
			break;

			default:
			System.out.println("Invalid Input!!!Try Again");
			break;


		}
	}

}