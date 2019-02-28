package com.gnn.sponsor.service;


import com.gnn.common.exception.AdException;
import com.gnn.sponsor.vo.CreateUserRequest;
import com.gnn.sponsor.vo.CreateUserResponse;

public interface IUserService {

    /**
     * 创建用户
     * */
    CreateUserResponse createUser(CreateUserRequest request) throws AdException;
}
