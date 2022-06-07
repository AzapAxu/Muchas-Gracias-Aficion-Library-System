
package library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static library.Book.Books;
import static library.FXMLDocumentController.kullanici;


public class KitapBirakController implements Initializable {
    //Değişkenler tanımlanıyor.
    @FXML
    private Button kitapBirakButton;
    @FXML
    private TextField kitapAdi;
    @FXML
    private Label kitapBirakildi;
    @FXML
    private Label kitapSizinDegil;
    @FXML
    private Label kitapYok;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void kitapBirak(ActionEvent event) throws IOException {   //Queue yapısı kullanılarak kitap bırakma metodu
        Books = Book.refreshBookList();
        String name = kitapAdi.getText();
        int sayac = 0;
        for (int i=0;i<Books.size();i++) {
        if (name.equals(Book.Books.get(i).getName())) {
            sayac ++;
            if(Books.get(i).getOwner().equals(kullanici)) {
                if(!LibraryUser.queue.isEmpty()) {
					Books.get(i).setOwner(LibraryUser.queue.dequeue());
				}else {
					Books.get(i).setOwner("null");
                                      }
                Book.refreshBooks(false);
                kitapBirakildi.setVisible(true);
            }
            else {
                kitapSizinDegil.setVisible(true);
            }
         }
       }
        if (sayac == 0) {
kitapYok.setVisible(true);
        }
    }
    
    public void kullaniciAnaMenu(ActionEvent event) throws IOException { //arayüzde ana menüye dönme metodu
        Library m = new Library();
         m.changeScene("KullaniciArayuz.fxml");
    }
}
