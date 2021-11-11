package co.edu.unbosque.programacindinmicajava.model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class AsignacionT{

    private int[][] matrizCostes;

    /* ----------------- IMPLEMENTACIÓN DEL ALGORITMO ----------------- */
    public AsignacionT(int n){ // n será el tamaño del problema
        matrizCostes=new int[n][n];
        for (int i=0; i<n; i++) // Generamos un problema aleatorio.
            for (int j=0; j<n; j++)
                matrizCostes[i][j]=(int) (Math.random()*10+1);



    }

    public int[] asignaTareas(){
        int[] nodoSolucion=generaSolucion(); // Generamos una solución por defecto
        int[] solucion=new int[matrizCostes.length]; // Solución que vdevolvemos
        int cota=calculaCotaAsociada(nodoSolucion);
        ArrayList<Integer> agentesDisponibles=inicializaArrayList(); // Tenemos el conjunto de agentes en una estructura de datos
        int j=0; // Contador para guiarnos sobre el nodoSolucion y nuestra solucion
        while (!agentesDisponibles.isEmpty()){ // Mientras que la pila no esté vacía
            int[] vectorCotas=new int[agentesDisponibles.size()]; // Nos declaramos un array de cotas
            for (int i=0; i<vectorCotas.length; i++){ // Rellenamos el array de cotas
                nodoSolucion[j]=matrizCostes[agentesDisponibles.get(i)][j];
                vectorCotas[i]=calculaCotaAsociada(nodoSolucion);

            }
            int posicion=getPosicionMejorAgente(vectorCotas); // Nos quedamos con el mejor valor (el que hace que la cota sea menor)
            nodoSolucion[j]=matrizCostes[agentesDisponibles.get(posicion)][j];
            solucion[j]=agentesDisponibles.get(posicion)+1; // Lo incluimos en nuestra solución
            agentesDisponibles.remove(posicion); // Lo eliminamos de la pila
            j++;

        }
        return solucion;
    }


    private int[] generaSolucion(){
        int[] solucion=new int[matrizCostes.length];
        int j=0;
        for (int i=0; i<solucion.length; i++){
            solucion[i]=matrizCostes[i][j];
            j++;
        }
        return solucion;
    }

    // Generamos la pila con la información sobre los agentes
    private ArrayList<Integer> inicializaArrayList(){
        ArrayList<Integer> solucion=new ArrayList<Integer>();
        for (int i=0; i<matrizCostes.length; i++)
            solucion.add(i);
        return solucion;
    }

    // Calculamos la cota asociada a un nodo
    private int calculaCotaAsociada(int[] nodo){
        int sol=0;
        for (int i=0; i<nodo.length; i++)
            sol+=nodo[i];
        return sol;
    }

    // Extraemos al mejor agente
    private int getPosicionMejorAgente(int[] vectorCotas){
        int posicion=0;
        int valor=vectorCotas[0];
        for (int i=1; i<vectorCotas.length; i++){
            if (valor>vectorCotas[i]){
                valor=vectorCotas[i];
                posicion=i;
            }
        }
        return posicion;
    }
    public int[] arregloArray(int [] a, int m, int agente){
        int []resultado = new int[m];

           for(int i=0;i<a.length;i++){
               resultado[i]=a[i];
           }
        int cont= agente;
        int cont2= 0;

            while(cont<m){
            if(cont2>agente){
                cont2=0;
                cont =cont-1;
            }
                resultado[cont]=a[cont2];
                cont2++;
                cont++;
            }
        return resultado;
    }
    public static int[] asignacionTareas(int a, int t, int m){
        AsignacionT asignacionT=new AsignacionT(a);
        int [] resultado = new int[m];
        if(t<=a){
            for(int i=0; i< m;i++) {
                resultado[i] = asignacionT.asignaTareas()[i];
            }
        }else{
            for(int i=0; i< a;i++) {
                resultado[i] = asignacionT.asignaTareas()[i];
            }
            resultado=asignacionT.arregloArray(resultado,m,a);



        }
        return resultado;
    }


}