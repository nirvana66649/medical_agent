package com.laioffer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.laioffer.entity.Appointment;
import org.apache.ibatis.annotations.Mapper;

/*
*
* ├── entity
│   └── Appointment.java
├── mapper
│   └── AppointmentMapper.java
├── service
│   └── AppointmentService.java  ← 接口
│   └── impl
│       └── AppointmentServiceImpl.java  ← 实现类
* */
@Mapper
 public interface AppointmentMapper extends BaseMapper<Appointment> {
 }