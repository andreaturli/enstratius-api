package com.enstratus.api.actions.infrastructure;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.enstratus.api.HttpMethod;
import com.enstratus.api.actions.AbstractAction;
import com.enstratus.api.actions.Action;

public class GetServer extends AbstractAction implements Action {

    private final String API_CALL = "infrastructure/Server/%s";
    private final String serverId;
    private final String regionId;
    
    public GetServer(String serverId, String regionId) {
        this.serverId = checkNotNull(serverId, "serverId");
        this.regionId = checkNotNull(regionId, "regionId");
    }
    
    @Override
    public String getURI() {
        return String.format(resolveUri(API_CALL), serverId);
    }

    @Override
    public HttpMethod getRestMethodName() {
        return HttpMethod.GET;
    }

    @Override
    public List<NameValuePair> getQueryParameters() {
        List<NameValuePair> queryParams = new ArrayList<NameValuePair>();
        queryParams.add(new BasicNameValuePair("regionId", regionId));
        return queryParams;
    }
    
    @Override
    public String getPathToResult() {
        return "servers";
    }

}
