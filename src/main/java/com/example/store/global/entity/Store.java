package com.example.store.global.entity;

import com.example.store.dto.request.PhotoRequest;
import com.example.store.dto.request.StoreUpdateRequest;
import com.example.store.dto.request.UpdateOwnerRequestDto;
import com.example.store.dto.request.UpdateStoreRequestDto;
import com.example.store.global.type.StoreCategory;
import com.example.store.global.type.UpdateOwnerType;
import com.example.store.global.type.UpdateStoreType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="stores")
@Builder
public class Store {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STORE_ID")
    private Long storeId;

    @Column(name = "STORE_NAME")
    private String storeName;

    @Column(name = "STORE_ADDRESS")
    private String storeAddress;

    @Column(name = "STORE_LONGITUDE")
    private double storeLongitude;

    @Column(name = "STORE_LATITUDE")
    private double storeLatitude;

    @Column(name = "STORE_OPEN_AT")
    private LocalTime storeOpenAt;

    @Column(name = "STORE_CLOSE_AT")
    private LocalTime storeCloseAt;

    @Column(name = "STORE_PHONE")
    private String storePhone;

    @Column(name = "STORE_MINIMUM_ORDER_AMOUNT")
    private int storeMinimumOrderAmount;

    @Column(name = "STORE_INTRODUCTION")
    private String storeIntroduction;

    @Column(name = "STORE_CATEGORY")
    @Enumerated(EnumType.STRING)
    private StoreCategory storeCategory;

    @Column(name = "STORE_IS_DELETED")
    private boolean storeIsDeleted;

//    1 -> 영업 수동 막기, 0 -> 정상 영업
    @Column(name = "STORE_BLOCK_IS_OPENED")
    private boolean storeBlockIsOpened;
//
//    @Column(name = "STORE_IMAGE_NICKNAME")
//    private String storeImageNickname;

    @Column(name = "STORE_IMAGE")
    private String storeImage;

    @JoinColumn (name = "OWNER_ID")
    @ManyToOne
    private Owner owner;

//    @OneToMany(mappedBy = "store")
//    private List<MenuCategory> menuCategories;
//
//    @OneToMany(mappedBy = "store")
//    private List<StoreDeliveryInfo> storeDeliveryInfos;

//    public void update(UpdateStoreType updateStoreType, UpdateStoreRequestDto updateStoreRequestDto) {
//        switch (updateStoreType) {
//            case STORE_NAME:
//                this.storeName = updateStoreRequestDto.value();
//                break;
//            case STORE_ADDRESS:
//                this.storeAddress = updateStoreRequestDto.value();
//                break;
//            case STORE_OPEN_AT:
//                this.storeOpenAt = LocalTime.parse(updateStoreRequestDto.value());
//                break;
//            case STORE_CLOSE_AT:
//                this.storeCloseAt = LocalTime.parse(updateStoreRequestDto.value());
//                break;
//            case STORE_PHONE:
//                this.storePhone = updateStoreRequestDto.value();
//                break;
//            case STORE_MINIMUM_ORDER_AMOUNT:
//                this.storeMinimumOrderAmount = Integer.parseInt(updateStoreRequestDto.value());
//                break;
//            case STORE_INTRODUCTION:
//                this.storeIntroduction = updateStoreRequestDto.value();
//                break;
//            case STORE_CATEGORY:
//                this.storeCategory = StoreCategory.stringToCategory(updateStoreRequestDto.value());
//                break;
//        }
//    }

    public void updateStoreInfo(StoreUpdateRequest dto) {
        if (!dto.storeName().equals(this.storeName)) this.storeName = dto.storeName();
        if (!dto.storeAddress().equals(this.storeAddress)) this.storeAddress = dto.storeAddress();
        if (!dto.storeOpenAt().equals(this.storeOpenAt)) this.storeOpenAt = dto.storeOpenAt();
        if (!dto.storeCloseAt().equals(this.storeCloseAt)) this.storeCloseAt = dto.storeCloseAt();
        if (!dto.storePhone().equals(this.storePhone)) this.storePhone = dto.storePhone();
        if (!(dto.storeMinimumOrderAmount() == this.storeMinimumOrderAmount)) this.storeMinimumOrderAmount = dto.storeMinimumOrderAmount();
        if (!(dto.storeIntroduction().equals(this.storeIntroduction))) this.storeIntroduction = dto.storeIntroduction();
        if (!dto.storeCategory().equals(this.storeCategory)) this.storeCategory = dto.storeCategory();
        if (!(dto.storeLongitude() == this.storeLongitude)) this.storeLongitude = dto.storeLongitude();
        if (!(dto.storeLatitude() == this.storeLatitude)) this.storeLatitude = dto.storeLatitude();
        if (!dto.storeImage().equals(this.storeImage)) this.storeImage = dto.storeImage();
    }

    public void setStoreIsDeleted() {
        this.storeIsDeleted = true;
    }

    public boolean getStoreBlockIsOpened() {
        return storeBlockIsOpened;
    }

    public void setStoreBlockIsOpened() {
        this.storeBlockIsOpened = !(this.storeBlockIsOpened);
    }

//    public void updateImageInfo(String input) {
////        this.storeImageNickname = dto.getNickname();
//        this.storeImage = input;
//    }
}
