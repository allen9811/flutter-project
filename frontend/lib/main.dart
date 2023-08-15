import 'package:flutter/material.dart';
import 'package:mobile_app/config/theme/app_theme.dart';
import 'package:mobile_app/presentation/screens/home_screen.dart';
import 'package:mobile_app/presentation/screens/login_screen.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      routes: {
        '/login_screen': (context) => const LoginScreen(),
        '/home_screen': (context) => const HomeScreen()
      },
      title: 'Login Screen',
      debugShowCheckedModeBanner: false,
      theme: AppTheme().getTheme(),
      home: const LoginScreen(),
    );
  }
}


// class SocialAuth extends StatefulWidget {
//   const SocialAuth({Key? key}) : super(key: key);

//   // This widget is the root of your application.
//   @override
//   State<SocialAuth> createState() => _SocialAuthState();
// }

// class _SocialAuthState extends State<SocialAuth> {
//   bool isProgressing = false;
//   bool isLoggedIn = false;

//   @override
//   void initState() {
//     initAuth();
//     super.initState();
//   }

//   initAuth() async {
//     setLoadingState();
//     final bool isAuthenticated = await AuthService.instance.initAuth();
//     if (isAuthenticated) {
//       setAuthenticatedState();
//     } else {
//       setUnauthenticatedState();
//     }
//   }

//   setLoadingState() {
//     setState(() {
//       isProgressing = true;
//     });
//   }

//   setAuthenticatedState() {
//     setState(() {
//       isProgressing = false;
//       isLoggedIn = true;
//     });
//   }

//   setUnauthenticatedState() {
//     setState(() {
//       isProgressing = false;
//       isLoggedIn = false;
//     });
//   }

//   @override
//   Widget build(BuildContext context) {
//     return MaterialApp(
//       title: 'SocialAuthApp',
//       theme: ThemeData(
//         primarySwatch: Colors.blue,
//       ),
//       home: SafeArea(
//         child: Builder(
//           builder: (context) {
//             if (isProgressing) {
//               return const LoadingScreen();
//             } else if (isLoggedIn) {
//               return MainScreen(
//                 setUnauthenticatedState: setUnauthenticatedState,
//               );
//             } else {
//               return AuthenticationScreen(
//                 setLoadingState: setLoadingState,
//                 setAuthenticatedState: setAuthenticatedState,
//                 setUnauthenticatedState: setUnauthenticatedState,
//               );
//             }
//           },
//         ),
//       ),
//     );
//   }
// }
//