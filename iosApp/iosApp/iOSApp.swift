import SwiftUI
import GoogleMaps
import ComposeApp

@main
struct iOSApp: App {
    var body: some Scene {
        WindowGroup {
            initKoinDi()
            initGoogleMap()
            ComposeContentView()
            //NativeGoogleMapView()
        }
    }
}

private func initKoinDi()-> some View {
    KoinModuleKt.doInitKoin { koinContext in }
    return EmptyView()
}

private func initGoogleMap() -> some View {
    GMSServices.provideAPIKey("AIzaSyAtRVvG3Be3xXiZFR7xp-K-9hy4nZ4hMFs")
    return EmptyView()
}
