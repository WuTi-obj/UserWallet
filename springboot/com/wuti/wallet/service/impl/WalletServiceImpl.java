package com.wuti.wallet.service.impl;

import com.wuti.wallet.entity.Wallet;
import com.wuti.wallet.mapper.WalletMapper;
import com.wuti.wallet.service.WalletService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wuti
 */
@Service
public class WalletServiceImpl extends ServiceImpl<WalletMapper, Wallet> implements WalletService {

    @Autowired
    private WalletMapper walletMapper;

    @Override
    public Boolean consume(Integer userId, BigDecimal amount) {
        int consume = walletMapper.consumeAmount(userId, amount);
        if (consume != 1){
            System.out.println("更新失败！");
        }
        return true;
    }

    @Override
    public Boolean refund(Integer userId, BigDecimal amount) {
        int refund = walletMapper.refundAmount(userId, amount);
        if (refund != 1){
            System.out.println("更新失败！");
        }
        return true;
    }
}
