package old;

import java.util.Scanner;
public class Pruebas
{
    public static void main(String [] test)
    {
        Scanner teclado = new Scanner(System.in);
        int aleatorio;
        int i;
        char caracter;
        for(i = 0; i < 10; i++)
        {
            aleatorio = (int)(Math.random() * 2); //El (int) transforma el duble en int
            System.out.println(aleatorio);
        }
        System.out.print("Caracter: ");
        caracter = teclado.next().charAt(0);
        System.out.print(caracter);
    }
}