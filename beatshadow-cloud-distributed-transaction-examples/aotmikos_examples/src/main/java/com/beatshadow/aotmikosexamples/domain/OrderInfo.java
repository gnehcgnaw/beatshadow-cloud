package com.beatshadow.aotmikosexamples.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/1/14 14:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo {
    private Integer id;

    private Double money;

    private String userId;

    private String address;

    private Date createTime;
}