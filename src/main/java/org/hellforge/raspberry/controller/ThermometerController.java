package org.hellforge.raspberry.controller;

import org.hellforge.raspberry.entity.ThermometerEntity;
import org.hellforge.raspberry.response.APIResponse;
import org.hellforge.raspberry.response.APIResponseBuilder;
import org.hellforge.raspberry.response.ThermometerDTO;
import org.hellforge.raspberry.service.ThermometerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Anton Afanasyeu on 17.03.16.
 */
@Controller
@RequestMapping(value = "/temp")
public class ThermometerController {

    @Autowired
    ThermometerService thermometerService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    @Produces({MediaType.APPLICATION_JSON})
    public APIResponse<ThermometerDTO> getTemp() {

        List<ThermometerDTO> thermometerDTOs = thermometerService.getAllThermometer().stream()
                .map(ThermometerDTO::new)
                .collect(Collectors.toList());

        return APIResponseBuilder.build(thermometerDTOs);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public APIResponse<ThermometerDTO> add(@RequestParam String id, @RequestParam Double temp) {

        return  APIResponseBuilder.build(
                new ThermometerDTO(
                        thermometerService.save(
                                new ThermometerEntity(id, temp))));

    }
}
