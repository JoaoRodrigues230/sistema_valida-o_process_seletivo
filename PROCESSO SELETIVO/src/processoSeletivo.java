import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class processoSeletivo { 
        
    public static void main(String[] args) {
        String[] candidatos = {"JOÃO", "CARLOS", "VITOR", "JULIA", "VINICIUS"};
        
        for(String candidato: candidatos){
            entrandoContato(candidato);
        }
    }

    //entrando em contato
    static void entrandoContato(String candidato){
        int tentativa = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando){
                tentativa++;
            }
            else{
                System.out.println("CONTATO REALIZADO COM SUCESSO!\n");
            }
        }while(continuarTentando&&tentativa<3);

        if(atendeu){
            System.out.println("CONSEGUIMOS CONTATO COM O "+candidato+" NA "+tentativa+" REALIZADAS.");
        }
        else{
            System.out.println("NÃO CONSEGUIMOS CONTATO COM O "+candidato+" NA "+tentativa+" REALIZADAS.");
        }
    }
    //método atender
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados (){
        String[] candidatos = {"JOÃO", "CARLOS", "VITOR", "JULIA", "VINICIUS"};
        System.out.println("IMPRIMINDO A LISTA DE CANDIDATOS INFORMANDO O INDICE DO ELEMENTO\n");

        for(int i=0;i<candidatos.length;i++){
            System.out.println("O CANDIDATO DE Nº "+ (i+1) + " É " + candidatos[i]);
        }
        
    }

    static void selectCandidatos(){

        String[] candidatos = {"JOÃO", "CARLOS", "VITOR", "JULIA", "VINICIUS", "MARIA", "VITORIA", "FABIO", "RODRIGO", "CAMILA"};
        
        int candSelecionados=0;
        int x = 0;
        double salario_base = 2000.0;

        while(candSelecionados<5 && x<candidatos.length){
            String candidato = candidatos[x];
            double salario_pretendido = valor_pretendido();

            System.out.println("O CANDIDATO " + candidato + " SOLICITOU R$ " + salario_pretendido + " COMO SALÁRIO\n");
            
            if(salario_base>=salario_pretendido){
                System.out.println("O CANDIDATO "+candidato+" FOI SELECIONADO!\n");
                candSelecionados++;
            }
            else{
                System.out.println("O CANDIDATO "+candidato+" NÃO FOI SELECIONADO!\n");
            }
            x++;
        }
    }

    static double valor_pretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salario_pretendido){
        double salario_base = 2000.0;
        if(salario_base>salario_pretendido){
            System.out.println("LIGAR PARA O CANDIDATO");
        }
        else if(salario_base==salario_pretendido){
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        }
        else{
            System.out.println("AGUARDANDO RESULTADO DEMAIS CANDIDATOS");
        }
    }

    @Override
    public String toString() {
        return "processoSeletivo []";
    }

}
