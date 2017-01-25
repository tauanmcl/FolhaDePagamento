package iniciando;

import java.util.Scanner;


public class Classe_01{
    
    public static void main (String[] args)
    {
        
        Scanner input = new Scanner(System.in);
        
        boolean passarDia = false;
        boolean passarMes = false;
        boolean passarAno = false;
        boolean desfez = false;
        boolean continuar = true;
        int maxFuncionarios = 30;
        
        Funcionarios[] arrayFuncionarios = new Funcionarios[maxFuncionarios];
        Funcionarios[] arrayAuxiliar = new Funcionarios[maxFuncionarios];
        Funcionarios[] arrayReserva = new Funcionarios[maxFuncionarios];
        for(int i=0; i<30; i++)
            arrayFuncionarios[i] = new Funcionarios();
        for(int i=0; i<30; i++)
            arrayAuxiliar[i] = new Funcionarios();
        for(int i=0; i<30; i++)
            arrayReserva[i] = new Funcionarios();
        
        
        System.out.println("Bem-vindo ao Payment Organizer.\n");
        System.out.println("Informe o dia da semana:");
        System.out.println("1 - Domingo");
        System.out.println("2 - Segunda");
        System.out.println("3 - Terça");
        System.out.println("4 - Quarta");
        System.out.println("5 - Quinta");
        System.out.println("6 - Sexta");
        System.out.println("7 - Sábado");
        int diaSemana = input.nextInt();
        System.out.print("Informe o dia do mês:");
        int dataDia = input.nextInt();
        System.out.print("Informe o mês:");
        int dataMes = input.nextInt();
        System.out.print("Informe o ano:");
        int dataAno = input.nextInt();
        do{       
            System.out.println("\n---------- TELA INICIAL ----------");
            System.out.print("Data: " + dataDia + "/" + dataMes + "/" + dataAno + "\nDia da semana: ");
            switch (diaSemana)
            {
                case 1: 
                    System.out.println("Domingo");
                    break;
                case 2: 
                    System.out.println("Segunda");
                    break;
                case 3: 
                    System.out.println("Terça");
                    break;
                case 4: 
                    System.out.println("Quarta");
                    break;
                case 5: 
                    System.out.println("Quinta");
                    break;
                case 6: 
                    System.out.println("Sexta");
                    break;
                case 7: 
                    System.out.println("Sábado");
                    break;
            }
            System.out.println("\nSelecione uma das ações a seguir:");
            System.out.println("1 - Adicionar um Funcionario.");
            System.out.println("2 - Remover um Funcionario.");
            System.out.println("3 - Lancar um Cartao de Ponto.");
            System.out.println("4 - Lancar um Resultado de Venda.");
            System.out.println("5 - Lancar uma Taxa de Servico.");
            System.out.println("6 - Alterar detalhes de um Funcionario.");
            System.out.println("7 - Rodar a Folha de Pagamento para Hoje.");
            System.out.println("8 - Undo/Redo.");
            System.out.println("9 - Agenda de Pagamento.");
            System.out.println("10 - Criacao de Novas Agendas de Pagamento.");
            System.out.println("11 - Rodar lista de funcionários.");
            System.out.println("\n15 - Encerrar Programa.");
            System.out.println("\n20 - Ir para o dia seguinte.\n\n");

            int opcao = input.nextInt();

            switch (opcao){
                case 1:
                    arrayReserva = copiarArray (arrayFuncionarios, arrayReserva, maxFuncionarios);
                    arrayFuncionarios = cadastrarFuncionario(arrayFuncionarios, maxFuncionarios);
                    desfez = false; 
                    break;
                case 2:
                    arrayReserva = copiarArray (arrayFuncionarios, arrayReserva, maxFuncionarios);
                    arrayFuncionarios = removerFuncionario (arrayFuncionarios, maxFuncionarios);
                    desfez = false; 
                    break;
                case 3:
                    arrayReserva = copiarArray (arrayFuncionarios, arrayReserva, maxFuncionarios);
                    arrayFuncionarios = lancarPonto(arrayFuncionarios, maxFuncionarios);
                    desfez = false; 
                    break;
                case 4:
                    arrayReserva = copiarArray (arrayFuncionarios, arrayReserva, maxFuncionarios);
                    arrayFuncionarios = lancarVenda(arrayFuncionarios, maxFuncionarios);
                    desfez = false; 
                    break;
                case 5:
                    arrayReserva = copiarArray (arrayFuncionarios, arrayReserva, maxFuncionarios);
                    arrayFuncionarios = lancarTaxaServico(arrayFuncionarios, maxFuncionarios);
                    desfez = false; 
                    break;
                case 6:
                    arrayReserva = copiarArray (arrayFuncionarios, arrayReserva, maxFuncionarios);
                    arrayFuncionarios = alterarFuncionario(arrayFuncionarios, maxFuncionarios);
                    desfez = false; 
                    break;
                case 7:
                    arrayReserva = copiarArray (arrayFuncionarios, arrayReserva, maxFuncionarios);
                    arrayFuncionarios = realizarPagamento (arrayFuncionarios, maxFuncionarios, diaSemana, dataDia);
                    passarDia = true;
                    desfez = false; 
                    break;   
                case 8:
                    if (desfez == false)
                    {
                        System.out.println("\nSua última ação foi desfeita!");
                        arrayAuxiliar = copiarArray (arrayFuncionarios, arrayAuxiliar, maxFuncionarios);
                        arrayFuncionarios = copiarArray (arrayReserva, arrayFuncionarios, maxFuncionarios);
                        arrayReserva = copiarArray (arrayAuxiliar, arrayReserva, maxFuncionarios);
                        desfez = true;                        
                    }
                    else
                    {
                        System.out.println("\nSua ação desfeita foi refeita!");
                        arrayAuxiliar = copiarArray (arrayFuncionarios, arrayAuxiliar, maxFuncionarios);
                        arrayFuncionarios = copiarArray (arrayReserva, arrayFuncionarios, maxFuncionarios);
                        arrayReserva = copiarArray (arrayAuxiliar, arrayReserva, maxFuncionarios);
                        desfez = false;                      
                    }
                    
                    break;
                case 9:
                    arrayReserva = copiarArray (arrayFuncionarios, arrayReserva, maxFuncionarios);
                    arrayFuncionarios = alterarDiaPagamento (arrayFuncionarios, maxFuncionarios);
                    desfez = false; 
                    break;
                case 10:
                    System.out.println("\nEsta funcionalidade não pode ser executada!");
                    desfez = false; 
                    break;
                case 11:
                    listaFuncionarios(arrayFuncionarios, maxFuncionarios);
                    break;
                case 15:
                    continuar = false;
                    break;
                case 20:
                    passarDia = true;
                    break;
            }
        if (passarDia == true) 
        {
            dataDia++;
            diaSemana++;
            while (diaSemana>7) diaSemana -= 7;
            while(dataDia>30)
            {
                dataDia -= 30;
                passarMes = true;
            }
            if (passarMes == true)  dataMes++;
            while (dataMes>12)
            {
                dataMes -= 12;
                passarAno = true;
            }
            if (passarAno == true) dataAno++;
            
            passarMes = false;
            passarAno = false;
            passarDia = false;
        }
        }while (continuar == true);
    }
    public static Funcionarios[] cadastrarFuncionario (Funcionarios[] arrayFuncionarios, int maxFuncionarios)
    {
                
        Scanner input = new Scanner(System.in);
        
        int id=-1;
        
        for (int i = 0; i < maxFuncionarios; i++)
        {
            if (arrayFuncionarios[i].id==-1)
            {
                id = i;
                i = maxFuncionarios;
            }
        }
        if (id != -1)
        {
            arrayFuncionarios[id].id = id + 1;

            System.out.println("\nInforme o primeiro nome do funcionário:");
            arrayFuncionarios[id].primeiroNome = input.nextLine();

            System.out.println("\nInforme o último nome do funcionário:");
            arrayFuncionarios[id].ultimoNome = input.nextLine();

            System.out.println("\nInforme o endereço do funcionário:");
            arrayFuncionarios[id].endereco = input.nextLine();
            
            System.out.println("\nSelecione o tipo de remuneração do funcionário:");
            System.out.println("1 - Horista.");
            System.out.println("2 - Assalariado.");
            System.out.println("3 - Comissionado.");
            int tipoDeSalario = input.nextInt();
            
            switch (tipoDeSalario)
            {
                case 1:
                    arrayFuncionarios[id].recebePorHora = true;
                    arrayFuncionarios[id].tipoSemanal = true;
                    System.out.println("\nInforme o salário horário do funcionário.");
                    arrayFuncionarios[id].salario = input.nextDouble();
                    break;
                case 2:
                    arrayFuncionarios[id].recebeMensal = true;
                    arrayFuncionarios[id].tipoMensal = true;
                    System.out.println("\nInforme o salário mensal do funcionário.");
                    arrayFuncionarios[id].salario = input.nextDouble();
                    break;
                case 3:
                    arrayFuncionarios[id].comissao = true;
                    arrayFuncionarios[id].tipoBisemanal = true;
                    System.out.println("\nInforme o salário base do funcionário.");
                    arrayFuncionarios[id].salario = input.nextDouble();
                    System.out.println("\nInforme o valor (%) da comissão do funcionário.");
                    arrayFuncionarios[id].valorComissao = input.nextDouble();
                    break;
            }
            System.out.println("\nSelecione o método de recebimento do funcionário:");
            System.out.println("1 - Cheque pelos correios.");
            System.out.println("2 - Cheque em mãos.");
            System.out.println("3 - Depósito em conta bancária.");
            arrayFuncionarios[id].metodoPagamento = input.nextInt();
            
            
            System.out.println("\nO funcionário pertence a algum sindicato? (True/False)");
            arrayFuncionarios[id].sindicato = input.nextBoolean();

            if (arrayFuncionarios[id].sindicato == true)
            {
                arrayFuncionarios[id].idSindicato = id + 101;
                System.out.println("\nInforme o valor da taxa sindical mensal:");
                arrayFuncionarios[id].valorSindicato = input.nextDouble();
            }
        
            
            System.out.println("\nCadastro realizado com sucesso. O ID do funcionário é: " + arrayFuncionarios[id].id + ".");
            if (arrayFuncionarios[id].sindicato == true)
            {
                System.out.println("\nA identificação do funcionário no sindicato é: " + arrayFuncionarios[id].idSindicato + ".");
            }
        }
        else
        {
            System.out.println("\nO número de funcionários chegou ao limite!");
        }
        
        return arrayFuncionarios;
    }
    public static Funcionarios[] removerFuncionario (Funcionarios[] arrayFuncionarios, int maxFuncionarios)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("\nInforme o ID do funcionário que será removido.");
        int id = input.nextInt();
        boolean ok = false;
        
