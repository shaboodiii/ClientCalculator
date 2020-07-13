package com.calculatorClient.CalculatorClient.service;

import com.calculatorClient.CalculatorClient.model.Calculator;
import com.calculatorClient.CalculatorClient.model.Result;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;


@Service
public class CalculatorServiceImp implements CalculatorService{

    private final ObjectMapper objectMapper = new ObjectMapper();

    private static final Logger logger = LogManager.getLogger(CalculatorServiceImp.class);

    @Override
    public Result calculate(Calculator body) throws JsonProcessingException {
        System.out.println("Calculate!");
        Result response = query(body);
        return response;

    }

    private Result query(Calculator body) throws JsonProcessingException {

        String url = "http://localhost:8082/ServerCalculate";
        System.out.println("Connecting...");
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("xValue", body.getxValue());
        jsonObject.put("yValue", body.getyValue());
        jsonObject.put("operator", body.getOperator());

        HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), headers);

        Result jsonResult = restTemplate.postForObject(url, request, Result.class);
        System.out.println("Sending...");

        System.out.println("Done!");
        return jsonResult;
    }
}
