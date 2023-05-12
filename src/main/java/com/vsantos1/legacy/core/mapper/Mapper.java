package com.vsantos1.legacy.core.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    private static final ModelMapper mapper = new ModelMapper();

    public ModelMapper modelMapper(boolean skillNullCheck, boolean ignoreAmbiguity) {
        mapper.getConfiguration().setSkipNullEnabled(skillNullCheck);
        mapper.getConfiguration().setAmbiguityIgnored(ignoreAmbiguity);
        return mapper;
    }

    public static <Origin, Destination> Destination parseObject(Origin origin, Class<Destination> destinationClass) {
        return mapper.map(origin, destinationClass);
    }


    public static <Origin, Destination> List<Destination> parseListObjects(List<Origin> origin, Class<Destination> destinationClass) {
        List<Destination> destination = new ArrayList<>();

        for (Origin o : origin) {
            mapper.map(o, destination);
        }
        return destination;
    }

    public static <Origin, Destination> void copyProperties(Origin origin, Destination destination) {
        mapper.map(origin, destination);
    }
}
