package ru.stazaev.service.impl;

import de.jollyday.HolidayCalendar;
import de.jollyday.HolidayManager;
import org.springframework.stereotype.Service;
import ru.stazaev.service.VacationCounter;

import java.time.LocalDate;

@Service
public class VacationCounterImpl implements VacationCounter {
    @Override
    public double countVacationPayment(double salary, int vacation, LocalDate startDate, LocalDate endDate) {
        if (startDate == null || endDate == null) {
            return getVacationPay(salary, vacation);
        }
        if (vacation != (endDate.compareTo(startDate) + 1)) {
            throw new RuntimeException("Проверьте введенные данные, даты не совпадают с колличеством дней отпуска");
        }
        HolidayManager manager = HolidayManager.getInstance(HolidayCalendar.RUSSIA);
        int officialHolidays = manager.getHolidays(startDate, endDate)
                .size();
        vacation = vacation - officialHolidays;
        return getVacationPay(salary, vacation);
    }

    private double getVacationPay(double salary, int vacation) {
        double averageDaily = salary / 29.3;
        return averageDaily * vacation;
    }
}
