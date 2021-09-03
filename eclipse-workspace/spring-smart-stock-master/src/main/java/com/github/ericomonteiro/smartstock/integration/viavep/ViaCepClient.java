package com.github.ericomonteiro.smartstock.integration.viavep;

import com.github.ericomonteiro.smartstock.integration.viavep.dto.ViaCepAddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(value = "viaCepClient", url = "http://viacep.com.br")
public interface ViaCepClient {

    @GetMapping(value = "/ws/{zipCode}/json/", consumes = {"application/json"})
    @ResponseBody
    public ViaCepAddressDto getAddress(@PathVariable("zipCode") String zipCode);

}
