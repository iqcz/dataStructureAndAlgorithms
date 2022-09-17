package com.lee.datastructureandalgorithms.msb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
/**
 * 堆溢出
 * VM options: -Xmx20M -Xms20M
 */
@RestController
public class HeapController {

    private List<String> list = new ArrayList<>();

    @GetMapping("heap")
    public String heap() {
        while (true) {
            list.add("hello,world");
        }
    }

}
