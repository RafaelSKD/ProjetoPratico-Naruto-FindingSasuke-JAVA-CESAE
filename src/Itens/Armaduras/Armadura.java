package Itens.Armaduras;

import Itens.Enum.TipoArmadura;
import Itens.Enum.TipoItem;
import Itens.Item;

public class Armadura extends Item {
    private TipoArmadura tipoArmadura; //CIMA,BAIXO
    private double defesaArmadura; // quanto defesa adicional vai trazer ao utilizador
    private int spawn; // possibilidade de aparecer

    public Armadura(String nome, TipoItem tipo, TipoArmadura tipoArmadura, double defesa, int spawn) {
        super(nome, tipo);
        this.tipoArmadura = tipoArmadura;
        this.defesaArmadura = defesa;
        this.spawn = spawn;
    }

    public TipoArmadura getTipoArmadura() {
        return tipoArmadura;
    }

    public void setTipoArmadura(TipoArmadura tipoArmadura) {
        this.tipoArmadura = tipoArmadura;
    }

    public double getDefesaArmadura() {
        return defesaArmadura;
    }

    public void setDefesaArmadura(double defesaArmadura) {
        this.defesaArmadura = defesaArmadura;
    }

    public int getSpawn() {
        return spawn;
    }

    public void setSpawn(int spawn) {
        this.spawn = spawn;
    }
}
