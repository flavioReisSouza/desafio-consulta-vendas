package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.projection.SaleMinProjection;

import java.time.LocalDate;

public class SaleMinDTO {

    private Long id;
    private Double amount;
    private LocalDate date;

    public SaleMinDTO(Sale entity) {
        id = entity.getId();
        amount = entity.getAmount();
        date = entity.getDate();
    }

    public SaleMinDTO(Long id, Double amount, LocalDate date, String sellerName) {
        this.id = id;
        this.amount = amount;
        this.date = date;
    }

    public SaleMinDTO(SaleMinProjection projection) {
        id = projection.getId();
        amount = projection.getAmount();
        date = projection.getDate();
    }

    public Long getId() {
        return id;
    }

    public Double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SaleMinDTO{");
        sb.append(String.format("id=%d, ", id));
        sb.append(String.format("amount=%.2f, ", amount));
        sb.append(String.format("date=%s", date));
        sb.append('}');
        return sb.toString();
    }
}
