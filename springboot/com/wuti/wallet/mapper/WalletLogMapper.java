package com.wuti.wallet.mapper;

import com.wuti.wallet.entity.WalletLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wuti
 */
public interface WalletLogMapper extends BaseMapper<WalletLog> {
    public List<WalletLog> getWalletLogByUserId(@Param("userId") Integer userId);
}
