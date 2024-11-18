//
//  ErrorView.swift
//  iosApp
//
//  Created by Алексей Смоляков on 18.11.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ErrorView: View {
    var body: some View {

        ZStack(alignment: .center){

            Text("Error, please try again")
                .font(.system(size: 20, weight: .light))
                .foregroundColor(.red.opacity(0.8))

        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)

    }
}

#Preview {
    ErrorView()
}
