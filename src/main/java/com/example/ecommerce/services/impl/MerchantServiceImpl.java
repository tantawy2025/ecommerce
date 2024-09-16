package com.example.ecommerce.services.impl;

import com.example.ecommerce.commons.model.MerchantModel;
import com.example.ecommerce.entity.Merchant;
import com.example.ecommerce.mapper.MerchantMapper;
import com.example.ecommerce.repo.MerchantRepository;
import com.example.ecommerce.services.MerchantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepository merchantRepo;

    private final MerchantMapper merchantMapper;

    @Override
    public void create(MerchantModel merchantModel) {

        if (merchantRepo.findByEmail(merchantModel.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Merchant email already exists");
        }
        merchantRepo.save(merchantMapper.toEntity(merchantModel));
    }

    @Override
    public Page<MerchantModel> getAll(Pageable pageable) {
        Page<Merchant> merchantPage = merchantRepo.findAll(pageable);
        return merchantPage.map(merchantMapper::toModel);
    }

    @Override
    public MerchantModel findById(Long id) {
        Merchant merchant = merchantRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No data found with id "+ id));

        return merchantMapper.toModel(merchant);
    }
}
