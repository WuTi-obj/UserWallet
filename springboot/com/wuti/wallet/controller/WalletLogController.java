package com.wuti.wallet.controller;


import com.wuti.wallet.entity.WalletLog;
import com.wuti.wallet.service.WalletLogService;
import com.wuti.wallet.util.ResultVOUtil;
import com.wuti.wallet.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuti
 */
@RestController
@RequestMapping("/walletLog")
public class WalletLogController {
    @Autowired
    private WalletLogService walletLogService;

    /**
     * 钱包金额变动明细
     * @param userId 用户ID
     * @return 钱包变动明细
     */
    @GetMapping("/getWalletLogs/{userId}")
    public ResultVO<WalletLog> getWalletLogs(@PathVariable("userId") Integer userId){
        List<WalletLog> walletLogList = new ArrayList<>();
            walletLogList = walletLogService.getWalletLogByUserId(userId);
            if (walletLogList == null) return ResultVOUtil.fail();
        return ResultVOUtil.success(walletLogList);
    }
}

