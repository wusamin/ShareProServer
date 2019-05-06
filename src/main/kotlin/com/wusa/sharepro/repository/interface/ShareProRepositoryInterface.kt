package com.wusa.sharepro.repository.`interface`

import com.wusa.sharepro.data.ShareProEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ShareProRepositoryInterface : JpaRepository<ShareProEntity, Long> {
}