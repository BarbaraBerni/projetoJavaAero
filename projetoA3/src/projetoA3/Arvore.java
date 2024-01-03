package projetoA3;
import java.util.Scanner;

class Voo {
    int id;
    int horario;
    String empresa;
    String destino;
    String status;
    String portao;

    public Voo(int id, int horario, String empresa, String destino, String status, String portao) {
        this.id = id;
        this.horario = horario;
        this.empresa = empresa;
        this.destino = destino;
        this.status = status;
        this.portao = portao;
    }

    public int getId() {
        return id;
    }

    public int getHorario() {
        return horario;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getDestino() {
        return destino;
    }

    public String getStatus() {
        return status;
    }

    public String getPortao() {
        return portao;
    }
}

class Folha {
    Voo voo;
    Folha esquerda, direita;

    public Folha(Voo voo) {
        this.voo = voo;
        this.esquerda = this.direita = null;
    }

    public Voo getVoo() {
        return voo;
    }

    public Folha getEsquerda() {
        return esquerda;
    }

    public Folha getDireita() {
        return direita;
    }

    public int getHorario() {
        return voo.getHorario();
    }

    public String getEmpresa() {
        return voo.getEmpresa();
    }

    public String getDestino() {
        return voo.getDestino();
    }

    public String getStatus() {
        return voo.getStatus();
    }

    public String getPortao() {
        return voo.getPortao();
    }

    public void setEsquerda(Folha esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(Folha direita) {
        this.direita = direita;
    }
}

public class Arvore {
    private Folha raiz;
    private Fila fila;  // Adicionando um campo para armazenar a referência de filas

    public Arvore(Fila Fila) {
        this.raiz = null;
        this.fila = fila;  // Inicializando o campo Filas
    }

 // Modificando o método adicionar para adicionar à fila também
    public void adicionar(Voo voo) {
        raiz = adicionarRec(raiz, voo);
        fila.adicionarVooInterface(voo.getId(), voo.getHorario(), voo.getEmpresa(), voo.getDestino(), voo.getStatus(), voo.getPortao());
    }

    private Folha adicionarRec(Folha raiz, Voo voo) {
        if (raiz == null) {
            return new Folha(voo);
        }

        if (voo.getId() < raiz.getVoo().getId()) {
            raiz.setEsquerda(adicionarRec(raiz.getEsquerda(), voo));
        } else if (voo.getId() > raiz.getVoo().getId()) {
            raiz.setDireita(adicionarRec(raiz.getDireita(), voo));
        }

        return raiz;
    }

    public Voo pesquisar(int id) {
        return pesquisarRec(raiz, id);
    }

    private Voo pesquisarRec(Folha raiz, int id) {
        if (raiz == null || raiz.getVoo().getId() == id) {
            return (raiz != null) ? raiz.getVoo() : null;
        }

        if (id < raiz.getVoo().getId()) {
            return pesquisarRec(raiz.getEsquerda(), id);
        }

        return pesquisarRec(raiz.getDireita(), id);
    }

    public void percorrerEmOrdem() {
        percorrerEmOrdemRec(raiz);
        System.out.println();
    }

    private void percorrerEmOrdemRec(Folha raiz) {
        if (raiz != null) {
            percorrerEmOrdemRec(raiz.getEsquerda());
            System.out.print("ID: " + raiz.getVoo().getId() + " ");
            percorrerEmOrdemRec(raiz.getDireita());
        }
    }

    public static void main(String[] args) {
    	Fila fila = new Fila();
    	Arvore arvore  = new Arvore(fila);

        try (Scanner scanner = new Scanner(System.in)){
        for (int i = 0; i < 4; i++) {
            System.out.println("Informe os detalhes do voo:");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            System.out.print("Horário: ");
            int horario = scanner.nextInt();
            System.out.print("Empresa: ");
            String empresa = scanner.next();
            System.out.print("Destino: ");
            String destino = scanner.next();
            System.out.print("Status: ");
            String status = scanner.next();
            System.out.print("Portão: ");
            String portao = scanner.next();

            Voo novoVoo = new Voo(id, horario, empresa, destino, status, portao);
            fila.adicionarVoo(novoVoo.getId(), novoVoo.getHorario(), novoVoo.getEmpresa(), novoVoo.getDestino(), novoVoo.getStatus(), novoVoo.getPortao());
        }
        
        if(!fila.isEmpty()) { //Aqui o empty funciona para ver se a fila esta vazia, para que o percorrerEmOrdem verifica se tem algo para percorrer 
        	System.out.println("Árvore em ordem: ");
        	fila.percorrerEmOrdem();
        }else {
        	System.out.println("A árvore está vazia. ");
        }

        System.out.print("Informe o ID do voo a ser pesquisado: ");
        int idPesquisa = scanner.nextInt();
        Voo vooEncontrado = fila.pesquisar(idPesquisa);
        if (vooEncontrado != null) {
            System.out.println("O voo com ID " + idPesquisa + " foi encontrado. Detalhes:");
            System.out.println("Horário: " + vooEncontrado.getHorario() +
                    ", Empresa: " + vooEncontrado.getEmpresa() +
                    ", Destino: " + vooEncontrado.getDestino());
        } else {
            System.out.println("O voo com ID " + idPesquisa + " não foi encontrado.");
        }

        scanner.close(); //Fecha a chamada do Scanner
    }
}
}