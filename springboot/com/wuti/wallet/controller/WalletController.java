package com.wuti.wallet.controller;

import com.wuti.wallet.entity.Wallet;
import com.wuti.wallet.entity.WalletLog;
import com.wuti.wallet.service.WalletLogService;
import com.wuti.wallet.service.WalletService;
import com.wuti.wallet.util.ResultVOUtil;
import com.wuti.wallet.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wuti
 */
@RestController
@RequestMapping("/wallet")
public class WalletController {
    @Autowired
    private WalletService walletService;
    @Autowired
    private WalletLogService walletLogService;

    /**
     * 查询用户钱包余额
     * @param userId 用户ID
     * @return 钱包余额
     */
    @GetMapping("/getBalance/{userId}")
    public ResultVO getBalance(@PathVariable("userId") Integer userId){
        try {
            Wallet wallet = walletService.getById(userId);
            if (wallet == null){
                throw new RuntimeException("未找到该用户！");
            }
            BigDecimal balance = wallet.getBalance();
            return ResultVOUtil.success(balance);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 消费
     * @param userId 用户ID
     * @param amount 消费金额
     */
    @GetMapping("/consume/{userId}/{amount}")
    public ResultVO consume(@PathVariable("userId") Integer userId, @PathVariable("amount") BigDecimal amount){
        try {
            Wallet wallet = walletService.getById(userId);
            BigDecimal balance = wallet.getBalance();
            if (balance.compareTo(amount) < 0) throw new RuntimeException("余额不足！");
            Boolean consume = walletService.consume(userId, amount);
            if (!consume) throw new RuntimeException("更新失败！");
            WalletLog walletLog = new WalletLog();
            walletLog.setUserId(userId);
            walletLog.setType("consume");
            walletLog.setAmount(amount);
            boolean save = walletLogService.save(walletLog);
            if (!save) throw new RuntimeException("添加失败！");
            return ResultVOUtil.success(null);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 退款
     * @param userId 用户ID
     * @param amount 退款金额
     */
    @GetMapping("/refund/{userId}/{amount}")
    public ResultVO refund(@PathVariable("userId") Integer userId, @PathVariable("amount") BigDecimal amount){
        try {
            Boolean refund = walletService.refund(userId, amount);
            if (!refund) throw new RuntimeException("更新失败！");
            WalletLog walletLog = new WalletLog();
            walletLog.setUserId(userId);
            walletLog.setType("refund");
            walletLog.setAmount(amount);
            boolean save = walletLogService.save(walletLog);
            if (!save) throw new RuntimeException("添加失败！");
            return ResultVOUtil.success(null);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

}

