package com.FindMySquad.FindMySquad.Controller;


import com.FindMySquad.FindMySquad.Model.Users.ModelDTO;
import com.FindMySquad.FindMySquad.Model.Users.ModelReponse;
import com.FindMySquad.FindMySquad.Model.Users.ModelRequest;
import com.FindMySquad.FindMySquad.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/data/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<ModelReponse> postUser(@RequestBody ModelRequest modelRequest) {
        ModelMapper mapper = new ModelMapper();
        ModelDTO modelDTO = mapper.map(modelRequest, ModelDTO.class);
        modelDTO = userService.addNewUser(modelDTO);
        ModelReponse modelReponse = mapper.map(modelDTO, ModelReponse.class);
        return new ResponseEntity<>(modelReponse, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<ModelReponse>> getAllUsers() {
        ModelMapper mapper = new ModelMapper();

        List<ModelDTO> modelDTOList = userService.getAllUsers();

        List<ModelReponse> modelReponses = modelDTOList.stream().map(
                responses -> mapper.map(responses, ModelReponse.class)
        ).collect(Collectors.toList());

        return new ResponseEntity<>(modelReponses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ModelReponse>> getUserById(@PathVariable Integer id) {
        ModelMapper mapper = new ModelMapper();
        Optional<ModelDTO> modelDTO = userService.getUserById(id);
        ModelReponse modelReponse = mapper.map(modelDTO, ModelReponse.class);
        return new ResponseEntity<>(Optional.of(modelReponse), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelReponse> updateUser(@PathVariable Integer id, @RequestBody ModelRequest modelRequest) {
        ModelMapper mapper = new ModelMapper();
        ModelDTO modelDTO = mapper.map(modelRequest, ModelDTO.class);
        modelDTO = userService.updateUser(id, modelDTO);
        return new ResponseEntity<>(mapper.map(modelDTO, ModelReponse.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<ModelReponse>> deleteUserById(@PathVariable Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
