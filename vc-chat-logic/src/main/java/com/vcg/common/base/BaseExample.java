package com.vcg.common.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseExample<Q, C> implements Serializable {

    private static final long serialVersionUID = 99999L;

    public final String UNDERLINE = "_";

    private List<String> fields;

    private List<String> columns;

    private List<Integer> limit;

    public void setFields(List<String> fields) {
        if (fields == null) {
            return;
        }
        List<String> columns = new ArrayList<String>();
        for (String column : fields) {
            String field = toUnderlineCase(column);
            columns.add(field);
        }
        this.fields = columns;
    }

    public Q withFields(String... fields) {
        setFields(Arrays.asList(fields));
        return (Q) this;
    }

    public Q withFields(List<String> fields) {
        setFields(fields);
        return (Q) this;
    }

    public void setColumns(List<String> columns) {
        this.fields = columns;
    }

    public Q excludeFields(String... fields) {
        for (String filed : fields) {
            getFields().remove(filed);
        }
        return (Q) this;
    }

    public Q withColumns(String... column) {
        setColumns(Arrays.asList(column));
        return (Q) this;
    }

    public Q withColumns(List<String> columns) {
        setColumns(columns);
        return (Q) this;
    }

    private String toUnderlineCase(String camelCaseStr) {
        if (camelCaseStr == null) {
            return null;
        }

        final int length = camelCaseStr.length();
        StringBuilder sb = new StringBuilder();
        char c;
        boolean isPreUpperCase = false;
        for (int i = 0; i < length; i++) {
            c = camelCaseStr.charAt(i);
            boolean isNextUpperCase = true;
            if (i < (length - 1)) {
                isNextUpperCase = Character.isUpperCase(camelCaseStr.charAt(i + 1));
            }
            if (Character.isUpperCase(c)) {
                if (!isPreUpperCase || !isNextUpperCase) {
                    if (i > 0)
                        sb.append(UNDERLINE);
                }
                isPreUpperCase = true;
            } else {
                isPreUpperCase = false;
            }
            sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }

    public void setLimit(List<Integer> limit) {
        this.limit = limit;
    }

    public Q withLimit(Integer... limit) {
        setLimit(Arrays.asList(limit));
        return (Q) this;
    }

    public Q withLimit(List<Integer> limit) {
        setLimit(limit);
        return (Q) this;
    }

    public Q withOrderByClause(String orderByClause){
        setOrderByClause(orderByClause);
        return (Q) this;
    }

    public void setOrderByClause(String orderByClause) {

    }

    public Q addCriteria(C c) {
        getOredCriteria().add(c);
        return (Q) this;
    }

    public Q addOrCriteria(C c) {
        return addCriteria(c);
    }

    public C createCriteria() {
        return null;
    }

    public List<C> getOredCriteria() {
        return new ArrayList<>();
    }


    public List<String> getFields() {
        return fields;
    }

}
