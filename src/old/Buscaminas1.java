package old;

import java.util.Scanner;
public class Buscaminas1
{
    public static char [][] muestraMapa(char[][]mapa)
    {
        int ren, col;
        for(ren = 0; ren < mapa.length; ren++)
        {
            System.out.println("");
            for(col = 0; col < mapa[ren].length; col++)
            {
                System.out.print(mapa[ren][col] + " ");
            }
        }
        return mapa;
    }
    public static void main(String [] pro)
    {
        Scanner teclado = new Scanner(System.in);
        int ren, col, rango = 10, i, minas = 15;
        char camino = '-', jugador = '0', colision = '-', direccion;
        char [][] mapa = new char [rango][rango];

        for(ren = 0; ren < mapa.length; ren++)// Llena una matriz con puros guiones (caracteres).
        {
            for(col = 0; col < mapa[ren].length; col++)
                mapa[ren][col] = camino;
        }

        for(i = 0; i < minas; i++) // Ciclo para llenar de minas el mapa.
        {
            ren = (int)(Math.random() * rango);
            col = (int)(Math.random() * rango);
            mapa[ren][col] = '*';
        }
        // Coloca al jugador en una posición aleatoria
        ren = (int)(Math.random() * rango);
        col = (int)(Math.random() * rango);
        mapa[ren][col] = jugador;

        System.out.println("Utiliza wasd para moverte.");
        muestraMapa(mapa); // Muestra el mapa por primera vez
        System.out.print("\nEste (0) eres tú. Esas (*) son las minas, evítalas.");
        while (colision != '*')
        {
            direccion = teclado.next().charAt(0); //Lee un caracter del teclado
            if(direccion == 'w' || direccion == 'a' || direccion == 's' || direccion == 'd')
            {
                if (direccion == 'w' && ren !=0) //Ir a arriba
                {
                    mapa[ren][col] = camino;
                    ren-=1;
                    if(mapa[ren][col] == '*')
                        colision = '*';
                    else
                        mapa[ren][col] = jugador;
                }
                if (direccion == 'a' && col !=0) //Ir a la izquierda
                {
                    mapa[ren][col] = camino;
                    col-=1;
                    if(mapa[ren][col] == '*')
                        colision = '*';
                    else
                        mapa[ren][col] = jugador;
                }
                if (direccion == 's' && ren != mapa.length - 1) //Ir a abajo
                {
                    mapa[ren][col] = camino;
                    ren+=1;
                    if(mapa[ren][col] == '*')
                        colision = '*';
                    else
                        mapa[ren][col] = jugador;
                }
                if (direccion == 'd' && col != mapa.length - 1) //Ir a la derecha
                {
                    mapa[ren][col] = camino;
                    col+=1;
                    if(mapa[ren][col] == '*')
                        colision = '*';
                    else
                        mapa[ren][col] = jugador;
                }
                muestraMapa(mapa);
            }
            else
                System.out.print("Comando desconocido, pulsa 'w', 'a', 's' o 'd' para moverte");
            if (colision == '*')
                System.out.print("Perdiste, tocaste la mina.");
        }
    }
}