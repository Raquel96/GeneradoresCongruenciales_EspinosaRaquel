package generadores;

import java.util.Scanner;

/**
 *
 * @author Raquel
 */
public class Generador_Multiplicativo {
//CLASE GENARADORA

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //DECLARACIÓN DE LAS VARIABLES
        int semilla, c_multiplicativa, c_aditiva, modulo;

        int i, n1;

        double n2;

        //INGRESO DE DATOS PARA EL GENERADOR
        System.out.print("Ingrese el valor de la semilla: ");

        semilla = entrada.nextInt();

        System.out.print("Ingrese el valor de la constante multiplicativa: ");

        c_multiplicativa = entrada.nextInt();

        System.out.print("Ingrese el valor del 5módulo: ");

        modulo = entrada.nextInt();

        //CALCULO DE LA ECUACIÓN
        for (i = 1; i <= 20; i++) {

            n1 = (c_multiplicativa * semilla) % modulo;

            n2 = (double) n1 / (double) (modulo - 1);

            //PRESENTACIÓN DE LOS DATOS
            System.out.printf("%d. %d (%.4f)\n", i, n1, n2);

            semilla = n1;

        }
    }
}
