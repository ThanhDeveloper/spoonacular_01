package com.sun_asterisk.foodies.screen.recipes_related

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.sun_asterisk.foodies.R
import com.sun_asterisk.foodies.data.model.RecipesRelated
import com.sun_asterisk.foodies.data.source.remote.RecipesRelatedRemoteDataSource
import com.sun_asterisk.foodies.data.source.repository.RecipesRelatedRepository
import com.sun_asterisk.foodies.screen.home.RecipesRelatedContract
import com.sun_asterisk.foodies.screen.home.RecipesRelatedPresenter
import com.sun_asterisk.foodies.screen.home.layout_adapter.RecipesRelatedAdapter
import com.sun_asterisk.foodies.utils.Constant
import kotlinx.android.synthetic.main.fragment_recipes_related.*

class RecipesRelatedFragment : Fragment(), RecipesRelatedContract.View {

    private var ingredientResID: Int? = null
    private var ingredientName: String? = null
    private val recipesRelatedAdapter by lazy { RecipesRelatedAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipes_related, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initView()
        buttonBack.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                remove(this@RecipesRelatedFragment)
                commit()
            }
        }
    }

    override fun onGetRecipesRelatedSuccess(info: List<RecipesRelated>?) {
        info?.let { recipesRelatedAdapter.updateData(it) }
    }

    override fun onGetRecipesRelatedError(exception: Exception?) {
        Toast.makeText(this.context, exception.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun initData() {
        val presenter = RecipesRelatedPresenter(
            RecipesRelatedRepository.getInstance(RecipesRelatedRemoteDataSource.getInstance())
        )
        arguments?.let {
            ingredientResID = it.getInt(Constant.KEY_INGREDIENT_IMAGE)
            ingredientName = it.getString(Constant.KEY_INGREDIENT_NAME)
        }
        presenter.let {
            it.setView(this)
            it.getRecipesRelated(ingredientName)
        }
    }

    private fun initView() {
        ingredientResID?.let { imageRecipesRelated.setImageResource(it) }
        textRecipesRelatedName.text = ingredientName
        recyclerRecipesRelated.adapter = recipesRelatedAdapter
    }
}
