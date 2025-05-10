//
//  AppDelegate.swift
//  iosApp
//
//  Created by Mahdi Zareei on 5/10/25.
//  Copyright © 2025 orgName. All rights reserved.
//
import Foundation
import UIKit
import GoogleMaps

class AppDelegate: UIResponder, UIApplicationDelegate {
  var window: UIWindow?

  func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {

    //the google map key
    GMSServices.provideAPIKey("YOUR_API_KEY")

    return true
  }

}
