/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Samuel
 */
public class Cachorro extends Animal {
    
    public boolean perdigree;
    public final float taxa = 0.10f;

    public Cachorro() {
        super();
    }

    public Cachorro(boolean perdigree, int codigo, String nome, String endereco, String cidade) {
        super(codigo, nome, endereco, cidade);
        setPerdigree(perdigree);
    }
    
    public boolean isPerdigree(){
        
        if(perdigree){
            return true;
        }else{
            return false;
        }
    }
    
    public void setPerdigree(boolean bol){
        perdigree = bol;
    }
    
    public float getTaxa(){
        return taxa;
    }
    
    @Override
    public String toString() {
        return super.toString()+"\nTipo: Cachorro" + "\nPerdigree: " + isPerdigree() + "\nTaxa: " + getTaxa();
    }
    
}
