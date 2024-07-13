package com.vektorel.firstproject.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class SocialMedia {
    private String twitter;
    private String facebook;
    private String instgram;
}
