package org.lhyf.mp.boot.emun;

import com.baomidou.mybatisplus.core.enums.IEnum;

/****
 * @author YF
 * @date 2020-03-08 14:29
 * @desc SexEnum
 *
 **/
public enum SexEnum implements IEnum<Integer> {

    MAN(1, "男"),
    WOMAN(0, "女");

    private int value;
    private String desc;

    SexEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.desc;
    }
}
