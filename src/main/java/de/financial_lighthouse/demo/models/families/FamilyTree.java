package de.financial_lighthouse.demo.models.families;

import java.util.ArrayList;
import java.util.List;

/**
 * 	Der Stammbaum eines Kunden.
 */
public class FamilyTree {

    private List<FamilyMember> members = new ArrayList<FamilyMember>();
    private List<Relationship> relationships = new ArrayList<Relationship>();

    /**
     * Die Familienmitglieder der Familie.
     */
    public List<FamilyMember> getMembers() {
        return members;
    }
    
    /**
     * Die Familienmitglieder der Familie.
     */
    public FamilyTree setMembers(List<FamilyMember> members) {
        this.members = members;
        return this;
    }

    /**
     * Die Beziehungen zwischen Familienmitgliedern.
     */
    public List<Relationship> getRelationships() {
        return relationships;
    }
    
    /**
     * Die Beziehungen zwischen Familienmitgliedern.
     */
    public FamilyTree setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
        return this;
    }
    
}
