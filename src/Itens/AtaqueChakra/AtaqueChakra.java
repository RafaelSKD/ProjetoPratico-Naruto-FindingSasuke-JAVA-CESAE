package Itens.AtaqueChakra;

import Itens.Enum.TipoItem;
import Itens.Item;

public class AtaqueChakra extends Item { // ataques que precisam de chakra
    private double forcaExtra; // forca extra que da
    private double chakraNecessario; // chakra necessario para usar o especial

    public AtaqueChakra(String nome, TipoItem tipo, double forcaExtra, double chakraNecessario) {
        super(nome, tipo);
        this.forcaExtra = forcaExtra;
        this.chakraNecessario = chakraNecessario;
    }

    public double getForcaExtra() {
        return forcaExtra;
    }

    public void setForcaExtra(double forcaExtra) {
        this.forcaExtra = forcaExtra;
    }

    public double getChakraNecessario() {
        return chakraNecessario;
    }

    public void setChakraNecessario(double chakraNecessario) {
        this.chakraNecessario = chakraNecessario;
    }
}
