package projetoA3;
/* Primeiro o painel vai conter as seguintes informações: horario do voo, id do voo, empresa do voo, destino, portao esssas informaçoes
 	quem vai colocar vai ser um usuario, então o SCANNER vai ser usado pra isso	
 * Com as informações vai ser preciso estruturar tudo em fila com todas as variaveis usadas para os atributos do painel 
 * Depois da estrutura criada precisa ordenar os voos, por uma árvore binaria e ela ordena pelo id do voo
 * Ele precisa retirar da fila por ordem de horario, o mais próximo
 */
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Fila { 
    private Queue<String> empString = new LinkedList<>();
    private Queue<String> destString = new LinkedList<>();
    private Queue<String> portString = new LinkedList<>();
    private Queue<String> statusString = new LinkedList<>();
    private Queue<Integer> horarioInt = new LinkedList<>();
    private Queue<Integer> idInt = new LinkedList<>();

 // Método para adicionar voo diretamente da interface gráfica
    public void adicionarVooInterface(int id, int horario, String empresa, String destino, String status, String portao) {
        adicionarVoo(id, horario, empresa, destino, status, portao);
    }
 // Método para adicionar voo à fila
    public void adicionarVoo(int id, int horario, String empresa, String destino, String status, String portao) {
        horarioInt.add(horario);
        idInt.add(id);
        empString.add(empresa);
        destString.add(destino);
        portString.add(portao);
        statusString.add(status);
    }
    //metodo de acesso
    public Queue<String> getEmpString() {
        return empString;
    }

    public Queue<String> getDestString() {
        return destString;
    }

    public Queue<String> getPortString() {
        return portString;
    }

    public Queue<String> getStatusString() {
        return statusString;
    }

    public Queue<Integer> getHorarioInt() {
        return horarioInt;
    }

    public Queue<Integer> getIdInt() {
        return idInt;
    }

    

    // System para mostrar os dados armazenados na fila para o user
    public void mostrarDados() {
        System.out.println("Informações do voo  ");
        System.out.println("Horário do voo: " + horarioInt);
        System.out.println("ID do voo: " + idInt);
        System.out.println("Empresa aérea: " + empString);
        System.out.println("Destino do voo: " + destString);
        System.out.println("Status do voo: " + statusString);
        System.out.println("Portão de embarque: " + portString);
    }

    public static void main(String[] args) {
    	Fila fila = new Fila();
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < 4; i++) {
                System.out.println("Informe os detalhes do voo " + (i + 1) + ":");
                System.out.print("ID do voo: ");
                int id = scanner.nextInt();
                System.out.print("Horário do voo: ");
                int horario = scanner.nextInt();
                System.out.print("Empresa aérea: ");
                String empresa = scanner.next();
                System.out.print("Destino do voo: ");
                String destino = scanner.next();
                System.out.print("Status do voo: ");
                String status = scanner.next();
                System.out.print("Portão de embarque: ");
                String portao = scanner.next();

                fila.adicionarVoo(id, horario, empresa, destino, status, portao);
            }

            fila.mostrarDados();
        }
    }
    public boolean isEmpty() { // Isso verifica se todas as listas internas estão vazias. Ele faz parte da interface QUEUE
        return horarioInt.isEmpty() && idInt.isEmpty() && empString.isEmpty() &&
               destString.isEmpty() && portString.isEmpty() && statusString.isEmpty();
    }
	public void percorrerEmOrdem() {
		// TODO Auto-generated method stub
		
	}
	public Voo pesquisar(int idPesquisa) {
		// TODO Auto-generated method stub
		return null;
	}
}