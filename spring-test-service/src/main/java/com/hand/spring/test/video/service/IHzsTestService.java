package com.hand.spring.test.video.service;

import com.hand.spring.test.exception.dto.TestException;
import com.hand.spring.test.redis.dto.RedisUser;
import com.hand.spring.test.video.dto.HzsStudent;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2017/12/13.
 * @description
 */
public interface IHzsTestService {
    /**
     * 保存会话记录（存Mongo）
     * @param jsonSession
     * @return
     */
    void submitSession(JSONObject jsonSession);

    /**
     * 查询会话记录
     * @return
     * @param levelNum
     */
    JSONObject selectSession(Long levelNum) throws TestException;

    /**
     *
     * @return
     */
    List<HzsStudent> select(int page, int pageSize);

    /**
     *
     * @return
     * @param name
     */
    RedisUser selectRedis(String name);

    /**
     *
     * @param name
     * @return
     */
    RedisUser selectFromRedis(String name);

    /**
     *
     * @param name
     */
    void setUserToRedis(String name);
}
