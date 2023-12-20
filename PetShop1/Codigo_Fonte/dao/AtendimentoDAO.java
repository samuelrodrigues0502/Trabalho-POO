package dao;

import bd.BancoDeDados;
import model.Atendimento;

public class AtendimentoDAO {

    private Atendimento atendimento[];

    /**
     * Construtor de AtendimentoDAO
     */
    public AtendimentoDAO() {
        // TODO Auto-generated constructor stub
        atendimento = BancoDeDados.getInstance().getAtendimentos();
    }

    /**
     * Insere os dados de atendimento no BD
     *
     * @param atendimento objeto atendimento passado pela camada Service
     * @return Retorno booleano para checagem de erros na inserção
     */
    public boolean inserir(Atendimento atendimento) {
        int i;
        for (i = 0; i < this.atendimento.length; i++) {
            if (this.atendimento[i] == null) {
                this.atendimento[i] = atendimento;
                return true;
            }
        }
        return false;
    }

    /**
     * Altera os dados de atendimento no BD
     *
     * @param cod Código do atendimento que será alterado
     * @param Atendimento objeto atendimento passado pela camada Service
     * @return Retorno booleano para checagem de erros na alteração
     */
    public boolean alterar(int cod, Atendimento Atendimento) {

        for (int i = 0; i < this.atendimento.length; i++) {
            if (this.atendimento[i] != null) {
                if (this.atendimento[i].getCodigo() == cod) {
                    this.atendimento[i] = Atendimento;
                    return true;
                }
            }
        }

        return false;

    }

    /**
     * Remove os dados de atendimento no BD setando o objeto como null
     *
     * @param cod Código do atendimento que será removido
     * @return Retorno booleano para checagem de erros na remoção
     */
    public boolean remover(int cod) {
        for (int i = 0; i < this.atendimento.length; i++) {
            if (this.atendimento[i] != null) {
                if (this.atendimento[i].getCodigo() == cod) {
                    this.atendimento[i] = null;
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Remove todos os dados do BD setando para nulo
     */
    public void limpaDados() {
        for (int i = 0; i < this.atendimento.length; i++) {
            this.atendimento[i] = null;
        }
    }

    /**
     * Obtém objeto atendimento do BD
     *
     * @param cod Código do atendimento que será retornado
     * @return Retorna atendimento caso existente no BD
     */
    public Atendimento getAtendimento(int cod) {
        for (int i = 0; i < this.atendimento.length; i++) {
            if (this.atendimento[i] != null) {
                if (this.atendimento[i].getCodigo() == cod) {
                    return this.atendimento[i];
                }
            }
        }
        return null;
    }

    /**
     * Obtém vetor de atendimento
     * @return Retorna o vetor de atendimentos
     */
    public Atendimento[] getAll() {

        return this.atendimento;
    }
}
