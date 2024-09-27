package com.example.ecommerce.services.impl;

import com.example.ecommerce.commons.exception.AlreadyExistsException;
import com.example.ecommerce.commons.exception.NotFoundException;
import com.example.ecommerce.commons.model.MerchantModel;
import com.example.ecommerce.repo.entity.Merchant;
import com.example.ecommerce.services.mapper.MerchantMapper;
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
        log.info("add  merchant ");
        validateEmailExistance(merchantModel.getEmail());

        merchantRepo.save(merchantMapper.toEntity(merchantModel));
        log.info("merchant added successfully");
    }



    @Override
    public Page<MerchantModel> getAll(Pageable pageable) {
        Page<Merchant> merchantPage = merchantRepo.findAll(pageable);
        return merchantPage.map(merchantMapper::toModel);
    }

    @Override
    public MerchantModel findById(Long id) {
        Merchant merchant = merchantRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Merchant with ID " + id + " not found"));

        return merchantMapper.toModel(merchant);
    }

    @Override
    public MerchantModel update(Long id, MerchantModel merchantModel) {
        log.info("update merchant by id {}",id);
        Merchant existingMerchant =merchantRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Merchant with ID " + id + " not found"));

        // check duplicate email when updating the email
        if (!merchantModel.getEmail().isEmpty())
            validateEmailExistance(merchantModel.getEmail());

        existingMerchant = merchantMapper.toEntity(merchantModel);

        merchantRepo.save(existingMerchant);
        log.info("merchant update successfully ");

        return merchantMapper.toModel(existingMerchant);
    }

    @Override
    public void delete(Long id) {
        log.info("delete merchant by id");
        Boolean exist = merchantRepo.existsById(id);

        if(exist)
            merchantRepo.deleteById(id);
        else
            throw new NotFoundException("Merchant with ID " + id + " not found");

        log.info("merchant deleted successfully ");
    }

    private void validateEmailExistance(String email) {
        if (merchantRepo.findByEmail(email).isPresent()) {
            throw new AlreadyExistsException("Merchant email " + email + " already exists");
        }
    }


}
