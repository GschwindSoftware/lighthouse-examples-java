// Copyright 2020 🔵🔵🔴🔵 Gschwind Software GmbH All rights reserved.
// Licensed under the Apache License, Version 2.0. See LICENSE file.

package de.financial_lighthouse.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.HttpClientErrorException;

import de.financial_lighthouse.demo.models.clients.*;
import de.financial_lighthouse.demo.models.plans.*;
import de.financial_lighthouse.demo.models.reports.*;
import de.financial_lighthouse.demo.util.Dates;

@SpringBootApplication
public class Main implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    /**
     * Zugangsdaten, siehe src/main/resources/application.yml
     */
    @Bean
    @ConfigurationProperties("config.oauth2.client")
    protected ClientCredentialsResourceDetails resourceDetails() {
        return new ClientCredentialsResourceDetails();
    }

    /**
     * Hauptattraktion
     */
    @Override
    public void run(String... args) throws Exception {
        // Zugriff auf die API
        var api = new LighthouseClient(resourceDetails());

        try {
            // Ein beratener Kunde
            var clientID = api.createClient(new Client("Max Mustermann")
                .setBirthday(LocalDateTime.of(1970, 1, 1, 0, 0, 0))
            );

            logger.info(String.format("Kunde %s angelegt", clientID));

            // Eine Finanzplanung für diesen Kunden
            var planID = api.createPlan(clientID, new Plan()
                .setDescription("Testplan Mustermann")
            );

            logger.info(String.format("Plan %d angelegt", planID));

            // Den Status Quo des Kunden im Finanzplan erfassen
            List.of(
                ExampleData.income(),
                ExampleData.expenses(),
                ExampleData.investment(),
                ExampleData.property()
            ).parallelStream().forEach(d -> {
                try {
                    var planDataID = api.createPlanData(planID, d);
                    logger.info(String.format("Vorgang %s angelegt", planDataID));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });

            api.updateFamily(planID, ExampleData.family());
            logger.info("Familienstammbaum erfasst");

            // Eine Finanzauswertung abrufen
            var reportParams = new DateReportParameters().setEndDate(Dates.yearsFromNow(5));
            var reportType = LiquidityReportType.Liquidity;
            var report = api.generateLiquidityReport(reportType, planID, reportParams);
            printReport(reportType, report);

            // Aufräumen
            api.deletePlan(planID);
            logger.info("Plan gelöscht");
            api.deleteClient(clientID);
            logger.info("Kunde gelöscht");
        } catch (HttpClientErrorException e) {
            System.out.println(e.getResponseBodyAsString());
        }
    }

    // #region Ausgabe von Finanzauswertungen

    private void printReport(LiquidityReportType type, Report report) {
        System.out.print(padRight("Report: " + type.toString(), 30));
        for (var c : report.getCategories())
            System.out.print(padRight(c.getName(), 18));

        System.out.println();
        System.out.println();

        for (var s : report.getSeries())
            printSeries(s, 0);
    }

    private void printSeries(HierarchicalDataSeries series, int level) {
        System.out.print(padRight(" ".repeat(level * 2) + series.getTitle(), 30));

        for (var d : series.getData())
            System.out.print(padRight(String.format("%.2f €", d), 18));

        System.out.println();

        for (var s : series.getSeries())
            printSeries(s, level + 1);
    }

    private String padRight(String s, int length) {
        if (s.length() > length)
            s = String.format("%s...", s.substring(0, length - 3));

        return String.format("%1$-" + length + "s", s);
    }

    // #endregion

}
