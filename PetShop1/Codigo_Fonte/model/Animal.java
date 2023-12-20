package model;

public class Animal {

    private int codigo;
    private String nome;
    private String endereco;
    private String cidade;

    /**
     * Construtor da classe animal
     */
    public Animal() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Construtor da classe animal com parâmetros
     *
     * @param codigo Código do animal
     * @param nome Nome do animal
     * @param endereco Endereço do animal
     * @param cidade Cidade do animal
     */
    public Animal(int codigo, String nome, String endereco, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
    }

    /**
     * Obtém código do animal
     *
     * @return Retorna código do animal
     */
    public int getCodigo() {
        return this.codigo;
    }

    /**
     * Seta código do animal
     *
     * @param codigo Código a ser inserido
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtém nome do animal
     *
     * @return Retorna nome do animal
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Seta nome do animal
     *
     * @param nome Nome a ser inserido
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém endereço do animal
     *
     * @return Retorna endereço do animal
     */
    public String getEndereco() {
        return this.endereco;
    }

    /**
     * Seta endereço do animal
     *
     * @param endereco Endereço a ser inserido
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Obtém cidade do animal
     *
     * @return Retorna cidade do animal
     */
    public String getCidade() {
        return this.cidade;
    }

    
    
    /**
     * Seta cidade do animal
     *
     * @param cidade Cidade a ser inserida
     * 
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
 
    @Override
    public String toString() {

        return "Código do Animal: " + this.codigo + "\nNome: " + this.nome
                + "\nEndereço: " + this.endereco + "\nCidade: " + this.cidade;
    }
}
