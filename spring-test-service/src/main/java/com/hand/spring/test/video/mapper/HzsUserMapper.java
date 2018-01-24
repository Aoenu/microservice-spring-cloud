package com.hand.spring.test.video.mapper;

import com.hand.spring.test.video.dto.HzsUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author baoben.wu@hand-china.com
 * @Date 2018/1/24.
 * @description
 */
@Component
@Mapper
public interface HzsUserMapper {
    List<HzsUser> select();
}
