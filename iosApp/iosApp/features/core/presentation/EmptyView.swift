//
//  EmptyView.swift
//  iosApp
//
//  Created by Алексей Смоляков on 18.11.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct EmptyView: View {
    var body: some View {
        ZStack(alignment: .center) {
            Text("History is empty")
                .font(.system(size: 18, weight: .regular))
                .foregroundStyle(Color(.greenPrimary))
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}

#Preview {
    EmptyView()
}
