package QuetaoComp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Principal{
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Insira o nome do departamento: ");
        String nomeDepartamento = sc.nextLine();

        System.out.println("Insira as informacoes do trabalhador: ");
        System.out.print("Nome: ");
        String nomeTrab = sc.nextLine();

        System.out.print("Level: ");
        String level = sc.nextLine();

        System.out.print("Insira o salario base: ");
        double salarioBase = sc.nextDouble();

        Trabalhador trabalhador = new Trabalhador(nomeTrab,WorkLevel.valueOf(level),salarioBase,new Departamento(nomeDepartamento));

        System.out.print("Quantos contratos o trabalhador tem: ");
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            System.out.printf("Contrato #%d: ",i+1);
            System.out.print("Data (DD/MM/YYYY): ");
            Date contratoData = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valorHora = sc.nextDouble();
            System.out.print("Duracao(horas): ");
            int duracaoHoras = sc.nextInt();
            HoraDeContrato contrato = new HoraDeContrato(contratoData,valorHora,duracaoHoras);
            trabalhador.addContract(contrato);
        }

        System.out.println();
        System.out.println("Insira o mes e o ano para calcular o salario: (MM/YYYY): ");
        String mesEAno = sc.next();
        int mes = Integer.parseInt(mesEAno.substring(0,2));
        int ano = Integer.parseInt(mesEAno.substring(3));

        System.out.println("Nome: "+trabalhador.getNome());
        System.out.println("Departamento: "+trabalhador.getDepartamento().getNome());
        System.out.println("Recebeu "+mesEAno+ ": "+String.format("%.2f",trabalhador.income(ano,mes)));

        sc.close();
    }
}
