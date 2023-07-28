package com.gaur.mealsearch.diModules

import com.gaur.mealsearch.data.repository.MealDetailsRepositoryImpl
import com.gaur.mealsearch.data.repository.MealSearchRepistoryImpl
import com.gaur.mealsearch.domain.repository.MealDetailsRepository
import com.gaur.mealsearch.domain.repository.MealSearchRepository
import com.gaur.mealsearch.domain.use_case.GetMealDetailsUseCase
import com.gaur.mealsearch.domain.use_case.SearchMealsUseCase
import com.gaur.mealsearch.presentation.meal_search.MealSearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

// Created a Koin module to provide the instances of use case classes and their dependencies
val useCaseModule = module {
    // Provided MealSearchRepository and MealDetailsRepository
    single<MealSearchRepository> { MealSearchRepistoryImpl(get()) }
    single<MealDetailsRepository> { MealDetailsRepositoryImpl(get()) }

    // Providing the instances of the use case classes
    single { SearchMealsUseCase(get()) }
    single { GetMealDetailsUseCase(get()) }
}

val viewModelModule = module {
    viewModel { MealSearchViewModel(get()) }
}
