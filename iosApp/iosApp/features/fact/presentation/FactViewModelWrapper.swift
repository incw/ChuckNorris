//
//  FactViewModel.swift
//  iosApp
//
//  Created by Алексей Смоляков on 17.11.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

final class FactViewModelWrapper: ObservableObject {

    var viewModel: FactViewModel = GetViewModels().getFactsViewModel()

    @Published var viewState: FactViewState = .Loading()



    @MainActor
    func collect() async {
        for await i in viewModel.viewState {

            self.viewState = i
        }
    }


    deinit {
        viewModel.onCleared()
    }


}
