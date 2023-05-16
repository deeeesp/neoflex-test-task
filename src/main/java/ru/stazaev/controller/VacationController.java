package ru.stazaev.controller;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.stazaev.service.VacationCounter;

import java.time.LocalDate;

@RequiredArgsConstructor
@RestController
public class VacationController {

    private final VacationCounter vacationCounter;

    @GetMapping("/calculate")
    public double countVacationPay(
            @RequestParam("salary") double salary,
            @RequestParam("vacation") int vacation,
            @RequestParam("start_date") @Nullable LocalDate startDate,
            @RequestParam("end_date") @Nullable LocalDate endDate) {
        return vacationCounter.countVacationPayment(salary, vacation, startDate, endDate);
    }
}
