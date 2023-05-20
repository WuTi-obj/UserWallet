package com.wuti.wallet.service;

import com.wuti.wallet.entity.Wallet;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuti
 */
public interface WalletService extends IService<Wallet> {
    public Boolean consume(Integer userId, BigDecimal amount);
    public Boolean refund(Integer userId, BigDecimal amount);
}
