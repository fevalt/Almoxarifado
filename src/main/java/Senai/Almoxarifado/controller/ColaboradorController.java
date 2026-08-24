package Senai.Almoxarifado.controller;

import Senai.Almoxarifado.Dtos.ColaboradorDto;
import Senai.Almoxarifado.Services.ColaboradorService;
import Senai.Almoxarifado.Sessao.SessaoDto;
import Senai.Almoxarifado.Sessao.SessaoUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ColaboradorController {

    private final ColaboradorService colaboradorService;


    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @PostMapping("/login")
    public String realizarLogin(
            String email,
            String senha,
            Model model,
            RedirectAttributes redirectAttributes,
            HttpSession session) {

        try {

            // Criação do DTO para enviar os dados para o Service
            ColaboradorDto colaboradorDto = new ColaboradorDto();

            colaboradorDto.setEmail(email);
            colaboradorDto.setSenha(senha);

            // Realiza login no banco de dados
            ColaboradorDto colaboradorDtoRetorno =
                    colaboradorService.realizarLogin(colaboradorDto);

            if (colaboradorDtoRetorno.getNome() != null) {

                SessaoDto sessaoDto = new SessaoDto();

                sessaoDto.setUsuarioid(colaboradorDtoRetorno.getId());

                // AQUI estava o problema
                sessaoDto.setUsuarioNome(colaboradorDtoRetorno.getNome());

                SessaoUtil.RegistrarSessao(session, sessaoDto);

                redirectAttributes.addFlashAttribute(
                        "usuario",
                        "Bem-vindo " + colaboradorDtoRetorno.getNome()
                );

                return "redirect:/home";
            }

        } catch (RuntimeException e) {

            model.addAttribute(
                    "erro",
                    "E-mail ou senha inválidos."
            );

            return "login";
        }

        return "redirect:/login";
    }
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        SessaoUtil.RemoverSessao(session);
        return "redirect:/login";
    }
}


