package com.mhlsky.common.enums.dictionary;

import com.mhlsky.common.enums.DictionaryEnum;
import lombok.Data;

/**
 * :字典模型类
 *
 * @author mhlsky孟
 * @date 2024/8/1 下午6:43
 * @description
 */
@Data
public class DictionaryData {
    private String label;
    private Integer value;
    private String cssTag;

    @SuppressWarnings("rawtypes")
    public DictionaryData(DictionaryEnum enumType) {
        if (enumType != null) {
            this.label = enumType.description();
            this.value = (Integer) enumType.getValue();
            this.cssTag = enumType.cssTag();
        }
    }

}
