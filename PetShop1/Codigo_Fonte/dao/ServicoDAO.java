package dao;

import bd.BancoDeDados;
import model.Servico;

public class ServicoDAO {

    private Servico servico[];

    /**
     * Construtor de ServicoDAO
     */
    public ServicoDAO() {
        // TODO Auto-generated constructor stub
        servico = BancoDeDados.getInstance().getServicos();

    }

    /**
     * Insere os dados de servico no BD
     *
     * @param servico objeto servico passado pela camada Service
     * @return Retorno booleano para checagem de erros na inserção
     */
    public boolean inserir(Servico servico) {
        int i;
        for (i = 0; i < this.servico.length; i++) {
            if (this.servico[i] == null) {
                this.servico[i] = servico;
                return true;
            }
        }
        return false;
    }

    /**
     * Altera os dados de servico no BD
     *
     * @param cod Código do servico que será alterado
     * @param servico objeto servico passado pela camada Service
     * @return Retorno booleano para checagem de erros na alteração
     */
    public boolean alterar(int cod, Servico servico) {

        for (int i = 0; i < this.servico.length; i++) {
            if (this.servico[i] != null) {
                if (this.servico[i].getCodigo() == cod) {
                    this.servico[i] = servico;
                    return true;
                }
            }
        }

        return false;

    }

    /**
     * Remove os dados de servico no BD setando o objeto como null
     *
     * @param cod Código do servico que será removido
     * @return Retorno booleano para checagem de erros na remoção
     */
    public boolean remover(int cod) {
        for (int i = 0; i < this.servico.length; i++) {
            if (this.servico[i] != null) {
                if (this.servico[i].getCodigo() == cod) {
                    this.servico[i] = null;
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
        for (int i = 0; i < this.servico.length; i++) {
            this.servico[i] = null;
        }
    }

    /**
     * Obtém objeto servico do BD
     *
     * @param cod Código do servico que será retornado
     * @return Retorna servico caso existente no BD
     */
    public Servico getServico(int cod) {
        for (int i = 0; i < this.servico.length; i++) {
            if (this.servico[i] != null) {
                if (this.servico[i].getCodigo() == cod) {
                    return this.servico[i];
                }
            }
        }
        return null;
    }

    /**
     * Obtém vetor de servico
     *
     * @return Retorna o vetor de servicos
     */
    public Servico[] getAll() {

        return this.servico;
    }
}
