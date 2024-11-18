//
//  BaseButton.swift
//  iosApp
//
//  Created by Алексей Смоляков on 16.11.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct BaseButton: View {

    let onClick: () -> Void
    let text: String
    let disabled: Bool

    var body: some View {
        Button {
            onClick()
        } label: {
            Text(text)
                .padding(8)
                .font(.system(size: 18, weight: .semibold))
                .foregroundStyle(.white)
                .frame(maxWidth: .infinity)

        }
        .disabled(disabled)
        .background(Color(.greenPrimary))
        .clipShape(RoundedRectangle(cornerRadius: 8.0))

    }
}

