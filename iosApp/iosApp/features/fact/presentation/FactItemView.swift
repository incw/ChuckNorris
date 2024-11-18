//
//  FactItemView.swift
//  iosApp
//
//  Created by Алексей Смоляков on 16.11.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct FactItemView: View {

    let model: FactModel

    var body: some View {
        ZStack {
            Text(model.fact)
                .font(.system(size: 18, weight: .regular))
                .foregroundColor(.secondary)
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .padding(.horizontal, 16)
    }
}

