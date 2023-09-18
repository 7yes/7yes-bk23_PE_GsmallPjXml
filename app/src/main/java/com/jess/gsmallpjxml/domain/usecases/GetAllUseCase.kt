package com.jess.gsmallpjxml.domain.usecases

import com.jess.gsmallpjxml.data.Repository
import javax.inject.Inject

class GetAllUseCase@Inject constructor(private val repository:Repository) {
 suspend operator fun invoke() = repository.getMyItems()
}