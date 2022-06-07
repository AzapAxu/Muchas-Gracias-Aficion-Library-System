package library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Ömer Alptuğ
 */
public class FXMLDocumentController implements Initializable {
    //Değişkenler tanımlanıyor.
    int a = 0;
    static String kullanici;
    @FXML
    private Label hataliGiris;
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passField;
    @FXML
    private Button adminGirisButton;
    @FXML
    private Button girisButton;
    @FXML
    private AnchorPane AnchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void adminGiris(ActionEvent event) throws IOException { //Admin arayüzüne geçme metodu
        Library m = new Library();
        m.changeScene("AdminArayuz.fxml");
    }
    
    @FXML
    private void kullaniciGiris(ActionEvent event) throws IOException { //Kullanıcı arayüzüne geçme metodu
        //libraryUsers = BListe.refreshUserList();
        //refreshUsers(false);
        Library m = new Library();
        kullanici = usernameField.getText();
        String sifre = passField.getText();
     for (int i=0;i<LibraryPerson.libraryUsers.elementCount();i++) {
        if (LibraryPerson.libraryUsers.get(i).getUserName().equals(kullanici) && LibraryPerson.libraryUsers.get(i).getPassword().equals(sifre))
        {
            m.changeScene("KullaniciArayuz.fxml");
        }
        else {
            hataliGiris.setVisible(true);
         }
        }
    }
    
}