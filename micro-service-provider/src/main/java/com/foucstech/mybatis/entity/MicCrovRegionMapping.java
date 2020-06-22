package com.foucstech.mybatis.entity;

import lombok.Data;

/**
 * @author wuandong
 * @classname MicCrovRegionMapping
 * @date 2020/5/8 11:31
 */
@Data
public class MicCrovRegionMapping {


    private Long recId;

    private String regionType;

    private Integer regionKey;

    private Integer status;

    private Integer crovRegionId;

    private String crovRegionNameEn;

}
