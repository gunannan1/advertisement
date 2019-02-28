package com.gnn.sponsor.service;



import com.gnn.common.exception.AdException;
import com.gnn.sponsor.entity.AdPlan;
import com.gnn.sponsor.vo.AdPlanGetRequest;
import com.gnn.sponsor.vo.AdPlanRequest;
import com.gnn.sponsor.vo.AdPlanResponse;

import java.util.List;


public interface IAdPlanService {

    /**
     * <h2>创建推广计划</h2>
     * */
    AdPlanResponse createAdPlan(AdPlanRequest request) throws AdException;

    /**
     * <h2>获取推广计划</h2>
     * */
    List<AdPlan> getAdPlanByIds(AdPlanGetRequest request) throws AdException;

    /**
     * <h2>更新推广计划</h2>
     * */
    AdPlanResponse updateAdPlan(AdPlanRequest request) throws AdException;

    /**
     * <h2>删除推广计划</h2>
     * */
    void deleteAdPlan(AdPlanRequest request) throws AdException;
}
