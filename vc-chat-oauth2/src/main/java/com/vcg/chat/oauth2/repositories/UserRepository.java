package com.vcg.chat.oauth2.repositories;

import com.vcg.chat.oauth2.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * created by wuyu on 2018/3/6
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findNicknameAndAvatarAndIdById(Long id);

}
