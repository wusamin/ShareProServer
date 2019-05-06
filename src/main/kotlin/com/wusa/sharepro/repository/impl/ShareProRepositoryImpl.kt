package com.wusa.sharepro.repository.impl

import com.wusa.sharepro.data.ShareProEntity
import com.wusa.sharepro.repository.`interface`.ShareProRepositoryInterface
import org.springframework.stereotype.Repository

@Repository
class ShareProRepositoryImpl(private val repository:
                             ShareProRepositoryInterface) {
    fun findAll(): List<ShareProEntity> {
        return repository.findAll()
    }
}