package com.chrome.api.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author chengcong
 * @description
 * @date 2018/9/8
 */
@Builder
@Data
public class ResponseTemplate {

    public Integer code;

    public String message;

    public Object data;

}
