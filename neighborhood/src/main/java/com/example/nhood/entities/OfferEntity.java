package com.example.nhood.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "offer")
public class OfferEntity extends BaseEntity{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	
	@Column (name = "name", nullable=false, length =255)
	private String name;
	
	@Column (name="offer_type", nullable=false, length=1)
	private String offerType;
	
	@Column (name = "user_id", nullable=false )
	private Integer userId;
	
	
	
	
}
