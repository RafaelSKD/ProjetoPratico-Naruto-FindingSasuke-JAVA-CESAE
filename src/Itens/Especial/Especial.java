package Itens.Especial;

import Itens.Enum.TipoItem;
import Itens.Item;

/**
 * Representa um item especial que aplica efeitos contínuos enquanto está equipado.
 * Pode afetar atributos como vida, ataque, defesa e chakra, e é uma das únicas formas de ultrapassar os limites máximos desses atributos.
 */
public class Especial extends Item {
    private double efeito; // Quantidade fixa de buff aplicada aos atributos marcados como verdadeiros
    private double spawn;  // Probabilidade de aparecer na loja (%)
    private double preco;  // Preço de mercado do item

    // Flags que determinam quais atributos recebem o efeito
    private boolean vida;
    private boolean ataque;
    private boolean defesa;
    private boolean chakra;

    /**
     * Construtor do item especial.
     *
     * @param nome     Nome do item.
     * @param tipo     Tipo do item (espera-se TipoItem.ESPECIAL).
     * @param efeito   Quantidade de efeito/buff aplicado.
     * @param spawn    Probabilidade de spawn na loja (%).
     * @param preco    Preço do item no mercado.
     * @param vida     Define se o efeito aplica-se à vida.
     * @param ataque   Define se o efeito aplica-se ao ataque.
     * @param defesa   Define se o efeito aplica-se à defesa.
     * @param chakra   Define se o efeito aplica-se ao chakra.
     */
    public Especial(String nome, TipoItem tipo, double efeito, double spawn, double preco, boolean vida, boolean ataque, boolean defesa, boolean chakra) {
        super(nome, tipo);
        this.efeito = efeito;
        this.spawn = spawn;
        this.preco = preco;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.chakra = chakra;
    }

    /** @return True se o efeito aplica-se ao chakra. */
    public boolean isChakra() {
        return chakra;
    }

    public void setChakra(boolean chakra) {
        this.chakra = chakra;
    }

    /** @return True se o efeito aplica-se à vida. */
    public boolean isVida() {
        return vida;
    }

    public void setVida(boolean vida) {
        this.vida = vida;
    }

    /** @return True se o efeito aplica-se ao ataque. */
    public boolean isAtaque() {
        return ataque;
    }

    public void setAtaque(boolean ataque) {
        this.ataque = ataque;
    }

    /** @return True se o efeito aplica-se à defesa. */
    public boolean isDefesa() {
        return defesa;
    }

    public void setDefesa(boolean defesa) {
        this.defesa = defesa;
    }

    /** @return Preço do item especial no mercado. */
    public double getPreco() {
        return preco;
    }

    /** @return Valor do efeito aplicado pelo item. */
    public double getEfeito() {
        return efeito;
    }

    /** @return Probabilidade de aparecer na loja (%). */
    public double getSpawn() {
        return spawn;
    }
}
