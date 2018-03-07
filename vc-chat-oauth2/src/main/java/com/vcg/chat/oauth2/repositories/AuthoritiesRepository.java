package com.vcg.chat.oauth2.repositories;

import com.vcg.chat.oauth2.model.Authorities;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * created by wuyu on 2018/3/6
 */
@Repository
public interface AuthoritiesRepository extends CrudRepository<Authorities, String> {

    Authorities findById(Long id);
}
