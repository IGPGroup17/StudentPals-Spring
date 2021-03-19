package com.igpgroup17.studentpals.models.requestbody;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RequestBodyEvent {

    private String name;

    private String description;

    private String organiserId;

    private String scheduledTime;
}
