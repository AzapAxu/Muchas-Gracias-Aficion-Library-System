
package library;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import static library.BListe.tersCevir;
import static library.Book.Books;
import static library.QuickSort.quickSort;

/**
 * FXML Controller class
 *
 * @author Ömer Alptuğ
 */
public class KitapGosterController implements Initializable {
    //Değişkenler tanımlanıyor.
    @FXML
    private ListView kitapListView;
    @FXML
    private Label sizeLabel;
    @FXML
    private Button kitapYenileButton;
    @FXML
    private Button kitapAraButton;
    @FXML
    private TextField kitapAra;
    @FXML
    private Label bulunduLabel;
    @FXML
    private Label bulunamadiLabel;
    int a;
    int sayac = 0;
    String c = "";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        kitapGoster();
    }    
    public void kullaniciAnaMenu(ActionEvent event) throws IOException { //arayüzden anamenüye dönme metodu
        Library m = new Library();
         m.changeScene("KullaniciArayuz.fxml");
    }
    public void kitapGoster() {                               //ListView'e kitap ekleme metodu
        for (int i=0;i<Books.size();i++) {
            kitapListView.getItems().add("Kitap "+(i+1));
            kitapListView.getItems().add("-----------------------------------");
            kitapListView.getItems().addAll("Adı              : "+Books.get(i).getName());
            kitapListView.getItems().addAll("Yazarı          : "+Books.get(i).getAuthoor());
            kitapListView.getItems().addAll("Sayfa Sayısı : "+Books.get(i).getPage());
            kitapListView.getItems().add("");
        }
        a = Books.size();
        String b = sizeLabel.getText();
        sizeLabel.setText(b+a);
    }
    public void kitapYenile(ActionEvent event) throws IOException { //Kitap listesi yenileme metodu
        Books = Book.refreshBookList();
        for(int i = 0; i < Books.size(); i++) {
            kitapListView.getItems().add("Kitap "+(i+1));
            kitapListView.getItems().add("-----------------------------------");
            kitapListView.getItems().addAll("Adı              : "+Books.get(i).getName());
            kitapListView.getItems().addAll("Yazarı          : "+Books.get(i).getAuthoor());
            kitapListView.getItems().addAll("Sayfa Sayısı : "+Books.get(i).getPage());
            kitapListView.getItems().add("");
       } 
     
    }
    public void kitapSirala(ActionEvent event) throws IOException { //Quicksort kullanılarak kitap sıralama metodu
        kitapListView.getItems().clear();
            for (int i=0;i<Books.size();i++) {
                kitapListView.getItems().add("Kitap "+(i+1));
                kitapListView.getItems().add("-----------------------------------");
                kitapListView.getItems().addAll("Adı              : "+quickSort(Books).get(i).getName());
                kitapListView.getItems().addAll("Yazarı          : "+quickSort(Books).get(i).getAuthoor());
                kitapListView.getItems().addAll("Sayfa Sayısı : "+quickSort(Books).get(i).getPage());
                kitapListView.getItems().add("");
        }
    }
    public void kitapAra(ActionEvent event) {     //Linear search kullanarak kitap arama metodu
        for (int i=0;i<Books.size();i++) {
            c = Books.get(i).getName();
            Pattern pattern = Pattern.compile(c);
            Matcher matcher = pattern.matcher(kitapAra.getText());
            if(matcher.matches()) {
                bulunduLabel.setVisible(true);
                kitapListView.getItems().clear();
                kitapListView.getItems().add("Sonuçlar:");
                kitapListView.getItems().add("Kitap "+(sayac+1));
                kitapListView.getItems().add("-----------------------------------");
                kitapListView.getItems().addAll("Adı              : "+Books.get(i).getName());
                kitapListView.getItems().addAll("Yazarı          : "+Books.get(i).getAuthoor());
                kitapListView.getItems().addAll("Sayfa Sayısı : "+Books.get(i).getPage());
                kitapListView.getItems().add("");
                sizeLabel.setVisible(false);
                sayac++;
            }
        }
        if (sayac==0) {
            bulunamadiLabel.setVisible(true);
            kitapListView.getItems().clear();
            sizeLabel.setVisible(false);
        }

    }
}