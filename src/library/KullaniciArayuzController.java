package library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Ömer Alptuğ
 */
public class KullaniciArayuzController implements Initializable {
    //Değişkenler tanımlanıyor.
@FXML
private Button anaMenuyeDonButton;
@FXML
private Button kitapBırakButton;
@FXML
private Button kitapAlButton;
@FXML
private Button kitapGosterButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    //Arayüz için çağırma metotları yazılıyor.
    public void anaMenuyeDon(ActionEvent event) throws IOException {   
         Library m = new Library();
         m.changeScene("GirisEkrani.fxml");
  } 
    public void kitapGoster(ActionEvent event) throws IOException {   
         Library m = new Library();
         m.changeScene("KitapGoster.fxml");
  }
    public void kitapAl(ActionEvent event) throws IOException {
         Library m = new Library();
         m.changeScene("KitapAl.fxml");
  }
    public void kitapBirak(ActionEvent event) throws IOException {
         Library m = new Library();
         m.changeScene("KitapBirak.fxml");
  }
    
}
