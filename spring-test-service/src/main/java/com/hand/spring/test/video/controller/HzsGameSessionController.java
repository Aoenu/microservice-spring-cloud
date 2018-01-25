package com.hand.spring.test.video.controller;

import com.hand.spring.test.exception.dto.TestException;
import com.hand.spring.test.video.service.IHzsGameSessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2017/12/13.
 * @description
 */
@Api(value = "用户会话记录", description = "用户会话记录")
@RestController
@RequestMapping("api/game-packet")
public class HzsGameSessionController {

    @Autowired
    private IHzsGameSessionService hzsGameSessionService;

    @ApiOperation(value = "查询会话记录", notes = "查询会话记录", httpMethod = "GET", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "levelNum", value = "关卡编号", required = true, dataType = "Long", paramType = "query")})
    @GetMapping("/selectSession")
    public ResponseEntity selectSession(@RequestParam(name = "levelNum") Long levelNum) throws TestException {
        Validate.notNull(levelNum, "关卡编号不能为空");
        Validate.isTrue(levelNum > 0 && levelNum <= 8, "关卡编号错误");
        return ResponseEntity.ok(hzsGameSessionService.selectSession(levelNum));
    }

    @ApiOperation(value = "查询", notes = "查询", httpMethod = "GET", response = ResponseEntity.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "page", dataType = "Integer", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "pageSize", dataType = "Integer", paramType = "query", defaultValue = "10")})
    @GetMapping("/select")
    public ResponseEntity select(@RequestParam(defaultValue = "1") int page,
                                 @RequestParam(defaultValue = "10") int pageSize) {
        return ResponseEntity.ok(hzsGameSessionService.select(page, pageSize));
    }

    @ApiOperation(value = "保存会话记录（存Mongo）", notes = "保存会话记录（存Mongo）", httpMethod = "POST", response = ResponseEntity.class)
    @PostMapping("/submitSession")
    public ResponseEntity submitSession(@RequestBody JSONObject jsonSession) {
        hzsGameSessionService.submitSession(jsonSession);
        Map<String, Object> rep = new HashMap<>();
        rep.put("success", Boolean.TRUE);
        return ResponseEntity.ok(rep);
    }
}
