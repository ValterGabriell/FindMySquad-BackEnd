package com.FindMySquad.FindMySquad.Repository;

import com.FindMySquad.FindMySquad.Model.Users.ModelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepotiroy extends JpaRepository<ModelUser, Integer> {
}
