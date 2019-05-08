package com.wusa.sharepro.data

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "m_sharepro")
class MShareProEntity {
    //TODO 時間が無いので一旦設定ファイルの代わり
    @Id
    val id: String? = null
    val value1: String? = null
}