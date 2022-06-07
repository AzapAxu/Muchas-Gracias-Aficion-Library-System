package library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LibraryPerson extends User {
     static int sayac;
     static int a = 0;
	public LibraryPerson(String name,String surname,String username,String password) { //Constructor yazılıyor.
		super(name, surname,username, password);
	}

	public LibraryPerson(){}; //Default Constructor yazılıyor.


	static BListe libraryUsers=new BListe(); //Kullanıcıların tutulacağı bağlı liste oluşturuluyor.

        
	public static void addUser(LibraryUser user) throws IOException { //Kullanıcı ekleme metodu
              File file=new File("src/Users.txt");
          if (a==0) {
              System.out.println(file.length());
              if (file.length()>2) {
            a++;
           libraryUsers =  BListe.refreshUserList();
              }
        }
		try
		{
			libraryUsers.addElementLast(user);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		libraryUsers.refreshUsers(false);
	}
        
        public static void removeUser(String username) throws IOException { //Kullanıcı silme metodu
         sayac = 0;
        for (int i = 0 ;i<libraryUsers.elementCount();i++) 
			if (libraryUsers.get(i).getUserName().equals(username)) {
				libraryUsers.deleteBNode(libraryUsers.get(i).getUserName());
                        }
                                sayac=1;  
    }

	// arraylist'in içindekileri txt dosyasına yazıyor
	
        public void usersList() {
                try {
			FileReader fReader = new FileReader("src/Users.txt");
			String line;
			BufferedReader bufferedReader=new BufferedReader(fReader);
			System.out.println("-------------------------------------");
			while ((line=bufferedReader.readLine())!=null)
			{
				System.out.println(line);
			}
			System.out.println("-------------------------------------");
			bufferedReader.close();
		}catch (Exception e){
			System.out.println(e.getStackTrace());
		}
        }


}

