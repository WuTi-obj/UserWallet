package com.wuti.wallet.util;

import com.wuti.wallet.vo.ResultVO;

/**
 * @author wuti
 */
public class ResultVOUtil {

    //成功
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setData(object);
        return resultVO;
    }

    //失败
    public static ResultVO fail(){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(-1);
        return resultVO;
    }

}
