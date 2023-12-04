package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.projection.SummaryProjection;

public class SummaryDTO {

    private String sellerName;
    private Double sum;

    public SummaryDTO() {
    }

    public SummaryDTO(String sellerName, Double sum) {
        this.sellerName = sellerName;
        this.sum = sum;
    }

    public SummaryDTO(SummaryProjection projection) {
        sellerName = projection.getSellerName();
        sum = projection.getSum();
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }
}
