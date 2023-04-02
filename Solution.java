import java.io.*;
import java.util.*;

class Node{
    Object data;
    Node next;
    Node(Object data){
        this.data = data;
    }
}
class LinkedList{
    Node head;
    Node tail;
    public boolean isEmpty(){

        return this.head == null;
    }
    public void addLast(Object data){
        Node node = new Node(data);
        if (this.head == null){
            head = tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }
    
    public void removeIndex(int index){
        if(index == 0){
            head = head.next;
        }else{
            Node current = head;
            for (int i = 0; i < (index - 1); i++) {
                current = current.next;
            }
            if(current.next == tail){
                tail = current;
            }
            current.next = current.next.next;
        }
    }

    public void print(){
        Node temp = head;
        while (temp != null){
            if(temp.next != null){
                System.out.print(temp.data + "-");
            }else{
                System.out.print(temp.data);
            }
            temp = temp.next;
        }
    }

}
public class Solution {
    public static void main(String[] args) {
        LinkedList sll = new LinkedList();
        Scanner input = new Scanner(System.in);
        String nama = input.nextLine();
        boolean par = true;
        while(par) {
            String[] command = input.nextLine().toUpperCase().split(" ");
            if (command[0].equals("TAMBAH")) {
                sll.addLast(command[1]);
            } else if (command[0].equals("LEPAS")) {
                sll.removeIndex(Integer.parseInt(command[1]));
            } else if (command[0].equals("CETAK")) {
                System.out.println(nama);
                sll.print();
               par = false;
            }
        }
    }
}
