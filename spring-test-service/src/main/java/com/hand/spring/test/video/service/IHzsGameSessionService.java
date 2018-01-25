package com.hand.spring.test.video.service;

import com.hand.spring.test.exception.dto.TestException;
import com.hand.spring.test.video.dto.HzsUser;
import net.sf.json.JSONObject;

import java.util.List;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2017/12/13.
 * @description
 */
public interface IHzsGameSessionService {
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
    List<HzsUser> select(int page, int pageSize);

}
