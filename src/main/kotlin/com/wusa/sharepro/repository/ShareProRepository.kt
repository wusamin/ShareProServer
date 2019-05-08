package com.wusa.sharepro.repository

import com.wusa.sharepro.data.ShareProEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShareProRepository : JpaRepository<ShareProEntity, Long>