//
//  HistoryView.swift
//  iosApp
//
//  Created by Алексей Смоляков on 18.11.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct HistoryView: View {

    @StateObject private var vm = HistoryViewModelWrapper()

    var body: some View {

        NavigationStack {
            switch onEnum(of: vm.viewState) {
            case .loading:
                LoadingView()
            case .empty:
                EmptyView()
            case .success(let facts):
                HistoryViewContent(items: facts.items)
            }
        }
        .navigationTitle("History facts")
        .onAppear {
            vm.fetchHistory()
            Task {
                await vm.collect()
            }
        }

    }
}

struct HistoryViewContent: View {

    let items: [FactModel]

    var body: some View {
        List {
            ForEach(items, id: \.self) { item in
                Text(item.fact)
                    .font(.system(size: 18, weight: .regular))
                    .foregroundStyle(Color(.secondary))
            }
        }
        .listRowInsets(EdgeInsets())
        .listStyle(.plain)
    }
}

#Preview {
    HistoryView()
}
