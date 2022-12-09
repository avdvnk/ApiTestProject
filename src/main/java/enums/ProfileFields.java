package enums;

import lombok.Getter;

/**
 * Enum with necessary fields in profile for customization test runs
 */
public enum ProfileFields {
    url("url"),
    protocol("protocol");

    @Getter
    private final String value;

    ProfileFields(String value) {
        this.value = value;
    }
}
