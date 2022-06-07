package library;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class BNode
{
	LibraryUser user;
		
    public BNode next;       
}
public class BListe 
{
	
	 static BNode head = null;
    public void initialize(LibraryUser user) //Bağlı liste oluşturma metodu
    {
      head = new BNode();
      head.user=user;
      
      head.next = null; 
    }

	
    
public void addElementLast(LibraryUser user) //Bağlı listeye veri ekleme metodu
 {
       BNode newBNode = new BNode();
       newBNode.user=user;
       newBNode.next = null;
       if(head==null) {
    	   head=new BNode();
    	   head.user=user;
    	   head.next=null;
       }else {
    	   BNode temp = head;
           while(temp.next != null)
           {
              temp = temp.next;
           }
           temp.next = newBNode; 
       }
                     
 }

public User naber(User user) {
	return user;
};
public static void refreshUsers(Boolean appendState) throws IOException { //kullanıcı listesi yenileme metodu
	BNode temp=head;
	File file=new File("src/Users.txt");
	if (!file.exists())
	{
		file.createNewFile();
	}
	FileWriter fWriter=new FileWriter(file,appendState);
	BufferedWriter bWriter = new BufferedWriter(fWriter);
	while(temp!=null) {
		bWriter.write(temp.user.getName()+" "+temp.user.getSurname()+" "+temp.user.getUserName()+" "+temp.user.getPassword());
		bWriter.newLine();
		bWriter.flush();
		temp=temp.next;
	}
	
	bWriter.close();
}
public User getUser(int x) {   //Kullanıcı verisi çekme metodu
	int i=0;
	User user;
	BNode temp=head;
	while(temp!=null || i>x) {
			try
			{
				user=temp.user;
				return user;
	
			} finally 
			{
				temp=temp.next;
				while(temp!=null || i>x) {
					return temp.user;
				}
			
			}
			
			}
	return null;
	
	
}
public int elementCount()  //Bağlı liste veri sayısı tutan metot
 {
       BNode temp = head;
       int count = 0;
       while(temp != null)
       {
           count++;
           temp = temp.next;
       }
      return count;               
 }
public LibraryUser get(int i) {

    int n = elementCount()-1;
    BNode current = head;
    while (n > i) {
        --n;
        current = current.next;
    }
    return current.user;
}


public void concatenate(BListe lis1,BListe list2) { //Bağlı liste birleştirme metodu
	BNode tempBNode= lis1.head;
	
	while(tempBNode.next!=null) {
		tempBNode=tempBNode.next;
	}
	tempBNode.next=list2.head;

}
public static BListe refreshUserList() throws IOException { //Kullanıcı listesi yenileme metodu
        BListe newBList = new BListe();
	refreshUsers(true);
	FileReader fReader = new FileReader("src/Users.txt");
	String line;
	BufferedReader bufferedReader = new BufferedReader(fReader);
	while ((line = bufferedReader.readLine()) != null) {
		String[] keys = line.split(" ");
		LibraryUser newUser =new LibraryUser(keys[0],keys[1],keys[2],keys[3]);
		newBList.addElementLast(newUser);
		
	}
	bufferedReader.close();

	return newBList;
}

public static BListe kullaniciYenile() throws FileNotFoundException, IOException {  //Kullanıcı listesi yenileme metodu
        FileReader fReader = new FileReader("src/Users.txt");
	String line;
	BufferedReader bufferedReader = new BufferedReader(fReader);
	while ((line = bufferedReader.readLine()) != null) {
		String[] keys = line.split(" ");
		LibraryUser newUser =new LibraryUser(keys[0],keys[1],keys[2],keys[3]);
		LibraryPerson.libraryUsers.addElementLast(newUser);
		
	}
	bufferedReader.close();
        
	return LibraryPerson.libraryUsers;
}

public static void tersCevir() {   //Bağlı liste ters çevirme metodu
	BNode tempBNode=head;
	BNode startBNode,previousBNode=null;
	while(tempBNode!=null) {
		startBNode=tempBNode.next;
		tempBNode.next=previousBNode;
		previousBNode=tempBNode;
		tempBNode=startBNode;
	}
		head=previousBNode;
}

public boolean deleteBNode(String data) throws IOException  //Bağlı listeden veri silme metodu
    {
       boolean durum = false;
       BNode current = head;
       BNode tmp = null;      
       if (current.user.getUserName() == data)
       {
          tmp = current.next;
          head = tmp;
       }
       else

    {
        {
           while(current.next != null)
           { 
              if (current.next.user.getUserName() == data)
              {
                 tmp = current.next;
                 current.next = tmp.next;
                 durum = true;
                 break;
              }
              current = current.next;
           }      
       }       
    
}
       refreshUsers(false);
       return durum;
}


}
