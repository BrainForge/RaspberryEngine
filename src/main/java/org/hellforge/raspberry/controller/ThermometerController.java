package org.hellforge.raspberry.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hellforge.raspberry.entity.ThermometerEntity;
import org.hellforge.raspberry.parser.Parser;
import org.hellforge.raspberry.parserEntity.EventEntity;
import org.hellforge.raspberry.parserEntity.OtherEventEntity;
import org.hellforge.raspberry.parserEntity.TemperatureEventEntity;
import org.hellforge.raspberry.response.APIResponse;
import org.hellforge.raspberry.response.APIResponseBuilder;
import org.hellforge.raspberry.response.TemperatureDTO;
import org.hellforge.raspberry.response.ThermometerDTO;
import org.hellforge.raspberry.service.TemperatureService;
import org.hellforge.raspberry.service.ThermometerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
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
    @Autowired
    TemperatureService temperatureService;
    @Autowired
    Parser parser;

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

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/statistic", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<TemperatureDTO> getStatistic(@RequestParam(required = false) String id) {

        List<TemperatureDTO> thermometerDTOs;

        if(id != null) {
            thermometerDTOs = temperatureService.getById(id).stream()
                    .map(TemperatureDTO::new)
                    .collect(Collectors.toList());
        } else {
            thermometerDTOs = temperatureService.getAll().stream()
                    .map(TemperatureDTO::new)
                    .collect(Collectors.toList());
        }

        return APIResponseBuilder.build(thermometerDTOs);

    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public APIResponse<String> test() {

        String json = "03:28:37.989 {\"id\":172,\"sid\":\"lumi.158d0001143109\",\"model\":\"lumi.sensor_ht.v1\",\"method\":\"props\",\"params\":{\"temperature\":2429}}";
        boolean isEvent = parser.isEventModel(json);
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        if(isEvent) {

            json = json.substring(json.indexOf("{"));

            try {
                EventEntity eventEntity = mapper.readValue(json, EventEntity.class);

                switch (eventEntity.getModel()) {
                    case "lumi.sensor_ht.v1":
                        eventEntity = mapper.readValue(json, TemperatureEventEntity.class);
                        break;
                    default:
                        eventEntity = mapper.readValue(json, OtherEventEntity.class);
                        break;
                }

                Class c = eventEntity.getClass();

                json = json;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        return APIResponseBuilder.build("Ok");

    }




}
