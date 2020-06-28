package com.leyou.item.api;

import com.leyou.item.pojo.Brand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: soushihou
 * @Date: 2020/3/29
 * @Description: com.leyou.item.controller
 * @version: 1.0
 */
public interface BrandApi {
    /**
     * 根据id查询品牌
     * @param id
     * @return
     */
    @GetMapping("brand/{id}")
    public Brand queryBrandById(@PathVariable("id") Long id);
}
