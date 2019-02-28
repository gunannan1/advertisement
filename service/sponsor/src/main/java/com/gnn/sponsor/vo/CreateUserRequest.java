package com.gnn.sponsor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

    private String username;

    //用户名为空时请求参数错误
    public boolean validate() {

        return !StringUtils.isEmpty(username);
    }
}
