package com.github.ericomonteiro.smartstock.resource.v1;

import com.github.ericomonteiro.smartstock.integration.viavep.ViaCepClient;
import com.github.ericomonteiro.smartstock.integration.viavep.dto.ViaCepAddressDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/address")
@RequiredArgsConstructor
public class AddressResource {
    private final ViaCepClient viaCepClient;

    @GetMapping("/{zipCode}")
    public ViaCepAddressDto getAddressByZipCode(@PathVariable String zipCode) {
        return viaCepClient.getAddress(zipCode);
    }

}
