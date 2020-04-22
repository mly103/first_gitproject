package com.mly.demodev.test1.constant;

public enum OperationType {
    /**添加*/
    CREATE(HisConstant.OPERATION_CREATE),
    /**更新*/
    UPDATE(HisConstant.OPERATION_UPDATE),
    /**删除*/
    DELETE(HisConstant.OPERATION_DELETE);

    private final String type;

    OperationType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
