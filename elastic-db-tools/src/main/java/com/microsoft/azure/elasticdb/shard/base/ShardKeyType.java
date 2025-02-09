package com.microsoft.azure.elasticdb.shard.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * Elastic database tools for Azure SQL Database.
 * 
 * Copyright(c) Microsoft Corporation All rights reserved.
 * 
 * This program is made available under the terms of the MIT License. See the LICENSE file in the project root for more information.
 */

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

import com.microsoft.azure.elasticdb.core.commons.helpers.EnumHelpers;
import com.microsoft.azure.elasticdb.core.commons.helpers.MappableEnum;

/**
 * Type of shard key. Currently, only Int32, Int64, Guid and byte[] are the data types supported as shard keys.
 */
@XmlEnum
public enum ShardKeyType implements MappableEnum{
    /**
     * No type specified.
     */
    @XmlEnumValue("0")
    None(0, 0),

    /**
     * 32-bit integral value.
     */
    @XmlEnumValue("1")
    Int32(1, Integer.BYTES),

    /**
     * 64-bit integral value.
     */
    @XmlEnumValue("2")
    Int64(2, Long.BYTES),

    /**
     * UniqueIdentifier value.
     */
    @XmlEnumValue("3")
    Guid(3, ShardKey.SIZE_OF_GUID),

    /**
     * Array of bytes value.
     */
    @XmlEnumValue("4")
    Binary(4, ShardKey.MAXIMUM_VAR_BYTES_KEY_SIZE),

    /**
     * Date and time value.
     */
    @XmlEnumValue("5")
    DateTime(5, Long.BYTES),

    /**
     * Time value.
     */
    @XmlEnumValue("6")
    TimeSpan(6, Long.BYTES),

    /**
     * Date and time value with offset.
     */
    @XmlEnumValue("7")
    DateTimeOffset(7, ShardKey.SIZE_OF_DATE_TIME_OFFSET);

    private static final Map<Integer, ShardKeyType> mappings = EnumHelpers.createMap(ShardKeyType.class);
    
    private int intValue;
    private int expectedByteArrayLength;

    ShardKeyType(int value,
            int expectedByteArrayLength) {
        intValue = value;
        this.expectedByteArrayLength = expectedByteArrayLength;
    }

    public static ShardKeyType forValue(int value) {
        return mappings.get(value);
    }

    @Override
    public int getValue() {
        return intValue;
    }

    public int getByteArraySize() {
        return expectedByteArrayLength;
    }
}
