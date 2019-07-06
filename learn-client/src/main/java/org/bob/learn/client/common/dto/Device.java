package org.bob.learn.client.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mac;

    private String sn;

    private String province;
}
