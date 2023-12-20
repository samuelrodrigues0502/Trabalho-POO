/**
 *
 */
package bd;

import java.util.HashSet;
import java.util.Set;
import model.Animal;
import model.Atendimento;
import model.Servico;

/**
 * @author Samuel
 *
 * Banco de dados que armazenará os dados inseridos durante a execução
 *
 */
public class BancoDeDados {

    private static Set<Animal> setAnim;
    private static Set<Atendimento> setAtend;
    private static Set<Servico> setServico;
    private static BancoDeDados bd;

    private BancoDeDados() {
        setAnim = new HashSet<Animal>();
        setAtend = new HashSet<Atendimento>();
        setServico = new HashSet<Servico>();
    }
    /**
     * Retorna o estado do BD
     */
    public static BancoDeDados getInstance() {

        if (bd == null) {
            bd = new BancoDeDados();
        }
        return bd;
    }

    /**
     * Retorna um vetor dos animais do BD
     */
    public static Set<Animal> getAnimais() {
        return setAnim;
    }

    /**
     * Retorna um vetor dos serviços do BD
     */
    public static Set<Servico> getServicos() {
        return setServico;
    }

    /**
     * Retorna um vetor dos atendimentos do BD
     */
    public static Set<Atendimento> getAtendimentos() {
        return setAtend;
    }
    
}
