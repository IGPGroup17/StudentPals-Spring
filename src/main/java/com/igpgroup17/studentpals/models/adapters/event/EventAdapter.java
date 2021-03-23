package com.igpgroup17.studentpals.models.adapters.event;

import com.igpgroup17.studentpals.models.Event;
import com.igpgroup17.studentpals.models.requestbody.RequestBodyEvent;

import java.util.ArrayList;
import java.util.UUID;

public class EventAdapter {

    public static Event fromRequestBodyEvent(RequestBodyEvent event) {
        return Event.builder()
                .eventID(UUID.randomUUID().toString())
                .name(event.getName())
                .description(event.getDescription())
                .organiserID(event.getOrganiserId())
                .scheduledTime(event.getScheduledTime()) // may have to change at some point in our lives idk lmao
                .likes(0)
                .state("SCHEDULED")
                .goingUsersIDs(new ArrayList<>())
                .interestedUsersIDs(new ArrayList<>())
                .build();
    }
}
