package com.vcg.chat.server.router;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public final class RemoteRouter implements Router<ClientLocation> {

    private ClientLocation clientLocation;

    public boolean isOnline() {
        return clientLocation.getSessionId() != null;
    }

    public boolean isOffline() {
        return clientLocation.getSessionId() == null;
    }

    @Override
    public ClientLocation getRouteValue() {
        return clientLocation;
    }
}
