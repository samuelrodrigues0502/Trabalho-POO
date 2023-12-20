/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import util.DocumentException;

/**
 *
 * @author Samuel
 */
public class Gato extends Animal{
    
    public String numeroDocumento;
    public final float taxa = 0.15f;

    public Gato() {
        
    }

    public Gato(String numeroDocumento, int codigo, String nome, String endereco, String cidade) {
       
        this.numeroDocumento = numeroDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento, String tipo) throws DocumentException{
        
        if(tipo.equals("CPF")){
            if(!(util.Util.cpfValido(numeroDocumento))){
                throw new DocumentException("CPF INVÁLIDO");
            }else{
            this.numeroDocumento = numeroDocumento;
            }
        }
        if(tipo.equals("CNPJ")){
            if(!(util.Util.cnpjValido(numeroDocumento))){
                throw new DocumentException("CNPJ INVÁLIDO");
            }else{
            this.numeroDocumento = numeroDocumento;
            }
        }
        
       
    }
    
    
    @Override
    public float getTaxa() {
        return taxa;
    }
    

    @Override
    public String toString() {
        return super.toString()+ "\nTipo: Gato" + "\nNumero do Documento: " + getNumeroDocumento() 
                + "\nTaxa: " + getTaxa();
    }

    
}
