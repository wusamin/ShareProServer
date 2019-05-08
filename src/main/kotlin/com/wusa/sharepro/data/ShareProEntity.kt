package com.wusa.sharepro.data

import java.time.LocalDate
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "t_sharepro")
class ShareProEntity {
    @Id
    var id: Long? = null;
    var contributor: String? = null
    var location: String? = null
    var uploadDay: LocalDate? = null
    var image: String? = null
    var comment: String? = null
    var ins_date: Date? = null
    var upd_date: Date? = null
}