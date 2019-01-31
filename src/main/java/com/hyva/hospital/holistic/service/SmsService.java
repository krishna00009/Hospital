/**
 * Created by harshitha on 18/06/06.
 */
package com.hyva.hospital.holistic.service;
import com.hyva.hospital.holistic.entities.OtpGeneration;
import com.hyva.hospital.holistic.entities.SMSServer;
import com.hyva.hospital.holistic.respositories.OtpRepository;
import com.hyva.hospital.holistic.respositories.SMSServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

@Service
public class SmsService {
    @Autowired
    SMSServerRepository smsServerRepository;
    @Autowired
    OtpRepository otpRepository;

    public  String sendSms(String appNo, String mobileNumber,String message) throws IOException {
        String sentance = message+"AppointmentNo is"+ appNo.toString();
        SMSServer smsServer = new SMSServer();
        smsServer=smsServerRepository.findOne(1L);
        if(smsServer!=null) {
            URL url = new URL(smsServer.getSmsUrl() + "?method=sms" + "&api_key=" + smsServer.getApiKey() + "&to=" + mobileNumber + "&sender=" + smsServer.getSenderId() + "&message=" + sentance);
            URLConnection conn = url.openConnection();
            conn.getInputStream();
        }
        return null;
    }


    public  String sendOtp(String userName, String phoneNumber) throws IOException {
        String numbers = "0123456789";
        Random rndm_method = new Random();
        char[] otp = new char[6];
        for (int i = 0; i < 6; i++) {
            otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        String sentance =String.valueOf(otp);
        SMSServer smsServer=smsServerRepository.findOne(1L);
        if(smsServer!=null) {
            URL url = new URL( smsServer.getSmsUrl() + "?method=sms" + "&api_key=" + smsServer.getApiKey() + "&to=" + phoneNumber + "&sender=" + smsServer.getSenderId() + "&message=" + sentance );
            URLConnection conn = url.openConnection();
            conn.getInputStream();
        }
            OtpGeneration otpGeneration = new OtpGeneration();
            otpGeneration.setOtp( String.valueOf( otp ) );
            otpGeneration.setName( userName );
            otpGeneration.setPhoneNumber( phoneNumber );
            otpRepository.save( otpGeneration );
            return null;
    }


}
