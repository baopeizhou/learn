package org.bob.learn.server.common.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    private Object value;
}
