
package library;

class SNode
{
    LibraryUser data;       // integer veri
    SNode next;      // Sonraki Node'un işaretleyicisi
}
 
public class Stack
{
    //Değişkenler ekleniyor.
    private SNode top;
    private int nodesCount;
 
    public Stack() { //Stack constructor oluşturuluyor.
        this.top = null;
        this.nodesCount = 0;
    }
 

    @SuppressWarnings("unused")
	public void push(LibraryUser x)    //Stack'e yeni veri ekleme fonksiyonu yazılıyor.
    {
       
        SNode node = new SNode();

        if (node == null)
        {
            System.out.println("Overflow gerçekleşti");
            return;
        }
 
        System.out.println("Ekleniyor " + x);
 
        
        node.data = x;
 
       
        node.next = top;
 
       
        top = node;
 
        this.nodesCount += 1;
    }
 

    public boolean isEmpty() {     //Stack'in boş olup olmadığı kontrol ediliyor.
        return top == null;
    }
 

    public LibraryUser peek()    //Stack boş ise çıktı veriliyor.
    {
        if (isEmpty()) {
            System.out.println("Stack boş");
            System.exit(-1);
        }
        return top.data;
    }
 
    
    public LibraryUser pop()       //Stack'ten veri çekme fonksiyonu yazılıyor. 
    {
        if (isEmpty())
        {
            System.out.println("Stack Underflow");
            System.exit(-1);
        }
 
        LibraryUser top = peek();
 
        System.out.println("Siliniyor " + top);
 
        this.nodesCount -= 1;
 
        this.top = (this.top).next;
 
        return top;
    }
 
    public int size() {     //Stack'in boyutunu alma fonksiyonu yazılıyor.
        return this.nodesCount;
    }
}
