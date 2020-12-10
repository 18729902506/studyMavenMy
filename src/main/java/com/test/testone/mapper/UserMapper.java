package com.test.testone.mapper;

import com.test.testone.entity.CompetingStoreExample;

/***
 * @author S
 */
public interface UserMapper {
    long countByExample(CompetingStoreExample example);
}
