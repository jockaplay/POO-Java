import com.classes.Contato;
import java.util.Scanner;
import java.util.ArrayList;


public class Agenda { 

	static ArrayList<Contato> contatos = new ArrayList<>();
	static Scanner input = new Scanner(System.in);
	static String menu = "\n----- MENU -----\n1. Adicionar\n2. Ver lista\n3. Editar\n4. Deletar\n5. Exit\n----------------\n";
	static String editOpt = "\n----- Editar -----\n1. Nome\n2. Número\n3. Endereço\n----------------\n";
	
	public static void main(String[] args) {
		clearScreen(); //Limpa o terminal ao iniciar o programa.
		int option;
		do{
			System.out.println(menu);
			option = input.nextInt();
			switch (option){
				case 1:
					addContato();
					break;
				case 2:
					viewContatos();
					break;
				case 3:
					editContato();
					break;
				case 4:
					deleteContato();
					break;
			}
		}while(option != 5);
		clearScreen(); //Limpar o terminal após o término do programa.
	}
	
	private static void addContato (){	
	
		/* Adicionar contato: Limpa a tela, e começa a aparecer os inputs para 
		configurar o contato, adiciona no array, limpa a tela e retorna um feedback. */
	
		clearScreen();
		input.nextLine(); //Sem essa linha não da pra dar espaço nas opções.
		boolean validName = false;
		String nome = "";
		while (!validName){
			System.out.print("Digite o nome do contato: ");
			nome = input.nextLine();
			validName = true;
			for (int i = 0; i < contatos.size(); i++){
				if (contatos.get(i).getNome().equals(nome)){
					System.out.println("Esse contato já existe.");
					validName = false;
					break;
				}
			}
			
		}
		System.out.print("Digite o telefone do contato: ");
		String telefone = input.nextLine();
		System.out.print("Digite o endereço do contato: ");
		String endereco = input.nextLine();
		
		Contato c1 = new Contato(nome, telefone, endereco);
		
		try{
			// Item 1
			contatos.add(c1);
			
			System.out.println();
			clearScreen();
			System.out.println("----- Contato adicionado! -----");
		} catch (Exception e) {
			System.out.println("----- Não foi possível adicionar! -----");
		}
		
		// O Item 1 pode ser colocado fora dessa estrutura, o try/catch é apenas um tratamento de erro.
		
	}
	
	private static void viewContatos () {
		
		clearScreen();
		input.nextLine();
		System.out.println();
		
		if (contatos.size() > 0){
			for (int i = 0; i < contatos.size(); i ++){
				System.out.print(contatos.get(i).getNome() + " - - - - ");
				System.out.print(contatos.get(i).getTelefone() + " - - - - ");
				System.out.println(contatos.get(i).getEndereco());
			}
		} else {
			System.out.println("Lista de contatos vazia.");	
		}
		System.out.println("\nPressione Enter para voltar.");
		input.nextLine();
		clearScreen();
	}
	
	private static void editContato () {
		
		clearScreen();
		System.out.println("\n----- Editar -----\n");
		
		input.nextLine();
		System.out.print("Nome do contato: ");
		String selectName = input.nextLine();
		
		String name = "";
		String tel = "";
		String local = "";
		
		for (int i = 0; i < contatos.size() + 1; i++){
		
			/* Com essa estrutura, ele vai percorrer o array inteiro, e ao chegar no 
			contato selecionado, vai alterar apenas aquilo que foi solicitado */
			if (i < contatos.size()){
				if (contatos.get(i).getNome().equals(selectName)){
					clearScreen();
					System.out.print("Editando: " + selectName + "\n");
					System.out.println(editOpt);
					int option = input.nextInt();
					
					clearScreen();
					System.out.println("Editando: " + selectName + "\n");
					switch (option){
						case 1:
							input.nextLine();
							System.out.print("Escolha um novo nome: ");
							name = input.nextLine();
							System.out.println();
							break;
						case 2:
							input.nextLine();
							System.out.print("Escolha um novo número: ");
							tel = input.nextLine();
							System.out.println();
							break;
						case 3:
							input.nextLine();
							System.out.print("Escolha um novo endereço: ");
							local = input.nextLine();
							System.out.println();
							break;
						default:
							clearScreen();
							System.out.print("\n------ Opção inválida. ------\n");
					}
					Contato c1 = new Contato (
						(name != "") ? name : contatos.get(i).getNome(),
						(tel != "") ? tel : contatos.get(i).getTelefone(),
						(local != "") ? local : contatos.get(i).getEndereco()
					);
					contatos.set(i, c1);
					clearScreen();
					System.out.println("Contato alterado!");
					break;
				}
			} else {
				clearScreen();
				System.out.println("Esse contato não existe!");
			}
		}
	}
	
	public static void deleteContato () {
		
		clearScreen();
		System.out.println("\n----- Apagar -----\n");
		
		input.nextLine();
		System.out.print("Nome do contato: ");
		String selectName = input.nextLine();
		
		for (int i = 0; i < contatos.size(); i++){
			if (contatos.get(i).getNome().equals(selectName)){
				clearScreen();
				System.out.println(contatos.get(i).getNome() + " foi removido!");
				contatos.remove(i);
				break;
			}
		}
	}
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	}
}
