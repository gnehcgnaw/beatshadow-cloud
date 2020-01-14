package com.beatshadow.aotmikosexamples.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : <a href="mailto:gnehcgnaw@gmail.com">gnehcgnaw</a>
 * @since : 2020/1/14 14:41
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogInfo {
    private Integer id;

    private Date createTime;

    private String content;
}