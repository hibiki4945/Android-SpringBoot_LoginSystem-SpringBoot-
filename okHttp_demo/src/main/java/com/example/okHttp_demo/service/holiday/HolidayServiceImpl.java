package com.example.okHttp_demo.service.holiday;

import com.example.okHttp_demo.constants.RtnCode;
import com.example.okHttp_demo.dao.HolidayAcuireDao;
import com.example.okHttp_demo.dao.HolidayAcuireSequenceDao;
import com.example.okHttp_demo.dao.UserDao;
import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.entity.HolidayAcquireSequence;
import com.example.okHttp_demo.entity.User;
import com.example.okHttp_demo.vo.BaseResponse;
import com.example.okHttp_demo.vo.HolidayAcquireRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class HolidayServiceImpl implements HolidayService{

    @Autowired
    private HolidayAcuireDao hDao;
    
    @Autowired
    private HolidayAcuireSequenceDao hsDao;
    
    @Autowired
    private UserDao uDao;
    
    /**
     * カレンダーナンバーの採番を取得する。 作成者:許智偉
     *
     * @return カレンダーナンバー採番
     */
    @Override
    public String getCalendarNoSequence() {
//      現在時刻を取得
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String localDate = dtf.format(LocalDate.now());
        String yearNow = localDate.substring(0,4);
//      来年になったら、カンターをゼロに設定
        if(!hDao.existsById(yearNow+"000")) {
            List<HolidayAcquireSequence> res = hsDao.findAll();
            for (HolidayAcquireSequence item : res) {
                hsDao.updateById(item.getIdNumber(), 0);
            }
        }
//      CalendarNoのカンターを取得
        List<HolidayAcquireSequence> res = hsDao.findAll();
        int idNumber = 0;
        for (HolidayAcquireSequence item : res) {
            idNumber = item.getIdNumber();
        }

//      CalendarNoのカンターを返す
        return String.format(yearNow+"%03d", idNumber);
    }

    /**
     * カレンダーナンバー採番を更新する。 作成者:許智偉
     *
     * @return 更新されたカレンダーナンバー採番
     */
    @Override
    public Integer updateCalendarNoSequence() {
        
//      CalendarNoのカンターを取得
        List<HolidayAcquireSequence> res = hsDao.findAll();
        int idNumber = 0;
        for (HolidayAcquireSequence item : res) {
            idNumber = item.getIdNumber();
        }
        
//      CalendarNoのカンターを更新
        return hsDao.updateById(idNumber, idNumber+1); 
    }

    /**
     * 休暇申込を作成し、データベースに追加する。 作成者:許智偉
     *
     * @param personalNo 社員番号
     * @param startDate 開始日付
     * @param startTime 開始時間
     * @param endDate 終了日付
     * @param endTime 終了時間
     * @param leaveType 休暇番号
     * @param reason 休暇理由
     * @return 休暇申込の作成結果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public BaseResponse<HolidayAcquireRes> HolidayAcquire(String personalNo, String[] selectedWorkSpot, String startDate, String startTime0, String endDate, String endTime0, String leaveType, String reason) {

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
        boolean manageFlag=false;
        
//      入力内容がヌルかの確認
        if(!StringUtils.hasText(personalNo) ||
           !StringUtils.hasText(startDate) ||
           !StringUtils.hasText(startTime0) ||
           !StringUtils.hasText(endDate) ||
           !StringUtils.hasText(endTime0) ||
           !StringUtils.hasText(leaveType) ||
           !StringUtils.hasText(reason) ||
           startDate.contains("選択") ||
           startTime0.contains("選択") ||
           endDate.contains("選択") ||
           endTime0.contains("選択")) {
            return new BaseResponse<HolidayAcquireRes>(RtnCode.INPUT_EMPTY_ERROR.getCode(), RtnCode.INPUT_EMPTY_ERROR.getMessage(), null);
        }
        Optional<User> findPersonalNo0 = uDao.findById(personalNo);
        User findPersonalNo = findPersonalNo0.get();
//      社員か現場リーダーの判断
        if(selectedWorkSpot == null) {
            if(!findPersonalNo.getAppAuthority().matches("2"))
                return new BaseResponse<HolidayAcquireRes>(RtnCode.INPUT_EMPTY_ERROR.getCode(), RtnCode.INPUT_EMPTY_ERROR.getMessage(), null);
            else
                manageFlag = true;
        }
//      時間の分離
        String[] startDateNew = startDate.split("-");
        String[] startTimeNew = startTime0.split(":");
        String[] endDateNew = endDate.split("-");
        String[] endTimeNew = endTime0.split(":");
//      時間を数字へと変換
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

//      開始時間が終了時間より先かを確認
        if(startYear >= endYear &&
           startMonth >= endMonth &&
           startDay >= endDay &&
           startTime >= endTime) {
            return new BaseResponse<HolidayAcquireRes>(RtnCode.TIME_INTERVAL_ERROR.getCode(), RtnCode.TIME_INTERVAL_ERROR.getMessage(), null);
        }
        
        HolidayAcquire holidayAcquire = new HolidayAcquire();
//      開始年を設定
        holidayAcquire.setStartYear(String.valueOf(startYear));
//      開始月を設定
        holidayAcquire.setStartMonth(String.valueOf(startMonth));
//      開始月を設定
        holidayAcquire.setStartDay(String.valueOf(startDay));
//      開始時を設定
        holidayAcquire.setStartTime(startTimeSave);
//      終了年を設定        
        holidayAcquire.setEndYear(String.valueOf(endYear));
//      終了月を設定
        holidayAcquire.setEndMonth(String.valueOf(endMonth));
//      終了月を設定
        holidayAcquire.setEndDay(String.valueOf(endDay));
//      終了時を設定
        holidayAcquire.setEndTime(endTimeSave);
//      休暇日数を設定
        holidayAcquire.setVacationDays(endDay-startDay+1);
//      休暇番号を設定
        if(leaveType.matches("私用"))
            holidayAcquire.setVacationNo("11");
        else if(leaveType.matches("体調不良"))
            holidayAcquire.setVacationNo("12");
        else if(leaveType.matches("振替"))
            holidayAcquire.setVacationNo("13");
        else
            holidayAcquire.setVacationNo("14");
//      休暇理由を設定
        holidayAcquire.setReason(reason);
//      社員番号を設定
        holidayAcquire.setWorkSpotDepart(personalNo);
//      作成者を設定
        holidayAcquire.setRegAuthor(personalNo);
//      現在時刻を取得
        LocalDate localDate = LocalDate.now();
//      作成年を設定
        holidayAcquire.setRegYear(String.valueOf(localDate.getYear()));
//      作成月を設定
        holidayAcquire.setRegMonth(String.valueOf(localDate.getMonthValue()));
//      作成時を設定
        holidayAcquire.setRegDay(String.valueOf(localDate.getDayOfMonth()));
//      更新者を設定
        holidayAcquire.setUptAuthor(personalNo);
//      更新年を設定
        holidayAcquire.setUptYear(String.valueOf(localDate.getYear()));
//      更新月を設定
        holidayAcquire.setUptMonth(String.valueOf(localDate.getMonthValue()));
//      更新時を設定
        holidayAcquire.setUptDay(String.valueOf(localDate.getDayOfMonth()));
//      可視化を設定
        holidayAcquire.setDelFlg("0");

        if(!manageFlag) { // 社員の場合
            for(int i = 0;i<selectedWorkSpot.length;i++) {
//              休暇申込の採番を設定
                holidayAcquire.setHolidayAcquireNo(this.getCalendarNoSequence());
//              選択現場を設定
                holidayAcquire.setSelectedWorkSpot(selectedWorkSpot[i]); 
//              承認区分を設定(現場審査中)
                holidayAcquire.setApprovalCtg("1");
                
//              休暇申込をデータベースに追加
                if (hDao.save(holidayAcquire) == null) {
                    return new BaseResponse<HolidayAcquireRes>(RtnCode.INSERT_ERROR.getCode(), RtnCode.INSERT_ERROR.getMessage(), null);
                }

//              CalendarNoのカンターを更新
                this.updateCalendarNoSequence();
            }
   
        }
        else { // 現場リーダーの場合
            
//          休暇申込の採番を設定
            holidayAcquire.setHolidayAcquireNo(this.getCalendarNoSequence());
//          承認区分を設定(本社審查中)
            holidayAcquire.setApprovalCtg("2");
            
//          休暇申込をデータベースに追加
            if (hDao.save(holidayAcquire) == null) {
                return new BaseResponse<HolidayAcquireRes>(RtnCode.INSERT_ERROR.getCode(), RtnCode.INSERT_ERROR.getMessage(), null);
            }

//          CalendarNoのカンターを更新
            this.updateCalendarNoSequence();
            
        }
        
        
//      休暇申込の作成結果を返す
        return new BaseResponse<HolidayAcquireRes>(RtnCode.INSERT_SUCCESSFUL.getCode(), RtnCode.INSERT_SUCCESSFUL.getMessage(), new HolidayAcquireRes(holidayAcquire.getHolidayAcquireNo()));
    }


    
}
