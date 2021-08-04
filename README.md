<a href="https://www.simform.com/"><img src="https://github.com/SimformSolutionsPvtLtd/SSToastMessage/blob/master/simformBanner.png"></a>
# ARCore Furniture Sample
## Furniture Sample with Scenform SDK
 [![Scenform Version](https://img.shields.io/badge/Sceneform%20SDK%20-v1.17.1-blue)](https://developers.google.com/sceneform) [![Kotlin Version](https://img.shields.io/badge/Kotlin-v1.5.21-blue.svg)](https://kotlinlang.org)  [![Platform](https://img.shields.io/badge/Platform-Android-green.svg?style=flat)](https://www.android.com/) [![API](https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=24)

This is a Augmented Reality Android app which is made by using **ARcore** and **Sceneform SDK**.


1. Augmented Reality Android app to view and place furniture object using ARcore and Sceneform.
2. User can place and interact with different furniture items which will be visible through the camera view finder.
3. If you want to add more 3D models of different furniture just download the respective files from https://poly.google.com/


## Features

- To Easily place 3D object over captured area through app
- Rotate 3D object 
- Pinch-To-Zoom 3D Object 

# 🎬 Preview

| Chair | Couch |
|--|--|
| ![](gifs/chair.gif) |![](gifs/couch.gif) |

## Project-Level Configuration

- Need to make a folder which is name of **samledata** in project directory,it is used to store 3D objects.
- Need to register **3D object in gradle** files by using below code.

```
            sceneform.asset('sampledata/chair/model.obj',
               'default',
               'sampledata/chair/model.sfa',
               'src/main/assets/chair')
```

```
            sceneform.asset('sampledata/couch/model.obj',
               'default',
               'sampledata/chair/model.sfa',
               'src/main/assets/couch')
```

## API Reference

See the [ARCore SDK for Java API Reference](//developers.google.com/ar/reference/java)
or [ARCore SDK for C API Reference](//developers.google.com/ar/reference/c).


## Release Notes

The SDK release notes are available on the
[releases](//github.com/google-ar/arcore-android-sdk/releases) page.


## Terms & Conditions

By downloading the ARCore SDK for Android, you agree that the
[Google APIs Terms of Service](//developers.google.com/terms/) governs your use
thereof.
## Further Refererence:
* [Android Scenform][developer-tutorial-url]

## Find this Sample useful? ❤️
Support it by joining __[stargazers]__ for this repository.⭐

## 🤝 How to Contribute

Whether you're helping us fix bugs, improve the docs, or a feature request, we'd love to have you! 💪
Check out our __[Contributing Guide]__ for ideas on contributing.

## Bugs and Feedback
For bugs, feature requests, and discussion please use __[GitHub Issues]__.

## License

```
Copyright 2021 Simform Solutions Pvt Ltd.

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and limitations under the License.
```

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)

   [git-repo-url]: <https://github.com/SimformSolutionsPvtLtd/SceneFormSdkSample>
   [developer-tutorial-url]: <https://developers.google.com/sceneform/develop>
   [stargazers]: <https://github.com/SimformSolutionsPvtLtd/SceneFormSdkSample/stargazers>
   [Contributing Guide]: <https://github.com/SimformSolutionsPvtLtd/SceneFormSdkSample/blob/feature_initial_setup/CONTRIBUTING.md>
   [GitHub Issues]: <https://github.com/SimformSolutionsPvtLtd/SceneFormSdkSample/issues>
   [RecyclerRefreshLayout]: <https://github.com/dinuscxj/RecyclerRefreshLayout?utm_source=android-arsenal.com&utm_medium=referral&utm_campaign=3383>
   [gif-lib-repo]: <https://github.com/koral--/android-gif-drawable.git>
   [SSCustomPullToRefresh]: <https://github.com/SimformSolutionsPvtLtd/SSCustomPullToRefresh.git>
