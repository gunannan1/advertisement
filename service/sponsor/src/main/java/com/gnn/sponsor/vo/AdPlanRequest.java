package com.gnn.sponsor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang.StringUtils;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdPlanRequest {

    private Long id;
    private Long userId;
    private String planName;
    private String startDate;
    private String endDate;

    //创建时，四个属性都不能为空
    public boolean createValidate() {

        return userId != null
                && !StringUtils.isEmpty(planName)
                && !StringUtils.isEmpty(startDate)
                && !StringUtils.isEmpty(endDate);
    }

    //更新时，id和用户id不能为空
    public boolean updateValidate() {

        return id != null && userId != null;
    }

    //更新时，id和用户id不能为空
    public boolean deleteValidate() {

        return id != null && userId != null;
    }
}
