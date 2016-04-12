package com.goit.gojavaonline.core.offline.offline4;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.AbstractList;
import java.util.List;
import java.util.Map;

public class JsonConverter {

    private final JsonFactory jsonFactory = new JsonFactory();
    private final ObjectMapper objectMapper;

    public JsonConverter() {
        objectMapper = new ObjectMapper();
    }

    public String convertToJson(Object object) {
        StringBuilder sb = new StringBuilder();
        appendObject(object,sb);
        return sb.toString();
    }

    private void appendObject(Object object,  StringBuilder sb) {
        boolean isEmpty = true;
        Class<?> aClass = object.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        sb.append("{");
        for (Field field : declaredFields) {
            if(field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                String name = annotation.value();
                Object value = getValue(object, field);

                if(value!=null) {
                    sb.append("\"");
                    sb.append(name);
                    sb.append("\":");
                    appendValue(sb, value);
                    sb.append(",");
                    isEmpty = false;
                }
            }
        }
        if (!isEmpty) sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
    }

    private void appendValue(StringBuilder sb, Object value) {
        if(isString(value)){
            appendString(sb, value);
        }else if(isNumber(value)) {
            appendNumber(sb, value);
        } else if(isList(value)) {
            appendList(sb, (List) value);
        } else {
            appendObject(value, sb);
        }
    }

    private void appendNumber(StringBuilder sb, Object value) {
        sb.append(value);
    }

    private void appendString(StringBuilder sb, Object value) {
        sb.append("\"");
        sb.append(value);
        sb.append("\"");
    }

    private void appendList(StringBuilder sb, List value) {
        sb.append("[");
        List list = value;
        for (Object listElement : list) {
            appendValue(sb, listElement);
            sb.append(",");
        }
        if (list.size() > 0) sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
    }

    private boolean isList(Object value) {
        return value.getClass().getSuperclass() == AbstractList.class;
    }

    private boolean isNumber(Object value) {
        return value.getClass()==Integer.class;
    }

    private boolean isString(Object value) {
        return value.getClass()==String.class;
    }

    @SuppressWarnings("unchecked")
    public <T> T parseJson(String jsonAsString, Class<T> aClass) {
        Map<String, Object> json = parseJsonToMap(jsonAsString);

        Object object = createAnObject(aClass);

        for (Field field : aClass.getDeclaredFields()) {
            if(field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                String name = annotation.value();
                Object value = json.get(name);
                if (value != null) {
                    setField(object, field, value);
                }
            }
        }

        return (T)object;
    }

    private Map parseJsonToMap(String jsonAsString) {
        try {
            return objectMapper.readValue(jsonAsString, Map.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setField(Object object, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(object, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private Object createAnObject(Class<?> aClass) {
        try {
            return aClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private Object getValue(Object object, Field field) {
        try {
            field.setAccessible(true);
            return field.get(object);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
