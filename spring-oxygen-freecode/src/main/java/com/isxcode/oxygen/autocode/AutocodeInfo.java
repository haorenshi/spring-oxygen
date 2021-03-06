package com.isxcode.oxygen.autocode;

import com.isxcode.oxygen.autocode.model.TableColumnInfo;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 给freemarker配置的文件
 *
 * @author ispong
 * @version v0.1.0
 */
@Data
public class AutocodeInfo {

    /**
     * 数据库字段列表
     */
    private List<TableColumnInfo> fieldList;

    /**
     * 数据库备注
     */
    private String tableComment;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 需要导入的包
     */
    private List<String> importPackages;

    /**
     * 基础类
     */
    private Map<String, String> baseClassList;

    /**
     * 类名
     */
    private String className;

    /**
     * 文件路劲集合
     */
    private AutocodeProperties autoCodeProperties;

    /**
     * 文件类型
     */
    private String fileType;

}
