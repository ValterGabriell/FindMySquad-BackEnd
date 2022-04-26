package com.FindMySquad.FindMySquad.Service;


import com.FindMySquad.FindMySquad.Handler.ResourceNoFoundExeptions;
import com.FindMySquad.FindMySquad.Model.Requisition.ModelRequisition;
import com.FindMySquad.FindMySquad.Model.Requisition.ModelRequisitonDTO;
import com.FindMySquad.FindMySquad.Repository.RequisitionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RequisitonService {
    @Autowired
    RequisitionRepository requisitionRepository;


    /**
     * Método para adicionar uma nova requisicao
     *
     * @param modelRequisitonDTO
     * @return
     */
    public ModelRequisitonDTO addNewRequisiton(ModelRequisitonDTO modelRequisitonDTO) {
        ModelMapper mapper = new ModelMapper();
        modelRequisitonDTO.setId(null);
        ModelRequisition modelRequisition = mapper.map(modelRequisitonDTO, ModelRequisition.class);
        requisitionRepository.save(modelRequisition);
        return modelRequisitonDTO;
    }

    /**
     * Método para retornar uma lista de requisicoes
     *
     * @return
     */
    public List<ModelRequisitonDTO> getAllRequisitons() {
        List<ModelRequisition> modelRequisitions = requisitionRepository.findAll();

        return modelRequisitions.stream().map(
                requisicoes -> new ModelMapper().map(requisicoes, ModelRequisitonDTO.class)
        ).collect(Collectors.toList());
    }

    /**
     * recuperando somente um usuario
     * @param id
     * @return
     */
    public Optional<ModelRequisitonDTO> getRequisitionById(Integer id) {
        Optional<ModelRequisition> requisition = requisitionRepository.findById(id);

        if (requisition.isPresent()) {
            ModelRequisitonDTO modelRequisitonDTO = new ModelMapper().map(requisition, ModelRequisitonDTO.class);
            return Optional.of(modelRequisitonDTO);
        } else {
            throw new ResourceNoFoundExeptions("Não foi possivel encontrar a requisicao");
        }
    }

    /**
     * método para upar a requisição
     * @param id
     * @param modelRequisitonDTO
     * @return
     */
    public ModelRequisitonDTO updateRequisition(Integer id, ModelRequisitonDTO modelRequisitonDTO){
        modelRequisitonDTO.setId(id);
        ModelRequisition requisition = new ModelMapper().map(modelRequisitonDTO, ModelRequisition.class);
        requisitionRepository.save(requisition);
        return modelRequisitonDTO;
    }

    /**
     * Deletar usuario do bd
     * @param id
     */
    public void deleteRequisition(Integer id){
        Optional<ModelRequisition> requisition = requisitionRepository.findById(id);
        if (requisition.isPresent()){
            requisitionRepository.deleteById(id);
        }else{
            throw new ResourceNoFoundExeptions("Nao foi possivel deletar");
        }
    }


}
