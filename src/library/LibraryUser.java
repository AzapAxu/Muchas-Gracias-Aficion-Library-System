package library;

public class LibraryUser extends User {
        static Queue queue=new Queue(); //Yeni sıra ekleniyor.
	public LibraryUser(String name, String surname,String username,String password) { //Constructor oluşturuluyor.
		super(name,surname,username,password);
	}
	public LibraryUser(){} //Default Constructor oluşturuluyor.

}
