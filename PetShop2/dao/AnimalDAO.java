package dao;

import bd.BancoDeDados;
import java.util.HashSet;
import java.util.Set;
import model.Animal;
import service.AnimalService;

public class AnimalDAO {

    Set<Animal> set = new HashSet<Animal>();

    /**
     * Construtor de AnimalDAO
     */
    public AnimalDAO() {
        // TODO Auto-generated constructor stub
        
        set = BancoDeDados.getInstance().getAnimais();
    }
    
    /**
     * Insere os dados de animal no BD
     *
     * @param animal objeto animal passado pela camada Service
     * @return Retorno booleano para checagem de erros na inserção
     */
    public boolean inserir(Animal animal) {
        if(set.add(animal)){
            return true;
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
        
        AnimalService aniserv = new AnimalService();
        
        for (Animal anim : set) {
            if(anim.getCodigo() == cod){
                set.remove(anim);
                break;
            }
        }
        
        return aniserv.inserir(animal);

    }

    /**
     * Remove os dados de animal no BD setando o objeto como null
     *
     * @param cod Código do animal que será removido
     * @return Retorno booleano para checagem de erros na remoção
     */
    public boolean remover(int cod) {
        
        for (Animal animal : set) {
            if(animal.getCodigo() == cod){
                set.remove(animal);
                return true;
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
     * Obtém objeto animal do BD
     *
     * @param cod Código do animal que será retornado
     * @return Retorna animal caso existente no BD
     */
    public Animal getAnimal(int cod) {
        for (Animal animal : set) {
            if(animal.getCodigo() == cod){
                return animal;
            }
        }
        return null;
    }

    /**
     * Obtém vetor de animal
     * @return Retorna o vetor de animais
     */
    public Set<Animal> getAll() {
       
        return set;
    }
}
