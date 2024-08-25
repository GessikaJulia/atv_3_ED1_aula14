public class Pilha {
    private Nodo topo;

    public Pilha() {
        this.topo = null;
    }

    public void empilhar(int valor) {
        Nodo novoNodo = new Nodo(valor);
        if (this.topo != null) {
            novoNodo.anterior = this.topo;
            this.topo.proximo = novoNodo;
        }
        this.topo = novoNodo;
    }

    public int desempilhar() {
        if (this.topo == null) {
            return -1;
        }
        int valor = this.topo.valor;
        this.topo = this.topo.anterior;
        if (this.topo != null) {
            this.topo.proximo = null;
        }
        return valor;
    }

    public int consultarTopo() {
        if (this.topo == null) {
            return -1;
        }
        return this.topo.valor;
    }

    public boolean estaVazia() {
        return this.topo == null;
    }

    public void imprimirPilha() {
        Nodo atual = this.topo;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.anterior;
        }
        System.out.println();
    }
}
