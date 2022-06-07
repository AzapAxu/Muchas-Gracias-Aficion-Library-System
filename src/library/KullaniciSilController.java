package library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static library.LibraryPerson.libraryUsers;

/**
 * FXML Controller class
 *
 * @author Ömer Alptuğ
 */
public class KullaniciSilController implements Initializable {
    //Değişkenler tanımlanıyor.
    @FXML
    private TextField username;
    @FXML
    private Button kullaniciSilButton;
    @FXML
    private Button anaMenuButton;
    @FXML
    private Label kullaniciSilHataLabel;
    @FXML
    private Label kullaniciSilindiLabel;

    int a = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    @FXML
    public void kullaniciSil(ActionEvent event) throws IOException { //Arayüz'den silinecek kullanıcıyı çekme metodu
        String usernameDelete = username.getText();
        a = libraryUsers.elementCount();
        LibraryPerson.removeUser(usernameDelete);
        if (libraryUsers.elementCount()<a) {
             kullaniciSilindiLabel.setVisible(true);
        }
        else {
             kullaniciSilHataLabel.setVisible(true);
        }
    }
    public void adminAnaMenu(ActionEvent event) throws IOException {  //Arayüz'de ana menüye dönme metodu
        Library m = new Library();
         m.changeScene("AdminArayuz.fxml");
    }
}
