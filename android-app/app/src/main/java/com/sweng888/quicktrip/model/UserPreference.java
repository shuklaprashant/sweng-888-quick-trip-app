package com.sweng888.quicktrip.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserPreference {
    private String id;
    private String category;
    private String characteristic;
    private boolean preferred;

    public void changeSelection() {
        this.preferred = this.preferred == true ? false : true;
    }
}
