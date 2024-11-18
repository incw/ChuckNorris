//
//  HistoryViewModelWrapper.swift
//  iosApp
//
//  Created by Алексей Смоляков on 18.11.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

final class HistoryViewModelWrapper: ObservableObject {

    let viewModel = GetViewModels().getHistoryViewModel()


    @Published var viewState: HistoryViewState = .Loading()


    func fetchHistory() {
        viewModel.fetchHistory()
    }

    @MainActor
    func collect() async {
        for await viewState in viewModel.viewState {
            self.viewState = viewState
        }
    }

    deinit {
        viewModel.onCleared()
    }

}
