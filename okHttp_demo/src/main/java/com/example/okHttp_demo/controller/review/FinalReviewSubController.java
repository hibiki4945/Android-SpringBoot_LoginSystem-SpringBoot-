package com.example.okHttp_demo.controller.review;

import com.example.okHttp_demo.entity.HolidayAcquire;
import com.example.okHttp_demo.service.review.FinalReviewService;
import com.example.okHttp_demo.vo.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class FinalReviewSubController {

    @Autowired
    private FinalReviewService frService;
    
    @RequestMapping(value = "/holiday_final_review")
    public String HolidayFinalReview(Model model) {
        
        BaseResponse<List<HolidayAcquire>> res = frService.HolidayFinalReview();

        model.addAttribute("holidayAcquireList", res.getData());
        
        return "holiday_final_review";
    }
    
    @PostMapping("/pcAccept")
    @ResponseBody
    public String pcAccept(@RequestBody Map<String, String> requestBody) {
        String holidayAcquireNo = requestBody.get("holidayAcquireNo");

//        System.out.println("holidayAcquireNo: "+holidayAcquireNo);

        BaseResponse<String> res = frService.HolidayFinalReviewAccept("A021", holidayAcquireNo);
        
        return "holiday_final_review0";
    }
    
    @PostMapping("/pcDenied")
    @ResponseBody
    public String pcDenied(@RequestBody Map<String, String> requestBody) {
        String holidayAcquireNo = requestBody.get("holidayAcquireNo");
        String reason = requestBody.get("reason");

        BaseResponse<String> res = frService.HolidayFinalReviewDenied("A021", holidayAcquireNo, reason);
        
        return "holiday_final_review0";
    }
    
}