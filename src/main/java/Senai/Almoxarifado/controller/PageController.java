package Senai.Almoxarifado.controller;

import Senai.Almoxarifado.Services.ColaboradorService;
import Senai.Almoxarifado.Sessao.SessaoDto;
import Senai.Almoxarifado.Sessao.SessaoUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private final ColaboradorService colaboradorService;

    public PageController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String getHome(Model model,HttpSession session){

        SessaoDto sessaoDto = SessaoUtil.ObterSessao(session);

        if (sessaoDto == null){
            return "redirect:/";
        }
        model.addAttribute("usuarioLogado",sessaoDto);
        return "home";
    }


}
