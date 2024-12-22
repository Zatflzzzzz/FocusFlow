package com.project.FocusFlow.database.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Habbit extends Action{
    private int id;
    private String frequency;
}
