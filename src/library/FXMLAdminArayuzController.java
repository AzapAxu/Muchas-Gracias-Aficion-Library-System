package library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class FXMLAdminArayuzController implements Initializable {
    //Değişkenler tanımlanıyor.
    @FXML
    private Button kullaniciEkleButton;
    @FXML
    private Button kullaniciSilButton;
    @FXML
    private Button kitapEkleButton;
    @FXML
    private Button kitapSilButton;
    @FXML
    private Button kullaniciGosterButton;
    @FXML
    private Button adminAnaMenuButton;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    //Kullanıcı arayüzünde scene değiştirme metotları
    public void anaMenuyeDon(ActionEvent event) throws IOException { 
         Library m = new Library();
         m.changeScene("GirisEkrani.fxml");
  }
    public void kullaniciEklemeEkrani(ActionEvent event) throws IOException {
         Library m = new Library();
         m.changeScene("KullaniciEkle.fxml");
  }
    public void kullaniciSilmeEkrani(ActionEvent event) throws IOException {
         Library m = new Library();
         m.changeScene("KullaniciSil.fxml");
  }
    public void kullaniciListesiGoster(ActionEvent event) throws IOException {
        Library m = new Library();
         m.changeScene("KullaniciListesi.fxml");
    }
    public void kitapEkle(ActionEvent event) throws IOException {
        Library m = new Library();
         m.changeScene("KitapEkle.fxml");
    }
    public void kitapSil(ActionEvent event) throws IOException {
        Library m = new Library();
         m.changeScene("KitapSil.fxml");
    }
    
}
