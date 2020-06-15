
//***** Detector de errores por paridad par o paridad impar *****

package PaqueteLogica;

import java.util.Scanner;

public class Programa {

    public static void main(String[] args) 
    {
        // Declaración de variables
        long Numero_binario;
        long Dividendo;
        long Cociente;
        int Cifras;
        long Residuo;
        long Suma = 0;
        long i;
        long BitParidad;
        Scanner escaneo = new Scanner(System.in);
        
        //Mensaje Información - Título del programa
        System.out.print("\tDetector de errores.\n\n");
        
        //Mensaje Información - Ingresar el número binario
        System.out.print("Ingrese el número binario: ");
        Numero_binario = escaneo.nextLong();   //Leer número binario
        
        Dividendo = Numero_binario;   //Asignación del número binario a la variable Dividendo
        Cifras = 0;                   //Inicializar variable Cifras con el valor de 0
        
        //Mientras Dividendo sea diferente de 0
        while(Dividendo!=0)
        {
            Cociente = Dividendo/10;  //Asignación de la división entre Dividendo y 10 a la variable COciente
            Dividendo = Cociente;     //Asignación de la variable Cociente a la variable Dividendo
            Cifras++;                 //Contabilizar el número de cifras mientras se cumpla la condición
        }

        //Mensaje Información - Número de Cifras
        System.out.println("El numero de cifras es: "+Cifras);

        Dividendo = Numero_binario;   //Asignación del número binario a la variable Dividendo
        i = Cifras-1;                 //Número de cifras totales menos 1, asignado a la variable i (Exponente) 
        
        //Mientras i sea mayor o igual que 0
        while(i>=0)                   
        {
            Cociente = Dividendo/10;  //Asignación de la división entre Dividendo y 10 a la variable COciente
            Residuo = Dividendo%10;   //Módulo de dividendo entre 10, asignado a la variable Residuo
            if(Residuo == 1 | Residuo == 0)
            {
                Suma = Suma + Residuo *(long)Math.pow(1,i);   //Acumular en Suma el número total de 1's
            Dividendo = Cociente;     //Asignación de la variable Cociente a la variable Dividendo
            i--;                      //Restar el valor de i menos 1, cada vez que se repita el bucle
            }

        }
        
        //Mensaje Información - Número total de 1's
        System.out.println("La suma total de 1's es: "+Suma);
      
        BitParidad = Suma%2;          //Módulo de Suma entre 2 (Para verificar si la suma total de 1's es par o impar)
        
        if(BitParidad == 1)           //Si BitParidad == 1 (Suma total de 1's es impar)
        {
            System.out.println("No hay error. Bit de paridad es "+(BitParidad));
        }
        else                          //Sino BitParidad !=1 (Suma total de 1's es par)  
        {
            System.out.println("No hay error. Bit de paridad es: "+(BitParidad));
        }
    
    }
}
