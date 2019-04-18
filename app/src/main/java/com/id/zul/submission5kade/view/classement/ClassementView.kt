package com.id.zul.submission5kade.view.classement

import com.id.zul.submission5kade.model.classement.ClassementResults

interface ClassementView {
    fun setLoadingClassement()
    fun setInItDataClassement(dataClassement: List<ClassementResults>)
    fun unSetLoadingClassement()
}