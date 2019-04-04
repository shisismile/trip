package com.dongguan.trip.modules.buz.repository;

import com.dongguan.trip.modules.buz.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface CommentRepository  extends JpaRepository<CommentEntity, Long>,JpaSpecificationExecutor<CommentEntity> {
    @Modifying
    @Query(value = "insert into trip_comment(id,user_id,`comment`,create_time,`status`,detail_id) value(?1,?2,?3,?4,?5,?6)",nativeQuery = true)
    void save0(Long id, Long userId, String comment, Date createTime, Integer status, Long detailId);

}
