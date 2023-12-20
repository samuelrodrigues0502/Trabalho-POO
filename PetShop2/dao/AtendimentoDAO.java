package dao;

import bd.BancoDeDados;
import java.util.HashSet;
import java.util.Set;
import model.Atendimento;

public class AtendimentoDAO {

    Set<Atendimento> set = new HashSet<Atendimento>();

    /**
     * Construtor de AtendimentoDAO
     */
    public AtendimentoDAO() {
        // TODO Auto-generated constructor stub
        set = BancoDeDados.getInstance().getAtendimentos();
    }

    /**
     * Insere os dados de atendimento no BD
     *
     * @param atendimento objeto atendimento passado pela camada Service
     * @return Retorno booleano para checagem de erros na inserção
     */
    public boolean inserir(Atendimento atendimento) {
        if(set.add(atendimento)){
            return true;
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
    public boolean alterar(int cod, Atendimento atendimento) {

        for (Atendimento atend : set) {
            if(atend.getCodigo() == cod){
                set.remove(atend);
            }
        }
        set.add(atendimento);
        
        return true;

    }

    /**
     * Remove os dados de atendimento no BD setando o objeto como null
     *
     * @param cod Código do atendimento que será removido
     * @return Retorno booleano para checagem de erros na remoção
     */
    public boolean remover(int cod) {
        for (Atendimento atend : set) {
            if(atend.getCodigo() == cod){
                set.remove(atend);
            }
        }

        return false;
    }

    /**
     * Remove todos os dados do BD setando para nulo
     */
    public void limpaDados() {
        set.clear();
    }

    /**
     * Obtém objeto atendimento do BD
     *
     * @param cod Código do atendimento que será retornado
     * @return Retorna atendimento caso existente no BD
     */
    public Atendimento getAtendimento(int cod) {
        for (Atendimento atend : set) {
            if(atend.getCodigo() == cod){
                return atend;
            }
        }
        return null;
    }

    /**
     * Obtém vetor de atendimento
     * @return Retorna o vetor de atendimentos
     */
    public Set<Atendimento> getAll() {
        
        return set;
    }
}
