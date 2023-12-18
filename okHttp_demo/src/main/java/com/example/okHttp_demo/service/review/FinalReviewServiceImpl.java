package com.example.okHttp_demo.service.review;

import com.example.okHttp_demo.constants.RtnCode;
import com.example.okHttp_demo.dao.HolidayAcuireDao;
import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * 作成者:許智偉 日付 2023/12/13
 */
@Service
public class FinalReviewServiceImpl implements FinalReviewService{

    @Autowired
    private HolidayAcuireDao hDao;

    /**
     * 現場審査完了の休暇申込を検索
     * 作成者:許智偉
     *
     * @return 現場審査完了の休暇申込
     */
    @Override
    public BaseResponse<List<HolidayAcquire>> HolidayFinalReview() {
//      現場審査完了の休暇申込を検索
        List<HolidayAcquire> res = hDao.findByApprovalCtgAndDelFlg("2", "0");

        return new BaseResponse<List<HolidayAcquire>>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), res);
    }

    /**
     * 現場審査完了の休暇申込を承認
     * 作成者:許智偉
     *
     * @param personalNo 自分の社員番号
     * @param workSpotDepart 休暇申込の採番
     * @return 本社審査完了の休暇申込の社員番号
     */
    @Override
    public BaseResponse<String> HolidayFinalReviewAccept(String personalNo, String holidayAcquireNo) {
//      休暇申込の採番で休暇申込を検索
        HolidayAcquire res = hDao.findById(holidayAcquireNo).get();
//      承認区分を確認要と設定
        res.setApprovalCtg("4");
//      現在時刻を取得
        LocalDate localDate = LocalDate.now();
//      更新者を設定
        res.setUptAuthor(personalNo);
//      更新年を設定
        res.setUptYear(String.valueOf(localDate.getYear()));
//      更新月を設定
        res.setUptMonth(String.valueOf(localDate.getMonthValue()));
//      更新時を設定
        res.setUptDay(String.valueOf(localDate.getDayOfMonth()));

//      休暇申込を更新
        hDao.save(res);

//      当社員の別現場の同じ開始時刻の休暇申込を検索
        String workSpotDepart = res.getWorkSpotDepart();
        String startYear = res.getStartYear();
        String startMonth = res.getStartMonth();
        String startDay = res.getStartDay();
        String startTime = res.getStartTime();
        List<HolidayAcquire> other = hDao.findByWorkSpotDepartAndStartYearAndStartMonthAndStartDayAndStartTime(workSpotDepart, startYear, startMonth, startDay, startTime);

//      同じ開始時刻の休暇申込を削除
        for (HolidayAcquire item : other) {
            if(!item.getHolidayAcquireNo().matches(holidayAcquireNo)) {
                item.setDelFlg("1");
                hDao.save(item);
            }
        }
        
        return new BaseResponse<String>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), holidayAcquireNo);
    }

    /**
     * 現場審査完了の休暇申込を却下
     * 作成者:許智偉
     *
     * @param personalNo 自分の社員番号
     * @param workSpotDepart 休暇申込の採番
     * @return 本社審査完了の休暇申込の社員番号
     */
    @Override
    public BaseResponse<String> HolidayFinalReviewDenied(String personalNo, String holidayAcquireNo, String refusal) {
//      休暇申込の採番で休暇申込を検索
        HolidayAcquire res = hDao.findById(holidayAcquireNo).get();
//      却下理由を設定
        res.setRefusal(refusal);
//      承認区分を却下と設定
        res.setApprovalCtg("3");
//      現在時刻を取得
        LocalDate localDate = LocalDate.now();
//      更新者を設定
        res.setUptAuthor(personalNo);
//      更新年を設定
        res.setUptYear(String.valueOf(localDate.getYear()));
//      更新月を設定
        res.setUptMonth(String.valueOf(localDate.getMonthValue()));
//      更新時を設定
        res.setUptDay(String.valueOf(localDate.getDayOfMonth()));

//      休暇申込を更新
        hDao.save(res);

//      当社員の別現場の同じ開始時刻の休暇申込を検索
        String workSpotDepart = res.getWorkSpotDepart();
        String startYear = res.getStartYear();
        String startMonth = res.getStartMonth();
        String startDay = res.getStartDay();
        String startTime = res.getStartTime();
        List<HolidayAcquire> other = hDao.findByWorkSpotDepartAndStartYearAndStartMonthAndStartDayAndStartTime(workSpotDepart, startYear, startMonth, startDay, startTime);

//      同じ開始時刻の休暇申込を削除
        for (HolidayAcquire item : other) {
            if(!item.getHolidayAcquireNo().matches(holidayAcquireNo)) {
                item.setDelFlg("1");
                hDao.save(item);
            }
        }
        
        return new BaseResponse<String>(RtnCode.SEARCHING_SUCCESSFUL.getCode(), RtnCode.SEARCHING_SUCCESSFUL.getMessage(), holidayAcquireNo);
    }
    
}
