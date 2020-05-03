package com.leyou.item.bo;

import com.leyou.item.pojo.Spu;

/**
 * @Author: soushihou
 * @Date: 2020/4/18
 * @Description: com.leyou.item.bo
 * @version: 1.0
 */
public class SpuBo extends Spu {

    private String cname;
    private String bname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }
}
