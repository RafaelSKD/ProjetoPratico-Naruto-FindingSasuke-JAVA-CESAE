package Utils;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Utils {
    public static int random (int quantidade){
        Random rd = new Random();
        return rd.nextInt(quantidade);
    }
    public static void stop(){
        System.out.print("\n\nPressionar Enter para continuar...  ");       // Wait for user input to continue
        new Scanner(System.in).nextLine();
    }
    public static void imprimirFicheiro(String src) throws FileNotFoundException {
        Scanner data = new Scanner(new File(src));
        String linha;
        while(data.hasNextLine()){
            linha = data.nextLine();
            System.out.println(linha);
        }
        data.close();
    }
    public static void imprimirFicheiroComDelay(String src, long delayMillis) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(new File(src));

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            for (int i = 0; i < linha.length(); i++) {
                System.out.print(linha.charAt(i));
                Thread.sleep(delayMillis);
            }
            System.out.print('\n');
        }

        scanner.close();
    }
    public static void cleanConsole(){                                                          // Tool to clean console
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
