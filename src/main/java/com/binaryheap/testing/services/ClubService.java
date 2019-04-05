package com.binaryheap.testing.services;

import com.binaryheap.testing.dtos.ClubCreateDto;
import com.binaryheap.testing.dtos.ClubDto;

public interface ClubService {
    ClubDto createClub(long bagId, ClubCreateDto createDto);
    ClubDto updateClub(long bagId, ClubDto clubDto);
    ClubDto removeClub(long bagId, ClubDto clubDto);
}
