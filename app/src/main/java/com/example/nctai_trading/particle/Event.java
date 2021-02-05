/*
 * Copyright (c) 2017 by Walter Stroebel and InfComTec.
 * All rights reserved.
 */
package com.example.nctai_trading.particle;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.nctai_trading.particle.Cloud;
import com.example.nctai_trading.particle.Device;

import java.util.Date;
import java.util.TreeMap;

import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author walter
 */
public class Event {

    public String deviceName="?";
    final public String eventName;
    final public String coreId;
    final public String data;
    final public Date publishedAt;
    final public long ttl;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public Event(final TreeMap<String, Device> devices, final String eventName, final JSONObject jo) throws JSONException {
        this.eventName = eventName;
        this.coreId = jo.getString("coreid");
        for (Device d : devices.values()) {
            if (d.id.equals(coreId)) {
                this.deviceName = d.name;
                break;
            }
        }
        this.data = jo.getString("data");
        this.publishedAt = Cloud.parseDateTime(jo.getString("published_at"));
        long _ttl = jo.getLong("ttl") * 1000L;
        this.ttl = Math.min(60000L, _ttl);
    }

    public Date expires() {
        return new Date(publishedAt.getTime() + ttl);
    }

    @Override
    public String toString() {
        return "Event{" + "deviceName=" + deviceName + ", eventName=" + eventName + ", coreId=" + coreId + ", data=" + data + ", publishedAt=" + publishedAt + ", ttl=" + ttl + '}';
    }

}