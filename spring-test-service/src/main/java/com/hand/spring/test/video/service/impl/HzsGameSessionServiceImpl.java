package com.hand.spring.test.video.service.impl;


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



    private final static String FIRSTGAMENAME = "interactive activity";

    /**
     * 查询会话记录
     *
     * @param levelNum
     * @return
     */
    @Override
    public JSONObject selectSession(Long levelNum) {
        JSONObject sessionJson = new JSONObject();
        //游戏内容抽取
        JSONObject gameJson1 = new JSONObject();
        gameJson1.put("name", FIRSTGAMENAME);
        JSONObject gameJson2 = mongoTemplate.findOne(new Query().addCriteria(Criteria.where("levelNum").is(levelNum).and("gameNum").is(2L).and("contentNum").is(1)), JSONObject.class, "gamepacket_material");
        JSONObject gameJson3 = mongoTemplate.findOne(new Query().addCriteria(Criteria.where("levelNum").is(levelNum).and("gameNum").is(3L).and("contentNum").is(1)), JSONObject.class, "gamepacket_material");
        JSONObject gameJson4 = mongoTemplate.findOne(new Query().addCriteria(Criteria.where("levelNum").is(levelNum).and("gameNum").is(4L).and("contentNum").is(1)), JSONObject.class, "gamepacket_material");
        List<JSONObject> gameJson = new ArrayList<>();
        gameJson.add(gameJson1);
        gameJson.add(gameJson2);
        gameJson.add(gameJson3);
        gameJson.add(gameJson4);
        sessionJson.put("userId", 1);
        sessionJson.put("levelNum", levelNum);
        sessionJson.put("levelStatus", 1);
        sessionJson.put("levelValue", "test");
        sessionJson.put("content", gameJson);
        return sessionJson;
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
