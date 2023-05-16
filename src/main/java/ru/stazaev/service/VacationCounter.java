package ru.stazaev.service;

import java.time.LocalDate;

public interface VacationCounter {
    double countVacationPayment(double salary, int vacation, LocalDate startDate, LocalDate endDate);
}
