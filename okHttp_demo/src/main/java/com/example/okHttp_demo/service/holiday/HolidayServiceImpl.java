package com.example.okHttp_demo.service.holiday;

import com.example.okHttp_demo.constants.RtnCode;
import com.example.okHttp_demo.dao.HolidayAcuireDao;
import com.example.okHttp_demo.dao.HolidayAcuireSequenceDao;
import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.entity.HolidayAcquireSequence;
import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.HolidayAcquireRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class HolidayServiceImpl implements HolidayService{

    @Autowired
    private HolidayAcuireDao hDao;
    
    @Autowired
    private HolidayAcuireSequenceDao hsDao;
    
    /**
     * カレンダーナンバーの採番を取得する。 作成者:
     *
     * @return カレンダーナンバー採番
     */
    @Override
    public String getCalendarNoSequence() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String localDate = dtf.format(LocalDate.now());
        String yearNow = localDate.substring(0,4);
//      来年になったら、カンターをゼロに設定
        if(!hDao.existsById(yearNow+"00")) {
            List<HolidayAcquireSequence> res = hsDao.findAll();
            for (HolidayAcquireSequence item : res) {
                hsDao.updateById(item.getIdNumber(), 0);
            }
        }
        
        List<HolidayAcquireSequence> res = hsDao.findAll();
        int idNumber = 0;
        for (HolidayAcquireSequence item : res) {
            idNumber = item.getIdNumber();
        }

        return String.format(yearNow+"%02d", idNumber);
    }

    /**
     * カレンダーナンバー採番を更新する。 作成者:
     *
     * @return 更新されたカレンダーナンバー採番
     */
    @Override
    public Integer updateCalendarNoSequence() {
        

        List<HolidayAcquireSequence> res = hsDao.findAll();
        int idNumber = 0;
        for (HolidayAcquireSequence item : res) {
            idNumber = item.getIdNumber();
        }
        
        return hsDao.updateById(idNumber, idNumber+1); 
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse<HolidayAcquireRes> HolidayAcquire(String personalNo, String startDate, String startTime0, String endDate, String endTime0, String leaveType, String reason) {

        int startYear;
        int startMonth;
        int startDay;
        int startTime;
        String startTimeSave;
        int endYear;
        int endMonth;
        int endDay;
        int endTime;
        String endTimeSave;
        
//      入力内容がヌルかの確認
        if(!StringUtils.hasText(personalNo) ||
           !StringUtils.hasText(startDate) ||
           !StringUtils.hasText(startTime0) ||
           !StringUtils.hasText(endDate) ||
           !StringUtils.hasText(endTime0) ||
           !StringUtils.hasText(leaveType) ||
           !StringUtils.hasText(reason)) {
            return new BaseResponse<HolidayAcquireRes>(RtnCode.INPUT_EMPTY_ERROR.getCode(), RtnCode.INPUT_EMPTY_ERROR.getMessage(), null);
        }
        
        String[] startDateNew = startDate.split("-");
        String[] startTimeNew = startTime0.split(":");
        String[] endDateNew = endDate.split("-");
        String[] endTimeNew = endTime0.split(":");
        
        startYear = Integer.parseInt(startDateNew[0]);
        startMonth = Integer.parseInt(startDateNew[1]);
        startDay = Integer.parseInt(startDateNew[2]);
        startTime = Integer.parseInt(startTimeNew[0])+Integer.parseInt(startTimeNew[1]);
        startTimeSave = startTimeNew[0]+startTimeNew[1];

        endYear = Integer.parseInt(endDateNew[0]);
        endMonth = Integer.parseInt(endDateNew[1]);
        endDay = Integer.parseInt(endDateNew[2]);
        endTime = Integer.parseInt(endTimeNew[0])+Integer.parseInt(endTimeNew[1]);
        endTimeSave = endTimeNew[0]+endTimeNew[1];
        
        if(startYear >= endYear &&
           startMonth >= endMonth &&
           startDay >= endDay &&
           startTime >= endTime) {
            return new BaseResponse<HolidayAcquireRes>(RtnCode.TIME_INTERVAL_ERROR.getCode(), RtnCode.TIME_INTERVAL_ERROR.getMessage(), null);
        }
        
//        1. 轉換所需資料(以存到DB)
        HolidayAcquire holidayAcquire = new HolidayAcquire();
        
        holidayAcquire.setCalendarNo(this.getCalendarNoSequence());
        
        holidayAcquire.setStartYear(String.valueOf(startYear));

        holidayAcquire.setStartMonth(String.valueOf(startMonth));
        
        holidayAcquire.setStartDay(String.valueOf(startDay));
        
        holidayAcquire.setStartTime(startTimeSave);
        
        holidayAcquire.setEndYear(String.valueOf(endYear));

        holidayAcquire.setEndMonth(String.valueOf(endMonth));
        
        holidayAcquire.setEndDay(String.valueOf(endDay));
        
        holidayAcquire.setEndTime(endTimeSave);
        
        holidayAcquire.setVacationDays(endDay-startDay+1);
        
        if(leaveType.matches("私用"))
            holidayAcquire.setVacationNo("11");
        else if(leaveType.matches("体調不良"))
            holidayAcquire.setVacationNo("12");
        else if(leaveType.matches("振替"))
            holidayAcquire.setVacationNo("13");
        else
            holidayAcquire.setVacationNo("14");
        
        holidayAcquire.setReason(reason);
        
        if (hDao.save(holidayAcquire) == null) {
            return new BaseResponse<HolidayAcquireRes>(RtnCode.INSERT_ERROR.getCode(), RtnCode.INSERT_ERROR.getMessage(), null);
        }
        
        this.updateCalendarNoSequence();
        return new BaseResponse<HolidayAcquireRes>(RtnCode.INSERT_SUCCESSFUL.getCode(), RtnCode.INSERT_SUCCESSFUL.getMessage(), null);
    }


    
}
