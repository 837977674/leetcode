package caigou.service;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CDHHost {
    private String hostId;
    private String ipAddress;
    private String hostname;
    private String rackId;
    private String hostUrl;
    private boolean maintenanceMode;
    private List<Object> maintenanceOwners = new ArrayList<>();
    private String commissionState;
    private float numCores;
    private float totalPhysMemBytes;
}