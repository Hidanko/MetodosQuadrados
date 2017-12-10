/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculo;

import static java.lang.Math.pow;

/**
 *
 * @author 6248489
 */
public class ResolverMatriz {

    int I; //linha
    int J; //coluna
    double matriz[][];
    int posME;
    int TAM;
    double maiorE;

    public ResolverMatriz(int I, int J, double[][] matriz, int posME, int TAM) {
        this.I = I;
        this.J = J;
        this.matriz = matriz;
        this.posME = posME;
        this.TAM = TAM;
        maiorE = 1.0;
    }

    


    void limparMatriz(double matriz[][]){
	for (int i = 0; i < I; i++) { //itera até chegar ao ultimo elemento da linha
            for (int j = 0; j < J; j++) { //itera até o ultimo elemento da coluna
              
                if (matriz[i][j] < pow(10, -10.0) && matriz[i][j] > -1.0) {
                    matriz[i][j] = 0.0;
                }
            }
        }
    }

//Função para imprimir a matriz
    void imprimeM(double matriz){
        
	for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM + 1; j++) {
               
            }
          
        }
    }

    void pivotear(double matriz[][], int i, int j) {
        
	// onde maiorE é o maior elemento e posME é sua posição
       //int posME = (int) I;
        for (int a = i; a < I; a++) {

            if (a == I) {
                
                maiorE = matriz[a][j];
                posME = a;
            } else {

                if (matriz[a][j] > maiorE) {
                    maiorE = matriz[a][j];
                    posME = a;
                }

            }
        }

        // Aqui é onde ocorre a troca da linha
        for (int k = 0; k < J; k++) {
            // Variavel para guardar o elemento temporariamente
            double temp;
                        
            temp = matriz[i][k];
            matriz[i][k] = matriz[posME][k];
            matriz[posME][k] = temp;

        }

    }

//==========================================================
//					INICIO DOS MÉTODOS
    void escalona(double matriz[][]){

	double pivo, multiplicador;

        for (int k = 0; k < TAM; k++) {
            pivotear(matriz, k, k);
            // Aqui é onde pega o Pivo, sendo sempre o elemento k, k...
            pivo = matriz[k][k];

            //Resetar o multiplicador se não é usado o da operação anterior...
            multiplicador = 0;

            //Onde começa a interação com a matriz
            for (int i = 1; i < TAM; i++) {

                //Checagem para ver se o elemento não é o pivo
                if (k < i) {
                    multiplicador = matriz[i][k] / pivo;
                }

                //Linha para checagem dos elementos			 
                for (int j = 0; j < TAM + 1; j++) {

                    //Atualização dos elementos da matriz
                    matriz[i][j] = matriz[i][j] - (matriz[k][j] * multiplicador);
                }
            }
        }

    }

//Função para calcular os valores das variaveis de uma matriz escalonada
    void raizes(double matriz[][],double x){
	
     	double raizes[] = new double[J];

        // Preenche o vetor das raizes
        for (int i = 0; i < J; i++) {
            raizes[i] = 1;
        }

        double acc = 0.0; // Um acumulador pra contar os elementos do vetor

        // Laço que percorre a matriz de baixo pra cima da direita pra esquerda
        for (int i = (int) (I - 1); i >= 0; i--) {
            for (int k = 0; k < J; k++) {

                // Condição para contar apenas a partir do "elemento chave", aquele que possui a raiz
                if (k > i) {
                    // Talvez um if aqui dentro excluiria a necessidade de mais um elemento
                    // no vetor das raizes, talvez não, deixa assim
                    acc = acc - matriz[i][k] * raizes[k];
                }

            }
            //cout << acc;
            // Aqui faz o preenchimento do vetor das raizes
            raizes[i] = acc / matriz[i][i];
            acc = 0;
        }

        for (int i = 0; i < J; i++) {
            raizes[i] *= -1;
        }

        double a0, a1, a2, a3, a4;

        a0 = raizes[0];
        a1 = raizes[1];
        a2 = raizes[2];
        a3 = raizes[3];
        a4 = raizes[4];

    }

}
