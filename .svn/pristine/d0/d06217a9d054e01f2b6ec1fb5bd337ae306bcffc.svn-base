package com.hyva.hospital.holistic.mapper;

import com.hyva.hospital.holistic.entities.Services;
import com.hyva.hospital.holistic.pojo.ServicesPojo;

import java.util.ArrayList;
import java.util.List;

public class ServiceMapper {
    public static Services mapPojoToEntity(ServicesPojo pojo){
        Services services =new Services();
        services.setId(pojo.getId());
        services.setAttendantsNumber(pojo.getAttendants_number());
        services.setAvailabilitiesType(pojo.getAvailabilities_type());
        services.setCurrency(pojo.getCurrency());
        services.setDescription(pojo.getDescription());
        services.setDuration(pojo.getDuration());
        services.setName(pojo.getName());
        services.setPrice(pojo.getPrice());
        if(pojo.getFlag()!=null) {
            services.setFlag( Integer.parseInt( pojo.getFlag() ) );
        }
        services.setIdservicecategories(pojo.getIdservicecategories());
        return services;
    }

    public static List<ServicesPojo> mapServiceEntityToPojo(List<Services> List){
        List<ServicesPojo> list=new ArrayList<>();
        for(Services services:List) {
            ServicesPojo pojo = new ServicesPojo();
            pojo.setId(services.getId());
            pojo.setIdservicecategories( services.getIdservicecategories() );
            pojo.setAttendants_number(services.getAttendantsNumber());
            pojo.setAvailabilities_type(services.getAvailabilitiesType());
            pojo.setCurrency(services.getCurrency());
            pojo.setDescription(services.getDescription());
            pojo.setDuration(services.getDuration());
            pojo.setName(services.getName());
            pojo.setPrice(services.getPrice());
            pojo.setFlag(String.valueOf(services.getFlag()));
            if(services.getIdservicecategories()!=null) {
                pojo.setCategoryId( services.getIdservicecategories().getId() );
            }
            pojo.setIdservicecategories(services.getIdservicecategories());
            list.add(pojo);
        }
        return list;
    }
}
