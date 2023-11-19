// App.js
import React from 'react';
import { HomeScreen } from './screens/HomeScreen';
import { LoginScreen}  from './screens/LoginScreen';
import { SignUp } from './screens/SignupScreen';
import { NavigationContainer } from "@react-navigation/native";
import { createNativeStackNavigator } from "@react-navigation/native-stack";


const Stack = createNativeStackNavigator();

export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen 
          name="Login"
          component={LoginScreen}
        />
        <Stack.Screen 
          name="Home"
          component={HomeScreen}
        />
        <Stack.Screen 
          name="Signup"
          component={SignUp}
        />
      </Stack.Navigator>
    </NavigationContainer>
  );
}