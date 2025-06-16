import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Scanner;

public class ContaTerminal {

    private static String BOM_DIA = "Bom dia";
    private static String BOA_TARDE = "Boa tarde";
    private static String BOA_NOITE = "Boa noite";

    public static void main(String[] args) {

        String conta;
        String agencia;
        String nomeCliente;
        String saldo;
        var sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println(resolverSaudacao() + " Por favor, digite seu nome !");
                nomeCliente = sc.nextLine();

                if (!isEmptyOrNull(nomeCliente)) {
                    break;
                }

                System.out.println("Nome inválido. Tente novamente.");
            }catch(Exception e){
                System.out.println("Nome inválido. Tente novamente. " + e.getMessage());
            }
        }

        while (true) {
            try{
                System.out.println( "Por favor, digite o número da Agência !");
                agencia = sc.nextLine();

                if (!isEmptyOrNull(agencia)) {
                    break;
                }

                System.out.println("Numero Agência inválida. Tente novamente.");
            }catch(Exception e){
                System.out.println("Numero Agência inválida. Tente novamente. " + e.getMessage());
            }
        }

        while (true) {
            try{
                System.out.println( "Por favor, digite o número da Conta !");
                conta = sc.nextLine();

                if (!isEmptyOrNull(conta)) {
                    break;
                }

                System.out.println("Numero Conta inválida. Tente novamente.");
            }catch(Exception e){
                System.out.println("Numero Conta inválida. Tente novamente. " + e.getMessage());
            }
        }

        while (true) {
            try{
                System.out.println( "Por favor, digite o Saldo atual da conta !");
                saldo = sc.nextLine();

                if (isValorValido(saldo)) {
                    break;
                }

                System.out.println("Saldo inválido. Tente novamente.");
            }catch(Exception e){
                System.out.println("Saldo inválido. Tente novamente. " + e.getMessage());
            }
        }



        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %s e seu saldo %s já está disponível para saque",nomeCliente,agencia,conta,saldo);
    }

    private static String resolverSaudacao(){
        var now = LocalTime.now();

        if(now.isAfter(LocalTime.of(5,0,1)) && now.isBefore(LocalTime.of(12,0,0))){
            return BOM_DIA;
        }else if(now.isAfter(LocalTime.of(12,0,1)) && now.isBefore(LocalTime.of(18,0,0))){
            return BOA_TARDE;
        }else if(now.isAfter(LocalTime.of(18,0,1)) && now.isBefore(LocalTime.of(5,0,0))){
            return BOA_NOITE;
        }
        return "Olá";
    }

    private static boolean isEmptyOrNull(String valor){
        return (valor == null || valor.isEmpty());
    }
    private static boolean isValorValido(String valor){
        if(isEmptyOrNull(valor)){
            return false;
        }
        try{
            valor = valor.replaceAll(",",".");
            new BigDecimal(valor);
            return true;
        }catch (Exception e){
           return false;
        }

    }
}