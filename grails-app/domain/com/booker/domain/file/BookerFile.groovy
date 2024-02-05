package com.booker.domain.file

import utils.BaseEntity

class BookerFile extends BaseEntity {

    String name

    Long size

    static mapping = {
        name unique: true
    }
}
