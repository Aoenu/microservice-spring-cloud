package com.hand.video.service;

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
    JSONObject selectSession(Long levelNum);

}
