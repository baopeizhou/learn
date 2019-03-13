package org.bob.learn.server.web.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CourseReq implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String no;

    private String name;
}
