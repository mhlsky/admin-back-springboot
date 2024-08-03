package com.mhlsky.domain.common.cache;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import com.mhlsky.common.enums.DictionaryEnum;
import com.mhlsky.common.enums.common.*;
import com.mhlsky.common.enums.dictionary.Dictionary;
import com.mhlsky.common.enums.dictionary.DictionaryData;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * :本地一级缓存  使用Map
 *
 * @author mhlsky孟
 * @date 2024/8/1 下午7:35
 * @description
 */
public class MapCache {
    private static final Map<String, List<DictionaryData>> DICTIONARY_CACHE = MapUtil.newHashMap(128);
    private MapCache() {
    }

    static {
        initDictionaryCache();
    }
    private static void initDictionaryCache() {
        // TODO 这个可以做成自动扫描
        loadInCache(BusinessTypeEnum.values());
        loadInCache(YesOrNoEnum.values());
        loadInCache(StatusEnum.values());
        loadInCache(GenderEnum.values());
        loadInCache(OperationStatusEnum.values());
        loadInCache(LoginStatusEnum.values());
        loadInCache(UserStatusEnum.values());
    }

    private static void loadInCache(DictionaryEnum[] dictionaryEnums) {
        DICTIONARY_CACHE.put(getDictionaryName(dictionaryEnums[0].getClass()), arrayToList(dictionaryEnums));
    }
    public static Map<String, List<DictionaryData>> dictionaryCache() {
        return DICTIONARY_CACHE;
    }
    private static String getDictionaryName(Class<?> clazz) {
        Objects.requireNonNull(clazz);
        Dictionary annotation = clazz.getAnnotation(Dictionary.class);

        Objects.requireNonNull(annotation);
        return annotation.name();
    }

    @SuppressWarnings("rawtypes")
    private static List<DictionaryData> arrayToList(DictionaryEnum[] dictionaryEnums) {
        if(ArrayUtil.isEmpty(dictionaryEnums)) {
            return ListUtil.empty();
        }
        return Arrays.stream(dictionaryEnums).map(DictionaryData::new).collect(Collectors.toList());
    }

}
