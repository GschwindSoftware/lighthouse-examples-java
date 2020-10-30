package de.financial_lighthouse.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.financial_lighthouse.demo.models.data.*;
import de.financial_lighthouse.demo.models.families.*;
import de.financial_lighthouse.demo.util.Dates;

/**
 * Beispieldaten
 */
public final class ExampleData {

    /**
     * Beispielhafte Familie: Vater, Mutter, zwei Kinder
     */
    public static FamilyTree family() {
        var members = Map.of(
            "client", new ClientF("Max Mustermann")
                .setIsMarried(true)
                .setBirthDay(LocalDateTime.of(1970, 1, 1, 0, 0, 0))
                .setGender(Gender.Female),
            "spouse", new Partner("Hilde Mustermann")
                .setGender(Gender.Female),
            "son", new Child("Hans Mustermann")
                .setGender(Gender.Male),
            "daughter", new Child("Sophie Mustermann")
                .setGender(Gender.Female)
        );

        return new FamilyTree()
            .setMembers(new ArrayList<>(members.values()))
            .setRelationships(List.of(
                members.get("spouse").isPartnerOf(members.get("client")),
                members.get("son").isChildOf(members.get("client")),
                members.get("son").isChildOf(members.get("spouse")),
                members.get("daughter").isChildOf(members.get("client")),
                members.get("daughter").isChildOf(members.get("spouse"))
            ));
    }

    /**
     * Beispielhafte Einkunft aus nichtselbständiger Arbeit
     */
    public static PlanData income() {
        return new EmployedIncome()
            // Gehälter
            .setCashFlows(new CashFlows()
                // Monatlich 4000 €
                .setPeriod(PeriodType.Monthly)
                .setValues(List.of(new CashFlow()
                    .setDate(Dates.startOfYear())
                    .setValue(4000)
                ))
                // 2%-ige Steigerung in einem Jahr
                .setIncreases(List.of(new CashFlow()
                    .setDate(Dates.yearsFromNow(1))
                    .setValue(2)
                ))
            )
            // Ende der Beschäftigung bei Renenteintritt mit 65
            .setTermination(Moment.AtRetirement(65))
            .setName("Beratertätigkeit");
    }

    /**
     * Beispielhafte Lebensunterhaltskosten
     */
    public static PlanData expenses() {
        return new LivingCosts()
            .setCashFlows(new CashFlows()
                .setPeriod(PeriodType.Yearly)
                // Jährliche Ausgaben von 1800 €
                .setValues(List.of(new CashFlow()
                    .setDate(Dates.startOfYear())
                    .setValue(1800)
                ))
                // Jährliche Steigerung um 3%
                .setIncreases(List.of(new CashFlow()
                    .setDate(Dates.startOfYear())
                    .setValue(3)
                ))
            )
            .setTermination(Moment.Never())
            .setName("Lebensunterhaltskosten");
    }

    /**
     * Beispielhaftes Wertpapierdepot
     */
    public static PlanData investment() {
        var deposit = new Deposit()
            // Depotkonto
            .setInstitute("Deutsche Bank")
            .setAccountNumber("DE26 5007 0010 1234 5678 90")
            // Geplanter Verkauf
            .setSale(new Sale()
                .setMoment(Moment.Never())
            )
            // Depotinhalt
            .setSecurities(List.of(
                // 📈 Aktienfonds
                new Security()
                    .setSecurityType(SecurityType.StockFunds)
                    .setValueDate(Dates.startOfYear())
                    // 50 Stück à 255 €
                    .setQuantity(50)
                    .setSecurityPrice(255)
                    // Wertsteigerung von 4%
                    .setAppreciations(List.of(new CashFlow()
                        .setDate(Dates.startOfYear())
                        .setValue(4)
                    ))
                    // Geplanter Verkauf
                    .setSale(new Sale()
                        .setMoment(Moment.Never())
                    )
                // 📈 Rentenfonds
                ,new Security()
                    .setSecurityType(SecurityType.BondFunds)
                    .setValueDate(Dates.startOfYear())
                    // 23 Stück à 231 €
                    .setQuantity(23)
                    .setSecurityPrice(231)
                    // Dividendenausschüttungen
                    .setDividends(List.of(new CashFlow()
                        .setDate(Dates.startOfYear())
                        .setValue(2)
                    ))
                    .setDividendPayout(Dates.endOfYear())
            ));

        deposit.setName("Depot Deutsche Bank");
        deposit.getSecurities().get(0).setName("Investmentfonds 1");
        deposit.getSecurities().get(0).setName("Investmentfonds 2");

        return deposit;
    }

    /**
     * Beispielhafte, eigengenutzte Immobilie
     */
    public static PlanData property() {
        return new OwnerProperty()
            .setName("Villa Mustermann");
    }
    
}
