package com.luxeserve.user_service.repository;

import com.luxeserve.user_service.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,String> {

}
