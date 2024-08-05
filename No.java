import java.util.LinkedList;
import java.util.Queue;

//Copiei o algorito disponibilizado no moodle
class No{
    int valor;
    No esquerda;
    No direita;

    public No(int valor){
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public int obterValor(){
        return this.valor;
    }

    public No obterEsquerda(){
        return this.esquerda;
    }

    public No obterDireita() {
        return this.direita;
    }

    public void definirEsquerda(No no){
        this.esquerda = no;
    }
    public void definirDireita(No no){
        this.direita = no;
    }

    public void imprimirPreOrdem(){
        System.out.print(this.valor+" ");
        if(this.esquerda != null){
            this.esquerda.imprimirPreOrdem();
        }
        if(this.direita != null){
            this.direita.imprimirPreOrdem();
        }
    }

    public void imprimirEmOrdem(){
        if(this.esquerda != null){
            this.esquerda.imprimirEmOrdem();
        }
        System.out.print(this.valor+" ");
        if(this.direita != null){
            this.direita.imprimirEmOrdem();
        }
    }

    public void imprimirPosOrdem(){
        if(this.esquerda!= null){
            this.esquerda.imprimirPosOrdem();
        }
        if(this.direita != null) {
            this.direita.imprimirPosOrdem();
        }
        System.out.print(this.valor+" ");
    }
}

class ArvoreBinaria{
    No raiz;

    public ArvoreBinaria(){
        this.raiz = null;
    }

    public void inserir(int valor){
        this.raiz = inserirNo(this.raiz, valor);
    }

    private No inserirNo(No no, int valor){
        if(no == null){
            return new No(valor);
        } else if(valor < no.obterValor()){
            no.definirEsquerda(inserirNo(no.obterEsquerda(), valor));
        } else if(valor > no.obterValor()){
            no.definirDireita(inserirNo(no.obterDireita(), valor));
        }
        return no;
    }

    public boolean pesquisar(int valor){
        return pesquisarNo(this.raiz, valor);
    }

    private boolean pesquisarNo(No no, int valor){
        if (no == null){
            return false;
        } else if(valor == no.obterValor()){
            return true;
        } else if(valor < no.obterValor()){
            return pesquisarNo(no.obterEsquerda(), valor);
        } else {
            return pesquisarNo(no.obterDireita(), valor);
        }
    }

    public void remover(int valor) {
        this.raiz = removerNo(this.raiz, valor);
    }

    private No removerNo(No no, int valor) {
        if (no == null) {
            return no;
        }
        if (valor< no.obterValor()){
            no.definirEsquerda(removerNo(no.obterEsquerda(), valor));
        } else if (valor > no.obterValor()) {
            no.definirDireita(removerNo(no.obterDireita(), valor));
        } else {
            if (no.obterEsquerda() == null) {
                No temp = no.obterDireita();
                no = null;
                return temp;
            } else if (no.obterDireita() == null) {
                No temp = no.obterEsquerda();
                no = null;
                return temp;
            }
            No temp = minimoValorNo(no.obterDireita());
            no.valor = temp.obterValor();
            no.definirDireita(removerNo(no.obterDireita(), temp.obterValor()));
        }
        return no;
    }
    private No minimoValorNo(No no) {
        No atual = no;
        while (atual.obterEsquerda() != null) {
            atual = atual.obterEsquerda();
        }
        return atual;
    }

    public void imprimirEmOrdem() {
        imprimirEmOrdemNo(this.raiz);
        System.out.println();
    }

    private void imprimirEmOrdemNo(No no) {
        if (no != null) {
            imprimirEmOrdemNo(no.obterEsquerda());
            System.out.print(no.obterValor()+" ");
            imprimirEmOrdemNo(no.obterDireita());
        }
    }
    public void imprimirPreOrdem() {
        if (this.raiz != null) {
            this.raiz.imprimirPreOrdem();
            System.out.println();
        }
    }

    public void imprimirPosOrdem() {
        if (this.raiz != null) {
            this.raiz.imprimirPosOrdem();
            System.out.println();
        }
    }

   
    public void imprimirEmNivel() {
        if (this.raiz == null) {
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(this.raiz);

        while (!fila.isEmpty()){
            No noAtual = fila.remove();
            System.out.print(noAtual.obterValor()+" ");

            if (noAtual.obterEsquerda() != null){
                fila.add(noAtual.obterEsquerda());
            }
            if (noAtual.obterDireita() != null){
                fila.add(noAtual.obterDireita());
            }
        }
        System.out.println("");
    }
}