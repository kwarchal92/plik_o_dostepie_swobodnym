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



}


public class Main {
    public static void main(String[] args)
        throws IOException
    {
        File1 file = new File1();

        file.zapisdoPliku();
    }
}
