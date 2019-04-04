package com.dongguan.trip.modules.buz.service.impl;

import com.dongguan.trip.modules.buz.entity.CommentEntity;
import com.dongguan.trip.modules.buz.repository.CommentRepository;
import com.dongguan.trip.modules.buz.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentRepository commentRepository;

    @Override
    public void save(CommentEntity commentEntity) {
        commentRepository.save(commentEntity);
    }
}
