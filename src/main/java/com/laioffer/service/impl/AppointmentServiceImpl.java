package com.laioffer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laioffer.entity.Appointment;
import com.laioffer.mapper.AppointmentMapper;
import com.laioffer.service.AppointmentService;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl  extends ServiceImpl<AppointmentMapper, Appointment>
implements AppointmentService {

    @Override
    public Appointment getOne(Appointment appointment) {
        //防止重复预约：
        //在添加预约前调用此方法，如果返回结果不为 null，说明这个用户已经预约了相同的时间段，可以提示“请勿重复预约”。
        LambdaQueryWrapper<Appointment> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Appointment::getUsername, appointment.getUsername());
        queryWrapper.eq(Appointment::getIdCard, appointment.getIdCard());
        queryWrapper.eq(Appointment::getDepartment, appointment.getDepartment());
        queryWrapper.eq(Appointment::getDate, appointment.getDate());
        queryWrapper.eq(Appointment::getTime, appointment.getTime());
        return baseMapper.selectOne(queryWrapper); //返回查询结果，如果查询结果不为 null，说明这个用户已经预约了相同的时间段

    }
}
