package com.julio.projects.datahub.repositories.login;

import com.julio.projects.datahub.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoginRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUserName(String userName);
}
