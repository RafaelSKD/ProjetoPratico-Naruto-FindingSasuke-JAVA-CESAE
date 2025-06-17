package Itens.Armas;

import Itens.Enum.HabilidadeArma;
import Itens.Enum.TipoItem;
import Itens.Item;

/**
 * Representa uma arma no sistema de itens.
 * As armas possuem habilidades especiais (por implementar) e adicionam ataque ao utilizador.
 */
public class Arma extends Item {
    private HabilidadeArma habilidade; // Define o efeito especial da arma (ex: enfraquecer ataque, defesa ou algo especial)
    private double forcaDoEfeito; // Intensidade do efeito da habilidade
    private double ataqueArma; // Valor de ataque adicional fornecido pela arma
    private int spawn; // Probabilidade ou prioridade de aparecer no jogo
    private double preco; // Preço da arma no mercado

    /**
     * Construtor para criar uma nova arma com todos os seus atributos.
     *
     * @param nome            Nome da arma.
     * @param tipo            Tipo do item (espera-se que seja ARMA).
     * @param habilidade      Tipo de habilidade da arma (efeito especial). - Por aplicar!
     * @param forcaDoEfeito   Intensidade do efeito da habilidade. - Por aplicar
     * @param ataqueArma      Valor de ataque adicional que a arma concede.
     * @param spawn           Valor indicando a probabilidade de aparecer na loja.
     * @param preco           Preço da arma na loja.
     */
    public Arma(String nome, TipoItem tipo, HabilidadeArma habilidade, double forcaDoEfeito, double ataqueArma, int spawn, double preco) {
        super(nome, tipo);
        this.habilidade = habilidade;
        this.forcaDoEfeito = forcaDoEfeito;
        this.ataqueArma = ataqueArma;
        this.spawn = spawn;
        this.preco = preco;
    }

    /**
     * Retorna a probabilidade de aparecimento da arma no jogo.
     *
     * @return Valor de spawn.
     */
    public int getSpawn() {
        return spawn;
    }

    /**
     * Retorna o preço da arma no mercado.
     *
     * @return Preço da arma.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Retorna o valor de ataque adicional fornecido pela arma.
     *
     * @return Valor de ataque.
     */
    public double getAtaqueArma() {
        return ataqueArma;
    }

    /**
     * Retorna a força do efeito especial da arma.
     *
     * @return Intensidade do efeito da habilidade.
     */
    public double getForcaDoEfeito() {
        return forcaDoEfeito;
    }
}
