# Android String Resource Helper

A helper class for retrieving and formatting string resources in an Android application. Provides a `getString(resId: Int, vararg args: Any)` API for retrieving and formatting string resources without passing an Android context to the ViewModel. Helps keep ViewModels independent of the Android framework and simplifies unit testing.

## Usage

To use the `AndroidStringResourceHelper` class in your unit tests, simply include the following dependency in your test module's build.gradle file:

```groovy
dependencies {
    testImplementation 'com.tanliner:android-string-resource-helper:1.0.0'
}
```

OR

Just copy the `AndroidStringResourceHelper` object into you unit test directory.

Once you have added the dependency, you can use the AndroidStringResourceHelper class in your ViewModel tests:

```kotlin
class MyViewModelTest {
    
    private lateinit var stringResourceHelper: AndroidStringResourceHelper
    
    @Before
    fun setUp() {
        stringResourceHelper = AndroidStringResourceHelper(RuntimeEnvironment.application)
    }

    @Test
    fun testFormattedStringResource() {
        val stringResourceId = R.string.user_current_state
        // <string name="user_current_state">Now you have been %1$s at %2$s</string>
        val formattedString = stringResourceHelper.getString(stringResourceId, "located", "China")
        assertEquals("Now you have been located at China", formattedString)
    }
}
```

also, you can refer the `StringViewModelTest.kt` file.

```kotlin
val display = viewModel.display.value as TextForUI
assertEquals(R.string.user_current_state, display.resId)
assertEquals("Now you have been located at China.", getString(R.string.user_current_state, *display.args))
```

The AndroidStringResourceHelper class can be instantiated with a Context parameter, which is required to access the resources in the test environment.

The getString method takes a string resource ID and an optional varargs argument list. The varargs arguments will be used to format the string resource, just like the `android.content.res.Resources.getString()` method.

## Example
To see an example of the AndroidStringResourceHelper in action, check out the sample tests included in this repository.

The sample tests demonstrate how to use the AndroidStringResourceHelper to retrieve and format string resources in ViewModel tests.


## Contributing
Contributions to this repository are welcome! If you find a bug or have an idea for a new feature, please open an issue or submit a pull request.

Before submitting a pull request, please ensure that your code follows the Android Kotlin style guide and that all unit tests pass.

## License

```
Copyright [2023] [Lin]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```



