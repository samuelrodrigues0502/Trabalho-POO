package model;

public class Servico {

    private int codigo;
    private String nome;
    private float valor;

    /**
     * Construtor da classe servico
     */
    public Servico() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Construtor da classe servico com parâmetros
     *
     * @param codigo Código do servico
     * @param nome Nome do servico
     * @param valor Valor do servico
     */
    public Servico(int codigo, String nome, float valor) {

        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }

    /**
     * Obtém código do servico
     *
     * @return Retorna código do servico
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Seta código do servico
     *
     * @param codigo Código a ser inserido
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtém nome do servico
     *
     * @return Retorna nome do servico
     */
    public String getNome() {
        return nome;
    }

    /**
     * Seta nome do servico
     *
     * @param nome Nome a ser inserido
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém valor do servico
     *
     * @return Retorna valor do servico
     */
    public float getValor() {
        return valor;
    }

    /**
     * Seta valor do servico
     *
     * @param valor Valor a ser inserido
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {

        return "Codigo do Serviço: " + this.codigo + "\nNome: " + this.nome
                + "\nValor: " + this.valor;
    }
}
