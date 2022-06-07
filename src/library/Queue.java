package library;

class Node {
    String id;
    Node next;
 
    
    public Node(String id) 
    {
        this.id = id;
        this.next = null;
    }
}
 

public class Queue {
    Node front, rear;
 
    public Queue() //Queue constructor oluşturuluyor.
    {
        this.front = this.rear = null;
    }
 
    // Sıraya veri ekleme metodu
    void enqueue(String id)
    {
 
       
        Node temp = new Node(id);
 
        if (this.rear == null) {
            this.front = this.rear = temp;
            return;
        }
 
        this.rear.next = temp;
        this.rear = temp;
    }
    
    boolean isEmpty() { //Sıranın boş olup olmadığını kontrol eden metot.
    	if(this.rear==null) {
    		return true;
    	}else {
    		return false;
    	}
    }
 
    String dequeue() //Sıraya veri çıkarma metodu
    {
      
        if (this.front == null) {
            System.out.println("Kuyruk BoÅŸ");
        	return "";
        }
 
        Node temp = this.front;
        this.front = this.front.next;
       
        if (this.front == null) {
            this.rear = null;
        }
        return temp.id;
    }
    void display() { //Sırayı gösterme metodu
    	Node tempNode=this.front;
    	System.out.println("SÄ±rada bekleyenler");
    	while(tempNode!=null) {
    		System.out.print(tempNode.id+"-->");
    		tempNode=tempNode.next;
    		
    	}
    }
}
