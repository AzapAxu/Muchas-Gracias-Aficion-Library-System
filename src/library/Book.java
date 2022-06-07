package library;

import java.io.*;
import java.util.ArrayList;

public class Book {
    static int a = 0;
    public static ArrayList<Book> Books = new ArrayList<>();
    //Kitaplar ArrayListindeki değişkenleri çağırma metotları
    public String getName() {
        return name;
    }

    public String getAuthoor() {
        return authoor;
    }

    public String getOwner() {
        return owner;
    }
    public int getPage() {
        return page;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

   
    private String name;
    private String authoor;
    private String owner;
    private int page;

    public Book(String name, String authoor,String owner,int page){ //Constructor oluşturuluyor.
        this.name=name;
        this.authoor=authoor;
        this.owner=owner;
        this.page=page;
    }

    
    public static void addBook(String name ,String author,int page) throws IOException { //Kitap ekleme metodu
        File file=new File("src/Books.txt");
          if (a==0) {
              if (file.length()>2) {
            a++;
           Books = refreshBookList();
              }
        }
        Book newBook = new Book(name,author,null,page);
        Book.Books.add(newBook);

        refreshBooks(false);

    }

    // bu method arraylist'in içindeki verileri txt dosyasına yazıyor
    public static void refreshBooks(boolean appendState) throws IOException {
        File file=new File("src/Books.txt");
        if (!file.exists())
        {
            file.createNewFile();
        }
        FileWriter fWriter=new FileWriter(file,appendState);
        BufferedWriter bWriter = new BufferedWriter(fWriter);

        for (int i = 0; i < Books.size(); i++){
            bWriter.write(Books.get(i).getName()+" "+Books.get(i).getAuthoor()+" "+Books.get(i).getOwner()+" "+Books.get(i).getPage());
            bWriter.newLine();

        }
        bWriter.close();
    }

    public static void removeBook(String name) throws IOException { //Kitap silme metodu
        Books = refreshBookList();
        System.out.println(Books.size());
        for (int i = 0 ; i<Books.size();i++) {
            if (Books.get(i).getName().equals(name)) {
                Books.remove(i);
            }
        }
        refreshBooks(false);
        System.out.println(Books.size());
    }

    // txt dosyasındaki verileri arraylist'e yazıyor
    public static ArrayList<Book> refreshBookList() throws IOException {
        ArrayList<Book> newBooks = new ArrayList<>();
        FileReader fReader = new FileReader("src/Books.txt");
        String line;
        BufferedReader bufferedReader = new BufferedReader(fReader);
        while ((line = bufferedReader.readLine()) != null) {
            String[] keys = line.split(" ");
            int a = Integer.parseInt(keys[3]);
            Book newBook = new Book(keys[0], keys[1],keys[2],a);
            newBooks.add(newBook);
        }
        bufferedReader.close();

        return newBooks;
    }
    public static ArrayList<Book> kitapYenile() throws IOException {
        refreshBooks(false);
        FileReader fReader = new FileReader("src/Books.txt");
        String line;
        BufferedReader bufferedReader = new BufferedReader(fReader);
        while ((line = bufferedReader.readLine()) != null) {
            String[] keys = line.split(" ");
            int a = Integer.parseInt(keys[3]);
            Book newBook = new Book(keys[0], keys[1],keys[2],a);
            Books.add(newBook);
        }
        bufferedReader.close();

        return Books;
    }
    

}
