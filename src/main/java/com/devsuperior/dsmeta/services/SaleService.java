package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.ReportDTO;
import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projection.SummaryProjection;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository repository;

    public SaleService(SaleRepository repository) {
        this.repository = repository;
    }

    public SaleMinDTO findById(Long id) {
        Optional<Sale> result = repository.findById(id);
        Sale entity = result.get();
        return new SaleMinDTO(entity);
    }

    public Page<List<ReportDTO>> findSalesReport(String minDate, String maxDate, String name, Pageable pageable) {
        LocalDate dateMax = dateMax(maxDate);
        LocalDate dateMin = dateMin(minDate, dateMax);
        return repository.findSalesReport(dateMin, dateMax, name, pageable);
    }

    public List<SummaryDTO> findSalesSummary(String minDate, String maxDate) {
        LocalDate dateMax = dateMax(maxDate);
        LocalDate dateMin = dateMin(minDate, dateMax);
        List<SummaryProjection> summaryProjections = repository.findSalesSummary(dateMin, dateMax);
        return summaryProjections.stream().map(SummaryDTO::new).toList();
    }

    private LocalDate dateMax(String maxDate) {
        if (maxDate == null || maxDate.isBlank()) {
            return LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        }
        return LocalDate.parse(maxDate);
    }

    private LocalDate dateMin(String minDate, LocalDate end) {
        if (minDate == null || minDate.isBlank()) {
            return end.minusYears(1L);
        }
        return LocalDate.parse(minDate);
    }
}