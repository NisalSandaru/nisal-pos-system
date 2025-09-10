package com.nisal.controller;

import com.nisal.domain.StoreStatus;
import com.nisal.mapper.StoreMapper;
import com.nisal.model.Store;
import com.nisal.model.User;
import com.nisal.payload.dto.StoreDTO;
import com.nisal.payload.response.ApiResponse;
import com.nisal.repository.StoreRepository;
import com.nisal.service.StoreService;
import com.nisal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<StoreDTO> createStore(@RequestBody StoreDTO storeDTO,
                                                @RequestHeader("Authorization")String jwt)throws Exception {

        User user = userService.getUserFromJwtToken(jwt);
        return ResponseEntity.ok(storeService.createStore(storeDTO, user));

    }


    @GetMapping()
    public ResponseEntity<List<StoreDTO>> getAllStore(@RequestHeader("Authorization")String jwt)throws Exception {

        return ResponseEntity.ok(storeService.getAllStores());

    }

    @GetMapping("/admin")
    public ResponseEntity<StoreDTO> getStoreByAdmin(
            @RequestHeader("Authorization")String jwt)throws Exception {

        return ResponseEntity.ok(StoreMapper.toDTO(storeService.getStoreByAdmin()));

    }

    @GetMapping("/employee")
    public ResponseEntity<StoreDTO> getStoreByEmplyee(
            @RequestHeader("Authorization")String jwt)throws Exception {

        return ResponseEntity.ok(storeService.getStoreByEmployee());

    }

    @PutMapping("/{id}")
    public ResponseEntity<StoreDTO> updateStore(@PathVariable Long id,
                                                @RequestBody StoreDTO storeDTO) throws Exception {

        return ResponseEntity.ok(storeService.updateStore(id, storeDTO));
    }

    @PutMapping("/{id}/moderate")
    public ResponseEntity<StoreDTO> moderateStore(@PathVariable Long id,
                                                  @RequestParam StoreStatus status) throws Exception {

        return ResponseEntity.ok(storeService.moderateStore(id, status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> getStoreById(@PathVariable Long id,
                                                 @RequestHeader("Authorization")String jwt)throws Exception {

        return ResponseEntity.ok(storeService.getStoreById(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteStore(@PathVariable Long id) throws Exception {

        storeService.deleteStore(id);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("store deleted successfully");
        return ResponseEntity.ok(apiResponse);
    }
}
