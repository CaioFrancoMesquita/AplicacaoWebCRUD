package com.lab.mvc.springbootlist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto é obrigatório")
    @Size(max = 60, message = "O nome do produto deve ter no máximo 60 caracteres")
    @Column(name = "nome", nullable = false, length = 60)
    private String nome;

    @NotBlank(message = "O nome da marca do produto é obrigatório.")
    @Size(min = 2, message = "O nome da marca deve ter no mínimo 2 caracteres.")
    @Column(name = "marca", nullable = false, length = 45)
    private String marca;

    @NotBlank(message = "O nome do país onde foi fabricado é obrigatório")
    @Size(min = 5, message = "O nome do país deve ter no mínimo 5 caracteres")
    @Column(name = "pais_fabricacao", nullable = false, length = 60)
    private String paisFabricacao;

    @NumberFormat(style = NumberFormat.Style.CURRENCY, pattern = "#,##0.00")
    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;
}
