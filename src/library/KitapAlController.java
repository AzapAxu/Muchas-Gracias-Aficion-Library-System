/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import static library.Book.Books;
import static library.FXMLDocumentController.kullanici;

/**
 * FXML Controller class
 *
 * @author Ömer Alptuğ
 */
public class KitapAlController implements Initializable {
    //Değişkenler tanımlanıyor.
    @FXML
    private Button kitapAraButton;
    @FXML
    private Button kitapAlAnaMenuButton;
    @FXML
    private TextField kitapName;
    @FXML
    private Label basariliLabel;
    @FXML
    private Label kitapBulunamadiLabel;
    @FXML
    private Label kuyrugaEkleLabel;
    @FXML
    private Label kitapSizde;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void kitapAra(ActionEvent event) throws IOException {  //Queue yapısı kullanılarak kütüphaneden kitap alma metodu
        Books = Book.refreshBookList();
        String name = kitapName.getText();
        int sayac = 0;
        for (int i=0;i<Books.size();i++) {
        if (name.equals(Book.Books.get(i).getName())) {
            sayac++;
            if(Book.Books.get(i).getOwner().equals("null")) {
                basariliLabel.setVisible(true);
                Book.Books.get(i).setOwner(kullanici);
                Book.refreshBooks(false);
            }
            else {
                if(Book.Books.get(i).getOwner().equals(kullanici)) {
                    kitapSizde.setVisible(true);
                }
                else {
                    kuyrugaEkleLabel.setVisible(true);
                    LibraryUser.queue.enqueue(kullanici);
                    LibraryUser.queue.display();
                }
            }
         }
       }
        if (sayac==0) {
            kitapBulunamadiLabel.setVisible(true);
        }
        
       
    }
    public void kullaniciAnaMenu(ActionEvent event) throws IOException { //arayüzde anamenüye dönme metodu
        Library m = new Library();
         m.changeScene("KullaniciArayuz.fxml");
    }
}
