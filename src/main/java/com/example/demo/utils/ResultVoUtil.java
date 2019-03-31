package com.example.demo.utils;

import com.example.demo.enums.LoginEnum;
import com.example.demo.vo.ResultVO;

import java.io.Serializable;

/**
 * @author dgh
 * @date 19-1-18 下午7:56
 */
public class ResultVoUtil implements Serializable {
    /**
     * 成功返回  携带内容
     */
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    /**
     * 成功返回 不携带内容
     *
     * @return
     */
    public static ResultVO success() {
        return success(null);
    }

    /**
     * 错误返回 并携带内容
     *
     * @param loginEnum
     * @return
     */
    public static ResultVO error(LoginEnum loginEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(loginEnum.getCode());
        resultVO.setMsg(loginEnum.getMessage());
        return resultVO;
    }


}
