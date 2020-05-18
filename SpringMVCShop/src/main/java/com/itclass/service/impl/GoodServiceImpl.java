package com.itclass.service.impl;

import com.itclass.domain.Good;
import com.itclass.repository.GoodRepository;
import com.itclass.service.GoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GoodServiceImpl implements GoodService {

    private final GoodRepository goodRepository;

    @Override
    public List<Good> findAll() {
        return goodRepository.findAll();
    }

    @Override
    public Optional<Good> findById(Long id) {
        return goodRepository.findById(id);
    }
}
