package com.gnn.sponsor.service;


import com.gnn.sponsor.vo.CreativeRequest;
import com.gnn.sponsor.vo.CreativeResponse;

public interface ICreativeService {

    CreativeResponse createCreative(CreativeRequest request);
}
