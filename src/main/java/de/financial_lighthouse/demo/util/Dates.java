package de.financial_lighthouse.demo.util;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * Hilfesmethoden für ein Datum.
 */
public final class Dates {

    /**
     * Gibt den jetztigen Zeitpunkt zurück.
     * @return Der jetztige Zeitpunkt.
     */
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    /**
     * Gibt den Anfang des aktuellen Jahres zurück.
     * @return Der Anfang des aktuellen Jahres.
     */
    public static LocalDateTime startOfYear() {
        return LocalDateTime.now()
            .withDayOfYear(1)
            .withHour(0)
            .withMinute(0)
            .withSecond(0)
            .withNano(0);
    }

    /**
     * Gibt das Ende des aktuellen Jahres zurück.
     * @return Das Ende des aktuellen Jahres.
     */
    public static LocalDateTime endOfYear() {
        return LocalDateTime.now()
            .with(TemporalAdjusters.lastDayOfYear())
            .withHour(0)
            .withMinute(0)
            .withSecond(0)
            .withNano(0);
    }

    /**
     * Gibt den jetztigen Zeitpunkt plus n Jahre zurück.
     * @param yearsFromNow DIe Anzahl der Jahre.
     * @return Der jetztige Zeitpunkt plus die übergebene Anzahl von Jahren.
     */
    public static LocalDateTime yearsFromNow(int yearsFromNow) {
        return LocalDateTime.now().plusYears(yearsFromNow);
    }

    /**
     * Gibt das aktuelle Jahr zurück.
     * @return Das aktuelle Jahr.
     */
    public static int currentYear() {
        return LocalDateTime.now().getYear();
    }

}
