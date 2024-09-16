package com.example.ecommerce.services.impl;

import com.example.ecommerce.commons.exception.MerchantEmailAlreadyExistsException;
import com.example.ecommerce.commons.exception.MerchantNotFoundException;
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
        log.info("add  merchant by id ");
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
                .orElseThrow(() -> new MerchantNotFoundException(id));

        return merchantMapper.toModel(merchant);
    }

    @Override
    public MerchantModel update(Long id, MerchantModel merchantModel) {
        log.info("update merchant by id {}",id);
        Merchant existingMerchant =merchantRepo.findById(id)
                .orElseThrow(() -> new MerchantNotFoundException(id));

        // check duplicate email when updating the email
        if (!merchantModel.getEmail().isEmpty())
            validateEmailExistance(merchantModel.getEmail());

        updateMerchantDetails(existingMerchant, merchantModel);

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
            throw new MerchantNotFoundException(id);

        log.info("merchant deleted successfully ");
    }

    private void validateEmailExistance(String email) {
        if (merchantRepo.findByEmail(email).isPresent()) {
            throw new MerchantEmailAlreadyExistsException(email);
        }
    }

    private void updateMerchantDetails(Merchant existingMerchant, MerchantModel merchantModel) {
        if (merchantModel.getName() != null) {
            existingMerchant.setName(merchantModel.getName());
        }
        if (merchantModel.getAddress() != null) {
            existingMerchant.setAddress(merchantModel.getAddress());
        }
        if (merchantModel.getEmail() != null) {
            existingMerchant.setEmail(merchantModel.getEmail());
        }
        // Only update status if it has changed
        if (merchantModel.isStatus() != existingMerchant.isStatus()) {
            existingMerchant.setStatus(merchantModel.isStatus());
        }

        /*
        * existingMerchant = Merchant.builder()
                        .name((merchantModel.getName()!=null)?merchantModel.getName():existingMerchant.getName())
                                .address((merchantModel.getAddress()!=null)?merchantModel.getAddress():existingMerchant.getAddress())
                                        .email((merchantModel.getEmail()!=null)?merchantModel.getEmail():existingMerchant.getEmail())
                                                .status((!merchantModel.isStatus())?merchantModel.isStatus():existingMerchant.isStatus())
                                                    .build();*/
    }
}
