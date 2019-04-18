package com.id.zul.submission5kade.presenter.classement

import com.google.gson.Gson
import com.id.zul.submission5kade.api.Get
import com.id.zul.submission5kade.api.Request
import com.id.zul.submission5kade.coroutine.ProviderContext
import com.id.zul.submission5kade.model.classement.Classement
import com.id.zul.submission5kade.view.classement.ClassementView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ClassementPresenter(
    private val view: ClassementView,
    private val apiRepository: Request,
    private val gson: Gson,
    private val context: ProviderContext = ProviderContext()
) {

    fun getClassement(id: String) {
        view.setLoadingClassement()
        GlobalScope.launch(context.main) {
            val dataClassement = gson.fromJson(
                apiRepository
                    .getRequestAsync(Get.getClassement(id)).await(),
                Classement::class.java
            )
            view.setInItDataClassement(dataClassement.table)
            view.unSetLoadingClassement()
        }
    }
}