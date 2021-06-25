# SceneFormSdkSample - FurnitureAR

**Augmentt Reality Android app For Furniture**

This is a Augmented Reality Android app which is made by using **ARcore** and **Sceneform SDK**.


1. Augmented Reality Android app to view and place furniture object using ARcore and Sceneform.

2. User can place and interact with different furniture items which will be visible through the camera view finder.

3. If you want to add more 3D models of different furniture just download the respective files from https://poly.google.com/


**Project-Level Configuration**

- Need to make a folder which is name of **samledata** in project directory,it is used to store 3D objects.

- Need to register 3D object in gradle files by using below code.

sceneform.asset('sampledata/chair/model.obj',
        'default',
        'sampledata/chair/model.sfa',
        'src/main/assets/chair')

sceneform.asset('sampledata/couch/model.obj',
        'default',
        'sampledata/couch/model.sfa',
        'src/main/assets/couch')


**Further Reference**

https://developers.google.com/sceneform/develop
