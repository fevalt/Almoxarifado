package Senai.Almoxarifado.Dtos;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class ColaboradorDto {

    private long id;

    @NotBlank(message = "O nome ´we obrigatorio")
    private String nome;

    @Email(message = "O e-mail [e obrigatorio.")
    @NotBlank(message = "Digite um e-mail válido")
    private String email;

    @NotBlank(message = "Senha e obrigatorio")
    @Size(min = 5, message = "A senha deve ter no minimo 5 caracteres")
    private String senha;

    @NotBlank(message = "A matrícula é obrigatória.")
    private String matricula;

    @NotNull(message = "A data de nascimento é obrigatória.")
    @Past(message = "A data de nascimento deve ser anterior a data atual")
    @PastOrPresent(message = "A data de nascimento não pode esta no futuro")
    private LocalDate dataNascimento;

    public ColaboradorDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
