package com.gaur.mealsearch.presentation.meal_search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaur.mealsearch.common.Resource
import com.gaur.mealsearch.domain.repository.MealSearchRepository
import com.gaur.mealsearch.domain.use_case.SearchMealsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MealSearchViewModel constructor(private val mealSearchMealsUseCase: SearchMealsUseCase) : ViewModel() {
    private val _mealSearchList = MutableStateFlow<MealSearchState>(MealSearchState())
    val mealSearchList: StateFlow<MealSearchState> = _mealSearchList


    fun getSearchMeals(s: String) {
        mealSearchMealsUseCase(s).onEach {
            when (it) {
                is Resource.Loading -> {
                    _mealSearchList.value = MealSearchState(isLoading = true)
                }
                is Resource.Success -> {
                    _mealSearchList.value = MealSearchState(data = it.data)
                }
                is Resource.Error -> {
                    _mealSearchList.value = MealSearchState(error = it.message ?: "")
                }
            }
        }.launchIn(viewModelScope)
    }


}