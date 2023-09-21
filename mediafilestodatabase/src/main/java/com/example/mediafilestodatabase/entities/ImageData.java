package com.example.mediafilestodatabase.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class ImageData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String type;

    private String filepath;
}
