package com.hand.spring.test.video.service.impl;


import com.github.pagehelper.PageHelper;
import com.hand.spring.test.exception.dto.TestException;
import com.hand.spring.test.video.dto.HzsUser;
import com.hand.spring.test.video.mapper.HzsUserMapper;
import com.hand.spring.test.video.service.IHzsGameSessionService;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2017/12/13.
 * @description
 */
@Service
public class HzsGameSessionServiceImpl implements IHzsGameSessionService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private HzsUserMapper mapper;


    private final static String FIRSTGAMENAME = "interactive activity";

    /**
     * 查询会话记录
     *
     * @param levelNum
     * @return
     */
    @Override
    public JSONObject selectSession(Long levelNum) throws TestException {
        throw new TestException("error!");
    }

    @Override
    public List<HzsUser> select(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return mapper.select();
    }

    /**
     * 保存会话记录（存Mongo）
     *
     * @param sessionJson
     * @return
     */
    @Override
    public void submitSession(JSONObject sessionJson) {
        Long levelStatusId;
        Long levelNum;
        Long userId;
        try {
            levelStatusId = sessionJson.getLong("levelStatus");
            levelNum = sessionJson.getLong("levelNum");
            userId = sessionJson.getLong("userId");
        } catch (Exception e) {
            e.printStackTrace();
        }


        JsonConfig jsonConfig = new JsonConfig();
        PropertyFilter filter = new PropertyFilter() {
            @Override
            public boolean apply(Object object, String fieldName, Object fieldValue) {
                return fieldValue.equals("null");
            }
        };
        jsonConfig.setExcludes(new String[]{"_id"});
        jsonConfig.setJsonPropertyFilter(filter);
        mongoTemplate.insert(new Document(JSONObject.fromObject(sessionJson, jsonConfig)), "sessionrecord");


    }

}
