/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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

/**
 * FXML Controller class
 *
 * @author Ömer Alptuğ
 */
public class KitapSilController implements Initializable {
    //Değişkenler tanımlanıyor.
    @FXML
    private TextField bookName;
    @FXML
    private Button kitapSilButton;
    @FXML
    private Label kitapSilindiLabel;
    @FXML
    private Label kitapSilinmediLabel;
    
     int a;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    public void kitapSil() throws IOException { //Arayüzden silmek için kitap çekme metodu
        a = Books.size();
        String name = bookName.getText();
        Book.removeBook(name.replace(" ","-"));
        if (Books.size()<a) {
            kitapSilindiLabel.setVisible(true);
        }
        else {
            kitapSilinmediLabel.setVisible(true);
        }
    }
    
    
    public void adminAnaMenu(ActionEvent event) throws IOException {  //arayüzden ana menüye dönme metodu
        Library m = new Library();
         m.changeScene("AdminArayuz.fxml");
    }
    
}
