package library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import static library.LibraryPerson.libraryUsers;

/**
 * FXML Controller class
 *
 * @author Ömer Alptuğ
 */
public class KullaniciListesiController implements Initializable {
    //Değişkenler tanımlanıyor.
    @FXML
    private ListView mListView;
    @FXML
    private Label sizeLabel;
    
    int a;
    Stack stack = new Stack();

    @Override
    public void initialize(URL url, ResourceBundle rb){
       
            kullaniciGoster();   //Metot çağrılıyor.
    }
    public void kullaniciGoster() {     //Listview oluşturulup kullanıcı bastırılma metodu
        LibraryUser libraryUser;
        for (int i=0;i<libraryUsers.elementCount();i++) {
        stack.push(libraryUsers.get(i));
        }
        a = stack.size();
        String b = sizeLabel.getText();
        sizeLabel.setText(b+a);
        for (int i=0;i<libraryUsers.elementCount();i++) {
        libraryUser = stack.pop();
        mListView.getItems().add("Kullanıcı "+(i+1));
        mListView.getItems().add("-----------------------------------");
        mListView.getItems().addAll("Adı               : "+libraryUser.getName());
        mListView.getItems().addAll("Soyadı          : "+libraryUser.getSurname());
        mListView.getItems().addAll("Kullanıcı Adı : "+libraryUser.getUserName());
        mListView.getItems().add("");
        }
    }
    public void kullaniciYenile(ActionEvent event) throws IOException { //Kullanıcı listesi yenileme metodu
        libraryUsers = BListe.refreshUserList();
        mListView.getItems().clear();
        for(int i = 0; i < libraryUsers.elementCount(); i++) {
            if (mListView.getItems().contains(libraryUsers.get(i).getName())) {
                
            }
            else {
            mListView.getItems().add("Kullanıcı "+(i+1));
            mListView.getItems().add("-----------------------------------");
            mListView.getItems().addAll("Adı               : "+libraryUsers.get(i).getName());
            mListView.getItems().addAll("Soyadı          : "+libraryUsers.get(i).getSurname());
            mListView.getItems().addAll("Kullanıcı Adı : "+libraryUsers.get(i).getUserName()); 
            mListView.getItems().add("");
            }
       }  
    }
    public void adminAnaMenu(ActionEvent event) throws IOException { //Arayüzden ana menüye dönme metodu
        Library m = new Library();
         m.changeScene("AdminArayuz.fxml");
    }    
}
