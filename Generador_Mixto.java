package generadores;

import javax.swing.JOptionPane;

/**
 *
 * @author Raquel
 */
public class Generador_Mixto {
    //METODO PARA VERIFICAR EL NUMERO PRIMO
    public static boolean primo(int num) {
        int cont = 2;
        boolean n_primo = true;//Nos devuelve un valor booleano para determinar si es o no primo
        while ((n_primo) && (cont != num)) { //Mientras la condicion sea true y el cont no llegue al tope del numero ingresado
            if (num % cont == 0) {//Si el residuo del num entre el contador es 0, entonces la condicion cambia a falso
                n_primo = false;
            }
            cont++;
        }
        return n_primo;
    }

    //METODO PARA ESCOGER EL NUMERO PRIMO RELATIVO A M
    public static double numero_Primo_Cercano(double num) {
        int cont = 2;
        boolean n_primo = true;

        while ((n_primo) && (cont != num)) {
            if (num % cont == 0) {
                n_primo = false;
            }
            cont++;
        }

        if (n_primo) {//Si la condicion es un true, entonces retorna el numero
            return num;
        } else {//caso contrario retorna el numero enviado en el parametro decrementado en 1
            return numero_Primo_Cercano(num - 1);
        }

    }

    public static void main(String[] args) {//CLASE PRINCIPAL MAIN
        //DECLARACIÓN DE LAS VARIABLES QUE SE VAN A OCUPAR
        double g = 0, n = 0, m_modulo, x;
        int k, a_multiplicador, c_aditiva; 
        boolean entero = true;
        
        //SELECCIONAR EL MODULO
        int n_validacion = 0;
        while (entero) {//Mientras la condicion sea true se va a seguir ejecutando
            try {//Capturamos el datos para hacer la validacion de que sea un numero entero --> Uso del TRY para excepciones
                n_validacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el valor de g para el modulo", "MODULO \nm=2^g", JOptionPane.INFORMATION_MESSAGE));
                entero = false;
            } catch (NumberFormatException e) {

            }
        }
        g = n_validacion;//la variable g va a tomar el valor del numero validado

        m_modulo = Math.pow(2, g);//Se realiza la operacion para determinar el valor del modulo

        //SELECCIONAR EL VALOR DEL MULTIPLICADOR
        //a = 1 + 4k
        entero = true;
        n_validacion = 0;
        while (entero) {
            try {
                n_validacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese k para el calculo del Multiplicador:", "MULTIPLICADOR\na=1+4k", JOptionPane.INFORMATION_MESSAGE));
                entero = false;
            } catch (NumberFormatException e) {

            }
        }
        k = n_validacion;//Asignación

        a_multiplicador = 1 + (4 * k);
        
        //SELECCIONAR EL VALOR DE LA CONSTANTE ADITIVA
        c_aditiva = (int) Generador_Mixto.numero_Primo_Cercano(m_modulo); //Hacemos un cast ya que el metodo devuelve un double

        JOptionPane.showMessageDialog(null, "El valor primo relativo a M es: " + Generador_Mixto.numero_Primo_Cercano(c_aditiva));
        x = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor de X", "SEMILLA", JOptionPane.INFORMATION_MESSAGE));

        boolean validar_X = true;
        while (validar_X) {
            if (x > 0) {
                validar_X = false;
            } else {
                x = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor de X", "SEMILLA", JOptionPane.INFORMATION_MESSAGE));
            }
        }

        //REALIZACIÓN DE LA SERIE FINAL
        JOptionPane.showMessageDialog(null, "***SERIE GENERADA***");
        System.out.println("Contador (i)" + "\t\t" + "Semilla (x)" + "\t\t" + "n" + "\t\t" + "(n/modulo)");//Presentamos el formato final
        double periodo = x / m_modulo; //Variable para calcular el periodo

        for (int i = 0; i < m_modulo; i++) {
            int cont = 1;
            n = (a_multiplicador * x + c_aditiva) % m_modulo;//Aplicacion de la formula
            System.out.println(i + "\t\t\t" + x + "\t\t\t" + n + "\t\t" + n + "/" + m_modulo);
            x = n;
            if (periodo == n / m_modulo) {
                System.out.println("LA SERIE GENERA " + cont + " PERIODOS");
                cont++;
            }
        }

    }
}
