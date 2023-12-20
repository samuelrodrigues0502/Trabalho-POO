package model;

import java.util.Date;

public class Atendimento {

    private int codigo;
    private Date date;
    private Animal animal;
    private Servico servico;

    /**
     * Construtor da classe atendimento
     */
    public Atendimento() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Construtor da classe atendimento com parâmetros
     *
     * @param codigo Código do atendimento
     * @param animal Objeto animal do atendimento
     * @param servico Objeto servico do atendimento
     * @param date Data do atendimento
     */
    public Atendimento(int codigo, Animal animal, Servico servico, Date date) {

        this.animal = animal;
        this.codigo = codigo;
        this.date = date;
        this.servico = servico;
    }

    /**
     * Obtém código do atendimento
     *
     * @return Retorna código do atendimento
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Seta código do atendimento
     *
     * @param codigo Código a ser inserido
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtém data do atendimento
     *
     * @return Retorna data do atendimento
     */
    public Date getDate() {
        return date;
    }

    /**
     * Seta data do atendimento
     *
     * @param date Data a ser inserida
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Obtém obejto animal do atendimento
     *
     * @return Retorna objeto animal do atendimento
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * Seta objeto animal do atendimento
     *
     * @param animal Objeto animal a ser inserido
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    /**
     * Obtém objeto serviço do atendimento
     *
     * @return Retorna objeto serviço do atendimento
     */
    public Servico getServico() {
        return servico;
    }

    /**
     * Seta objeto servico do atendimento
     *
     * @param servico Objeto servico a ser inserido
     */
    public void setServico(Servico servico) {
        this.servico = servico;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Código do Atendimento: " + this.codigo + "\nData: " + this.date + "\n\n" + this.animal + "\n\n" + this.servico;
    }

}
