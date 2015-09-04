package com.pabili.core.service;

import com.pabili.core.model.Location;
import com.pabili.core.service.custom.LocationServiceCustom;

public interface LocationService extends BaseJpaService<Location>, LocationServiceCustom {

    Location findByName(String name);

}
