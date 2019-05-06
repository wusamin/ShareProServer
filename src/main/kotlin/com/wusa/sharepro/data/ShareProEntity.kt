package com.wusa.sharepro.data

import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "t_sharepro")
class ShareProEntity {
    @Id
    @GeneratedValue
    val id: Long? = null;
    val contributor: String? = null
    val location: String? = null
    val uploadDay: LocalDate? = null
    var image: String? = null
    val comment: String? = null
    val ins_date: Date? = null
    val upd_date: Date? = null
}