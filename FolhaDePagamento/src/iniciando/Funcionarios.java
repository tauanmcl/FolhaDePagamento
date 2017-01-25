package iniciando;

public class Funcionarios {
    String primeiroNome;
    String ultimoNome;
    String endereco;
    
    boolean tipoMensal = false;
    boolean tipoSemanal = false;
    boolean tipoBisemanal = false;
    
    boolean recebePorHora = false;
    boolean recebeMensal = false;
    
    double salario = 0;
    
    boolean comissao = false; 
    double valorComissao = 0; 
    int recebeu = 1;
    
    int id = -1;
    
    int metodoPagamento = 0;
    
    int totalHoraNormal = 0;
    int totalHoraExtra = 0;
    
    boolean sindicato = false;
    double valorSindicato = 0;
    int idSindicato = -1;
    
    double totalParaReceber = 0;
    
    boolean seraPagoHoje = false;
}
