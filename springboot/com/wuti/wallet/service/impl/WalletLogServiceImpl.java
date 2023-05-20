package com.wuti.wallet.service.impl;

import com.wuti.wallet.entity.WalletLog;
import com.wuti.wallet.mapper.WalletLogMapper;
import com.wuti.wallet.service.WalletLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuti
 */
@Service
public class WalletLogServiceImpl extends ServiceImpl<WalletLogMapper, WalletLog> implements WalletLogService {

    @Autowired
    private WalletLogMapper walletLogMapper;
    @Override
    public List<WalletLog> getWalletLogByUserId(Integer userId) {
        List<WalletLog> walletLogList = walletLogMapper.getWalletLogByUserId(userId);
        return walletLogList;
    }
}
