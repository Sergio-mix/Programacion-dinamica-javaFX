package co.edu.unbosque.programacindinmicajava.model;

public class AlgoritmoFloyd {

    public int floyd(long[][] adyacencia, long max, long min) {
        int matriz1 = adyacencia.length;
        long D[][] = adyacencia;

        String enlaces[][] = new String[matriz1][matriz1];
        String[][] aux_enlaces = new String[adyacencia.length][adyacencia.length];

        for (int i = 0; i < matriz1; i++) {
            for (int j = 0; j < matriz1; j++) {
                enlaces[i][j] = "";
                aux_enlaces[i][j] = "";
            }
        }
        String enl_rec = "";
        for (int k = 0; k < matriz1; k++) {
            for (int i = 0; i < matriz1; i++) {
                for (int j = 0; j < matriz1; j++) {
                    float aux = D[i][j];
                    float aux2 = D[i][k];
                    float aux3 = D[k][j];
                    float aux4 = aux2 + aux3;
                    float result = Math.min(aux, aux4);
                    if (aux != aux4) {
                        if (result == aux4) {
                            enl_rec = "";
                            aux_enlaces[i][j] = k + "";
                            enlaces[i][j] = enlaces(i, k, aux_enlaces, enl_rec) + (k);
                        }
                    }
                    D[i][j] = (long) result;
                }
            }
        }

        String cadena = "";
        for (int i = 0; i < matriz1; i++) {
            for (int j = 0; j < matriz1; j++) {
                cadena += D[i][j] + " ";
            }
            cadena += "\n";
        }

        String enlacesres = "";

        enlacesres = D[(int) min][(int) max] + "";
        int resultado = Integer.parseInt(enlacesres);


        return resultado;
    }

    public String enlaces(int i, int k, String[][] aux_enlaces, String enl_rec) {
        if (aux_enlaces[i][k].equals("") == true) {
            return "";
        } else {
            enl_rec += enlaces(i, Integer.parseInt(aux_enlaces[i][k].toString()), aux_enlaces, enl_rec) + (Integer.parseInt(aux_enlaces[i][k].toString()) + 1) + " , ";

            return enl_rec;
        }
    }


}