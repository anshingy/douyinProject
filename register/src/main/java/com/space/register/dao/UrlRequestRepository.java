package com.space.register.dao;

import com.space.register.entity.UrlRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UrlRequestRepository extends JpaRepository<UrlRequestEntity, Integer>, JpaSpecificationExecutor<UrlRequestEntity> {


    /**
     * 根据id返回url
     * @param id
     * @return
     */
    @Query(value = "select * from t_url_request where id = ?1", nativeQuery = true)
    UrlRequestEntity findUrlById(int id);
}
