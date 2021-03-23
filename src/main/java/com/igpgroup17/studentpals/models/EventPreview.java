package com.igpgroup17.studentpals.models;

import lombok.Builder;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
public class EventPreview {

    private String eventId;

    private String name;

    private String description;

    private String dateTime;

    private int likes;
}
