package com.example.ecommerce.services;

import com.example.ecommerce.commons.model.MerchantModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MerchantService {


    public void create(MerchantModel merchantModel);

    public Page<MerchantModel> getAll(Pageable pageable);

    public MerchantModel findById(Long id);

    public MerchantModel update(Long id, MerchantModel merchantModel);

    public void delete(Long id);


}
