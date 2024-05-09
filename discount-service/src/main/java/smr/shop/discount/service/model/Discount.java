package smr.shop.discount.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import smr.shop.discount.service.model.valueobject.DiscountType;

import java.time.ZonedDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Discount {
    @Id
    private Long id;

    private Long productId;

    private DiscountType type;

    private Float percent;

    private Double amount;

    @CreatedDate
    private ZonedDateTime createdAt;

    @LastModifiedDate
    private ZonedDateTime updatedAt;
}

/*
Mehsullara endirim elave etmek ucun istifade olunan entitidir.
sadece magaza sahibleri terefinden verile biler. eger type percent qeyd olunubsa percent field nezere alinsin
eger amount olaraqq qeyd olunubsa amount nezere alinsin sifaris zamani
 */
