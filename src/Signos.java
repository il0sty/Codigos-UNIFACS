import java.util.Scanner;
import static java.lang.System.in;

public class Signos {
    public static void main(String[] args) {

        //Declaração de variaveis
        Scanner input = new Scanner(in);
        int dia;
        int mes;
        int ano;
        boolean verData;

        //Entrada dos valores das variaveis e verificação da data
        do {
            //Entrada do valor do dia
            System.out.print("Digite o seu dia de nascimento: ");
            dia = input.nextInt();

            //Entrada do valor do mes
            System.out.print("Digite o seu mês de nascimento: ");
            mes = input.nextInt();

            //Entrada do valor do ano
            System.out.print("Digite o seu ano de nascimento: ");
            ano = input.nextInt();

            verData = isDataValida(dia,mes,ano);
        } while (!verData);
        input.close();

        //Entrada das Strings dos Signos e em que dia do mês ocorre a mudança de um signo pra outro
        String[] signos = {"Capricórnio", "Aquário", "Peixes", "Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem", "Libra", "Escorpião", "Sagitário"};
        int[] diaMudancaSigno = {21,20,21,21,21,21,23,23,23,23,22,22};

        //Como cada slot do array corresponde a um mês, retira-se 1 do valor do mês para ser equivalente a sua posição correspondente
        int indiceSigno = mes-1;

        if (dia>=diaMudancaSigno[indiceSigno]){ //Caso o dia seja igual ou superior doq o dia da mudança do mês daquele mês, será usado o signo do proximo mês
            indiceSigno++;
            if(indiceSigno==12) indiceSigno = 0; //Passagem do mês de dezembro (indice 11) para o mes de janeiro (indice 0)
        }
        System.out.printf("Sua data de nascimento: %0,2d/%0,2d/%d\nSeu signo é: %s%n",dia,mes,ano,signos[indiceSigno]);

    }

    public static boolean isDataValida(int dia, int mes, int ano) {
        // Verifica se o ano é bissexto
        boolean bissexto = (ano % 4 == 0 && ano % 100 != 0) || ano % 400 == 0;

        // Verifica se o mês é válido
        if (mes < 1 || mes > 12) {
            System.out.println("Mês Inválido\n");
            return false;
        }

        // Verifica o número de dias do mês
        int numDias = switch (mes) {
            case 2 -> bissexto ? 29 : 28;
            case 4, 6, 9, 11 -> 30;
            default -> 31;
        };

        // Verifica se o dia é válido
        if (dia < 1 || dia > numDias) {
            System.out.println("Dia inválido");
            return false;
        }

        // Retorno se a data for válida
        return true;
    }

}