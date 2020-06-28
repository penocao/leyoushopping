package com.leyou.item.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: soushihou
 * @Date: 2020/3/22
 * @Description: com.leyou.item.controller
 * @version: 1.0
 */
public interface CategoryApi {


    @GetMapping("category")
    public List<String> queryNamesByIds(@RequestParam("ids") List<Long> ids);
}
