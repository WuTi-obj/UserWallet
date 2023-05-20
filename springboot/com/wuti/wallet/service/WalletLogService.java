package com.wuti.wallet.service;

import com.wuti.wallet.entity.WalletLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wuti
 */
public interface WalletLogService extends IService<WalletLog> {
    public List<WalletLog> getWalletLogByUserId(Integer userId);
}
