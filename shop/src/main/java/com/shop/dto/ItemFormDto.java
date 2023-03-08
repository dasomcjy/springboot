package com.shop.dto;

import com.shop.constant.ItemSellStatus;
import com.shop.entity.Item;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ItemFormDto {

    private Long id;

    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    private String itemNm;

    @NotNull(message = "가격은 필수 입력 값입니다.")
    private Integer price;

    @NotBlank(message = "상품 상세는 필수 입력 값입니다.")
    private String itemDetail;

    @NotNull(message = "재고는 필수 입력 값입니다.")
    private Integer stockNumber;

    private ItemSellStatus itemSellStatus;

    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();

    private List<Long> itemImgIds = new ArrayList<>();

    // DTO의 값을 Entity 클래스와 연결해서 자동으로 값이 주입되도록 
    //modelmapper 라이브러리 반드시 등록되어 있어야 사용가능
    
    private static ModelMapper modelMapper = new ModelMapper();

    //  Client form 에서 넘어오는 값을 DTO에 답아서 Item Entity 클래스에 적용후 DB에 저장
    public Item createItem(){
        return modelMapper.map(this, Item.class);
    }

    //DB에서 가져온 item Entity 클래스를 DTO에 주입해서 client로 전송하기 위한 매핑
    public static ItemFormDto of(Item item){
        return modelMapper.map(item,ItemFormDto.class);
    }

}