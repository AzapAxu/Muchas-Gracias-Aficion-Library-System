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

/**
 * FXML Controller class
 *
 * @author Ömer Alptuğ
 */
public class KitapEkleController implements Initializable {
    //Değişkenler tanımlanıyor.
    @FXML
    private TextField bookName;
    @FXML
    private TextField bookAuthor;
    @FXML
    private TextField bookPage;
    @FXML
    private Label kitapEklendiLabel;
    @FXML
    private Button kitapEkleButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void yeniKitapEkle(ActionEvent event) throws IOException {  //arayüzden eklemek için kitap çağırma metodu
                        String name = bookName.getText();
			String author = bookAuthor.getText();
                        int page = Integer.parseInt(bookPage.getText());
                        Book.addBook(name.replace(" ","-"),author.replace(" ","-"),page);
                        kitapEklendiLabel.setVisible(true);
    }
    
    public void adminAnaMenu(ActionEvent event) throws IOException {  //arayüzde anamenüye dönme metodu
        Library m = new Library();
         m.changeScene("AdminArayuz.fxml");
    }
    
}
