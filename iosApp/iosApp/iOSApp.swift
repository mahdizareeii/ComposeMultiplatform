import SwiftUI
import GoogleMaps

@main
struct iOSApp: App {
    var body: some Scene {
        WindowGroup {
            initGoogleMap()
            ContentView()
        }
    }
}

private func initGoogleMap() -> some View {
    GMSServices.provideAPIKey("AIzaSyAtRVvG3Be3xXiZFR7xp-K-9hy4nZ4hMFs")
    return EmptyView()
}