        for (int i = 0; i < maxFuncionarios; i++)
        {
            if (arrayFuncionarios[i].id == id)
            {
                arrayFuncionarios[i].recebePorHora = false;
                arrayFuncionarios[i].recebeMensal = false;
                arrayFuncionarios[i].comissao = false;
                arrayFuncionarios[i].id = -1;  
                ok = true;
                i = maxFuncionarios;
            }
        }
        if (ok == true) System.out.println("\nFuncionário removido com sucesso!");
        else            System.out.println("\nFuncionário não encontrado");
        
        return arrayFuncionarios;
    }
    public static Funcionarios[] lancarPonto (Funcionarios[] arrayFuncionarios, int maxFuncionarios)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("\nInforme o ID do funcionário para lançar o cartão de ponto.");
        int id = input.nextInt();
        boolean ok = false;
        
        for (int i = 0; i < maxFuncionarios; i++)
        {
            if (arrayFuncionarios[i].id == id)
            {
                ok = true;
                id--;
                i = maxFuncionarios;
            }
        }
        if (ok == true) 
        {
            if (arrayFuncionarios[id].recebePorHora == true)
            {
                System.out.println("\nInforme a hora de entrada do funcionário:");   
                int x = input.nextInt();
                System.out.println("\nInforme a hora de saída do funcionário;"); 
                int y = input.nextInt();
                if (y-x > 8 )
                {
                    arrayFuncionarios[id].totalHoraNormal += 8;
                    x = y-x-8;
                    arrayFuncionarios[id].totalHoraExtra += x;
                }
                System.out.println("\nPonto lançado com sucesso!");
            }
            else    System.out.println("\nEsse funcionário não recebe por hora!");
        }
        else            System.out.println("\nFuncionário não encontrado");
        
        return arrayFuncionarios;
    }
    public static Funcionarios[] lancarVenda (Funcionarios[] arrayFuncionarios, int maxFuncionarios)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("\nInforme o ID do funcionário que realizou a venda:.");
        int id = input.nextInt();
        boolean ok = false;
        
        for (int i = 0; i < maxFuncionarios; i++)
        {
            if (arrayFuncionarios[i].id == id)
            {
                ok = true;
                id--;
                i = maxFuncionarios;
            }
        }
        if (ok == true) 
        {
            if (arrayFuncionarios[id].comissao == true)
            {
                System.out.println("\nInforme a valor da venda realizada:");   
                double x = input.nextDouble();
                arrayFuncionarios[id].totalParaReceber += (arrayFuncionarios[id].valorComissao/100)*x;
                System.out.println("\nResultado de venda lançado com sucesso!");
            }
            else    System.out.println("\nEsse funcionário não recebe comissão!");
        }
        else            System.out.println("\nFuncionário não encontrado");
        
        return arrayFuncionarios;
    }
    public static Funcionarios[] alterarDiaPagamento (Funcionarios[] arrayFuncionarios, int maxFuncionarios)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("\nInforme o ID do funcionário que deseja realizar alteração:.");
        int id = input.nextInt();
        boolean ok = false;
        int i;
        for (i = 0; i < maxFuncionarios; i++)
        {
            if (arrayFuncionarios[i].id == id)
            {
                ok = true;
                id--;
                i = maxFuncionarios;
            }
        }
        if (ok == true) 
        {
            System.out.print("\nO modo de recebimento do funcionário é:");
            if (arrayFuncionarios[i].tipoMensal == true)System.out.println("Mensal.");
            else if (arrayFuncionarios[i].tipoSemanal == true)System.out.println("Semanal.");
            else    System.out.println("Bisemanal.");
            System.out.println("\nDeseja alterar para que tipo?");
            System.out.println("\n1 - Mensal");
            System.out.println("\n2 - Semanal");
            System.out.println("\n3 - Bisemanal");
            int escolha = input.nextInt();
            switch (escolha)
            {
                case 1: 
                    arrayFuncionarios[i].tipoMensal = true;
                    arrayFuncionarios[i].tipoSemanal = false;
                    arrayFuncionarios[i].tipoBisemanal = false;
                case 2: 
                    arrayFuncionarios[i].tipoMensal = false;
                    arrayFuncionarios[i].tipoSemanal = true;
                    arrayFuncionarios[i].tipoBisemanal = false;
                case 3: 
                    arrayFuncionarios[i].tipoMensal = false;
                    arrayFuncionarios[i].tipoSemanal = false;
                    arrayFuncionarios[i].tipoBisemanal = true;
            }
            System.out.println("\nAlteração realizada com sucesso\n");
        }
        else            System.out.println("\nFuncionário não encontrado");
        
        return arrayFuncionarios;
    }
    public static Funcionarios[] lancarTaxaServico (Funcionarios[] arrayFuncionarios, int maxFuncionarios)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("\nInforme o ID do funcionário que será descontada a taxa sindical:");
        int id = input.nextInt();
        boolean ok = false;
        
        for (int i = 0; i < maxFuncionarios; i++)
        {
            if (arrayFuncionarios[i].id == id)
            {
                ok = true;
                id--;
                i = maxFuncionarios;
            }
        }
        if (ok == true) 
        {
            if (arrayFuncionarios[id].sindicato == true)
            {
                System.out.println("\nInforme o valor da taxa sindical extra:");
                double x = input.nextDouble();
                arrayFuncionarios[id].totalParaReceber -= x; 
                System.out.println("\nValor da taxa sindical extra foi associado ao funcionário com sucesso!");
            }
            else    System.out.println("\nEsse funcionário não pertence ao sindicato!");
        }
        else            System.out.println("\nFuncionário não encontrado");
        
        return arrayFuncionarios;
    }
    public static Funcionarios[] alterarFuncionario (Funcionarios[] arrayFuncionarios, int maxFuncionarios)
    {
        Scanner input = new Scanner(System.in);
        String debug;
        System.out.println("\nInforme o ID do funcionário que será feita a alteração");
        int id = input.nextInt();
        boolean ok = false;
        boolean continuar;
        
        for (int i = 0; i < maxFuncionarios; i++)
        {
            if (arrayFuncionarios[i].id == id)
            {
                ok = true;
                id--;
                i = maxFuncionarios;
            }
        }
        if (ok == true) 
        {
            do
            {
                System.out.println("\nSelecione uma das opções de alteração:");
                System.out.println("1 - Nome.");
                System.out.println("2 - Endenreço.");
                System.out.println("3 - Tipo de remuneração.");
                System.out.println("4 - Método de pagamento.");
                System.out.println("5 - Vínculo com o sindicato.");
                System.out.println("6 - Identificação no sindicato.");
                System.out.println("7 - Taxa sindical.");
                int escolha = input.nextInt();
                debug = input.nextLine();
                switch (escolha)
                {
                    case 1:
                        System.out.println("\nInforme o primeiro nome do funcionário:");
                        arrayFuncionarios[id].primeiroNome = input.nextLine();

                        System.out.println("\nInforme o último nome do funcionário:");
                        arrayFuncionarios[id].ultimoNome = input.nextLine();
                        break;
                    case 2:
                        System.out.println("\nInforme o endereço do funcionário:");
                        arrayFuncionarios[id].endereco = input.nextLine();
                        System.out.println("\nASUDHIAUSHDUS");
                        break;
                    case 3:
                        System.out.println("\nSelecione o tipo de remuneração do funcionário:");
                        System.out.println("1 - Horista.");
                        System.out.println("2 - Assalariado.");
                        System.out.println("3 - Comissionado.");
                        int tipoDeSalario = input.nextInt();

                        switch (tipoDeSalario)
                        {
                            case 1:
                                arrayFuncionarios[id].recebePorHora = true;
                                arrayFuncionarios[id].tipoSemanal = true;
                                System.out.println("\nInforme o salário horário do funcionário.");
                                arrayFuncionarios[id].salario = input.nextDouble();
                                break;
                            case 2:
                                arrayFuncionarios[id].recebeMensal = true;
                                arrayFuncionarios[id].tipoMensal = true;
                                System.out.println("\nInforme o salário mensal do funcionário.");
                                arrayFuncionarios[id].salario = input.nextDouble();
                                break;
                            case 3:
                                arrayFuncionarios[id].comissao = true;
                                arrayFuncionarios[id].tipoBisemanal = true;
                                System.out.println("\nInforme o salário base do funcionário.");
                                arrayFuncionarios[id].salario = input.nextDouble();
                                System.out.println("\nInforme o valor da comissão do funcionário.");
                                arrayFuncionarios[id].valorComissao = input.nextDouble();
                                break;
                        }
                        break;
                    case 4:
                        System.out.println("Selecione o método de recebimento do funcionário:");
                        System.out.println("1 - Cheque pelos correios.");
                        System.out.println("2 - Cheque em mãos.");
                        System.out.println("3 - Depósito em conta bancária.");
                        arrayFuncionarios[id].metodoPagamento = input.nextInt();
                        break;
                    case 5:
                        System.out.println("O funcionário pertence a algum sindicato? (True/False)");
                        arrayFuncionarios[id].sindicato = input.nextBoolean();

                        if (arrayFuncionarios[id].sindicato == true)
                        {
                            System.out.println("Informe o valor da taxa sindical mensal:");
                            arrayFuncionarios[id].valorSindicato = input.nextDouble();
                        }
                        break;
                    case 6:
                        if (arrayFuncionarios[id].sindicato == true)
                        {
                            System.out.println("Informe a nova identificação sindical:");
                            arrayFuncionarios[id].idSindicato = input.nextInt();
                        }
                        else    System.out.println("Esse funcionário não pertence ao sindicato!");
                        break;
                    case 7:
                        if (arrayFuncionarios[id].sindicato == true)
                        {
                            System.out.println("Informe a nova taxa sindical mensal:");
                            arrayFuncionarios[id].valorSindicato = input.nextDouble();
                        }
                        else    System.out.println("Esse funcionário não pertence ao sindicato!");
                        break;
                }
                System.out.println("Deseja fazer mais alguma alteração neste funcnionário? (True/False)");
                continuar = input.nextBoolean();
            }while(continuar == true);
        }
        else            System.out.println("Funcionário não encontrado");
        
        return arrayFuncionarios;
    }
    public static Funcionarios[] realizarPagamento (Funcionarios[] arrayFuncionarios, int maxFuncionarios, int diaSemana, int dataDia)
    {
        Scanner input = new Scanner(System.in);
        
        boolean alguemSeraPago = false;
        
        boolean pagamentoMensal = false;
        
        if (dataDia >= 28)
        {
            if (dataDia == 28)
            {
                if(diaSemana == 6)  pagamentoMensal = true;
            }
            else if (dataDia == 29)
            {
                if (diaSemana == 6) pagamentoMensal = true;
            }
            else pagamentoMensal = true;
        }
        boolean pagamentoSemanal = false;
        boolean pagamentoBisemanal = false;
        if(diaSemana == 6) 
        {
            pagamentoSemanal = true;
            pagamentoBisemanal = true;
        }
        
        
        for (int i = 0; i < maxFuncionarios; i++)
        {
            if (pagamentoMensal == true)
            {
                if (arrayFuncionarios[i].tipoMensal == true)  arrayFuncionarios[i].seraPagoHoje = true;
            }
            if (pagamentoSemanal == true)
            {
                if (arrayFuncionarios[i].tipoSemanal == true)    arrayFuncionarios[i].seraPagoHoje = true;
            }
            if (pagamentoBisemanal == true)
            {
                if (arrayFuncionarios[i].tipoBisemanal== true) 
                {
                    if (arrayFuncionarios[i].recebeu == 0)    
                    {
                        arrayFuncionarios[i].seraPagoHoje = true;
                        arrayFuncionarios[i].recebeu++;
                    }
                    else arrayFuncionarios[i].recebeu = 0;
                }
            }
        }
        
        for (int i = 0; i < maxFuncionarios; i++)
        {
            if (arrayFuncionarios[i].seraPagoHoje == true)
            {
                if (arrayFuncionarios[i].recebeMensal == true)
                {
                    arrayFuncionarios[i].totalParaReceber += arrayFuncionarios[i].salario;
                    arrayFuncionarios[i].totalParaReceber -= arrayFuncionarios[i].valorSindicato;
                }
                else if(arrayFuncionarios[i].recebePorHora == true)
                {
                    arrayFuncionarios[i].totalParaReceber += (arrayFuncionarios[i].totalHoraNormal * arrayFuncionarios[i].salario);
                    arrayFuncionarios[i].totalParaReceber += (arrayFuncionarios[i].totalHoraExtra * (arrayFuncionarios[i].salario * 1.5));
                    arrayFuncionarios[i].totalParaReceber -= arrayFuncionarios[i].valorSindicato;
                }
                else
                {
                    arrayFuncionarios[i].totalParaReceber += (arrayFuncionarios[i].salario/4);
                    arrayFuncionarios[i].totalParaReceber -= arrayFuncionarios[i].valorSindicato;
                }
                if(arrayFuncionarios[i].totalParaReceber > 0)
                {
                    alguemSeraPago = true;
                    System.out.println("\nO Funcionário de ID " + arrayFuncionarios[i].id + " tem o valor de " + arrayFuncionarios[i].totalParaReceber + "0 reais para receber.");
                    System.out.print("O pagamento será realizado ");
                    switch (arrayFuncionarios[i].metodoPagamento)
                    {
                        case 1:
                            System.out.println("através de um cheque pelos correios!");
                            break;
                        case 2:
                            System.out.println("através de um cheque em mãos!");
                            break;
                        case 3:
                            System.out.println("através de um depósito em conta bancária!");
                            break;
                    }
                    System.out.println("");
                }
                else if (arrayFuncionarios[i].totalParaReceber < 0) System.out.println("\nO Funcionário de ID " + arrayFuncionarios[i].id + " está devendo um valor de " + arrayFuncionarios[i].totalParaReceber + "0 reais.\n");
                    
                arrayFuncionarios[i].seraPagoHoje = false;
                arrayFuncionarios[i].totalParaReceber = 0;
                arrayFuncionarios[i].totalHoraNormal = 0;
                arrayFuncionarios[i].totalHoraExtra = 0;
            }
        } 
        if (alguemSeraPago == false)    System.out.println("\nNão há ninguém para ser pago hoje!");
        return arrayFuncionarios;
    }
    public static void listaFuncionarios (Funcionarios[] arrayFuncionarios, int maxFuncionarios)
    {
        
        System.out.println("---------- LISTA DE FUNCIONÁRIOS ----------\n\n");
        
        for (int i = 0; i < maxFuncionarios; i++)
        {
            if (arrayFuncionarios[i].id != -1)
            {
                System.out.println("ID: " + arrayFuncionarios[i].id + ".");
                System.out.println("Nome: " + arrayFuncionarios[i].primeiroNome + " " + arrayFuncionarios[i].ultimoNome + ".");
                if (arrayFuncionarios[i].recebePorHora == true) System.out.println("Tipo: Horista.");
                else if (arrayFuncionarios[i].recebeMensal == true) System.out.println("Tipo: Assalariado.");
                else    System.out.println("Tipo: Comissionado.");
                System.out.println("Endereço: " + arrayFuncionarios[i].endereco + ".");
                System.out.println("");
            }
        }
    }
    public static Funcionarios[] copiarArray (Funcionarios[] arrayFuncionarios, Funcionarios[] arrayReserva, int maxFuncionarios)
    {
        for (int i=0; i < maxFuncionarios; i++)
        {
                arrayReserva[i].primeiroNome = arrayFuncionarios[i].primeiroNome;
                arrayReserva[i].ultimoNome = arrayFuncionarios[i].ultimoNome;
                arrayReserva[i].endereco = arrayFuncionarios[i].endereco;
                arrayReserva[i].tipoMensal = arrayFuncionarios[i].tipoMensal;
                arrayReserva[i].tipoSemanal = arrayFuncionarios[i].tipoSemanal;
                arrayReserva[i].tipoBisemanal = arrayFuncionarios[i].tipoBisemanal;
                arrayReserva[i].recebePorHora = arrayFuncionarios[i].recebePorHora;
                arrayReserva[i].recebeMensal = arrayFuncionarios[i].recebeMensal;
                arrayReserva[i].salario = arrayFuncionarios[i].salario;
                arrayReserva[i].comissao = arrayFuncionarios[i].comissao;
                arrayReserva[i].valorComissao = arrayFuncionarios[i].valorComissao;
                arrayReserva[i].recebeu = arrayFuncionarios[i].recebeu;
                arrayReserva[i].id = arrayFuncionarios[i].id;
                arrayReserva[i].metodoPagamento = arrayFuncionarios[i].metodoPagamento;
                arrayReserva[i].totalHoraNormal = arrayFuncionarios[i].totalHoraNormal;
                arrayReserva[i].totalHoraExtra = arrayFuncionarios[i].totalHoraExtra;
                arrayReserva[i].sindicato = arrayFuncionarios[i].sindicato;
                arrayReserva[i].valorSindicato = arrayFuncionarios[i].valorSindicato;
                arrayReserva[i].idSindicato = arrayFuncionarios[i].idSindicato;
                arrayReserva[i].totalParaReceber = arrayFuncionarios[i].totalParaReceber;
                arrayReserva[i].seraPagoHoje = arrayFuncionarios[i].seraPagoHoje;
        
        }
        return arrayReserva;
    }
}