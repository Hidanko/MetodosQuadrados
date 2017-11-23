/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculo;

/**
 *
 * @author 6248489
 */
public class MinimosQuadrados {

    double x[];
    double f[];
    double valor;
    int size, i, j;
    double resultado = 0.0;
    double matriz[][];
    double matrizParcial[][] = null;

    public MinimosQuadrados(double[] x, double[] f, double valor, int size) {

        this.x = new double[size];
        this.f = new double[size];

        this.size = size - 1;
        this.x = x;
        this.f = f;
        this.valor = valor;

        matrizParcial = new double[2][size];
        for (i = 0; i < size; i++) {
            matrizParcial[0][i] = 1.0;
            matrizParcial[1][i] = x[i];
        }
    }

    public MinimosQuadrados() {
    }

    public double calculo() {

        matriz = new double[size][size];
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {

                resultado = 0.0;
                for (int k = 0; k < size-1; k++) {
                    resultado += (matrizParcial[i][k] * matrizParcial[j][k]);
                }

                matriz[i][j] = resultado;

            }
        }

        for (i = 0; i < size; i++) {
            resultado = 0.0;
            for (int k = 0; k < size; k++) {
                if (k != 0) {
                    resultado += (k * x[k] * f[k]);

                } else {
                    resultado += f[k];
                }
            }
            matriz[i][size] = resultado;
        }

        for (int A = 0; A < size; A++) {
            for (int B = 0; B < size; B++) {
                System.out.println(A + " " + B + " = " + matriz[A][B]);
            }
        }
        return resultado;
    }

}
