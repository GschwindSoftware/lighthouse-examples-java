package de.financial_lighthouse.demo.models.families;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.lang.Nullable;

import de.financial_lighthouse.demo.models.HasId;

/**
 * Ein Familienmitglied im {@link FamilyTree}.
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, property = "type", defaultImpl = Relative.class)
@JsonSubTypes({
    @JsonSubTypes.Type(value = ClientF.class, name = ClientF.TYPENAME),
    @JsonSubTypes.Type(value = Partner.class, name = Partner.TYPENAME),
    @JsonSubTypes.Type(value = Child.class, name = Child.TYPENAME)
})
public abstract class FamilyMember extends HasId<UUID> {

    @JsonProperty("birthDay")
    protected LocalDateTime birthDay;
    @JsonProperty("firstName")
    protected String firstName;
    @JsonProperty("gender")
    protected Gender gender = Gender.Male;
    @JsonProperty("isDead")
    protected boolean isDead;
    @JsonProperty("lastName")
    protected String lastName;
    @JsonProperty("liveInFamilyResidetial")
    protected boolean livesInFamilyResidetial;
    @JsonProperty("mandatoryPartialWaiver")
    protected boolean mandatoryPartialWaiver;
    @JsonProperty("title")
    protected String title;

    /**
     * Der Geburtstag der Person.
     */
    public LocalDateTime getBirthDay() {
        return birthDay;
    }

    /**
     * Der Geburtstag der Person.
     */
    public FamilyMember setBirthDay(LocalDateTime birthDay) {
        this.birthDay = birthDay;
        return this;
    }

    /**
     * Der Vorname der Person.
     */
    public @Nullable String getFirstName() {
        return firstName;
    }

    /**
     * Der Vorname der Person.
     */
    public FamilyMember setFirstName(@Nullable String firstName) {
        this.firstName = firstName;
        return this;
    }

    /**
     * Das Geschlecht der Person.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Das Geschlecht der Person.
     */
    public FamilyMember setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    /**
     * Falls <code>true</code>, ist die Person verstorben.
     */
    public boolean getIsDead() {
        return isDead;
    }

    /**
     * Falls <code>true</code>, ist die Person verstorben.
     */
    public FamilyMember setIsDead(boolean isDead) {
        this.isDead = isDead;
        return this;
    }

    /**
     * Der Nachname der Person.
     */
    public @Nullable String getLastName() {
        return lastName;
    }

    /**
     * Der Nachname der Person.
     */
    public FamilyMember setLastName(@Nullable String lastName) {
        this.lastName = lastName;
        return this;
    }

    /**
     * Falls <code>true</code>, bewohnt die Person das Haupt-Familienwohnheim.
     */
    public boolean getLivesInFamilyResidetial() {
        return livesInFamilyResidetial;
    }

    /**
     * Falls <code>true</code>, bewohnt die Person das Haupt-Familienwohnheim.
     */
    public FamilyMember setLivesInFamilyResidetial(boolean livesInFamilyResidetial) {
        this.livesInFamilyResidetial = livesInFamilyResidetial;
        return this;
    }

    /**
     * Falls <code>true</code>, liegt ein Pflichtteilsverzicht vor.
     */
    public boolean getMandatoryPartialWaiver() {
        return mandatoryPartialWaiver;
    }

    /**
     * Falls <code>true</code>, liegt ein Pflichtteilsverzicht vor.
     */
    public FamilyMember setMandatoryPartialWaiver(boolean mandatoryPartialWaiver) {
        this.mandatoryPartialWaiver = mandatoryPartialWaiver;
        return this;
    }

    /**
     * Der Titel der Person, z.B. ein akademischer Titel.
     */
    public @Nullable String getTitle() {
        return title;
    }

    /**
     * Der Titel der Person, z.B. ein akademischer Titel.
     */
    public FamilyMember setTitle(@Nullable String title) {
        this.title = title;
        return this;
    }

    public FamilyMember() {
        id = UUID.randomUUID();
    }

    /**
     * Gibt eine {@link Relationship} zurück, in der dieses {@link FamilyMember} Kind des übergebenen {@link FamilyMember} ist.
     * @param parent Der Elternteil.
     * @return Die erzeugte {@link Relationship}.
     */
    public Relationship isChildOf(FamilyMember parent) {
        return new Relationship()
            .setMember(getID())
            .setIs(RelationshipType.Child)
            .setOf(parent.getID());
    }

    /**
     * Gibt eine {@link Relationship} zurück, in der dieses {@link FamilyMember} Kind der übergebenen {@link FamilyMember} ist.
     * @param parent1 Der erste Elternteil.
     * @param parent2 Der zweite Elternteil.
     * @return Die erzeugte {@link Relationship}.
     */
    public List<Relationship> isChildOf(FamilyMember parent1, FamilyMember parent2) {
        return List.of(isChildOf(parent1), isChildOf(parent2));
    }

    /**
     * Gibt eine {@link Relationship} zurück, in der dieses {@link FamilyMember} Lebenspartner des übergebenen {@link FamilyMember} ist.
     * @param parent Der Lebenspartner.
     * @return Die erzeugte {@link Relationship}.
     */
    public Relationship isPartnerOf(FamilyMember partner) {
        return new Relationship()
            .setMember(getID())
            .setIs(RelationshipType.Partner)
            .setOf(partner.getID());
    }

    /**
     * Gibt eine {@link Relationship} zurück, in der dieses {@link FamilyMember} Elternteil des übergebenen {@link FamilyMember} ist.
     * @param parent Das Kind.
     * @return Die erzeugte {@link Relationship}.
     */
    public Relationship isParentOf(FamilyMember child) {
        return new Relationship()
            .setMember(getID())
            .setIs(RelationshipType.Parent)
            .setOf(child.getID());
    }

}
