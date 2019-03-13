package org.bob.learn.server.web.controller;

import org.bob.learn.server.web.model.CourseReq;
import org.bob.learn.server.web.model.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    @PostMapping("/list")
    public Result listCourse(@RequestBody CourseReq req){
        return Result.failure("123231","sdfsdf");
    }
}
