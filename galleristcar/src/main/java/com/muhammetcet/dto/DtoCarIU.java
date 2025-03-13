package com.muhammetcet.dto;

import java.math.BigDecimal;

import com.muhammetcet.enums.CarStatusType;
import com.muhammetcet.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoCarIU {
    @NotBlank(message = "Plaka boş olamaz")
    private String plaka;

    @NotBlank(message = "Marka boş olamaz")
    private String brand;

    @NotBlank(message = "Model boş olamaz")
    private String model;

    @NotNull(message = "Üretim yılı boş olamaz")
    @Min(value = 1886, message = "Geçerli bir üretim yılı giriniz") // İlk araba 1886'da üretildi
    private Integer productionYear;

    @NotNull(message = "Fiyat boş olamaz")
    @DecimalMin(value = "0.0", inclusive = false, message = "Fiyat 0'dan büyük olmalıdır")
    private BigDecimal price;

    @NotNull(message = "Para birimi boş olamaz")
    private CurrencyType currencyType;

    @NotNull(message = "Hasar fiyatı boş olamaz")
    @DecimalMin(value = "0.0", inclusive = true, message = "Hasar fiyatı negatif olamaz")
    private BigDecimal damagePrice;

    @NotNull(message = "Araba durumu boş olamaz")
    private CarStatusType carStatusType;
    
    @Override
    public String toString() {
        return "DtoCarIU{" +
                "plaka='" + plaka + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", price=" + price +
                ", currencyType=" + currencyType +
                ", damagePrice=" + damagePrice +
                ", carStatusType=" + carStatusType +
                '}';

    }
}
