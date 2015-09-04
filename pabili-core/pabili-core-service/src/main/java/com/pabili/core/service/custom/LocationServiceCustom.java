package com.pabili.core.service.custom;

import com.pabili.commons.dto.location.LocationInfo;
import com.pabili.core.model.Location;

/**
 * @author Mark Martinez, created Sep 4, 2015
 */
public interface LocationServiceCustom {

    LocationInfo saveInfo(LocationInfo locationInfo);
    Location saveInfoGetEntity(LocationInfo locationInfo);

}
