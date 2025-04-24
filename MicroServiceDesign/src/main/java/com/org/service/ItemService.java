package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.org.model.Item;
import com.org.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Cacheable(value = "items", key = "#page + '-' + #size")
    public Page<Item> getItems(int page, int size) {
	Pageable pageable = PageRequest.of(page, size);
	return itemRepository.findAll(pageable);
    }
    /*
     * Pageable sortedByName = PageRequest.of(0, 3, Sort.by("name"));
     * 
     * Pageable sortedByPriceDesc = PageRequest.of(0, 3,
     * Sort.by("price").descending());
     * 
     * Pageable sortedByPriceDescNameAsc = PageRequest.of(0, 5,
     * Sort.by("price").descending().and(Sort.by("name")));
     */

    // This removes all entries in the items cache after updating one item — which
    // is simple but can be overkill for paginated data.
    @CacheEvict(value = "items", allEntries = true)
    public void updateItem(Item item) {
	itemRepository.save(item);
    }

}
