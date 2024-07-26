package com.week_2_1springBootStarterWeb.week_2_1springBootStarterWeb.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class mapper {

    @Bean
    public ModelMapper ModelMapper(){  // we declare this in configs so whenever we wan to use the ModelMapper we don;t need to create the object everytime we simply call this object 
        return new ModelMapper();


        // // Define a mapping to skip the 'id' field
        // modelMapper.addMappings(new PropertyMap<employeeData, employeeEntity>() {
        //     @Override
        //     protected void configure() {
        //         skip(destination.getId());
        //     }
        // });

        // return modelMapper;
    }
}
