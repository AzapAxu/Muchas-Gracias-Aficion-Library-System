
package library;

public class User {

        //Değişkenler tanımlanıyor.
	private String name;
	private String surname;
	private String password;
	private String username;

	public User(String name,String surname,String username,String password) {  //Constructor oluşturuluyor.
		this.name=name;
		this.surname=surname;
                this.username = username;
		this.password=password;
	}

	public User() { //Default Constructor oluşturuluyor.

	}
        //Değişkenleri çağırma fonksiyonları ekleniyor.
	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return username;
	}

	public String getName() {
		return this.name;
	}
	public	String getSurname() {
		return this.surname;
	}	
}