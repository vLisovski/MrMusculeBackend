package com.lisovski.mrmuscule.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="purchases")
public class Purchase {

    @Id
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "product_id")
    private int productId;
}
