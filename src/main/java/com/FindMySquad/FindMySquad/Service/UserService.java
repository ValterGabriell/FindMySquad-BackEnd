package com.FindMySquad.FindMySquad.Service;


import com.FindMySquad.FindMySquad.Handler.ResourceNoFoundExeptions;
import com.FindMySquad.FindMySquad.Model.Users.ModelDTO;
import com.FindMySquad.FindMySquad.Model.Users.ModelUser;
import com.FindMySquad.FindMySquad.Repository.UserRepotiroy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepotiroy userRepotiroy;

    /**
     * Método para fazer a inserção de um novo
     * usuário e passar para o controller
     *
     * @param modelDTO
     * @return modelDTO
     */
    public ModelDTO addNewUser(ModelDTO modelDTO) {
        ModelMapper mapper = new ModelMapper();

        ModelUser modelUser = mapper.map(modelDTO, ModelUser.class);
        modelDTO.setId(null);
        modelUser = userRepotiroy.save(modelUser);
        modelDTO.setId(modelUser.getId());
        return modelDTO;
    }


    /**
     * Método para ler todos os usuarios
     *
     * @return listaModel
     */
    public List<ModelDTO> getAllUsers() {
        List<ModelUser> modelUserList = userRepotiroy.findAll();

        return modelUserList.stream().map(
                users -> new ModelMapper().map(users, ModelDTO.class)
        ).collect(Collectors.toList());
    }


    /**
     * Método para retornar o usuario por id
     * @param id
     * @return
     */
    public Optional<ModelDTO> getUserById(Integer id) {
        ModelMapper mapper = new ModelMapper();

        Optional<ModelUser> usuario = userRepotiroy.findById(id);

        if (usuario.isEmpty()) {
            throw new ResourceNoFoundExeptions("O usuário" + id + " não pode ser encontrado");
        }

        ModelDTO modelDTO = mapper.map(usuario.get(), ModelDTO.class);

        return Optional.of(modelDTO);

    }

    /**
     * Método para atualizar um usuário
     * @param id
     * @param modelDTO
     * @return
     */
    public ModelDTO updateUser(Integer id, ModelDTO modelDTO){
        ModelMapper mapper = new ModelMapper();

        modelDTO.setId(id);
        ModelUser modelUser = mapper.map(modelDTO, ModelUser.class);
        userRepotiroy.save(modelUser);
        return modelDTO;

    }


    /**
     * Deletar usuário
     * @param id
     */
    public void deleteUser(Integer id){
        Optional<ModelUser> modelUser = userRepotiroy.findById(id);
        if (modelUser.isPresent()){
            userRepotiroy.deleteById(id);
        }else{
            throw new ResourceNoFoundExeptions("Não foi possivel deletar o usuário: " + id);
        }
    }


}
