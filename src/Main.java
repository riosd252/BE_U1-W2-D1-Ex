import exceptions.BancaException;
import it.be.conti.ContoCorrente;
import it.be.conti.ContoOnLine;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Digita un numero da 1 a 3 per selezionare l'esercizio da eseguire, oppure 0 per chiudere l'applicazione.");
            int excersizeToExecute = scanner.nextInt();
            if (excersizeToExecute != 0) {

                switch (excersizeToExecute) {

                    case 1:
                        System.out.println("Ex. 1");

                        int[] newArr = new int[5];

                        for (int i = 0; i < newArr.length; i++) {
                            Random rand = new Random();
                            newArr[i] = rand.nextInt(1, 10);
                        }

                        System.out.println(Arrays.toString(newArr));

                        while (true) {
                            try {
                                System.out.println("Digita il valore numerico da inserire, oppure 0 per annullare l'operazione.");
                                int newNum = scanner.nextInt();
                                if (newNum != 0) {
                                    System.out.println("Digita la posizione selezionata:");
                                    int index = scanner.nextInt();
                                    newArr[index - 1] = newNum;
                                    System.out.println(Arrays.toString(newArr));
                                } else {
                                    break;
                                }
                            } catch (IndexOutOfBoundsException exception) {
                                System.err.println(exception.getMessage());
                            }
                        }
                        break;
                    case 2:
                        while (true) {
                            System.out.println("Digita km percorsi o 0 per uscire:");
                            int kmPercorsi = scanner.nextInt();
                            if (kmPercorsi != 0) {
                                System.out.println("Digita consumo carburante:");
                            int consumoLitri = scanner.nextInt();

                            try {
                                int kmAlLitro = kmPercorsi / consumoLitri;
                                System.out.println("La media di km al litro è di: " + kmAlLitro);
                            } catch (ArithmeticException exception) {
                                System.err.println(exception.getMessage());
                            }
                        } else {
                                break;
                            }
                        }

                        break;

                    case 3:
                        ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 20000.0);

                        System.out.println("Saldo conto: " + conto1.restituisciSaldo());

                        try {
                            conto1.preleva(20001.0);

                            System.out.println("Saldo conto: " + conto1.restituisciSaldo());
                        } catch (BancaException e) {
                            System.err.println("Errore durante il prelievo: " + e.getMessage());
                        }

                        ContoOnLine conto2 = new ContoOnLine("Rossi Luigi", 50350.0, 1500);

                        conto2.stampaSaldo();

                        try {
                            conto2.preleva(1700);

                            conto2.stampaSaldo();

                        } catch (BancaException e) {
                            System.err.println("Errore durante il prelievo: " + e.getMessage());

                        }


                }
            } else {
                break;
            }
        }
    }
}