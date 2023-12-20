package dao;

import bd.BancoDeDados;
import model.Animal;

public class AnimalDAO {

    private Animal animal[];

    /**
     * Construtor de AnimalDAO
     */
    public AnimalDAO() {
        // TODO Auto-generated constructor stub
        animal = BancoDeDados.getInstance().getAnimais();

    }
    

    /**
     * Insere os dados de animal no BD
     *
     * @param animal objeto animal passado pela camada Service
     * @return Retorno booleano para checagem de erros na inserção
     */
    public boolean inserir(Animal animal) {
        int i;
        for (i = 0; i < this.animal.length; i++) {
            if (this.animal[i] == null) {
                this.animal[i] = animal;
                return true;
            }
        }
        return false;
    }

    /**
     * Altera os dados de animal no BD
     *
     * @param cod Código do animal que será alterado
     * @param animal objeto animal passado pela camada Service
     * @return Retorno booleano para checagem de erros na alteração
     */
    public boolean alterar(int cod, Animal animal) {

        for (int i = 0; i < this.animal.length; i++) {
            if (this.animal[i] != null) {
                if (this.animal[i].getCodigo()== cod) {
                    this.animal[i] = animal;
                    return true;
                }
            }
        }

        return false;

    }

    /**
     * Remove os dados de animal no BD setando o objeto como null
     *
     * @param cod Código do animal que será removido
     * @return Retorno booleano para checagem de erros na remoção
     */
    public boolean remover(int cod) {
        for (int i = 0; i < this.animal.length; i++) {
            if (this.animal[i] != null) {
                if (this.animal[i].getCodigo() == cod) {
                    this.animal[i] = null;
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
        for (int i = 0; i < this.animal.length; i++) {
            this.animal[i] = null;
        }
    }

    /**
     * Obtém objeto animal do BD
     *
     * @param cod Código do animal que será retornado
     * @return Retorna animal caso existente no BD
     */
    public Animal getAnimal(int cod) {
        for (int i = 0; i < this.animal.length; i++) {
            if (this.animal[i] != null) {
                if (this.animal[i].getCodigo() == cod) {
                    return this.animal[i];
                }
            }
        }
        return null;
    }

    /**
     * Obtém vetor de animal
     * @return Retorna o vetor de animais
     */
    public Animal[] getAll() {

        return this.animal;
    }
}
