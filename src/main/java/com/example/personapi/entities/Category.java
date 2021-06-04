package com.example.personapi.entities;

import com.example.personapi.enuns.CategoryType;
import com.example.personapi.enuns.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Department department;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CategoryType categoryType;

    @Column(nullable = false)
    private Integer salary;
}
