
package library;

import java.util.ArrayList;


public class QuickSort {
    public static ArrayList<Book> quickSort(ArrayList<Book> list)
{
    if (list.isEmpty()) 
        return list; // Özyineleme bazlı çalışıyor.
    ArrayList<Book> sorted;  // Bu döndürülecek olan sıralı liste.Dolayısıyla initialize etmeye gerek yok.
    ArrayList<Book> smaller = new ArrayList<Book>(); // Ortalamadan küçük kitaplar
    ArrayList<Book> greater = new ArrayList<Book>(); // Ortalamadan büyük kitaplar
    Book pivot = list.get(0);  // listedeki ilk kitap,ortalama olarak kullanılıyor.
    int ort = pivot.getPage();
    int i;
    Book j;          //Kitaplar ArrayListinde gezinmek için değişken oluşturuluyor.
    for (i=1;i<list.size();i++)
    {
        j=list.get(i);
        if (j.getPage()<ort)    //Karşılaştırma yapılıyor. 
            smaller.add(j);
        else
            greater.add(j);
    }
    smaller=quickSort(smaller);  //Daha küçük değerler sıralanıyor.
    greater=quickSort(greater);  // İki tarafı da özyinelemeli bir şekilde sıralıyor.
    smaller.add(pivot);          // Sıralanmış olan smaller ArrayListine ortalama değer ekleniyor.
    smaller.addAll(greater);     // Ardından aynı ArrayList'e daha büyük değerler de ekleniyor.
    sorted = smaller;            // Son olarak sıraladığımız ArrayList'i fonksiyonu döndüreceğimiz ArrayList'e ekliyoruz.

    return sorted;
}
}
