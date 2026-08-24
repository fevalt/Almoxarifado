package Senai.Almoxarifado.Sessao;

public class SessaoDto {

    private Long usuarioid;
    private String usuarioNome;

    public SessaoDto() {
    }

    public long getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Long usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }
}

