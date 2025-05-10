import SwiftUI
import GoogleMaps

@main
struct iOSApp: App {
    var body: some Scene {
        WindowGroup {
            GMSServices.provideAPIKey("YOUR_API_KEY")
            ContentView()
        }
    }
}
