package com.foucstech.mybatis.mapper;

import com.foucstech.mybatis.entity.MicCrovRegionMapping;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wuandong
 * @classname MicCrovRegionMappingMapper
 * @date 2020/5/8 11:29
 */
public interface MicCrovRegionMappingMapper {


    @Select("select * from mic_crov_region_mapping")
    @Results({
        @Result(id = true,column = "rec_id",property = "recId"),
        @Result(column = "regioin_type",property = "regionType")
    })
    List<MicCrovRegionMapping> queryAll();


}
