package com.FindMySquad.FindMySquad.Service;


import com.FindMySquad.FindMySquad.Model.Users.ModelDTO;
import com.FindMySquad.FindMySquad.Model.Users.ModelUser;
import com.FindMySquad.FindMySquad.Repository.UserRepotiroy;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
