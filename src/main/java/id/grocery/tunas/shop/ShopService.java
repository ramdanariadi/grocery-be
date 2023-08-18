package id.grocery.tunas.shop;

import com.google.common.base.Strings;
import id.grocery.tunas.exception.ApiRequestException;
import id.grocery.tunas.shop.dto.GetShopDTO;
import id.grocery.tunas.shop.dto.ShopDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    public void saveShop(UUID userId, ShopDTO shopDTO){
        if(Strings.isNullOrEmpty(shopDTO.getName())){
            throw new ApiRequestException(ApiRequestException.BAD_REQUEST, HttpStatus.BAD_REQUEST);
        }

        Shop shopByUserId = shopRepository.findShopByUserId(userId);
        if(null != shopByUserId){
            throw new ApiRequestException("SHOP_ALREADY_EXIST", HttpStatus.BAD_REQUEST);
        }

        Shop shop = new Shop();
        shop.setName(shopDTO.getName());
        shop.setImageUrl(shopDTO.getImageUrl());
        shop.setAddress(shopDTO.getAddress());
        shopRepository.save(shop);
    }

    public GetShopDTO.Response getUserShop(UUID userId){
        Shop shopByUserId = shopRepository.findShopByUserId(userId);
        if(null == shopByUserId){
            throw new ApiRequestException("SHOP_NOT_EXIST", HttpStatus.BAD_REQUEST);
        }
        GetShopDTO.ShopDTO shopDTO = new GetShopDTO.ShopDTO();
        shopDTO.setId(shopByUserId.getId());
        shopDTO.setName(shopByUserId.getName());
        shopDTO.setImageUrl(shopByUserId.getImageUrl());
        shopDTO.setAddress(shopDTO.getAddress());
        return new GetShopDTO.Response(shopDTO);
    }

    public void updateShop(UUID userId, UUID shopId, ShopDTO shopDTO){
        if(Strings.isNullOrEmpty(shopDTO.getName())){
            throw new ApiRequestException(ApiRequestException.BAD_REQUEST, HttpStatus.BAD_REQUEST);
        }

        Optional<Shop> shopOptional = shopRepository.findById(shopId);
        if(shopOptional.isEmpty()){
            throw new ApiRequestException(ApiRequestException.BAD_REQUEST, HttpStatus.BAD_REQUEST);
        }

        Shop shop = shopOptional.get();
        shop.setName(shopDTO.getName());
        shop.setImageUrl(shopDTO.getImageUrl());
        shop.setAddress(shopDTO.getAddress());
        shopRepository.save(shop);
    }

    public void deleteShop(UUID userId, UUID shopId){

        Optional<Shop> shopOptional = shopRepository.findById(shopId);
        if(shopOptional.isEmpty()){
            throw new ApiRequestException(ApiRequestException.BAD_REQUEST, HttpStatus.BAD_REQUEST);
        }
        shopRepository.deleteById(shopId, userId);
    }
}
