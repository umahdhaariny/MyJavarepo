package learnjava.service;

import learnjava.domain.Inventory;
import learnjava.domain.ProductOption;

import java.util.concurrent.CompletableFuture;

import static learnjava.util.CommonUtil.delay;

public class InventoryService {
    public Inventory addInventory(ProductOption productOption) {
    	//this is to simulate the latency
        delay(500);
        return Inventory.builder()
                .count(2).build();

    }

    public CompletableFuture<Inventory> addInventory_CF(ProductOption productOption) {

        return CompletableFuture.supplyAsync(() -> {
            delay(500);
            return Inventory.builder()
                    .count(2).build();
        });

    }
}
