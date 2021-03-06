package com.enstratus.api.features;

import java.util.List;

import com.enstratus.api.actions.geography.GetRegion;
import com.enstratus.api.actions.geography.ListClouds;
import com.enstratus.api.actions.geography.ListDatacenters;
import com.enstratus.api.actions.geography.ListRegions;
import com.enstratus.api.actions.geography.ListSubscriptions;
import com.enstratus.api.client.EnstratusClient;
import com.enstratus.api.model.Cloud;
import com.enstratus.api.model.Datacenter;
import com.enstratus.api.model.Jurisdiction;
import com.enstratus.api.model.Region;
import com.enstratus.api.model.Subscription;

public class GeographyApi {
    
    private final EnstratusClient enstratusClient;

    public GeographyApi(EnstratusClient enstratusClient) {
        this.enstratusClient = enstratusClient;
    }

    public List<Region> listRegions()   {
        return this.listRegions(null, null, null);
    }

    public List<Region> listRegions(String accountId, Jurisdiction jurisdiction, String scope)  {
        return enstratusClient.execute(new ListRegions(accountId, jurisdiction, scope)).getSourceAsObjectList(Region.class);
    }
    
    public Region getRegion(String regionId)  {
        return enstratusClient.execute(new GetRegion(regionId)).getSourceAsObject(Region.class);
    }
    
    public Region getRegion(String regionId, String accountId, Jurisdiction jurisdiction, String scope)  {
        return enstratusClient.execute(new GetRegion(regionId, accountId, jurisdiction, scope))
                .getSourceAsObjectList(Region.class);
    }

    public List<Cloud> listClouds()  {
        return enstratusClient.execute(new ListClouds()).getSourceAsObjectList(Cloud.class);
    }

    public List<Datacenter> listDatacenters(String regionId)  {
        return enstratusClient.execute(new ListDatacenters(regionId)).getSourceAsObjectList(Datacenter.class);
    }

    public List<Subscription> listSubscriptions()  {
        return enstratusClient.execute(new ListSubscriptions()).getSourceAsObjectList(Subscription.class);
    }

}
