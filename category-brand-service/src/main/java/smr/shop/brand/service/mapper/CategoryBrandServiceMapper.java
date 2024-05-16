package smr.shop.brand.service.mapper;

import org.springframework.stereotype.Component;
import smr.shop.brand.service.dto.request.BrandCreateRequest;
import smr.shop.brand.service.dto.request.BrandUpdateRequest;
import smr.shop.brand.service.dto.request.CategoryCreateRequest;
import smr.shop.brand.service.dto.request.CategoryUpdateRequest;
import smr.shop.brand.service.dto.response.BrandResponse;
import smr.shop.brand.service.dto.response.CategoryResponse;
import smr.shop.brand.service.model.BrandEntity;
import smr.shop.brand.service.model.CategoryEntity;
import smr.shop.libs.common.dto.message.BrandDeleteMessageModel;
import smr.shop.libs.common.dto.message.BrandImageDeleteMessageModel;
import smr.shop.libs.common.dto.message.CategoryMessageModel;
import smr.shop.libs.grpc.brand.BrandGrpcResponse;
import smr.shop.libs.grpc.category.CategoryGrpcResponse;

import java.util.List;

@Component
public class CategoryBrandServiceMapper {
    public BrandEntity brandCreateResponseToBrandEntity(BrandCreateRequest request) {
        return BrandEntity.builder()
                .name(request.getName())
                .description(request.getDescription()).build();
    }

    public BrandEntity brandUpdateRequestToBrandEntity(BrandUpdateRequest request, BrandEntity entity) {
        entity.setName(request.getName());
        entity.setSlug(request.getSlug());
        entity.setDescription(request.getDescription());
        return entity;
    }

    public BrandResponse brandEntityToBrandResponse(BrandEntity brandEntity) {
        return BrandResponse.builder()
                .id(brandEntity.getId())
                .name(brandEntity.getName())
                .slug(brandEntity.getSlug())
                .description(brandEntity.getDescription())
                .imageUrl(brandEntity.getImageUrl())
                .build();
    }

    public BrandImageDeleteMessageModel brandEntityToBrandImageDeleteMessageModel(BrandEntity brandEntity) {
        return BrandImageDeleteMessageModel.builder()
                .imageId(brandEntity.getImageUrl())
                .build();
    }

    public BrandDeleteMessageModel brandEntityToBrandDeleteMessageModel(BrandEntity brandEntity) {
        return BrandDeleteMessageModel.builder()
                .id(brandEntity.getId())
                .build();
    }

    public CategoryEntity categoryCreateRequestToCategoryEntity(CategoryCreateRequest request) {
        return CategoryEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();
    }

    public CategoryEntity categoryUpdateRequestToCategoryEntity(CategoryEntity category, CategoryUpdateRequest request) {
        category.setName(request.getName());
        category.setSlug(request.getSlug());
        category.setDescription(request.getDescription());
        return category;
    }

    public CategoryResponse categoryEntityToCategoryResponse(CategoryEntity category) {
        List<CategoryEntity> children = category.getChildren();
        List<CategoryResponse> categoryChildrenResponseList = null;
        if (children != null) {
            categoryChildrenResponseList = children.stream().map(this::categoryEntityToCategoryResponse).toList();
        }
        CategoryResponse categoryResponse = CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .slug(category.getSlug())
                .description(category.getDescription())
                .children(categoryChildrenResponseList)
                .build();
        return categoryResponse;
    }

    public CategoryMessageModel categoryEntityToCategoryMessageModel(CategoryEntity categoryEntity) {
        return CategoryMessageModel.builder()
                .id(categoryEntity.getId())
                .build();
    }

    public CategoryGrpcResponse categoryEntityToCategoryGrpcResponse(CategoryEntity categoryEntity) {
        return CategoryGrpcResponse.newBuilder()
                .setId(categoryEntity.getId())
                .setName(categoryEntity.getName())
                .setSlug(categoryEntity.getSlug())
                .build();
    }

    public BrandGrpcResponse brandEntityToBrandGrpcResponse(BrandEntity brandEntity) {
        return BrandGrpcResponse.newBuilder()
                .setId(brandEntity.getId())
                .setName(brandEntity.getName())
                .setSlug(brandEntity.getSlug())
                .setDescription(brandEntity.getDescription())
                .setImageUrl(brandEntity.getImageUrl())
                .build();
    }
}