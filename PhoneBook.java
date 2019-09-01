import java.util.*;
import java.io.*;

public class PhoneBook {

    static Node head;

    static class Node {
        double mobileNo;
        String name;
        Node prev;
        Node next;

        // Constructor to create a new node 
        // next and prev is by default initialized as null 
        Node(double d, String s) {
            mobileNo = d;
            name = s;
        }

    }


    static void add() {
        System.out.println("Enter Name to add");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("Enter Mobile No");
        double number = sc.nextDouble();

        Node new_node = new Node(number, name);

        Node last = head;

        if (head == null) {
            new_node.prev = null;
            head = new_node;

        } else if (head != null) {
            while (last.next != null)
                last = last.next;
            last.next = new_node;
            new_node.prev = last;
        }


        if (head != null) {
            System.out.println("Data Added Sucessfully");
        }
    }

    static void delete() {
        System.out.println("Enter the name  you want to delete");
        Scanner sc = new Scanner(System.in);
        String del = sc.nextLine();

        if (head == null) {
            System.out.println("No data found to delete");
        }
        if (head.name == del) {
            Node last = head;
            head = head.next;
            head.prev = null;
            last = null;
        } else if (head != null) {
            Node temp = head;
            while (temp.name != del) {
                temp = temp.next;
            }

            Node a = temp.next;
            Node b = temp.prev;
            b.next = a;
            a.prev = b;
            temp = null;
        }
    }

    static void display() {
        Node last = null;
        Node ptr = head;
        System.out.println("Wait a second!!!");

        if (ptr == null) {
            System.out.println("No data Found");
        }

        while (ptr != null) {
            System.out.println(ptr.name + " ");
            System.out.println(ptr.mobileNo + " ");
            last = ptr;
            ptr = ptr.next;
        }
    }

    static void search() {
        System.out.println("Enter the name or number you want to search");
        Scanner val = new Scanner(System.in);
        String value = val.nextLine();
        int i = 1;
        boolean flag = false;
        Node current = head;


        if (head == null) {
            System.out.println("ContactBook is empty");
            return;
        }
        while (current != null) {

            if (current.name == value) {
                flag = true;
                break;
            }
            current = current.next;
            i++;
        }
        if (flag)
            System.out.println("Data is present in the list at the position : " + i);
        else
            System.out.println("Data is not present in the list");
    }



    public static void main(String[] args) {

        PhoneBook phone = new PhoneBook();
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1  to add Number");
        System.out.println("Press 2 to delete Number");
        System.out.println("Press 3 to Display Number");
        System.out.println("Press 4 to Search Number");
        System.out.println("Press 5 to Exit the Program");
        int check = 1;
        while (check != 0) {
            System.out.println("Enter your choice from the above");
            int input = sc.nextInt();
            check = input;
            switch (input) {
                case 1:
                    add();
                    break;

                case 2:
                    delete();
                    break;

                case 3:
                    display();
                    break;

                case 4:
                    search();
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid Input!!!Try Again");
                    break;
            }
        }
    }

}