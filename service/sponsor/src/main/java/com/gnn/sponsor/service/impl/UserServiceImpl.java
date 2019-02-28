package com.gnn.sponsor.service.impl;


import com.gnn.common.exception.AdException;
import com.gnn.sponsor.constant.Constants;
import com.gnn.sponsor.dao.AdUserRepository;
import com.gnn.sponsor.entity.AdUser;
import com.gnn.sponsor.service.IUserService;
import com.gnn.sponsor.utils.CommonUtils;
import com.gnn.sponsor.vo.CreateUserRequest;
import com.gnn.sponsor.vo.CreateUserResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    private final AdUserRepository userRepository;

    @Autowired
    public UserServiceImpl(AdUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserRequest request)
            throws AdException {

        //用户名为空的话抛出异常
        if (!request.validate()) {
            throw new AdException(Constants.ErrorMsg.REQUEST_PARAM_ERROR);
        }

        //检查用户名是否重复，重复的话抛出异常
        AdUser oldUser = userRepository.
                findByUsername(request.getUsername());
        if (oldUser != null) {
            throw new AdException(Constants.ErrorMsg.SAME_NAME_ERROR);
        }

        //创建新用户并插入数据库，token为根据用户名生成的md5
        AdUser newUser = userRepository.save(new AdUser(
                request.getUsername(),
                CommonUtils.md5(request.getUsername())
        ));

        //返回用户response
        return new CreateUserResponse(
                newUser.getId(), newUser.getUsername(), newUser.getToken(),
                newUser.getCreateTime(), newUser.getUpdateTime()
        );
    }
}
