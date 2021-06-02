package Application;

import java.io.IOException;
import java.sql.SQLException;
/*import java.util.Date;*/
import java.util.List;
import java.util.Scanner;

import modelo.dao.AlunoDAO;
import modelo.dao.FactoryDAO;
import model.entities.Aluno;

public class Program {

	public static void main(String[] args) throws IOException, SQLException {
		
        try {
            int opcao = 0;
            @SuppressWarnings("resource")
			Scanner console = new Scanner(System.in);
            
            do {
                System.out.println("\n");
                System.out.print("############ Menu ###########"
                                 + "\n#       1- Cadastrar        #"
                                 + "\n#       2- Listar           #"
                                 + "\n#       3- Alterar          #"
                                 + "\n#       4- Excluir          #"
                                 + "\n#       5- Sair             #"
                                 + "\n-----------------------------");
                System.out.print("\n\n# Opção: ");
                opcao = Integer.parseInt(console.nextLine());
                //(1 - INSERT)
                if (opcao == 1){
                    AlunoDAO acao = FactoryDAO.createAlunoDAO();
                    Aluno a = new Aluno();
                    
                    System.out.print("\n#     Cadastrar Aluno(a)    #\n\r");
                    System.out.print("Nome: ");
                    a.setNome(console.nextLine());
                    System.out.print("Sexo: ");
                    a.setSexo(console.nextLine());
                  /*  System.out.print("Data de nascimento: ");
                    a.setDt_nasc(new Date(console.nextLine())); */

                    acao.insert(a);
                    System.out.println("\n");
                    System.out.print("######## Aluno(a) cadastrado(a) com sucesso! ########"
                    		+ "\n"
                    		+ "\n#  [ ID: " + a.getId() + " | "
                    		+ "NOME: " + a.getNome() + " | " 
                    		+ "SEXO: " + a.getSexo()
                    		/* + a.getDt_nasc()*/ + " ] ");
                    System.out.println("\n");
                    console.nextLine();
                }
                //(2 - LIST OBJ)
                if (opcao == 2){
                    AlunoDAO acao = FactoryDAO.createAlunoDAO();
                    List<Aluno> alunos = acao.getLista();
                    System.out.print("\n########   Alunos(as) cadastrados(as):  ########");
                    for(Aluno aluno : alunos) {
                    	System.out.print("\n"
                        		+ "\n#  [ ID: " + aluno.getId() + " | "
                        		+ "NOME: " + aluno.getNome() + " | " 
                        		+ "SEXO: " + aluno.getSexo()
                        		/* + aluno.getDt_nasc()*/ + " ] ");
                    }    
                }
                //(3 - UPDATE)
                if (opcao == 3){
                	AlunoDAO acao = FactoryDAO.createAlunoDAO();
                    Aluno a = acao.findByid(1);
                    
                    System.out.print("\n*** Informe os dados para atualização cadastral: ***\n\r");
                    System.out.print("Nome: ");
                    a.setNome(console.nextLine());
                    System.out.print("Sexo: ");
                    a.setSexo(console.nextLine());
                    acao.update(a);
                    System.out.print("\n*** Cadastro atualizado com sucesso! ***\n\r");
                }                                       
                //(4 - DELETE)
                if (opcao == 4){
                	AlunoDAO acao = FactoryDAO.createAlunoDAO();
                    
                    System.out.print("\n*** Qual o ID do Aluno a ser excluído? ***\n\r");
                    int id = console.nextInt();
                    acao.deleteByid(id);
                    
                    System.out.print("\n*** Aluno excluído com sucesso! ***\n\r");
                    System.out.println("\n\n\n\n");
                                      
                    console.nextLine();
                }
            } while(opcao != 5);
        } catch (Exception e){
            System.out.println("Erro: " + e);
        }
	}
}