package com.sx.ybj.controller.note;

import com.sx.ybj.service.note.active.ActiveService;
import com.sx.ybj.utils.ExceptionUtil;
import com.sx.ybj.utils.YbjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ybj
 * @description: 活动
 * @author: lwx
 * @create: 2019-05-24 19:44
 */
@RestController
@RequestMapping("/user")
public class ActiveController {

    @Autowired
    ActiveService activeService;
    @GetMapping("/getActivity")
    public YbjResult  getActivity(){
        try {
            return  YbjResult.ok(activeService.getActivity());
        } catch (Exception e) {
            return  YbjResult.build(0,"查看活动主题失败", ExceptionUtil.getStackTrace(e));
        }
    }


    @GetMapping("/geyActivityById/{activityId}")
    public YbjResult getActivityById(@PathVariable("activityId") int activityId){
        try {
            return YbjResult.ok(activeService.getActivityById(activityId));
        } catch (Exception e) {
            return  YbjResult.build(0,"查看活动", ExceptionUtil.getStackTrace(e));
        }
    }
    @GetMapping("/joinActivity")
    public YbjResult finalActivityById(int notebookId,int activity_id){
        return activeService.joinActivity(notebookId,activity_id);
    }





}