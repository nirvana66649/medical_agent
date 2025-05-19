package com.laioffer.tools;

import com.laioffer.entity.Appointment;
import com.laioffer.service.AppointmentService;
import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// 工具类，用于提供预约的相关功能
public class AppointmentTools {
    //首先，需要调用getOne方法来获取预约信息，判断用户是否有预约
    @Autowired
    private AppointmentService appointmentService;
    @Tool(
            name = "book_appointment",
            value = "Based on the given parameters, first call the tool method 'queryDepartment' to check if an appointment can be made. Respond directly to the user with the result and ask the user to confirm all appointment details before proceeding with the booking."
    )
    public String bookAppointment(Appointment appointment) {
        Appointment existingAppointment = appointmentService.getOne(appointment);
        if (existingAppointment != null) {
            return "Sorry, you have already book on this time slot. Please choose another time.";
        }
        else {
            appointment.setId(null);//防止大模型幻觉设置了id
            if (appointmentService.save(appointment)) {
                return "Appointment booked successfully!";
            }
            else {
                return "Appointment booking failed!";
            }
        }
    }
    @Tool(name = "modify_appointment", value = "Modifies an existing appointment with new details. Requires original appointment details and new parameters.")
    public String modifyAppointment( @P(value = "Original appointment details") Appointment originalAppointment,
                                     @P(value = "New department name", required = false) String newDepartment,
                                     @P(value = "New date", required = false) String newDate,
                                     @P(value = "New time (morning or afternoon)", required = false) String newTime
                                    ) {
        // 检查原始预约是否存在
        Appointment existingAppointment = appointmentService.getOne(originalAppointment);
        if (existingAppointment == null) {
            return "Sorry, you have not booked an appointment on this time slot.";
        }
        if (newDepartment != null) {
            existingAppointment.setDepartment(newDepartment);
        }
        if (newDate != null) {
            existingAppointment.setDate(newDate);
        }
        if (newTime != null) {
            existingAppointment.setTime(newTime);
        }
        if (appointmentService.updateById(existingAppointment)) {
            return "Appointment modified successfully!";
        }
        else {
            return "Appointment modification failed!";
        }

    }
    @Tool(name="cancel_appointment", value = "Queries if the appointment exists, deletes the record if found, and returns success or failure accordingly.")
    public String cancelAppointment(Appointment appointment) {
        Appointment existingAppointment = appointmentService.getOne(appointment);
        if (existingAppointment == null) {
            return "Sorry, you have not booked an appointment on this time slot.";
        }
        else {
            if (appointmentService.removeById(existingAppointment.getId())) {
                return "Appointment canceled successfully! New details: " + existingAppointment.toString();
            }
            else {
                return "Appointment cancellation failed!";
            }
        }
    }
    @Tool(name = "check_availability", value = "Checks if appointments are available for the specified school department, date, time, and returns the result.")
    public boolean queryDepartment(
            @P(value = "Department name") String name,
            @P(value = "Date") String date,
            @P(value = "Time (morning or afternoon)") String time,
            @P(value = "Doctor name", required = false) String doctorName
    ) {
        System.out.println("Checking appointment availability");
        System.out.println("Department name: " + name);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        return true;
    }



}
