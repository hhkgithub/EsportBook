package com.esportbook.mapper;

import com.esportbook.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by hhkmac on 2017/4/18.
 */
@Mapper
public interface UserMapper {
    @Select("select * from user where userseq=#{userseq}")
     User findUserBySeq(Integer userseq) ;
}
