package Senai.Almoxarifado.Services;

import Senai.Almoxarifado.Dtos.ColaboradorDto;
import Senai.Almoxarifado.Entitis.ColaboradorEntity;
import Senai.Almoxarifado.Repositories.ColaboradorRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    public ColaboradorService(ColaboradorRepository colaboradorRepository) {
        this.colaboradorRepository = colaboradorRepository;
    }
    public ColaboradorDto realizarLogin(ColaboradorDto colaboradorDto){

        System.out.println(colaboradorDto.getEmail());
        System.out.println(colaboradorDto.getSenha());

        Optional<ColaboradorEntity> colaboradorOP = colaboradorRepository.findByEmailAndSenha(colaboradorDto.getEmail(),colaboradorDto.getSenha());
        if (colaboradorOP.isPresent()) {
            return converterEntityParaDto(colaboradorOP.get());
        }
        else {
            throw new RuntimeException("Credenciais inválidas.");
        }
    }

    private ColaboradorDto converterEntityParaDto(ColaboradorEntity colaborador){
        ColaboradorDto colaboradorDto = new ColaboradorDto();
        colaboradorDto.setId(colaborador.getId());
        colaboradorDto.setNome(colaborador.getNome());
        colaboradorDto.setEmail(colaborador.getEmail());
        colaboradorDto.setSenha(colaborador.getSenha());
        colaboradorDto.setMatricula(colaborador.getMatricula());
        colaboradorDto.setDataNascimento(colaborador.getDataNascimento());

        return colaboradorDto;
    }
}
