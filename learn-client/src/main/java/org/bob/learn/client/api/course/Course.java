package org.bob.learn.client.api.course;

import lombok.Data;

import java.io.Serializable;

@Data
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;

    private String no;

    private String name;

    private int duration;

    private int credit;
}
