package com.github.prxy_rgb.city_break_manager.Entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "trips")
public class Trip {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne
  @JoinColumn(name = "city_id", referencedColumnName = "id")
  private City city;
  private Date startDate;
  private Date endDate;
  private int rating;
  private String personalNotes;
}
