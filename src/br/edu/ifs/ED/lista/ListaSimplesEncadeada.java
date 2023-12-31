package br.edu.ifs.ED.lista;

public class ListaSimplesEncadeada<T extends Comparable<T>> extends Lista<T> {

    private No<T> primeiro;
    private No<T> ultimo;
    private int tamanho;

    public No<T> getPrimeiro() {
        return this.primeiro;
    }

    public void setPrimeiro(No<T> primeiro) {
        this.primeiro = primeiro;
    }

    public No<T> getUltimo() {
        return this.ultimo;
    }

    public void setUltimo(No<T> ultimo) {
        this.ultimo = ultimo;
    }

    public ListaSimplesEncadeada(){
        this.tamanho = 0;
    }

    @Override
    public void incluir(T elemento) throws Exception {
        No<T> novo = new No<T>(elemento);
        if(this.primeiro == null && this.ultimo == null){
            this.primeiro = novo;
            this.ultimo = novo;
        }else {
            this.ultimo.setProximo(novo);
            this.ultimo = novo;
        }
        tamanho++;
        //throw new Exception("Não implementado");
    }


    public T get(int posicao)  throws Exception {
        No<T> atual = this.primeiro;
        if (posicao < 0 || posicao > getTamanho()){
            throw new Exception("Posição solicitada não existe na lista");
        }
        for (int i = 0; i < posicao; i++) {
            if (atual.getProximo() != null){
                atual = atual.getProximo();
            }
        }
        return atual.getElemento();
    }


    public int getPosElemento(T elemento)  throws Exception {
        No<T> atual = this.primeiro;
        int posicao = -1;
        for (int i = 0; i < this.getTamanho(); i++) {
            if (atual.getElemento().equals(elemento)){
                posicao = i;
            }
            if (atual.getProximo() == null && posicao == -1){
                throw new Exception("Elemento não localizado");
            }
            atual = atual.getProximo();
        }
        return posicao;
    }

    @Override
    public void remover(int posicao) throws Exception {
        No<T> anterior = null;
        No<T> atual = this.primeiro;
        for (int i = 0; i < this.getTamanho(); i++) {
            if (posicao == 0){ //Remove no inicio
                this.primeiro = atual.getProximo();
                atual = null;
                this.tamanho--;
                break;
            }
            if (i == posicao){ //Remove no meio
                anterior.setProximo(atual.getProximo());
                atual = null;
                this.tamanho--;
                break;
            }
            if (posicao == this.getTamanho() - 1){ //Remove no fim
                this.setUltimo(anterior);
                atual = null;
                this.tamanho--;
                break;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
        //throw new Exception("Não implementado");
    }

    @Override
    public int getTamanho() {
        return this.tamanho;
    }

    public void limpar() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }



    @Override
    public boolean contem(T elemento) throws Exception {
        No<T> atual = this.primeiro;
        for (int i = 0; i < getTamanho(); i++) {
            if (atual.getElemento().equals(elemento)){
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
        //throw new Exception("Não implementado");
    }

    @Override
    public int compareTo(Lista<T> item) {
        No<T> atualPrimeira = this.primeiro;
        No<T> atualSegunda = item.getPrimeiro();

        while (atualPrimeira != null && atualSegunda != null){
            int resultado = atualPrimeira.getElemento().compareTo(atualSegunda.getElemento());
            if (resultado != 0){
                return resultado;
            }
            atualPrimeira = atualPrimeira.getProximo();
            atualSegunda = atualSegunda.getProximo();
        }

        if (atualPrimeira != null){
            return 1;
        } else if (atualSegunda != null){
            return -1;
        }
        return 0;
    }

    private int transformarRecursivo(No<T> atual, T[] vetor, int i){
        if (atual == null){
            return i;
        }
        vetor[i] = atual.getElemento();
        return transformarRecursivo(atual.getProximo(), vetor, i + 1);
    }

	@Override
	public T[] TransformarEmVetor() {
        if (getTamanho() == 0){
            return (T[]) new Object[0];
        }
        T[] vetor = (T[]) new Comparable[getTamanho()];
        transformarRecursivo(this.primeiro, vetor, 0);
        return vetor;




        /*T[] vetor = (T[]) new Comparable[getTamanho()];
        No<T> atual = this.primeiro;
        int i = 0;

        while (atual != null){
            vetor[i] = atual.getElemento();
            i++;
            atual = atual.getProximo();
        }
        return vetor;*/

        //throw new UnsupportedOperationException("Não implementado 'TransformarEmVetor'");
	}


}
