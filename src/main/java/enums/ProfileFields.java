package enums;

import lombok.Getter;

public enum ProfileFields {
    url("url"),
    protocol("protocol");

    @Getter
    private final String value;

    ProfileFields(String value) {
        this.value = value;
    }
}
