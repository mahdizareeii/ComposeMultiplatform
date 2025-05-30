//
//  GMSIndoorLevel.h
//  Google Maps SDK for iOS
//
//  Copyright 2013 Google LLC
//
//  Usage of this SDK is subject to the Google Maps/Google Earth APIs Terms of
//  Service: https://cloud.google.com/maps-platform/terms
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface GMSIndoorLevel : NSObject

- (instancetype)init NS_UNAVAILABLE;

/** Localized display name for the level, e.g. "Ground floor". */
@property(nonatomic, copy, readonly, nullable) NSString *name;

/** Localized short display name for the level, e.g. "1". */
@property(nonatomic, copy, readonly, nullable) NSString *shortName;

@end

NS_ASSUME_NONNULL_END
