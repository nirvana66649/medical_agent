package com.laioffer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.laioffer.entity.Appointment;

public interface AppointmentService extends IService<Appointment> {
    Appointment getOne(Appointment appointment);  // 方法签名
}
