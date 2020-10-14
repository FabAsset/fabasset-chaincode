package com.github.fabasset.chaincode.util;

import com.github.fabasset.chaincode.constant.DataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataTypeConversion {
    private static final String EMPTY_LIST = "[]";

    private DataTypeConversion() {}

    public static Object strToDataType(String dataType, String value) {
        switch (dataType) {
            case DataType.BYTE:
                return Byte.parseByte(value);

            case DataType.SHORT:
                return Short.parseShort(value);

            case DataType.INTEGER:
                return Integer.parseInt(value);

            case DataType.LONG:
                return Long.parseLong(value);

            case DataType.FLOAT:
                return Float.parseFloat(value);

            case DataType.DOUBLE:
                return Double.parseDouble(value);

            case DataType.BOOLEAN:
                return Boolean.parseBoolean(value);

            case DataType.CHARACTER:
                return value.charAt(0);

            case DataType.STRING:
                return value;

            case DataType.LIST_BYTE:
                return toListByte(value);

            case DataType.LIST_SHORT:
                return toListShort(value);

            case DataType.LIST_INTEGER:
                return toListInteger(value);

            case DataType.LIST_LONG:
                return toListLong(value);

            case DataType.LIST_FLOAT:
                return toListFloat(value);

            case DataType.LIST_DOUBLE:
                return toListDouble(value);

            case DataType.LIST_BOOLEAN:
                return toListBoolean(value);

            case DataType.LIST_CHARACTER:
                return toListCharacter(value);

            case DataType.LIST_STRING:
                return toListString(value);

            default:
                return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static String dataTypeToStr(String dataType, Object value) {
        switch (dataType) {
            case DataType.BYTE:
                return Byte.toString((byte) value);

            case DataType.SHORT:
                return Short.toString((short) value);

            case DataType.INTEGER:
                return Integer.toString((int) value);

            case DataType.LONG:
                return Long.toString((long) value);

            case DataType.FLOAT:
                return Float.toString((float) value);

            case DataType.DOUBLE:
                return Double.toString((double) value);

            case DataType.BOOLEAN:
                return Boolean.toString((boolean) value);

            case DataType.CHARACTER:
                return Character.toString((char) value);

            case DataType.STRING:
                return (String) value;

            case DataType.LIST_BYTE:
                List<Byte> bytes = (List<Byte>) value;
                return bytes != null ? bytes.toString() : null;

            case DataType.LIST_SHORT:
                List<Short> shorts = (List<Short>) value;
                return shorts != null ? shorts.toString() : null;

            case DataType.LIST_INTEGER:
                List<Integer> integers = (List<Integer>) value;
                return integers != null ? integers.toString() : null;

            case DataType.LIST_LONG:
                List<Long> longs = (List<Long>) value;
                return longs != null ? longs.toString() : null;

            case DataType.LIST_FLOAT:
                List<Float> floats = (List<Float>) value;
                return floats != null ? floats.toString() : null;

            case DataType.LIST_DOUBLE:
                List<Double> doubles = (List<Double>) value;
                return doubles != null ? doubles.toString() : null;

            case DataType.LIST_BOOLEAN:
                List<Boolean> booleans = (List<Boolean>) value;
                return booleans != null ? booleans.toString() : null;

            case DataType.LIST_CHARACTER:
                List<Character> characters = (List<Character>) value;
                return characters != null ? characters.toString() : null;

            case DataType.LIST_STRING:
                List<String> strings = (List<String>) value;
                return strings != null ? strings.toString() : null;

            default:
                return null;
        }
    }

    private static List<Byte> toListByte(String value) {
        List<Byte> bytes = new ArrayList<>();
        if (value == null || value.equals(EMPTY_LIST)) {
            return bytes;
        }

        List<String> strings = toList(value);
        for (String string : strings) {
            bytes.add(Byte.parseByte(string));
        }

        return bytes;
    }

    private static List<Short> toListShort(String value) {
        List<Short> shorts = new ArrayList<>();
        if (value == null || value.equals(EMPTY_LIST)) {
            return shorts;
        }

        List<String> strings = toList(value);
        for (String string : strings) {
            shorts.add(Short.parseShort(string));
        }

        return shorts;
    }

    private static List<Integer> toListInteger(String value) {
        List<Integer> integers = new ArrayList<>();
        if (value == null || value.equals(EMPTY_LIST)) {
            return integers;
        }

        List<String> strings = toList(value);
        for (String string : strings) {
            integers.add(Integer.parseInt(string));
        }

        return integers;
    }

    private static List<Long> toListLong(String value) {
        List<Long> longs = new ArrayList<>();
        if (value == null || value.equals(EMPTY_LIST)) {
            return longs;
        }

        List<String> strings = toList(value);
        for (String string : strings) {
            longs.add(Long.parseLong(string));
        }

        return longs;
    }

    private static List<Float> toListFloat(String value) {
        List<Float> floats = new ArrayList<>();
        if (value == null || value.equals(EMPTY_LIST)) {
            return floats;
        }

        List<String> strings = toList(value);
        for (String string : strings) {
            floats.add(Float.parseFloat(string));
        }

        return floats;
    }

    private static List<Double> toListDouble(String value) {
        List<Double> doubles = new ArrayList<>();
        if (value == null || value.equals(EMPTY_LIST)) {
            return doubles;
        }

        List<String> strings = toList(value);
        for (String string : strings) {
            doubles.add(Double.parseDouble(string));
        }

        return doubles;
    }

    private static List<Boolean> toListBoolean(String value) {
        List<Boolean> booleans = new ArrayList<>();
        if (value == null || value.equals(EMPTY_LIST)) {
            return booleans;
        }

        List<String> strings = toList(value);
        for (String string : strings) {
            booleans.add(Boolean.parseBoolean(string));
        }

        return booleans;
    }

    private static List<Character> toListCharacter(String value) {
        List<Character> characters = new ArrayList<>();
        if (value == null || value.equals(EMPTY_LIST)) {
            return characters;
        }

        List<String> strings = toList(value);
        for (String string : strings) {
            characters.add(string.charAt(0));
        }

        return characters;
    }

    private static List<String> toListString(String value) {
        List<String> strings = new ArrayList<>();
        if (value == null || value.equals(EMPTY_LIST)) {
            return strings;
        }

        strings = toList(value);
        return strings;
    }

    private static List<String> toList(String value) {
        return Arrays.asList(value.substring(1, value.length() - 1).split(", "));
    }
}
