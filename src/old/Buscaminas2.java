package old;
/**
 * Notas de la actualización:
 *  Se implementó un sistema de dificultad.
 * @author César Zárate
 * @version 1.1
 */
import java.util.Scanner;
public class Buscaminas2
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
    public static void main(String [] args)
    {
        Scanner lector = new Scanner(System.in);
        int ren = 10, col = 10, i, numMinas = 15, numBonus = 5, rango = 10, contBonus = 0, dificultad = 0;
        char camino = '-', mina = '*', bonus = 'o', jugador = 'J', direccion;
        boolean colision = false, ganar = false, perder = false;
        System.out.println("Dificultad:\n1 = fácil.(Mapa 5x5, 5 minas y 3 objetos)\n2 = medio. (Mapa 10x10, 10 minas y 5 objetos) \n3 = difícil. (Mapa 5x5, 5 minas y 3 objetos)");
        dificultad = lector.nextInt();
        if(dificultad == 1)
        {
            ren = 5;
            col = 5;
            numMinas = 5;
            numBonus = 3;
            rango = 5;
        }
        if(dificultad == 2)
        {
            ren = 10;
            col = 10;
            numMinas = 10;
            numBonus = 5;
            rango = 10;
        }
        if(dificultad == 3)
        {
            ren = 15;
            col = 15;
            numMinas = 25;
            numBonus = 10;
            rango = 15;
        }
        char [][] mapa = new char[ren][col];
        for(ren = 0; ren < mapa.length; ren++) // Llena una matriz con puros guiones (caracteres).
        {
            for(col = 0; col < mapa[ren].length; col++)
                mapa[ren][col] = camino;
        }
        for(i = 0; i < numMinas; i++) // Ciclo para llenar de minas el mapa.
        {
            ren = (int)(Math.random() * rango);
            col = (int)(Math.random() * rango);
            mapa[ren][col] = mina;
        }
        for(i = 0; i < numBonus; i++) // Ciclo para llenar de bonus el mapa.
        {
            ren = (int)(Math.random() * rango);
            col = (int)(Math.random() * rango);
            mapa[ren][col] = bonus;
        }
        // Coloca al jugador en una posición aleatoria
        ren = (int)(Math.random() * rango);
        col = (int)(Math.random() * rango);
        mapa[ren][col] = jugador;

        System.out.println("Utiliza wasd para moverte.");
        muestraMapa(mapa); // Muestra el mapa por primera vez
        System.out.print("\nEste (0) eres tú. Esas (*) son las minas, evítalas." + "\n¡Ah! consigue todos los objetos (o) para ganar.");
        while (colision == false)
        {
            direccion = lector.next().charAt(0); //Lee un caracter del teclado
            if(direccion == 'w' || direccion == 'a' || direccion == 's' || direccion == 'd')
            {
                if (direccion == 'w' && ren !=0) //Ir a arriba
                {
                    mapa[ren][col] = camino;
                    ren-=1;
                }
                if (direccion == 'a' && col !=0) //Ir a la izquierda
                {
                    mapa[ren][col] = camino;
                    col-=1;
                }
                if (direccion == 's' && ren != mapa.length - 1) //Ir a abajo
                {
                    mapa[ren][col] = camino;
                    ren+=1;
                }
                if (direccion == 'd' && col != mapa.length - 1) //Ir a la derecha
                {
                    mapa[ren][col] = camino;
                    col+=1;
                }
            }
            if (mapa[ren][col] == bonus)
                contBonus++;
            if (mapa[ren][col] == mina)
                perder = true;
            if (contBonus == numBonus)
                ganar = true;
            if (ganar == true || perder == true)
                colision = true;
            mapa[ren][col] = jugador;
            System.out.println("Utiliza wasd para moverte.");
            muestraMapa(mapa);
        }
        if(perder == true)
            System.out.print(" Perdiste.");
        if(ganar == true)
            System.out.print(" ¡Ganaste!");
    }
}