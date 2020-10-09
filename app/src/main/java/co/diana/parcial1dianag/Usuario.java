package co.diana.parcial1dianag;

public class Usuario {
    private String tipo="usuario";
    private String usuario;

    public Usuario(String usuario) {
        super();
        this.usuario = usuario;

    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
