import java.util.Random;

public class GerenciadorDePilhas {
    private Pilha pilha1;
    private Pilha pilha2;
    private Pilha pilha3;
    private Random random;

    public GerenciadorDePilhas() {
        this.pilha1 = new Pilha();
        this.pilha2 = new Pilha();
        this.pilha3 = new Pilha();
        this.random = new Random();
    }

    public void fase1() {
        for (int i = 0; i < 100; i++) {
            int numero = random.nextInt(9) + 1;
            if (numero >= 1 && numero <= 3) {
                pilha1.empilhar(numero);
            } else if (numero >= 4 && numero <= 6) {
                pilha2.empilhar(numero);
            } else if (numero >= 7 && numero <= 9) {
                pilha3.empilhar(numero);
            }
        }
    }

    public void fase2() {
        for (int i = 0; i < 100; i++) {
            int sorteio = random.nextInt(3) + 1;
            Pilha pilhaDestino = null;
            Pilha pilha1Aux = pilha1;
            Pilha pilha2Aux = pilha2;
            Pilha pilha3Aux = pilha3;

            if (sorteio == 1) {
                pilhaDestino = pilha1Aux;
            } else if (sorteio == 2) {
                pilhaDestino = pilha2Aux;
            } else if (sorteio == 3) {
                pilhaDestino = pilha3Aux;
            }

            int valorPilha1 = pilha1Aux.consultarTopo();
            int valorPilha2 = pilha2Aux.consultarTopo();
            int valorPilha3 = pilha3Aux.consultarTopo();

            if (pilhaDestino == pilha1Aux) {
                if (valorPilha2 != -1 && valorPilha3 != -1) {
                    System.out.println("Empilhando os números " + valorPilha2 + " e " + valorPilha3 + " na pilha 1");
                    pilhaDestino.empilhar(pilha2Aux.desempilhar());
                    pilhaDestino.empilhar(pilha3Aux.desempilhar());
                }
            } else if (pilhaDestino == pilha2Aux) {
                if (valorPilha1 != -1 && valorPilha3 != -1) {
                    System.out.println("Empilhando os números " + valorPilha1 + " e " + valorPilha3 + " na pilha 2");
                    pilhaDestino.empilhar(pilha1Aux.desempilhar());
                    pilhaDestino.empilhar(pilha3Aux.desempilhar());
                }
            } else if (pilhaDestino == pilha3Aux) {
                if (valorPilha1 != -1 && valorPilha2 != -1) {
                    System.out.println("Empilhando os números " + valorPilha1 + " e " + valorPilha2 + " na pilha 3");
                    pilhaDestino.empilhar(pilha1Aux.desempilhar());
                    pilhaDestino.empilhar(pilha2Aux.desempilhar());
                }
            }

            if (pilha1Aux.estaVazia() || pilha2Aux.estaVazia() || pilha3Aux.estaVazia()) {
                System.out.println("O programa foi encerrado porque uma das pilhas está vazia");
                break;
            }
        }
    }

    public void imprimirPilhas() {
        System.out.println("Pilha 1:");
        pilha1.imprimirPilha();
        System.out.println("Pilha 2:");
        pilha2.imprimirPilha();
        System.out.println("Pilha 3:");
        pilha3.imprimirPilha();
    }
}
