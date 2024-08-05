import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
       public static void main(String[] args) throws FileNotFoundException {
        int[] arr = new int[500_000];
        int n = 0;
    
        Scanner scan = new Scanner(new File("C:/Users/miche/Downloads/dados500_mil.txt"));
        while (scan.hasNextInt() && n < 500_000){
            arr[n++] = scan.nextInt();
        }

        HeapSort ob = new HeapSort();

        long inicio = System.currentTimeMillis();
        ob.ordenar(arr);
        long fim = System.currentTimeMillis();

        long tempoTotal = fim - inicio;
        long minutos = tempoTotal/ 60000;
        long segundos = (tempoTotal% 60000)/1000;
        long milissegundos = tempoTotal%1000;

        System.out.println("tempo de execução: " +minutos+ " minutos, "+segundos+" segundos, "+milissegundos+" milissegundos");
    }
}
