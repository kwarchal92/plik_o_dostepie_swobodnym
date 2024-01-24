package zadanie;
import java.io.*;

//Napisz program, który umieszcza w pliku o dostepie swobodnym tablicę
//przeprowadzonych pomiarów, a następnie wyświetla z pliku co drugi
//pomiar na ekranie monitora

class File1
{
    double tablica[] = {15.6, 7, 48.6, 61.7, 94.3, 0.94};
    double d;

    public void zapisdoPliku()
        throws IOException
    {
        RandomAccessFile raf = new RandomAccessFile("pomiary.dat", "rw");
        //rw - otwarcie pliku o dostepie swobodnym w trybie zapisu i odczytu

        for (int i = 0; i < tablica.length; i++)
            raf.writeDouble(tablica[i]); //zapis elementów tablicy do pliku

        raf.close(); //zamkniecie pliku
    }

    public void odczytPliku()
        throws IOException
    {
        RandomAccessFile raf = new RandomAccessFile("pomiary.dat", "r");
        //"r" otwarcie pliku o dostepie swobodnym tylko w trybie odczytu

        for (int i = 0; i < tablica.length; i+=2)
        {
            raf.seek(8*i);//typ double ma 8 bajtow
            d = raf.readDouble(); //odczyt danych z pliku
            System.out.println(d);
        }
        raf.close(); //zamkniecie pliku
    }

}


public class Main {
    public static void main(String[] args)
        throws IOException
    {
        File1 file = new File1();

        System.out.println("Program wyswietla co drugi pomiar zapisany wczesniej w pliku pomiary.dat");

        file.zapisdoPliku();
        file.odczytPliku();
    }
}
