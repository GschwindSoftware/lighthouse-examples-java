package de.financial_lighthouse.demo.models.families;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 * Ein sonstiger Verwandter im {@link FamilyTree}.
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type")
public class Relative extends FamilyMember {
    
    protected static final String TYPENAME = "Relative";

    public Relative() { }

    public Relative(String fullName) {
        this();
        var split = fullName.split(" ", 2);
        firstName = split[0];
        lastName = split[1];
    }

}
