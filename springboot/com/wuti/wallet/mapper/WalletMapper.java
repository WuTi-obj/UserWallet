package com.wuti.wallet.mapper;

import com.wuti.wallet.entity.Wallet;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.math.BigDecimal;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuti
 */
public interface WalletMapper extends BaseMapper<Wallet> {
    //消费
    public int consumeAmount(Integer userId, BigDecimal amount);
    //退款
    public int refundAmount(Integer userId, BigDecimal amount);
}
