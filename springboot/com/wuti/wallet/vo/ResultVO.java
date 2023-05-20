package com.wuti.wallet.vo;

import lombok.Data;

/**
 * @author wuti
 */
@Data
public class ResultVO<T> {
    private Integer code;
    private T data;

}
