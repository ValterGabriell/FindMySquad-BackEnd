package com.FindMySquad.FindMySquad.Controller;


import com.FindMySquad.FindMySquad.Model.Requisition.ModelRequisitonDTO;
import com.FindMySquad.FindMySquad.Model.Requisition.ModelRequisitonRequest;
import com.FindMySquad.FindMySquad.Model.Requisition.ModelRequisitonResponse;
import com.FindMySquad.FindMySquad.Service.RequisitonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/data/requisition")
public class RequisitionController {
    @Autowired
    RequisitonService requisitonService;

    @PostMapping
    public ResponseEntity<ModelRequisitonResponse> addNewRequisition(@RequestBody ModelRequisitonRequest modelRequisitonRequest) {
        ModelMapper mapper = new ModelMapper();
        ModelRequisitonDTO modelRequisitonDTO = mapper.map(modelRequisitonRequest, ModelRequisitonDTO.class);

        modelRequisitonDTO = requisitonService.addNewRequisiton(modelRequisitonDTO);
        ModelRequisitonResponse modelRequisitonResponse = mapper.map(modelRequisitonDTO, ModelRequisitonResponse.class);

        return new ResponseEntity<>(modelRequisitonResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ModelRequisitonResponse>> getAllRequisitons() {
        ModelMapper mapper = new ModelMapper();
        List<ModelRequisitonDTO> modelRequisitonDTOList = requisitonService.getAllRequisitons();

        List<ModelRequisitonResponse> modelRequisitonResponses = modelRequisitonDTOList.stream().map(
                reponses -> mapper.map(reponses, ModelRequisitonResponse.class)
        ).collect(Collectors.toList());

        return new ResponseEntity<>(modelRequisitonResponses, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ModelRequisitonResponse>> getRequisitionById(@PathVariable Integer id) {
        ModelMapper mapper = new ModelMapper();
        Optional<ModelRequisitonDTO> modelRequisitonDTO = requisitonService.getRequisitionById(id);
        ModelRequisitonResponse modelRequisitonResponse = mapper.map(modelRequisitonDTO, ModelRequisitonResponse.class);
        return new ResponseEntity<>(Optional.of(modelRequisitonResponse), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelRequisitonResponse> updateRequisitionById(
            @RequestBody ModelRequisitonRequest modelRequisitonRequest,
            @PathVariable Integer id) {

        ModelMapper mapper = new ModelMapper();
        ModelRequisitonDTO modelRequisitonDTO = mapper.map(modelRequisitonRequest, ModelRequisitonDTO.class);
        modelRequisitonDTO = requisitonService.updateRequisition(id, modelRequisitonDTO);
        ModelRequisitonResponse modelRequisitonResponse = mapper.map(modelRequisitonDTO, ModelRequisitonResponse.class);
        return new ResponseEntity<>(modelRequisitonResponse, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<ModelRequisitonResponse>> deleteRequisiton(@PathVariable Integer id) {
        requisitonService.deleteRequisition(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
