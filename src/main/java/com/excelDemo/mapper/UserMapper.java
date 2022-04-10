package com.excelDemo.mapper;

import com.excelDemo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int insertList(@Param("list") List<User> userList);

    int insert(User user);
}
