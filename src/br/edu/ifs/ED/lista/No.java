package br.edu.ifs.ED.lista;

public class No<T> {
    public T elemento;
    public No<T> proximo;

    public No(T elemento) {
        this.elemento = elemento;
    }

    public T getElemento() {
        return this.elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public No<T> getProximo() {
        return this.proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }
}
