package org.zhezhela.zonky.dto.filter;

public class ZonkySortItem {

    private ZonkyFieldName fieldName;
    private SortDirection direction;


    public String formSortParam() {
        return getDirection().getCode() + getFieldName();
    }

    public enum SortDirection {
        ASC(""),
        DESC("-");

        private final String code;

        private SortDirection(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }


    public ZonkyFieldName getFieldName() {
        return fieldName;
    }

    public void setFieldName(ZonkyFieldName fieldName) {
        this.fieldName = fieldName;
    }

    public SortDirection getDirection() {
        return direction;
    }

    public void setDirection(SortDirection direction) {
        this.direction = direction;
    }
}
