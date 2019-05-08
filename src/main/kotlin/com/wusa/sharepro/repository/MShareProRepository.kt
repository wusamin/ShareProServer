package com.wusa.sharepro.repository

import com.wusa.sharepro.data.MShareProEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MShareProRepository : JpaRepository<MShareProEntity, String>