import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double saldo = 0.0;
        double limite = 200.0;
        String historico = "";

        int opcao;

        do {
            System.out.println("\n--- MENU BANCÁRIO ---");
            System.out.println("1. Sacar");
            System.out.println("2. Depositar");
            System.out.println("3. Extrato");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.print("Digite o valor do saque: R$ ");
                    double saque = scanner.nextDouble();

                    if (saque > 0 && saque <= saldo + limite) {
                        saldo -= saque;
                        historico += String.format("Saque de R$ %.2f%n", saque);
                        System.out.println("Saque realizado com sucesso!");
                    } else {
                        System.out.println("Saque não permitido!");
                        System.out.println("Você pode sacar até R$ "
                                + String.format("%.2f", saldo + limite));
                    }
                    break;

                case 2:
                    System.out.print("Digite o valor do depósito: R$ ");
                    double deposito = scanner.nextDouble();

                    if (deposito > 0) {
                        saldo += deposito;
                        historico += String.format("Depósito de R$ %.2f%n", deposito);
                        System.out.println("Depósito realizado com sucesso!");
                    } else {
                        System.out.println("Valor de depósito inválido!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- SEU EXTRATO ---");
                    System.out.printf("Saldo atual: R$ %.2f%n", saldo);
                    System.out.printf("Limite disponível: R$ %.2f%n", limite);

                    System.out.println("\n--- HISTÓRICO ---");

                    if (historico.isEmpty()) {
                        System.out.println("Nenhuma operação realizada.");
                    } else {
                        System.out.print(historico);
                    }

                    System.out.println("-------------------");
                    break;

                case 4:
                    System.out.println("Obrigado por utilizar o sistema bancário!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 4);

        scanner.close();
    }
}


