package library;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import static library.LibraryPerson.libraryUsers;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author Ömer Alptuğ
 */
public class KullaniciEkleController extends LibraryPerson implements Initializable {
 //Değişkenler tanımlanıyor.
	LibraryUser libraryUser  =new LibraryUser();
	LibraryPerson libraryPerson = new LibraryPerson();
@FXML
    private TextField yeniKullaniciAd;
    @FXML
    private TextField yeniKullaniciSoyad;
    @FXML
    private TextField yeniKullaniciKullaniciAd;
    @FXML
    private PasswordField yeniKullaniciSifre;
    @FXML
    private Button kullaniciEkleButton;
    @FXML
    private Label kullaniciEklendiLabel;
    @FXML
    private Label kullaniciEklenemediLabel;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void yeniKullaniciEkle(ActionEvent event) throws IOException { //Arayüzden veri çekip kullanıcı ekleme metodu
         sayac = 0;
         String name = yeniKullaniciAd.getText();
         String surname = yeniKullaniciSoyad.getText();
         String username = yeniKullaniciKullaniciAd.getText();
         String password = yeniKullaniciSifre.getText();
         for (int i = 0; i < libraryUsers.elementCount(); i++){
         if (username.equals(libraryUsers.get(i).getUserName())) {
             sayac=1;
          }
         }
         if (sayac != 0) {
              kullaniciEklenemediLabel.setVisible(true);
              sayac = 0;
         }
         else {
         File file = new File("src/Users.txt");
         file.delete();
         file.createNewFile();
         LibraryPerson.addUser(new LibraryUser(name,surname,username,password));
         kullaniciEklendiLabel.setVisible(true);
         }
    }  
  
    public void adminAnaMenu(ActionEvent event) throws IOException { //arayüzden ana menüye dönme metodu
        Library m = new Library();
         m.changeScene("AdminArayuz.fxml");
    }
}
