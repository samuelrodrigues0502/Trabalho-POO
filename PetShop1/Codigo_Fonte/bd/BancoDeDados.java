/**
 *
 */
package bd;

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

    private static Animal animal[];
    private static Servico servico[];
    private static Atendimento atendimento[];
    private static BancoDeDados bd;

    private BancoDeDados() {
        animal = new Animal[100];
        servico = new Servico[100];
        atendimento = new Atendimento[20];
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
    public static Animal[] getAnimais() {
        return animal;
    }

    /**
     * Retorna um vetor dos serviços do BD
     */
    public static Servico[] getServicos() {
        return servico;
    }

    /**
     * Retorna um vetor dos atendimentos do BD
     */
    public static Atendimento[] getAtendimentos() {
        return atendimento;
    }
    
}
