package com.gnn.sponsor.service.impl;


import com.gnn.sponsor.dao.CreativeRepository;
import com.gnn.sponsor.entity.Creative;
import com.gnn.sponsor.service.ICreativeService;
import com.gnn.sponsor.vo.CreativeRequest;
import com.gnn.sponsor.vo.CreativeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreativeServiceImpl implements ICreativeService {

    private final CreativeRepository creativeRepository;

    @Autowired
    public CreativeServiceImpl(CreativeRepository creativeRepository) {
        this.creativeRepository = creativeRepository;
    }

    @Override
    public CreativeResponse createCreative(CreativeRequest request) {

        Creative creative = creativeRepository.save(
                request.convertToEntity()
        );

        return new CreativeResponse(creative.getId(), creative.getName());
    }
}
