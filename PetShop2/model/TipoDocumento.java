
package model;

/**
 *
 * @author Samuel
 */
public enum TipoDocumento {
 
    CPF("CPF"), CNPJ("CNPJ");
    
    private String tipo;

    private TipoDocumento(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTipo(){
        return tipo;
    }
    
}
