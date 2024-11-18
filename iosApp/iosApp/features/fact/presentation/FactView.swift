//
//  FactView.swift
//  iosApp
//
//  Created by Алексей Смоляков on 16.11.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct FactView: View {


    @StateObject
    private var vm = FactViewModelWrapper()


    var body: some View {


        NavigationStack {

            VStack(alignment: .center) {


                switch onEnum(of: vm.viewState) {

                    case .loading:
                        LoadingView()
                    case .error:
                        ErrorView()
                    case .success(let fact):
                        FactItemView(model: fact.fact)

                }


                Spacer()

                BaseButton(
                    onClick: {
                        vm.viewModel.reFetch()
                    },
                    text: "New fact",
                    disabled: vm.viewState == FactViewState.Loading()
                )
                .padding(.vertical, 8)
                .padding(.horizontal, 16)


            }
            .navigationTitle("The Facts")
            .navigationBarTitleDisplayMode(.inline)
            .toolbar {

                ToolbarItem(placement: .primaryAction) {
                    NavigationLink {
                        HistoryView()
                    } label: {
                        Image(systemName: "folder.fill")
                            .foregroundColor(Color(.greenPrimary))
                    }
                }
            }
            .onAppear {
                Task {
                    await vm.collect()
                }
            }
            .frame(maxWidth: .infinity)

        }

    }
}



#Preview {
    FactView()
}
