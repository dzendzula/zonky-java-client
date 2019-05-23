package org.zhezhela.zonky.dto.filter;

public class ZonkyFilterItem {

    private final String DELIMITER = "__";

    private ZonkyFieldName fieldName;
    private OperationalSuffix operationalSuffix;
    private String value;

    public String formFilterItemQuery() {
        if (fieldName == null || operationalSuffix == null) {
            return null;
        }
        return fieldName + DELIMITER + operationalSuffix;
    }

    public ZonkyFieldName getFieldName() {
        return fieldName;
    }

    public void setFieldName(ZonkyFieldName fieldName) {
        this.fieldName = fieldName;
    }

    public OperationalSuffix getOperationalSuffix() {
        return operationalSuffix;
    }

    public void setOperationalSuffix(OperationalSuffix operationalSuffix) {
        this.operationalSuffix = operationalSuffix;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public enum OperationalSuffix {
        CONTAINS("contains"),
        ICONTAINS("icontains"),
        STARTSWITH("startswith"),
        ISTARTSWITH("istartswith"),
        ENDSWITH("endswith"),
        IENDSWITH("iendswith"),
        IN("in", true),
        EQ("eq"),
        NOTEQ("noteq"),
        GT("gt"),
        GTE("gte"),
        GTEORNULL("gteornull"),
        LT("lt"),
        LTE("lte"),
        LTEORNULL("lteornull"),
        CONTAINSALL("containsall", true),
        CONTAINSANY("containsany", true);

        private final String code;
        private final boolean isList;

        private OperationalSuffix(String code) {
            this.code = code;
            this.isList = false;
        }

        private OperationalSuffix(String code, boolean isList) {
            this.code = code;
            this.isList = isList;
        }

        public String getCode() {
            return code;
        }

        public boolean isList() {
            return isList;
        }
    }

}
