package Itens;

import Itens.Enum.TipoItem;

public class Item {
    private String nome; // nome do item
    private TipoItem tipo; // ARMADURA,ARMA,ATAQUEESPECIAL,CONSUMIVEL,ESPECIAL

    public Item(String nome, TipoItem tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }
}
