package de.financial_lighthouse.demo.models.families;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Eine Familienbeziehung im {@link FamilyTree}.
 */
public class Relationship {
    
    @JsonProperty("member")
    private UUID member;
    @JsonProperty("is")
    private RelationshipType is = RelationshipType.Parent;
    @JsonProperty("of")
    private UUID of;

    /**
     * Der eindeutige Schlüssel eines Familienmitgliedes
     */
    public UUID getMember() {
        return member;
    }

    /**
     * Der eindeutige Schlüssel eines Familienmitgliedes
     */
    public Relationship setMember(UUID member) {
        this.member = member;
        return this;
    }

    /**
     * Der Typ der Beziehung
     */
    public RelationshipType getIs() {
        return is;
    }

    /**
     * Der Typ der Beziehung
     */
    public Relationship setIs(RelationshipType is) {
        this.is = is;
        return this;
    }

    /**
     * Der eindeutige Schlüssel des Familienmitglieds, zu dem die Beziehung besteht
     */
    public UUID getOf() {
        return of;
    }

    /**
     * Der eindeutige Schlüssel des Familienmitglieds, zu dem die Beziehung besteht
     */
    public Relationship setOf(UUID of) {
        this.of = of;
        return this;
    }


}
