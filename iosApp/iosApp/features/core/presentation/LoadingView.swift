//
//  LoadingView.swift
//  iosApp
//
//  Created by Алексей Смоляков on 17.11.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct LoadingView: View {
    var body: some View {

        ZStack(alignment: .center) {

            ProgressView()
                .foregroundColor(Color.primary)

        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)

    }
}

#Preview {
    LoadingView()
}
